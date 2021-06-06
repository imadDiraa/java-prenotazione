package server.entity;

import java.io.Serial;
import java.io.Serializable;

public class Room implements Serializable {

    @Serial
    private static final long serialVersionUID = 6529685098267757691L;

    private final Place[][] places;

    public Room(Place[][] places) {
        this.places = places;
    }

    public Place[][] getPlaces() {
        return places.clone();
    }

    public synchronized void setPlace(Place place, int row, int column) {
        places[row][column].setBusy(place.isBusy());
    }

    public synchronized void setPlace(boolean busy, int row, int column) {
        places[row][column].setBusy(busy);
    }

    public Place getPlace(int row, int column) {
        return places[row][column];
    }
    public Room clone() {
        return new Room(places.clone());
    }
}
