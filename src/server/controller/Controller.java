package server.controller;

import client.utils.Request;
import client.utils.Response;
import server.ClientHandle;

public class Controller {
    static public Response index(Request request, ClientHandle handler) {
        return switch (request.getPath()) {
            case "login" -> UserController.login(request, handler);
            case "registration" -> UserController.registration(request, handler);
            case "info" -> ReservationController.info(request, handler);
            case "reserve" -> ReservationController.reserve(request, handler);
            case "empty_places" -> ReservationController.emptyPlaces(request, handler);
            default -> new Response("invalid path error", 400);
        };
    }
}
