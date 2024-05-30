/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rubenrdc.consultartoptimizado.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class DaoConnection {

    public DaoConnection() {

    }
    Connection conectar;
    private CharPropieties Propiet = new CharPropieties();
    private String puerto = "3306";

    private String cadena = "jdbc:mysql://" + Propiet.getIp() + ":" + puerto + "/" + Propiet.getBd();

    public Connection ExtablecerC() {
        conectar = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("cadena= "+cadena);
            conectar = DriverManager.getConnection(cadena, Propiet.getUser(), Propiet.getPass());
            //JOptionPane.showMessageDialog(null, "Se establecio la conexion exitosamente");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            //System.out.println("ex " + e);
            JOptionPane.showMessageDialog(null, "No se logro conectar a la base de datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        //System.out.println("conectar " + conectar);
        return conectar;

    }


    public ResultSet ConsultaG(String consulta) {
        ResultSet rs = null;
        try {
            PreparedStatement cs = conectar.prepareStatement(consulta);
            rs = cs.executeQuery();
            return rs;
        } catch (SQLException | java.lang.NullPointerException ex) {
            //System.out.println("ex= " + ex);
        }
        return rs;
    }

    public int RetornarId(String Consulta) {
        int id = 0;
        try {
            PreparedStatement cs = conectar.prepareStatement(Consulta);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            //System.out.println("ex= " + ex);
        }
        return id;
    }

    public void getCloseC() {
        if (conectar != null) {
            try {
                conectar.close();
                conectar = null;
            } catch (SQLException ex) {

            }
        }

    }

    public ResultSet QueryById(String Query, int IdParam) throws SQLException {
        ResultSet rs = null;
        
        PreparedStatement ps = conectar.prepareStatement(Query);
        ps.setInt(1, IdParam);
        rs = ps.executeQuery();
        
        return rs;
    }

    public boolean GenericUpdate(String Query, java.util.List<String> params) throws SQLException {

        PreparedStatement ps = conectar.prepareStatement(Query);
        int index = 1;
        for (String param : params) {
            ps.setString(index, param);
            index++;
        }
        int rs = ps.executeUpdate();

        return rs > 0;

    }
    public ResultSet GenericQuery(String Query, java.util.List<String> params)throws SQLException{
        PreparedStatement ps = conectar.prepareStatement(Query);
        int index = 1;
        for (String param : params) {
            ps.setString(index, param);
            index++;
        }
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
