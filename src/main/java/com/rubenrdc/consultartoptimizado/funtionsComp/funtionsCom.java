/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rubenrdc.consultartoptimizado.funtionsComp;

import com.rubenrdc.consultartoptimizado.dao.DepositosDao;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public interface funtionsCom {

    default public void depositos(javax.swing.JComboBox listDeposito) {
        listDeposito.removeAllItems();
        DepositosDao depDao = new DepositosDao();
        String[] depositos = depDao.getDepositos();

        for (String d : depositos) {
            if (d != null) {
                listDeposito.addItem(d);
            }
        }
    }

    default public void ClearTable(javax.swing.JTable jTable) {
        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (jTable.getModel());
        dm.setNumRows(0);
        jTable.setModel(dm);
    }

    /**
     * msgInfo Mensaje Emergente dependiendo del tipo
     *
     * @param tipo | 0-Error | 1-Exito | 2-...
     *
     */
    default public void msgInfo(int tipo) {
        if (tipo == 0) {
            JOptionPane.showMessageDialog(null, "Ha Ocurrido un Error a la hora de realizar la operacion solicitada.", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else if (tipo == 1) {//Exito
            JOptionPane.showMessageDialog(null, "Operacion realizada con exito.", "Exito!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    default public void centrarTable(javax.swing.JTable tb) {
        javax.swing.table.DefaultTableCellRenderer Alinear = new javax.swing.table.DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        for (int i = 0; i < tb.getColumnModel().getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }
    }
    
    
    default public void llenarTabla(javax.swing.JTable jT, String[][] matrixContents,int columns) {
        ClearTable(jT);

        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (jT.getModel());
        if (matrixContents != null) {
            String Rows[] = new String[columns];
            for (String[] matrixContent : matrixContents) {

                for (int j = 0; j < columns; j++) {
                    if (j == 0) {
                        Rows[j] = matrixContent[j];
                    } else {
                        Rows[j] = matrixContent[j];
                    }
                }
                if (matrixContent[0] != null) {
                    dm.addRow(Rows);
                }

            }
            jT.setModel(dm);
        }

        //
    }
    
    default public void setPanelEnabled(javax.swing.JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);
        java.awt.Component[] components = panel.getComponents();
        for (Component component : components) {
            System.out.println(" ... " + component);
            component.setEnabled(isEnabled);
        }
    }
}
