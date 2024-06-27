package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.Articulo;
import com.rubenrdc.consultartoptimizado.models.UbicacionPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class UbicacionPrincDao {

    private List<String> paramsSql = new ArrayList<>();
    private DaoConnection abc = new DaoConnection();
    private UbicacionExtraDao ubicExtraDao = new UbicacionExtraDao();

    public HashMap ObtenerUbic(Articulo art) {
        if (abc.ExtablecerC() != null) {
            int i =0;
            String[][] stocks = new String[DepositosDao.getLimitDep()][2];
            HashMap ubicacion = new HashMap();
            String cUbics = "SELECT * FROM ubicaciones INNER JOIN depositos ON depositos.id=ubicaciones.idDep WHERE idArt = ?;";
            paramsSql.add(0, String.valueOf(art.getId()));
            ResultSet rsUbics = abc.GenericQuery(cUbics, paramsSql);
            try {
                while (rsUbics.next()) {
                    ubicacion.put(rsUbics.getString("depositos.descrip"),
                            new UbicacionPrincipal(rsUbics.getInt("ubicaciones.id"),
                                    rsUbics.getString("ubic"),
                                    ubicExtraDao.ObtenerListUbicExtra(rsUbics.getInt("ubicaciones.id"))));
                    stocks[i][0]=rsUbics.getString("depositos.descrip");
                    stocks[i][1]=rsUbics.getString("ubicaciones.exist");
                    i++;
                }
            } catch (SQLException ex) {
            }
            art.setStocks(stocks);
            paramsSql.clear();
            return ubicacion;
        }
        return null;
    }
}
