package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.UbicacionExtra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class UbicacionExtraDao {

    private static DaoConnection abc = new DaoConnection();
    private static String Query;

    public static List<UbicacionExtra> ObtenerListUbicExtra(int idUbicPrincipal) {
        if (abc.ExtablecerC() != null) {
            Query = "SELECT * FROM ubicacion_extra WHERE idUbic = ?";
            ResultSet rsUbicExt = abc.QueryById(Query, idUbicPrincipal);
            List<UbicacionExtra> listaUbicExtra = new ArrayList<>();
            try {
                while (rsUbicExt.next()) {
                    listaUbicExtra.add(new UbicacionExtra(rsUbicExt.getInt("id"),rsUbicExt.getInt("idUbic"), rsUbicExt.getString("ubic")));
                }
            } catch (SQLException ex) {
            }
            abc.getCloseC();
            return listaUbicExtra;
        }
        return null;
    }

    public static boolean deleteUbicExtra(int idUbicExtra) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "DELETE FROM ubicacion_extra WHERE id = ?";
            exito = abc.GenericUpdate(Query, idUbicExtra);
            abc.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean AddUbicExtra(UbicacionExtra ubicEx) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "INSERT INTO ubicacion_extra (idUbic,ubic) VALUES (?,?)";
            exito = abc.GenericUpdate(Query, ubicEx.getIdUbicP(),ubicEx.getConcatUbic());
            abc.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean UpdateUbicExtra(UbicacionExtra ubicEx) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "UPDATE ubicacion_extra SET ubic = ? WHERE id = ?";
            exito = abc.GenericUpdate(Query, ubicEx.getConcatUbic(),ubicEx.getId());
            abc.getCloseC();
            return exito;
        }
        return false;
    }
}
