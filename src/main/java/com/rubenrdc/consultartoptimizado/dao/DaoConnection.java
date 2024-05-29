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

    public boolean UpOrDelectOrInsert(String consulta) {
        boolean exito = false;
        try {
            PreparedStatement cs = conectar.prepareStatement(consulta);
            //System.out.println("UpdateUb consulta: " + consulta);
            int rs = cs.executeUpdate();
            if (rs > 0) {
                return exito = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ha Ocurrido un Error a la hora de realizar la operacion solicitada.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("consulta UpOrDelectOrInsert " + consulta);
            System.out.println(ex);
        }
        return exito;
        //System.out.println("consulta: " + consulta);
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

    public int RetornarIdArt(String Consulta) {
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
                conectar=null;
            } catch (SQLException ex) {

            }
        }

    }
}
