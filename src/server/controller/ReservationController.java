package server.controller;

import client.utils.Parameter;
import client.utils.Request;
import client.utils.Response;
import server.ClientHandle;
import server.entity.*;
import server.exceptions.ReservationExistsException;
import server.model.ReservationModel;
import server.model.RoomModel;
import server.service.ReservationService;

import java.io.IOException;
import java.util.Vector;

public class ReservationController {

    public static Response emptyPlaces(Request request, ClientHandle handle) {

        // prepare info
        RoomModel roomModel = null;
        try {
            roomModel = new RoomModel();
        } catch (Exception e) {
            return new Response("error", 500);
        }

        Room room = roomModel.getRoom();
        return new Response("info", 200, room.clone());
    }

    public static Response info(Request request, ClientHandle handle) {
        // check user logged
        User user = handle.getUser();

        if (user == null) {
            return new Response("not authorizied", 401);
        }

        ReservationModel reservationModel = null;
        try {
            reservationModel = new ReservationModel();
        } catch (Exception e) {
            return new Response("server error", 500);
        }

        Vector<Reservation> reservations = reservationModel.getReservationsByUserId(user.getId());

        return new Response("success", 200, reservations);
    }

    public static Response reserve(Request request, ClientHandle handle) {
        // check user logged
        User user = handle.getUser();

        if (user == null) {
            return new Response("not authorizied", 401);
        }

        // check parameter col
        Parameter colp = request.getParameter("col");
        if (colp == null) {
            return new Response("parameter col not found", 200);
        }

        // check parameter row
        Parameter rowp = request.getParameter("row");
        if (rowp == null) {
            return new Response("parameter row not found", 200);
        }

        // get room
        RoomModel roomModel = null;
        try {
            roomModel = new RoomModel();
        } catch (Exception e) {
            return new Response("server error", 500);
        }
        int row = (int)rowp.getValue();
        int col = (int)colp.getValue();

        Reservation reservation = null;

        synchronized (roomModel) {
            Room room = roomModel.getRoom();

            // check place
            Place place = room.getPlace(row, col);

            if (place.isBusy()) {
                return new Response("place already busy", 302);
            }

            // pack place coordinate
            PlaceCoordinate placeCoordinate = new PlaceCoordinate(row, col);

            // make reservation
            try {
                reservation = new Reservation(user.getId(), ReservationService.generateNewId());
            } catch (IOException e) {
                return new Response("server error", 500);
            }

            try {
                reservation.addPlaceCoordinate(placeCoordinate);
            } catch (Exception e) {
                return new Response("server error", 500);
            }

            ReservationModel reservationModel = null;
            try {
                reservationModel = new ReservationModel();
            } catch (Exception e) {
                return new Response("server error", 500);
            }

            try {
                reservationModel.addReservation(reservation);
            } catch (ReservationExistsException | IOException e) {
                return new Response("server error", 500);
            }

            room.setPlace(true, row, col);
            roomModel.setRoom(room);
        }
        return new Response("success", 200, reservation);
    }
}
