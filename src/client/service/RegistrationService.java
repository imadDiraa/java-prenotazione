package client.service;

import client.utils.Parameter;
import client.utils.Request;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class RegistrationService {
    private static final Scanner scanner = new Scanner(System.in);
    private static String firstname;
    private static String lastname;
    private static String email;
    private static String password;
    private static int age;

    public static String getFirstname() {
        return firstname;
    }

    public static String getLastname() {
        return lastname;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static int getAge() {
        return age;
    }

    public static void registration() {
        registrationMenu();

    }

    private static void registrationMenu() {
        System.out.println("-registration");
        // first name
        System.out.println("first name : __");
        firstname = scanner.next();

        System.out.println(firstname);

        // last name
        System.out.println("last name : __");
        lastname = scanner.next();

        // age
        do {
            System.out.println("age : __");
            try {
                age = scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("please age must be a number");
                scanner.next();
                continue;
            }
            if (age < 0) {
                System.out.println("please age must be a number great than 0");
                continue;
            }
            break;
        } while (true);

        // email
        System.out.println("email : __");
        email = scanner.next();

        // password
        System.out.println("password : __");
        password = scanner.next();
    }

    public static Request getRequest() {
        Parameter firstNameParameter = new Parameter("firstname", firstname);
        Parameter lastNameParameter = new Parameter("lastname", lastname);
        Parameter emailParameter = new Parameter("email", email);
        Parameter ageParameter = new Parameter("age", age);
        Parameter passwordParameter = new Parameter("password", password);
        Vector<Parameter> parameters = new Vector<Parameter>();
        parameters.add(firstNameParameter);
        parameters.add(lastNameParameter);
        parameters.add(emailParameter);
        parameters.add(ageParameter);
        parameters.add(passwordParameter);
        Request request = new Request("registration", parameters);
        return request;
    }
}
