package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.UbicacionExtra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruben
 */
public class UbicacionExtraDao {

    private static DaoConnection abc = new DaoConnection();

    public static List<UbicacionExtra> ObtenerListUbicExtra(int idUbicPrincipal) {
        if (abc.ExtablecerC() != null) {
            String cUbicExt = "SELECT * FROM ubicacion_extra WHERE idUbic = ?";
            ResultSet rsUbicExt = abc.QueryById(cUbicExt, idUbicPrincipal);
            List<UbicacionExtra> listaUbicExtra = new ArrayList<>();
            try {
                while (rsUbicExt.next()) {
                    listaUbicExtra.add(new UbicacionExtra(rsUbicExt.getInt("id"), rsUbicExt.getString("ubic")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UbicacionExtraDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listaUbicExtra;
        }
        return null;
    }
}
