package server.controller;

import client.utils.Parameter;
import client.utils.Request;
import client.utils.Response;
import server.ClientHandle;
import server.entity.User;
import server.exceptions.UserExistsException;
import server.model.UserModel;
import server.service.UserService;

import java.io.IOException;

public class UserController {

    public static Response login(Request request, ClientHandle handle) {

        Parameter usernameParameter = request.getParameter("username");

        if (usernameParameter == null) {
            return new Response("parameter username not found", 400);
        }
        Parameter passwordParameter = request.getParameter("password");

        if (passwordParameter == null) {
            return new Response("parameter password not found", 400);
        }

        // get user model
        UserModel userModel;
        try {
            userModel = new UserModel();
        } catch (IOException | ClassNotFoundException e) {
            return new Response("something was wrong on the server", 500, null);
        }

        User user;

        // check user by userName or by email
        user = userModel.getUserByUsername((String) usernameParameter.getValue());

        if (user == null) {
            // check user by email

            user = userModel.getUserByEmail((String) usernameParameter.getValue());

            if (user == null) {
                return new Response("userName doesn't exists", 400);
            }
        }

        // check user password
        if (!user.getPass().equals(passwordParameter.getValue())) {
            return new Response("incorrect password error", 400);
        }

        handle.setUser(user);
        return new Response("logged with successful", 200, user);
    }

    public static Response registration(Request request, ClientHandle handle) {

        // check registration parameters
        try {
            UserService.checkRegistrationParameters(request);
        } catch (Exception e) {
            return new Response(e.getMessage(), 400);
        }

        // get user model
        UserModel userModel;
        try {
            userModel = new UserModel();
        } catch (IOException | ClassNotFoundException e) {
            return new Response("something was wrong on the server", 500);
        }

        String firstname = (String) request.getParameter("firstname").getValue();
        String lastname = (String) request.getParameter("lastname").getValue();
        String email = (String) request.getParameter("email").getValue();
        int age = (int) request.getParameter("age").getValue();
        String password = (String) request.getParameter("password").getValue();

        /// add user
        User user = null;
        try {
            user = new User(firstname, lastname, email, age, password, UserService.generateNewId());
        } catch (IOException e) {
            return new Response("something was wrong on the server", 500);
        }

        try {
            userModel.addUser(user);
        } catch (UserExistsException | IOException e) {
            return new Response("user already exists", 400);
        }

        handle.setUser(user);
        return new Response("user registered successfully", 200, user);
    }

    public static Response logout(Request request, ClientHandle handle) {
        if (handle.getUser() == null) {
            return new Response("error user already logged out", 400);
        }
        return new Response("user logged out", 200);
    }
}
