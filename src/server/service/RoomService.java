package server.service;

import server.entity.Place;
import server.entity.Room;

public class RoomService {
    public static void showRoom(Room room) {
        int i = 0;
        String place = "";
        for (int j = 0; j < 11; j++) System.out.print(j + " ");
        System.out.println();
        for (Place[] rows:
                room.getPlaces()) {
            System.out.print(++i + " ");
            for (Place column:
                    rows) {
                place = column.isBusy() ? "O" : "L";
                System.out.print(" " + place + " ");
            }
            System.out.println();
        }
    }
}
