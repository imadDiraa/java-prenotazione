package server.service;

import server.entity.PlaceCoordinate;
import server.entity.Reservation;

import java.io.*;
import java.util.Vector;

public class ReservationService {
    public static int generateNewId() throws FileNotFoundException, IOException {
        final String source = "reservationId.txt";
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
