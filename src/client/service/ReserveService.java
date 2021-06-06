package client.service;

import client.utils.Parameter;
import client.utils.Request;
import server.entity.PlaceCoordinate;
import server.entity.Reservation;
import server.entity.Room;
import server.service.ReservationService;
import server.service.RoomService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class ReserveService {
    private static final Scanner scanner = new Scanner(System.in);
    private static int row;
    private static int col;

    public static Request getReserveRequest() {
        Parameter rowp = new Parameter("row", row);
        Parameter colp = new Parameter("col", col);
        Vector<Parameter> parameters = new Vector<Parameter>();
        parameters.add(rowp);
        parameters.add(colp);
        return new Request("reserve", parameters);
    }

    public static void showInfo(Object object) {
        Vector<Reservation> reservations = (Vector<Reservation>) object;
        showReservations(reservations);
    }
    public static void showPlaces(Object object) {
        RoomService.showRoom((Room) object);
    }
    public static void getCoordinate() {
        System.out.println("-coordinates");
        do {
            System.out.println("row : __");
            try {
                row = scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("please row must be a number");
                scanner.next();
                continue;
            }
            if (row < 0) {
                System.out.println("please row must be a number great than 0");
                continue;
            }
            break;
        } while (true);

        do {
            System.out.println("col : __");
            try {
                col = scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("please col must be a number");
                scanner.next();
                continue;
            }
            if (col < 0) {
                System.out.println("please col must be a number great than 0");
                continue;
            }
            break;
        } while (true);
    }

    public static void showReservations(Vector<Reservation> reservations) {
        if (reservations != null) {
            System.out.println("Reservations: " + reservations.size());
            for (Reservation reservation:
                    reservations) {
                System.out.println("\treservation n." + reservation.getId());
                for (PlaceCoordinate placeCoordinate:
                        reservation.getPlaceCoordinates()) {
                    System.out.println("place row(" + placeCoordinate.getRow() + ") col(" + placeCoordinate.getColumn() + ")");
                }
            }
        } else {
            System.out.println("Reservations: " + 0);
        }
    }

}
