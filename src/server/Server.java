package server;

import server.entity.Place;
import server.entity.Reservation;
import server.entity.Room;
import server.exceptions.ReservationExistsException;
import server.model.ReservationModel;
import server.model.RoomModel;
import server.service.RoomService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    ServerSocket serverSocket;
    int port;

    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
        System.out.println("server listening in port: " + port);
    }

    public void start() throws IOException {
        // server data initialization

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("user connected");
            ClientHandle clientHandle = new ClientHandle(socket);
            Thread thread = new Thread(clientHandle);
            thread.start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, ReservationExistsException {
        Server server = null;
        try {
            server = new Server(5000);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null)
                server.stop();
        }
    }
}
