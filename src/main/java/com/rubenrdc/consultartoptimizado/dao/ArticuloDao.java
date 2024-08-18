package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.Articulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.rubenrdc.consultartoptimizado.models.interfaces.Utilities;

/**
 *
 * @author Ruben
 */
public class ArticuloDao implements Utilities {

    private static final DaoConnection genericDao = new DaoConnection();
    private static String query = "";

    public ArticuloDao() {
    }

    public static List getListArt(String code, int limiteLista) {
        if (genericDao.ExtablecerC() != null) {
            List<Articulo> list = new ArrayList<>();
            String Query = "SELECT * FROM articulos WHERE codigo LIKE ? OR descripcion LIKE ? LIMIT " + limiteLista;
            ResultSet rs = genericDao.GenericQuery(Query, "%" + code + "%", "%" + code + "%");
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
            genericDao.getCloseC();
            return list;
        }
        return null;
    }

    public static Articulo findBasicArticuloByCode(String code) {
        Articulo art = null;
        if (genericDao.ExtablecerC() != null) {
            String Query = "SELECT * FROM Articulos WHERE codigo = ? LIMIT 1";
            ResultSet GenericQuery = genericDao.GenericQuery(Query, code);

            try {
                while (GenericQuery.next()) {
                    art = new Articulo(GenericQuery.getInt("id"), GenericQuery.getString("codigo"), GenericQuery.getString("descripcion"), GenericQuery.getString("foto"));
                }
            } catch (SQLException ex) {
            }
            genericDao.getCloseC();
            return art;
        }
        return art;
    }

    public static Articulo findCompleteArticuloByCode(String code) {
        Articulo art = null;
        if (genericDao.ExtablecerC() != null) {
            String Query = "SELECT * FROM Articulos WHERE codigo = ? LIMIT 1";
            ResultSet GenericQuery = genericDao.GenericQuery(Query, code);

            try {
                while (GenericQuery.next()) {
                    art = new Articulo(GenericQuery.getInt("id"), GenericQuery.getString("codigo"), GenericQuery.getString("descripcion"), GenericQuery.getString("foto"));
                    art.setListCantsFromUbics(UbicacionDao.findUbicacionFromArticulo(art));
                }
            } catch (SQLException ex) {
            }
            genericDao.getCloseC();
            return art;
        }
        return null;
    }

    public static boolean addArticulo(Articulo varArt) {
        if (genericDao.ExtablecerC() != null) {
            query = "INSERT IGNORE INTO articulos (codigo,descripcion,foto) VALUES (?,?,?);";
            boolean exito = genericDao.GenericUpdate(query, varArt.getCodigo(), varArt.getDesc(), varArt.getFoto());
            genericDao.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean updateArticulo(Articulo varArt) {
        if (genericDao.ExtablecerC() != null) {
            query = "UPDATE articulos SET codigo = ? ,descripcion = ? ,foto = ? WHERE id = ? ;";
            boolean exito = genericDao.GenericUpdate(query, varArt.getCodigo(), varArt.getDesc(), varArt.getFoto(), varArt.getId());
            genericDao.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean eliminarArt(int idArt) {
        if (genericDao.ExtablecerC() != null) {
            query = "DELETE FROM articulos WHERE id = ?";
            boolean exito = genericDao.GenericUpdate(query, idArt);
            genericDao.getCloseC();
            return exito;
        }
        return false;
    }
}
