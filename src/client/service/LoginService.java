package client.service;

import client.utils.Parameter;
import client.utils.Request;

import java.util.Scanner;
import java.util.Vector;

public class LoginService {
    private static final Scanner scanner = new Scanner(System.in);
    private static String userName;
    private static String password;

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void login() {
        loginMenu();
    }

    private static void loginMenu() {
        System.out.println("-Login");
        System.out.println("user name(FirstName LastName) : __");
        userName = scanner.nextLine();
        System.out.println("password : __");
        password = scanner.next();
        scanner.nextLine();
    }

    public static Request getRequest() {
        Parameter userNameParameter = new Parameter("username", userName);
        Parameter passwordParameter = new Parameter("password", password);
        Vector<Parameter> parameters = new Vector<Parameter>();
        parameters.add(userNameParameter);
        parameters.add(passwordParameter);
        Request request = new Request("login", parameters);
        return request;
    }
}
