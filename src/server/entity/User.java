package server.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 6529685098267757692L;

    private String userName;
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private String pass;
    private int id;
    private Vector<Reservation> reservations;

    public User(String firstname, String lastname, String email, int age, String pass, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.pass = pass;
        this.id = id;
        this.userName = firstname + " " + lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Vector<Reservation> getReservations() {
        return reservations;
    }

    public void addReservations(Reservation reservation) throws Exception {
        if (this.reservations.contains(reservation)) {
            throw new Exception("reservation already exists");
        }
        this.reservations.add(reservation);
    }

    public void removeReservations(Reservation reservation) {
        this.reservations.remove(reservation);
    }
}
