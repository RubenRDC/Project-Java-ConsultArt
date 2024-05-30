package com.rubenrdc.consultartoptimizado.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ruben
 */
public class DepositosDao {

    private int limitDep = 10;
    private DaoConnection C = new DaoConnection();
    private String Depositos[] = new String[limitDep];//Maximo 10 depositos;

    public DepositosDao() {
    }

    public String[] getDepositos() {
        int f = 0;
        if (C.ExtablecerC() != null) {
            String Query = "SELECT * FROM depositos;";
            ResultSet rsdepositos = C.GenericQuery(Query, null);
            //Consulta cantidad de Depositos
            try {
                while (rsdepositos.next()) {
                    Depositos[f] = rsdepositos.getString("descrip");
                    f++;
                }
            } catch (SQLException ex) {

            }
            C.getCloseC();
            return Depositos;
        }
        return Depositos;
    }
    public int getLimitDep() {
        return limitDep;
    }
}
