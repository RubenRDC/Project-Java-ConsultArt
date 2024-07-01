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

    private static List<String> paramsSql = new ArrayList<>();
    private static DaoConnection abc = new DaoConnection();
    private static String Query;

    public static HashMap ObtenerUbic(Articulo art) {
        if (abc.ExtablecerC() != null) {
            int i = 0;
            String[][] stocks = new String[DepositosDao.getLimitDep()][2];
            HashMap ubicacion = new HashMap();
            String cUbics = "SELECT * FROM ubicaciones INNER JOIN depositos ON depositos.id=ubicaciones.idDep WHERE idArt = ?;";
            paramsSql.add(0, String.valueOf(art.getId()));
            ResultSet rsUbics = abc.GenericQuery(cUbics, paramsSql);
            try {
                while (rsUbics.next()) {
                    ubicacion.put(rsUbics.getString("depositos.descrip"),
                            new UbicacionPrincipal(rsUbics.getInt("ubicaciones.id"),
                                    rsUbics.getInt("ubicaciones.idArt"),
                                    rsUbics.getInt("ubicaciones.idDep"),
                                    rsUbics.getInt("ubicaciones.exist"),
                                    rsUbics.getString("ubicaciones.ubic"),
                                    UbicacionExtraDao.ObtenerListUbicExtra(rsUbics.getInt("ubicaciones.id"))));
                    stocks[i][0] = rsUbics.getString("depositos.descrip");
                    stocks[i][1] = rsUbics.getString("ubicaciones.exist");
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

    public static boolean deleteUbicP(int idUbicP) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "DELETE FROM ubicaciones WHERE id = ?";
            paramsSql.add(Integer.toString(idUbicP));
            exito = abc.GenericUpdate(Query, paramsSql);

            paramsSql.clear();
            abc.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean AddUbicP(UbicacionPrincipal ubicP) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "INSERT INTO ubicaciones (idArt,idDep,exist,ubic) SELECT ?,?,?,? WHERE NOT EXISTS(SELECT 1 FROM ubicaciones WHERE idArt = ? AND idDep = ?);";
            paramsSql.add(0, String.valueOf(ubicP.getIdArt()));
            paramsSql.add(1, String.valueOf(ubicP.getIdDep()));
            paramsSql.add(2, String.valueOf(ubicP.getExist()));
            paramsSql.add(3, ubicP.getConcatUbic());
            paramsSql.add(4, String.valueOf(ubicP.getIdArt()));
            paramsSql.add(5, String.valueOf(ubicP.getIdDep()));
            exito = abc.GenericUpdate(Query, paramsSql);
            paramsSql.clear();
            abc.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean UpdateUbicP(UbicacionPrincipal ubicP) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "UPDATE ubicaciones SET exist = ?, ubic = ? WHERE id = ?";
            paramsSql.add(0, String.valueOf(ubicP.getExist()));
            paramsSql.add(1, ubicP.getConcatUbic());
            paramsSql.add(2, String.valueOf(ubicP.getId()));
            exito = abc.GenericUpdate(Query, paramsSql);

            paramsSql.clear();
            abc.getCloseC();
            return exito;
        }
        return false;
    }
}
