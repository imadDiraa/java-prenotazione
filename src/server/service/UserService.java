package server.service;

import client.utils.Parameter;
import client.utils.Request;

import javax.xml.transform.Source;
import java.io.*;
import java.util.Scanner;

public class UserService {
    public static void checkRegistrationParameters(Request request) throws Exception {
        Parameter firstnameParameter = request.getParameter("firstname");

        if (firstnameParameter == null) {
            throw new Exception("parameter firstname not found");
        }

        Parameter lastnameParameter = request.getParameter("lastname");

        if (lastnameParameter == null) {
            throw new Exception("parameter lastname not found");
        }

        Parameter emailParameter = request.getParameter("email");

        if (emailParameter == null) {
            throw new Exception("parameter email not found");
        }
        Parameter ageParameter = request.getParameter("age");

        if (ageParameter == null) {
            throw new Exception("parameter age not found");
        }

        Parameter passwordParameter = request.getParameter("password");

        if (passwordParameter == null) {
            throw new Exception("parameter password not found");
        }
    }

    public static int generateNewId() throws FileNotFoundException, IOException {
        final String source = "userId.txt";
        int id = 0;

        File file = new File(source);

        // if file not exists
        if (file.createNewFile()) {
            PrintWriter pw = new PrintWriter(source);
            pw.print(++id);
            pw.close();
        } else {
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(file));
            String text = reader.readLine();
            id = Integer.parseInt(text);
            reader.close();

            // rewriting file
            PrintWriter pw = new PrintWriter(source);
            pw.print(++id);
            pw.close();
        }
        return id;
    }

}
