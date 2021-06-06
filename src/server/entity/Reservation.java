package server.entity;

import java.io.Serializable;
import java.util.Vector;

public class Reservation implements Serializable {

    private static final long serialVersionUID = 6549685098267757692L;
    private int user_id;
    private int id;
    private Vector<PlaceCoordinate> placeCoordinates;

    public Reservation(int user_id, int id, Vector<PlaceCoordinate> placeCoordinates) {
        this.user_id = user_id;
        this.id = id;
        this.placeCoordinates = placeCoordinates;
    }

    public Reservation(int user_id, int id) {
        this.user_id = user_id;
        this.id = id;
        this.placeCoordinates = new Vector<PlaceCoordinate>();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addPlaceCoordinate(PlaceCoordinate placeCoordinate) throws Exception {
        if (this.placeCoordinates.contains(placeCoordinate)) {
            throw new Exception("coordinate already exists");
        }
        this.placeCoordinates.add(placeCoordinate);
    }

    public void removePlaceCoordinate(PlaceCoordinate placeCoordinate) {
        this.placeCoordinates.remove(placeCoordinate);
    }

    public Vector<PlaceCoordinate> getPlaceCoordinates() {
        return placeCoordinates;
    }
}
