package com.rubenrdc.consultartoptimizado.funtionsComp;

import com.rubenrdc.consultartoptimizado.models.Deposito;
import com.rubenrdc.consultartoptimizado.models.interfaces.Exportables;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public interface funtionsCom {
    
    public static final int AAA=0;

    default public void JComboBoxDepositos(javax.swing.JComboBox listDeposito, List<Deposito> listDeps) {
        listDeposito.removeAllItems();
        for (Deposito d : listDeps) {
            if (d != null) {
                listDeposito.addItem(d.getNombre());
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

    default public void llenarTabla(javax.swing.JTable jT, String[][] matrixContents, int columns) {
        ClearTable(jT);

        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (jT.getModel());
        if (matrixContents != null) {
            String Rows[] = new String[columns];
            for (String[] matrixContent : matrixContents) {
                //El primer elemento del Array No puede ser Nulo;
                if (matrixContent[0] != null) {
                    for (int j = 0; j < columns; j++) {
                        Rows[j] = matrixContent[j];
                    }
                    dm.addRow(Rows);
                } else {
                    break;
                }
            }
            jT.setModel(dm);
        }
    }

    default public <T extends Exportables> void llenarTabla(javax.swing.JTable tb, List<T> lista) {
        //No se va a llamar a este metodo si la lista esta vacia.
        ClearTable(tb);
        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (tb.getModel());
        for (int i = 0; i < lista.size(); i++) {
            dm.addRow(lista.get(i).getRow());
        }
        tb.setModel(dm);
    }

    default public void setPanelEnabled(javax.swing.JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);
        java.awt.Component[] components = panel.getComponents();
        for (Component component : components) {
            //System.out.println(" ... " + component);
            component.setEnabled(isEnabled);
        }
    }

    default public void pinterJFrame(javax.swing.JFrame window, boolean setVisible, Component setLocationRelativeTo, boolean setResizable) {
        window.setVisible(setVisible);
        window.setLocationRelativeTo(setLocationRelativeTo);
        window.setResizable(setResizable);
    }

    default public void showPanel(javax.swing.JPanel panel, int SizeWhidth, int Sizeheight, int setLocationX, int setLocationY, javax.swing.JPanel InPanel) {
        panel.setSize(SizeWhidth, Sizeheight);
        panel.setLocation(setLocationX, setLocationY);
        InPanel.removeAll();
        InPanel.add(panel, BorderLayout.CENTER);
        InPanel.revalidate();
        InPanel.repaint();
    }

    default public void filtrarKeyEvent(java.awt.event.KeyEvent evt) {
        String cadena;
        char keyAscii;
        int intKeyAscii;

        cadena = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-" + (char) 32;// + (char)32
        keyAscii = evt.getKeyChar();
        intKeyAscii = (int) keyAscii;

        if (intKeyAscii > 26) {

            if (cadena.indexOf(keyAscii) == -1) {
                evt.setKeyChar((char) 0);//Si el keyAscii recibida no corresponde a ninguno de la cadena de caracteres permitadas setea la key a null para anular la entrada del digito
                JOptionPane.showMessageDialog(null, "Intento ingresar digitos no permitidos.", "Advertencia!", JOptionPane.ERROR_MESSAGE);
            } else {

                evt.setKeyChar(keyAscii);

            }
        }
    }
}
