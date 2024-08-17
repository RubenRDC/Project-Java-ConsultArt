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

    private static DaoConnection abc = new DaoConnection();
    private static String Query;

    public static HashMap ObtenerUbic(Articulo art) {
        if (abc.ExtablecerC() != null) {
            List<Object[]> stock = new ArrayList<>();
            Object[] aux;
            HashMap ubicacion = new HashMap();
            String cUbics = "SELECT * FROM ubicaciones INNER JOIN depositos ON depositos.id=ubicaciones.idDep WHERE idArt = ?;";
            ResultSet rsUbics = abc.GenericQuery(cUbics, art.getId());
            try {
                while (rsUbics.next()) {
                    aux = new String[2];
                    ubicacion.put(rsUbics.getString("depositos.descrip"),
                            new UbicacionPrincipal(rsUbics.getInt("ubicaciones.id"),
                                    rsUbics.getInt("ubicaciones.idArt"),
                                    rsUbics.getInt("ubicaciones.idDep"),
                                    rsUbics.getInt("ubicaciones.exist"),
                                    rsUbics.getString("ubicaciones.ubic"),
                                    UbicacionExtraDao.ObtenerListUbicExtra(rsUbics.getInt("ubicaciones.id"))));
                    aux[0]=rsUbics.getString("depositos.descrip");
                    aux[1]=rsUbics.getString("ubicaciones.exist");
                    stock.add(aux);
                }
            } catch (SQLException ex) {
            }
            art.setStocks(stock);
            return ubicacion;
        }
        return null;
    }

    public static boolean deleteUbicP(int idUbicP) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "DELETE FROM ubicaciones WHERE id = ?";
            exito = abc.GenericUpdate(Query, idUbicP);
            abc.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean AddUbicP(UbicacionPrincipal ubicP) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "INSERT INTO ubicaciones (idArt,idDep,exist,ubic) SELECT ?,?,?,? WHERE NOT EXISTS(SELECT 1 FROM ubicaciones WHERE idArt = ? AND idDep = ?);";
            exito = abc.GenericUpdate(Query, ubicP.getIdArt(),ubicP.getIdDep(),ubicP.getExist(),ubicP.getConcatUbic(),ubicP.getIdArt(),ubicP.getIdDep());
            abc.getCloseC();
            return exito;
        }
        return false;
    }

    public static boolean UpdateUbicP(UbicacionPrincipal ubicP) {
        if (abc.ExtablecerC() != null) {
            boolean exito;
            Query = "UPDATE ubicaciones SET exist = ?, ubic = ? WHERE id = ?";
            exito = abc.GenericUpdate(Query, ubicP.getExist(),ubicP.getConcatUbic(),ubicP.getId());
            abc.getCloseC();
            return exito;
        }
        return false;
    }
}
