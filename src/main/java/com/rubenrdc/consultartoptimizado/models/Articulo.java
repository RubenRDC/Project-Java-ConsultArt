package com.rubenrdc.consultartoptimizado.models;

import com.rubenrdc.consultartoptimizado.models.interfaces.Exportable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class Articulo implements Exportable{

    private final int limitUbicExtra = 10, limitUbicP = 1;
    private int id;
    private String codigo, desc, foto, ubicConcat;
    private List<Object[]> stocks;
    private final Object[] row = new Object[4];
    private HashMap Ubicacion;

    public Articulo(int idArt, String code, String desc, String foto) {
        this.id = idArt;
        this.codigo = code;
        this.desc = desc;
        this.foto = foto;
    }

    public Articulo() {
    }

    @Override
    public Object[] getRow() {
        row[0] = id;
        row[1] = codigo;
        row[2] = desc;
        row[3] = foto;
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

    public List<Object[]> getStocks() {
        return stocks;
    }

    public void setStocks(List<Object[]> stocks) {
        this.stocks = stocks;
    }

    public String getUbicsConcat(String DepName) {
        UbicacionPrincipal ubicPrinc = (UbicacionPrincipal) Ubicacion.get(DepName);
        if (ubicPrinc != null) {
            List<UbicacionExtra> listUbicacionesExtras = ubicPrinc.getListUbicacionesExtras();
            ubicConcat = ubicPrinc.getConcatUbic();
            if (!listUbicacionesExtras.isEmpty()) {
                int p = 1;
                for (UbicacionExtra listUbicacionesExtra : listUbicacionesExtras) {
                    if (p < 3) {
                        ubicConcat += " | ";
                        ubicConcat += listUbicacionesExtra.getConcatUbic();
                        p++;
                    } else {
                        ubicConcat += "\n";
                        ubicConcat += listUbicacionesExtra.getConcatUbic();
                        p = 1;
                    }
                }
                return ubicConcat;
            } else {
                return ubicConcat;
            }
        }
        return null;
    }

    public int getLimitUbicExtra() {
        return limitUbicExtra;
    }

    public int getLimitUbicP() {
        return limitUbicP;
    }

    public HashMap getUbicacionHashMap() {
        return Ubicacion;
    }

    public List<UbicacionExtra> getUbicacionExtra(String DepName) {
        if (this.getUbicacionPrincipal(DepName) != null) {
            UbicacionPrincipal UbicP = this.getUbicacionPrincipal(DepName).get(0);
            if (UbicP != null) {
                if (!UbicP.getListUbicacionesExtras().isEmpty()) {
                    return UbicP.getListUbicacionesExtras();
                }
            }
        }
        return null;
    }

    public List<UbicacionPrincipal> getUbicacionPrincipal(String DepName) {
        UbicacionPrincipal ubicPrinc = (UbicacionPrincipal) Ubicacion.get(DepName);
        if (ubicPrinc != null) {
            List<UbicacionPrincipal> listaUbicP = new ArrayList<>();
            listaUbicP.add(ubicPrinc);
            return listaUbicP;
        }
        return null;
    }

    public void setUbicacion(HashMap Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public void setUbicConcat(String ubicConcat) {
        this.ubicConcat = ubicConcat;
    }

}
