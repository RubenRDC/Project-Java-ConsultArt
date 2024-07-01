package com.rubenrdc.consultartoptimizado.models;

import com.rubenrdc.consultartoptimizado.models.interfaces.Exportables;
import com.rubenrdc.consultartoptimizado.models.modelAbstract.Ubicaciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class UbicacionPrincipal extends Ubicaciones implements Exportables {

    private int id,idArt,idDep,exist;
    private List<UbicacionExtra> ListUbicacionesExtras;
    private String concatUbic;
    private Object[] row = new Object[2];
    private String[] RowAtributos = new String[2];

    public UbicacionPrincipal(int id,int idArt,int idDep,int exist, String concatUbic, List<UbicacionExtra> ListUbicacionesExtras) {//Proposito General
        this.id = id;
        this.idArt=idArt;
        this.idDep=idDep;
        this.exist=exist;
        this.concatUbic = concatUbic;
        this.ListUbicacionesExtras = ListUbicacionesExtras;
    }
    public UbicacionPrincipal(int id,int exist, String concatUbic) {//Para Update
        this.id=id;
        this.exist=exist;
        this.concatUbic = concatUbic;
    }
    public UbicacionPrincipal(int idArt,int idDep,int exist, String concatUbic) {//Para Insert
        this.idArt=idArt;
        this.idDep=idDep;
        this.exist=exist;
        this.concatUbic = concatUbic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UbicacionExtra> getListUbicacionesExtras() {
        return ListUbicacionesExtras;
    }

    public void setListUbicacionesExtras(ArrayList<UbicacionExtra> ListUbicacionesExtras) {
        this.ListUbicacionesExtras = ListUbicacionesExtras;
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

    public int getIdArt() {
        return idArt;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int stock) {
        this.exist = stock;
    }
    
}
