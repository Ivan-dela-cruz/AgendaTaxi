package co.desofsi.taxiapp.models;

import java.io.Serializable;
import java.sql.Blob;

public class OwnerTaxi implements Serializable {

    private String name, phone, movil, email;
    private int id;
    private byte[] image;

    public OwnerTaxi(int id, String name, String phone, String movil, String email, byte[] image) {
        this.name = name;
        this.phone = phone;
        this.movil = movil;
        this.email = email;
        this.id = id;
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
