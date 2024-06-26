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
    private DaoConnection C = new DaoConnection();
    private Deposito dep;
    private List<Deposito> listDepSimple;
    private List<Deposito> listComplet;
    private List<String> paramsSql = new ArrayList<>();

    public DepositosDao() {
    }

    public List<Deposito> getDepositos() {
        int f = 0;
        if (C.ExtablecerC() != null) {
            listDepSimple = new ArrayList<>();
            String Query = "SELECT * FROM depositos;";
            ResultSet rsdepositos = C.GenericQuery(Query, null);
            //Consulta cantidad de Depositos
            try {
                while (rsdepositos.next()) {
                    dep = new Deposito(rsdepositos.getInt("id"), rsdepositos.getString("descrip"));
                    listDepSimple.add(dep);
                    f++;
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return listDepSimple;
        }
        return null;
    }

    public List<Deposito> getListDepsByTitleAndProv(String provincia, String desc, int limiteLista) {

        if (C.ExtablecerC() != null) {
            listComplet = new ArrayList<>();
            String Query = "SELECT * FROM depositos WHERE descrip LIKE ? AND id LIKE ? LIMIT " + limiteLista;
            paramsSql.add(0, "%" + desc + "%");
            paramsSql.add(1, "%" +provincia+ "%");

            ResultSet rs = C.GenericQuery(Query, paramsSql);
            //Consulta cantidad de Depositos
            try {
                while (rs.next()) {
                    dep = new Deposito(rs.getInt("id"), rs.getString("descrip"), rs.getString("provincia"), rs.getString("localidad"), rs.getString("direccion"), rs.getInt("numero"));
                    
                    listComplet.add(dep);
                }
            } catch (SQLException ex) {
                
            }
            paramsSql.clear();
            C.getCloseC();
            return listComplet;
        }

        return null;
    }

    public Deposito getDepById(String idDep) {
        if (C.ExtablecerC() != null) {
            String Query = "SELECT * FROM depositos WHERE id = ?";
            
            ResultSet rs = C.QueryById(Query, Integer.parseInt(idDep));
            try {
                while (rs.next()) {
                    dep = new Deposito(rs.getInt("id"), rs.getString("descrip"), rs.getString("provincia"), rs.getString("localidad"), rs.getString("direccion"), rs.getInt("numero"));
                    
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return dep;
        }
        return null;
    }

    public static int getLimitDep() {
        return limitDep;
    }
}
