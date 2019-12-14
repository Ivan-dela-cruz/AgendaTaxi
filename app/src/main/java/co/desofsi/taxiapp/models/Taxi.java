package co.desofsi.taxiapp.models;

import java.io.Serializable;

public class Taxi implements Serializable {

    private String description, model;
    private int id, id_owner;
    private byte[] image;
    private double price;


    public Taxi(int id, String description, String model, byte[] image, double price, int id_owner) {
        this.description = description;
        this.model = model;
        this.id = id;
        this.id_owner = id_owner;
        this.image = image;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
