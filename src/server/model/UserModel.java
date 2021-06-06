package server.model;

import server.entity.User;
import server.exceptions.UserExistsException;

import java.io.*;
import java.util.Vector;

public class UserModel {
    private static final String source = "users.txt";
    private static final File file = new File(source);
    private static Vector<User> users = new Vector<User>();

    public UserModel() throws IOException, ClassNotFoundException {
        if (!file.createNewFile()) {
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Object obj;

                while ((obj = objectIn.readObject()) != null)
                    users.add((User) obj);
                objectIn.close();
            } catch (Exception ex) {
//                ex.printStackTrace();
            }
        }
    }

    public User getUserById(int id) {
        for (User user:
             users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for (User user:
                users) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public User getUserByUsername(String username) {
        for (User user:
                users) {
            if (user.getUserName().equals(username))
                return user;
        }
        return null;
    }

    public void addUser(User user) throws IOException, UserExistsException {
        userExists(user);
        users.add(user);
        saveUsers();
    }

    private void userExists(User user) throws UserExistsException {
        if (users != null) {
            for (User tempUser:
                    users) {
                if (tempUser.getEmail().equals(user.getEmail())) {
                    throw new UserExistsException("user already exist by email");
                }
                if (tempUser.getId() == user.getId()) {
                    throw new UserExistsException("user already exist by id");
                }
            }
        }
    }

    private void saveUsers() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        for (User user : users)
            objectOut.writeObject(user);
        objectOut.close();
    }
}
