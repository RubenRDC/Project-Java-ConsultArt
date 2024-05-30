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

    private int limitDep = 10;
    private DaoConnection C = new DaoConnection();
    private Deposito dep;
    private List<Deposito> listDep;
    public DepositosDao() {
    }

    public List<Deposito> getDepositos() {
        int f = 0;
        if (C.ExtablecerC() != null) {
            listDep= new ArrayList<>();
            String Query = "SELECT * FROM depositos;";
            ResultSet rsdepositos = C.GenericQuery(Query, null);
            //Consulta cantidad de Depositos
            try {
                while (rsdepositos.next()) {
                    dep = new Deposito(rsdepositos.getInt("id"),rsdepositos.getString("descrip"));
                    listDep.add(dep);
                    f++;
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return listDep;
        }
        return null;
    }
    public int getLimitDep() {
        return limitDep;
    }
}
