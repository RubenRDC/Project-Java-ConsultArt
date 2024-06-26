package com.rubenrdc.consultartoptimizado.models;

import com.rubenrdc.consultartoptimizado.models.interfaces.Exportables;

/**
 *
 * @author Ruben
 */
public class UbicacionExtra implements Exportables{

    private int id;
    private int idUbicacionPrincipal;
    private char sector;
    private int pasillo, estante, cajon, altura;
    private Object[] row = new Object[2];
    private String[] RowAtributos = new String[2];
    
    private String concatUbic;

    public UbicacionExtra(int id, int idUbicacionPrincipal, char sector, int pasillo, int estante, int cajon, int altura) {
        this.id = id;
        this.idUbicacionPrincipal = idUbicacionPrincipal;
        this.sector = sector;
        this.pasillo = pasillo;
        this.estante = estante;
        this.cajon = cajon;
        this.altura = altura;
    }

    public UbicacionExtra(int id, String concatUbic) {
        this.id=id;
        this.concatUbic=concatUbic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUbicacionPrincipal() {
        return idUbicacionPrincipal;
    }

    public void setIdUbicacionPrincipal(int idUbicacionPrincipal) {
        this.idUbicacionPrincipal = idUbicacionPrincipal;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    public int getCajon() {
        return cajon;
    }

    public void setCajon(int cajon) {
        this.cajon = cajon;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getConcatUbic() {
        return concatUbic;
    }

    public void setConcatUbic(char sector, int pasillo, int estante, int cajon, int altura) {
        String p = Integer.toString(pasillo), e = Integer.toString(estante), c = Integer.toString(cajon), a = Integer.toString(altura);
        if (pasillo < 10) {
            p = "0" + pasillo;
        }
        if (estante < 10) {
            e = "0" + estante;
        }
        if (cajon < 10) {
            c = "0" + cajon;
        }
        if (altura < 10) {
            a = "0" + altura;
        }

        this.concatUbic = sector + p + "-" + e + c + "-" + a;
    }

    public void setConcatUbic(String ConcatUbic) {
        this.concatUbic = ConcatUbic;
    }

    public char getSector() {
        return sector;
    }

    public void setSector(char sector) {
        this.sector = sector;
    }
    
    @Override
    public Object[] getRow() {
        row[0] = id;
        row[1] = concatUbic;
        return row;
    }

    @Override
    public String[] getTitulosAtributos() {

        RowAtributos[0] = "ID";
        RowAtributos[1] = "Ubicacion";
        return RowAtributos;
    }
}
