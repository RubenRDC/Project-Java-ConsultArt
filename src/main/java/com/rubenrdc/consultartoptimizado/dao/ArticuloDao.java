package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.funtionsComp.funtionsCom;
import com.rubenrdc.consultartoptimizado.models.Articulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class ArticuloDao implements funtionsCom {

    private List<String> paramsSql = new ArrayList<>(), datosArt = new ArrayList<>();
    private DaoConnection abc = new DaoConnection();
    private List<Articulo> list = new ArrayList<>();
    private UbicacionPrincDao ubicPrincDao = new UbicacionPrincDao();

    public ArticuloDao() {
    }

    public HashMap ObtenerUbicHashMap(Articulo art) {
        return ubicPrincDao.ObtenerUbic(art);
    }

    public List getListArt(String code, int limiteLista) {
        list.clear();
        String Query = "SELECT * FROM articulos WHERE codigo LIKE ? OR descripcion LIKE ? LIMIT " + limiteLista;

        if (abc.ExtablecerC() != null) {
            paramsSql.add("%" + code + "%");
            paramsSql.add("%" + code + "%");
            ResultSet rs = abc.GenericQuery(Query, paramsSql);
            try {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String cod = rs.getString("codigo");
                    String descrip = rs.getString("descripcion");
                    String foto = rs.getString("foto");

                    list.add(new Articulo(id, cod, descrip, foto));
                }
            } catch (SQLException e) {
                System.out.println("SQLException " + e);
            }
            paramsSql.clear();
            abc.getCloseC();
        }
        return list;
    }

    public Articulo StrictSearchArt(String cod) {

        if (abc.ExtablecerC() != null) {
            String Query = "SELECT * FROM articulos WHERE codigo = ?";
            Articulo art = null;
            paramsSql.add(cod);
            ResultSet rs = abc.GenericQuery(Query, paramsSql);
            try {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String codigo = rs.getString("codigo");
                    String descrip = rs.getString("descripcion");
                    String foto = rs.getString("foto");

                    art = new Articulo(id, codigo, descrip, foto);
                    art.setUbicacion(ObtenerUbicHashMap(art));
                }
            } catch (SQLException e) {
                System.out.println("SQLException " + e);
            }
            paramsSql.clear();
            abc.getCloseC();
            return art;
        }
        return null;
    }

    public void addArticulo(Articulo varArt) {

        datosArt.add(0, varArt.getCodigo());
        datosArt.add(1, varArt.getDesc());
        datosArt.add(2, varArt.getFoto());

        boolean exito = UpOrDelectOrInsert(datosArt);
        if (exito) {
            msgInfo(1);
        } else {
            msgInfo(0);
        }
        datosArt.clear();
    }

    public void updateArticulo(Articulo varArt) {

        datosArt.add(0, varArt.getCodigo());
        datosArt.add(1, varArt.getDesc());
        datosArt.add(2, varArt.getFoto());
        datosArt.add(3, String.valueOf(varArt.getId()));

        boolean exito = UpOrDelectOrInsert(datosArt);
        if (exito) {
            msgInfo(1);
        } else {
            msgInfo(0);
        }
        datosArt.clear();
    }

    public void eliminarArt(int idArt) {
        boolean exito = false;
        datosArt.add(String.valueOf(idArt));
        exito = UpOrDelectOrInsert(datosArt);

        datosArt.clear();
        if (exito) {
            msgInfo(1);
        } else {
            msgInfo(0);
        }
    }

    private boolean UpOrDelectOrInsert(List<String> datosArt) {
        String query = "";
        boolean exito = false;
        if (abc.ExtablecerC() != null) {
            if (datosArt.size() == 4) {
                query = "UPDATE articulos SET codigo = ? ,descripcion = ? ,foto = ? WHERE id = ? ;";
                return abc.GenericUpdate(query, datosArt);
            }

            if (datosArt.size() == 3) {
                query = "INSERT INTO articulos (codigo,descripcion,foto) VALUES (?,?,?);";
                return abc.GenericUpdate(query, datosArt);
            }

            if (datosArt.size() == 1) {
                query = "SELECT id FROM ubicaciones WHERE idArt = ?";
                int idArt = Integer.parseInt(datosArt.get(0));
                ResultSet rs = abc.QueryById(query, idArt);

                try {

                    while (rs.next()) {
                        paramsSql.add(rs.getString("id"));

                        query = "DELETE FROM ubicacion_extra WHERE idUbic = ?";
                        abc.GenericUpdate(query, paramsSql);

                        query = "DELETE FROM ubicaciones WHERE id = ?";
                        abc.GenericUpdate(query, paramsSql);
                    }
                    query = "DELETE FROM articulos WHERE id = ?";
                    exito = abc.GenericUpdate(query, datosArt);

                } catch (SQLException ex) {

                }
            }
            paramsSql.clear();
            abc.getCloseC();
        }
        return exito;
    }
}
