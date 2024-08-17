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
            ResultSet rs = abc.GenericQuery(Query, "%" + code + "%", "%" + code + "%");
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
            abc.getCloseC();
            return list;
        }
        return null;
    }

    public static Articulo StrictSearchArt(String cod) {

        if (abc.ExtablecerC() != null) {
            String Query = "SELECT * FROM articulos WHERE codigo = ?";
            Articulo art = null;
            ResultSet rs = abc.GenericQuery(Query, cod);
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
            abc.getCloseC();
            return art;
        }
        return null;
    }

    public static boolean addArticulo(Articulo varArt) {
        if (abc.ExtablecerC() != null) {
            query = "INSERT INTO articulos (codigo,descripcion,foto) VALUES (?,?,?);";
            boolean exito = abc.GenericUpdate(query, varArt.getCodigo(), varArt.getDesc(), varArt.getFoto());
            abc.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean updateArticulo(Articulo varArt) {
        if (abc.ExtablecerC() != null) {
            query = "UPDATE articulos SET codigo = ? ,descripcion = ? ,foto = ? WHERE id = ? ;";
            boolean exito = abc.GenericUpdate(query, varArt.getCodigo(), varArt.getDesc(), varArt.getFoto(), varArt.getId());
            abc.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean eliminarArt(int idArt) {
        if (abc.ExtablecerC() != null) {
            query = "DELETE FROM articulos WHERE id = ?";
            boolean exito = abc.GenericUpdate(query, idArt);
            abc.getCloseC();
            return exito;
        }
        return false;
    }
}
