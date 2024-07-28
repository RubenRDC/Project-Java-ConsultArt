package com.rubenrdc.consultartoptimizado.models;

import com.rubenrdc.consultartoptimizado.models.interfaces.Exportable;
import com.rubenrdc.consultartoptimizado.models.modelAbstract.Ubicaciones;

/**
 *
 * @author Ruben
 */
public class UbicacionExtra extends Ubicaciones implements Exportable{

    private int id,idUbicP;
    private final Object[] row = new Object[2];
    private String concatUbic;

    public UbicacionExtra(int id,int idUbicP, String concatUbic) {//Para uso general.
        this.id=id;
        this.idUbicP=idUbicP;
        this.concatUbic=concatUbic;
    }
    public UbicacionExtra(int idUbicP, String concatUbic) {//Para Inserts
        this.idUbicP=idUbicP;
        this.concatUbic=concatUbic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUbicP() {
        return idUbicP;
    }

    public void setIdUbicP(int idUbicP) {
        this.idUbicP = idUbicP;
    }
    
    @Override
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

    @Override
    public void setConcatUbic(String ConcatUbic) {
        this.concatUbic = ConcatUbic;
    }
    
    @Override
    public Object[] getRow() {
        row[0] = id;
        row[1] = concatUbic;
        return row;
    }
}
