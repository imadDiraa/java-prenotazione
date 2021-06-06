package server.model;

import server.entity.Reservation;
import server.exceptions.ReservationExistsException;

import java.io.*;
import java.util.Vector;

public class ReservationModel {
    private static final String source = "reservations.txt";
    private static final File file = new File(source);
    private static Vector<Reservation> reservations = new Vector<Reservation>();

    public ReservationModel() throws IOException, ClassNotFoundException {
        if (!file.createNewFile()) {
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Object obj;

                while ((obj = objectIn.readObject()) != null)
                    reservations.add((Reservation) obj);
                objectIn.close();
            } catch (Exception ex) {
//                ex.printStackTrace();
            }
        }
    }

    public Reservation getReservationById(int id) {
        for (Reservation reservation:
                reservations) {
            if (reservation.getId() == id)
                return reservation;
        }
        return null;
    }

    public Vector<Reservation> getReservationsByUserId(int id) {
        Vector<Reservation> reservationsResult = new Vector<Reservation>();
        for (Reservation reservation:
                reservations) {
            if (reservation.getUser_id() == id)
                reservationsResult.add(reservation);
        }
        if (reservationsResult.size() > 0)
            return reservationsResult;
        return null;
    }

    public void addReservation(Reservation reservation) throws ReservationExistsException, IOException {
        reservationExists(reservation);
        reservations.add(reservation);
        saveReservations();
    }

    private void reservationExists(Reservation reservation) throws ReservationExistsException {
        if (reservation != null) {
            for (Reservation reservationIterator:
                    reservations) {
                if (reservationIterator.getId() == reservation.getId()) {
                    throw new ReservationExistsException("reservation already exist by id");
                }
            }
        }
    }

    private void saveReservations() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        for (Reservation reservation : reservations)
            objectOut.writeObject(reservation);
        objectOut.close();
    }
}
