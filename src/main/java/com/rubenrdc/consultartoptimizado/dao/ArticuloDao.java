package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.interfaces.funtionsCom;
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

    private static List<String> paramsSql = new ArrayList<>(), datosArt = new ArrayList<>();
    private static DaoConnection abc = new DaoConnection();
    private static String query = "";

    public ArticuloDao() {
    }

    public static HashMap ObtenerUbicHashMap(Articulo art) {
        return UbicacionPrincDao.ObtenerUbic(art);
    }

    public static List getListArt(String code, int limiteLista) {
        if (abc.ExtablecerC() != null) {
            List<Articulo> list = new ArrayList<>();
            String Query = "SELECT * FROM articulos WHERE codigo LIKE ? OR descripcion LIKE ? LIMIT " + limiteLista;
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
            return list;
        }
        return null;
    }

    public static Articulo StrictSearchArt(String cod) {

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

    public static boolean addArticulo(Articulo varArt) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            query = "INSERT INTO articulos (codigo,descripcion,foto) VALUES (?,?,?);";
            datosArt.add(0, varArt.getCodigo());
            datosArt.add(1, varArt.getDesc());
            datosArt.add(2, varArt.getFoto());
            exito = abc.GenericUpdate(query, datosArt);
            
            abc.getCloseC();
            datosArt.clear();
            return exito;
        }
        return false;
    }

    public static boolean updateArticulo(Articulo varArt) {
        if (abc.ExtablecerC() != null) {
            query = "UPDATE articulos SET codigo = ? ,descripcion = ? ,foto = ? WHERE id = ? ;";
            boolean exito;
            datosArt.add(0, varArt.getCodigo());
            datosArt.add(1, varArt.getDesc());
            datosArt.add(2, varArt.getFoto());
            datosArt.add(3, String.valueOf(varArt.getId()));
            exito = abc.GenericUpdate(query, datosArt);
            
            abc.getCloseC();
            datosArt.clear();
            return exito;
        }
        return false;
    }

    public static boolean eliminarArt(int idArt) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            query = "DELETE FROM articulos WHERE id = ?";
            datosArt.add(String.valueOf(idArt));
            exito = abc.GenericUpdate(query, datosArt);
            
            abc.getCloseC();
            datosArt.clear();
            return exito;
        }
        return false;
    }
}
