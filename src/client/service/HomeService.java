package client.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeService {
    private static final Scanner reader = new Scanner(System.in);

    public static int homeMenu() {
        int choice;
        do {
            System.out.println("1.Login");
            System.out.println("2.Signup");
            System.out.println("3.Exit");
            System.out.print("Choice : __");

            // get input and also handle errors
            try {
                choice = reader.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("please insert numbers");
                // consume the invalid token
                reader.next();
                continue;
            }

            // if choice is unknown
            if (choice > 3 || choice < 1) {
                System.out.println("please select the correct choice");
            } else
                break;
        } while (true);

        return choice;
    }
    public static int serviceMenu() {
        int choice;
        do {
            System.out.println("1.info");
            System.out.println("2.empty_places");
            System.out.println("3.reserve");
            System.out.println("4.logout");
            System.out.print("Choice : __");

            // get input and also handle errors
            try {
                choice = reader.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("please insert numbers");
                // consume the invalid token
                reader.next();
                continue;
            }

            // if choice is unknown
            if (choice > 4 || choice < 1) {
                System.out.println("please select the correct choice");
            } else
                break;
        } while (true);

        return choice;
    }
}
