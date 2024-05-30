package com.rubenrdc.consultartoptimizado.models;

/**
 *
 * @author Ruben
 */
public class Deposito {

    private int id,numDireccion;
    private String nombre,provincia,localidad,direccion;

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

    public int getNumDireccion() {
        return numDireccion;
    }

    public void setNumDireccion(int numDireccion) {
        this.numDireccion = numDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
