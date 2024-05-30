package com.rubenrdc.consultartoptimizado.models;

/**
 *
 * @author Ruben
 */
public class Deposito {

    private int id;
    private String nombre;

    public Deposito(int idDep, String nameDep) {
        this.id = idDep;
        this.nombre = nameDep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
