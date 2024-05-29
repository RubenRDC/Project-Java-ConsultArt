/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        C.ExtablecerC();
        ResultSet rsdepositos = C.ConsultaG("SELECT * FROM depositos;");
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

    /*public String[] getDepositos() {
        return Depositos;

    }*/

    public int getLimitDep() {
        return limitDep;
    }
}
