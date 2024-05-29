/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rubenrdc.consultartoptimizado.models;

/**
 *
 * @author Ruben
 */
public class Articulo {

    private int id;
    private String codigo, desc, foto,ubicConcat;
    private String[][] UbicPrinc = new String[1][2];
    private String[][] UbicExtra = new String[10][2];
    private String[][] stocks;
    private String[] row = new String[3];

    public Articulo(int idArt, String code, String desc, String foto) {
        this.id = idArt;
        this.codigo = code;
        this.desc = desc;
        this.foto = foto;
    }
    
    public Articulo(){}
    
    public String[] getRow(){
        row[0]=Integer.toString(id);
        row[1]=codigo;
        row[2]=desc;
        return row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String[][] getStocks() {
        return stocks;
    }

    public void setStocks(String[][] stocks) {
        this.stocks = stocks;
    }

    public String getUbicConcat() {
        return ubicConcat;
    }

    public void setUbicConcat(String ubicConcat) {
        this.ubicConcat = ubicConcat;
    }

    public String[][] getUbicPrinc() {
        return UbicPrinc;
    }

    public void setUbicPrinc(String[][] UbicPrinc) {
        this.UbicPrinc = UbicPrinc;
    }

    public String[][] getUbicExtra() {
        return UbicExtra;
    }

    public void setUbicExtra(String[][] UbicExtra) {
        this.UbicExtra = UbicExtra;
    }
    
}
