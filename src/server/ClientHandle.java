package server;

import client.utils.Parameter;
import server.controller.Controller;
import client.utils.Request;
import client.utils.Response;
import server.entity.User;

import java.io.*;
import java.net.Socket;

public class ClientHandle implements Runnable {

    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    Socket socket;
    User user;

    public ClientHandle(Socket socket) throws IOException {
        this.socket = socket;
        this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        this.user = null;
    }

    public void run() {
        System.out.println("client connected");

        while (true) {
            Request request = null;
            try {
                request = (Request) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            Response response = Controller.index(request, this);

            try {
                objectOutputStream.writeUnshared(response);
                objectOutputStream.reset();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void sendData(String data) {

    }

    private String getData() {
        return "";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}
