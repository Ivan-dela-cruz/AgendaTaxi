package co.desofsi.taxiapp.models;

import java.io.Serializable;

public class Avatar implements Serializable {

    private int id;
    private int id_avatar;
    private String nombre;
    private String descripcion;

    public Avatar(int id, int id_avatar, String nombre, String descripcion) {
        this.id = id;
        this.id_avatar = id_avatar;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_avatar() {
        return id_avatar;
    }

    public void setId_avatar(int id_avatar) {
        this.id_avatar = id_avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
