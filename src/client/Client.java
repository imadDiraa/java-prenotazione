package client;

import client.service.HomeService;
import client.service.LoginService;
import client.service.RegistrationService;
import client.service.ReserveService;
import client.utils.Request;
import client.utils.Response;
import server.entity.Reservation;
import server.entity.Room;
import server.service.RoomService;

import java.io.*;
import java.net.Socket;

public class Client {

    public static int serverPort = 5000;
    public static String serverHost = "localhost";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            socket = new Socket(serverHost, serverPort);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR 500 (^_^)");
            System.exit(500);
        }


        System.out.println("Welcome Anonymous user please login or signup to access cinema services");
        Response response;
        do {
            do {
                int choice = HomeService.homeMenu();
                if (choice == 1) {
                    LoginService.login();
                    objectOutputStream.writeObject(LoginService.getRequest());
                } else if (choice == 2) {
                    RegistrationService.registration();
                    objectOutputStream.writeObject(RegistrationService.getRequest());
                } else if (choice == 3) {
                    System.out.println("thanks see you later (^__^)");
                    System.exit(200);
                }

                response = (Response) objectInputStream.readObject();

                System.out.println(response.getMessage());



            } while (response.getStatus() != 200);

            do {
                int choice = HomeService.serviceMenu();
                if (choice == 1) {
                    objectOutputStream.writeObject(new Request("info"));
                    response = (Response) objectInputStream.readObject();
                    ReserveService.showInfo(response.getResult());
                } else if (choice == 2) {
                    objectOutputStream.writeObject(new Request("empty_places"));
                    response = (Response) objectInputStream.readObject();
                    RoomService.showRoom((Room)response.getResult());
                } else if (choice == 3) {
                    ReserveService.getCoordinate();
                    objectOutputStream.writeObject(ReserveService.getReserveRequest());
                    response = (Response) objectInputStream.readObject();
                    System.out.println(response.getMessage());
                } else if (choice == 4) {
                    System.out.println("thanks see you later (^__^)");
                    break;
                }
            } while (true);
        } while (true);
    }
}