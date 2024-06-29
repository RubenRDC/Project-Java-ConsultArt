package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.Deposito;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class DepositosDao {

    private final static int limitDep = 10;
    private static final DaoConnection C = new DaoConnection();
    private static List<String> paramsSql = new ArrayList<>();

    public DepositosDao() {
    }

    public static List<Deposito> getListDeps() {
        if (C.ExtablecerC() != null) {
            List<Deposito> listDepSimple = new ArrayList<>();
            String Query = "SELECT * FROM depositos;";
            ResultSet rsdepositos = C.GenericQuery(Query, null);
            try {
                while (rsdepositos.next()) {
                    listDepSimple.add(new Deposito(rsdepositos.getInt("id"), rsdepositos.getString("descrip")));
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return listDepSimple;
        }
        return null;
    }

    public static List<Deposito> getListDepsByTitleAndProv(String provincia, String desc, int limiteLista) {

        if (C.ExtablecerC() != null) {
            List<Deposito> listComplet = new ArrayList<>();

            String Query = "SELECT * FROM depositos WHERE descrip LIKE ? AND id LIKE ? LIMIT " + limiteLista;
            paramsSql.add(0, "%" + desc + "%");
            paramsSql.add(1, "%" + provincia + "%");

            ResultSet rs = C.GenericQuery(Query, paramsSql);
            try {
                while (rs.next()) {
                    listComplet.add(new Deposito(rs.getInt("id"), rs.getString("descrip"), rs.getString("provincia"), rs.getString("localidad"), rs.getString("direccion"), rs.getInt("numero")));
                }
            } catch (SQLException ex) {

            }
            paramsSql.clear();
            C.getCloseC();
            return listComplet;
        }

        return null;
    }

    public static Deposito getDepById(String idDep) {

        if (C.ExtablecerC() != null) {
            String Query = "SELECT * FROM depositos WHERE id = ?";

            ResultSet rs = C.QueryById(Query, Integer.parseInt(idDep));
            try {
                while (rs.next()) {
                    return new Deposito(rs.getInt("id"), rs.getString("descrip"), rs.getString("provincia"), rs.getString("localidad"), rs.getString("direccion"), rs.getInt("numero"));
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return null;
        }
        return null;
    }

    public static int getLimitDep() {
        return limitDep;
    }

    public static boolean delectDep(int idDep) {
        boolean exito = false;
        if (C.ExtablecerC() != null) {
            String Query = "DELETE FROM depositos where depositos.id = ?;";
            paramsSql.add(Integer.toString(idDep));
            exito = C.GenericUpdate(Query, paramsSql);
        }
        paramsSql.clear();
        C.getCloseC();
        return exito;
    }

    public static boolean insertNewDep(Deposito dep) {
        boolean exito = false;
        if (C.ExtablecerC() != null) {
            String Query = "INSERT INTO depositos (descrip,provincia,localidad,direccion,numero) VALUES (?,?,?,?,?);";
            paramsSql.add(dep.getNombre());
            paramsSql.add(dep.getProvincia());
            paramsSql.add(dep.getLocalidad());
            paramsSql.add(dep.getDireccion());
            paramsSql.add(Integer.toString(dep.getNumDireccion()));
            exito = C.GenericUpdate(Query, paramsSql);
        }
        paramsSql.clear();
        C.getCloseC();
        return exito;
    }

    public static boolean updateDep(Deposito dep) {
        boolean exito = false;
        if (C.ExtablecerC() != null) {
            String Query = "UPDATE depositos SET descrip = ? ,provincia = ? ,localidad = ?,direccion = ?, numero = ? WHERE id = ?;";
            paramsSql.add(dep.getNombre());
            paramsSql.add(dep.getProvincia());
            paramsSql.add(dep.getLocalidad());
            paramsSql.add(dep.getDireccion());
            paramsSql.add(Integer.toString(dep.getNumDireccion()));
            paramsSql.add(Integer.toString(dep.getId()));
            exito = C.GenericUpdate(Query, paramsSql);
        }
        paramsSql.clear();
        C.getCloseC();
        return exito;
    }
}
