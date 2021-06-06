package server.model;

import server.entity.Place;
import server.entity.Room;
import java.io.*;

public class RoomModel {

    private static final String source = "room.txt";
    private static final File file = new File(source);
    private static Room room = null;

    public RoomModel() throws IOException {
        if (room == null) {
            if (!file.createNewFile()) {
                try {
                    FileInputStream fileIn = new FileInputStream(file);
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                    Object obj;

                    if ((obj = objectIn.readObject()) != null)
                        room = (Room) obj;
                    objectIn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                Place[][] places = new Place[15][10];
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 10; j++) {
                        places[i][j] = new Place();
                    }
                }
                room = new Room(places);
                saveRoom();
            }
        }
    }

    public Room getRoom() {
        return room.clone();
    }

    public synchronized void setRoom(Room room) {
        RoomModel.room = room;
        saveRoom();
    }

    public synchronized void saveRoom() {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(room);
            objectOut.close();
        } catch (Exception ex) {
                ex.printStackTrace();
        }
    }
}
