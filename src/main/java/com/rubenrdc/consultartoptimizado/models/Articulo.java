package com.rubenrdc.consultartoptimizado.models;

/**
 *
 * @author Ruben
 */
public class Articulo {

    private final int limitUbicExtra = 10, limitUbicP = 1;
    private int id;
    private String codigo, desc, foto, ubicConcat;
    private String[][] UbicPrinc = new String[limitUbicP][2];
    private String[][] UbicExtra = new String[limitUbicExtra][2];
    private String[][] stocks;
    private Object[] row = new Object[4];
    private String[] RowAtributos = new String[4];

    public Articulo(int idArt, String code, String desc, String foto) {
        this.id = idArt;
        this.codigo = code;
        this.desc = desc;
        this.foto = foto;
    }

    public Articulo() {
    }

    public Object[] getRow() {
        row[0] = id;
        row[1] = codigo;
        row[2] = desc;
        row[3]= foto;
        return row;
    }

    public String[] getTitulosAtributos() {
        
        RowAtributos[0] = "ID";
        RowAtributos[1] = "Codigo";
        RowAtributos[2] = "Descripcion";
        RowAtributos[3] = "URL Foto";
        return RowAtributos;
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

    public int getLimitUbicExtra() {
        return limitUbicExtra;
    }

    public int getLimitUbicP() {
        return limitUbicP;
    }

}
