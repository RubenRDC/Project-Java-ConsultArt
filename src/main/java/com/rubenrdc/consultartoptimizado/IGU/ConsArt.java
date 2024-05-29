/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.rubenrdc.consultartoptimizado.IGU;

import com.rubenrdc.consultartoptimizado.dao.ArticuloDao;
import com.rubenrdc.consultartoptimizado.funtionsComp.funtionsCom;
import com.rubenrdc.consultartoptimizado.models.Articulo;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class ConsArt extends javax.swing.JFrame {

    ArticuloDao ArtDao = new ArticuloDao();
    Articulo Art;
    funtionsCom funcions = new funtionsCom();
    AdvancedViewer ventana;
    ImageViewer imageV;

    public ConsArt() {

        initComponents();
        //VerFoto.setVisible(false);
        listDeposito.setVisible(false);
        //ubicTxt.setText("asfa\nasdafgsa");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        titleCod = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        titleDesc = new javax.swing.JLabel();
        titleRelacion = new javax.swing.JLabel();
        titleUbic = new javax.swing.JLabel();
        descTxt = new javax.swing.JLabel();
        relacionTxt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ubicTxt = new javax.swing.JTextArea();
        listDeposito = new javax.swing.JComboBox<>();
        titleRelacion1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        VerFoto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaStock = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        clearShBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        InteraccionBtn = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        listDepItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Consultar Articulo");

        titleCod.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleCod.setText("Codigo:");

        codigoTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        codigoTxt.setBorder(null);
        codigoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoTxtKeyTyped(evt);
            }
        });

        titleDesc.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleDesc.setText("Descripcion:");

        titleRelacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleRelacion.setText("Relacion:");

        titleUbic.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleUbic.setText("Ubicacion:");

        descTxt.setMaximumSize(new java.awt.Dimension(0, 80));

        relacionTxt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        ubicTxt.setEditable(false);
        ubicTxt.setColumns(20);
        ubicTxt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ubicTxt.setLineWrap(true);
        ubicTxt.setRows(5);
        ubicTxt.setBorder(null);
        ubicTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ubicTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ubicTxt.setEnabled(false);
        ubicTxt.setOpaque(false);
        ubicTxt.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        ubicTxt.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(ubicTxt);

        listDeposito.setBorder(null);
        listDeposito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listDeposito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listDepositoItemStateChanged(evt);
            }
        });

        titleRelacion1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleRelacion1.setText("Deposito:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleDesc)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(titleCod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(titleRelacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(relacionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(titleUbic)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(titleRelacion1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleCod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleDesc)
                .addGap(1, 1, 1)
                .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleRelacion)
                    .addComponent(relacionTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(listDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(titleRelacion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(titleUbic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        codigoTxt.getAccessibleContext().setAccessibleName("");
        codigoTxt.getAccessibleContext().setAccessibleDescription("");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Stock:");

        VerFoto.setText("Ver Foto");
        VerFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerFoto.setFocusPainted(false);
        VerFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerFotoMouseClicked(evt);
            }
        });

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(

            new Object [][] {
                //{6,7},{8, 4}, {0,2}, {5,2}
            },
            new String [] {
                "Deposito","Existencias"
            }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tablaStock.setModel(tableModel);
        tablaStock.setEnabled(false);
        tablaStock.getTableHeader().setResizingAllowed(false);
        tablaStock.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaStock);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 149, Short.MAX_VALUE)
                        .addComponent(VerFoto)))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerFoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clearShBtn.setText("Limpiar Busqueda");
        clearShBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearShBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearShBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearShBtn)
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(clearShBtn))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Usuarios");

        jMenuItem1.setText("Lista de Usuarios");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pedidos");

        jMenuItem2.setText("Lista de Pedidos");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Articulos");

        InteraccionBtn.setText("Interacion Avanzada");
        InteraccionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InteraccionBtnActionPerformed(evt);
            }
        });
        jMenu3.add(InteraccionBtn);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Depositos");

        listDepItem.setText("Lista de Depositos");
        jMenu4.add(listDepItem);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyPressed

        //Key Code del Enter es 10
        if (evt.getKeyCode() == 10) {
            String c = codigoTxt.getText().toUpperCase();
            if (c.length() > 3 && c.length() <= 10) {

                Art = ArtDao.buscarArt(c);
                if (Art != null) {
                    descTxt.setText(Art.getDesc());
                    funcions.llenarTabla(tablaStock, Art.getStocks());
                    listDeposito.setVisible(true);
                    funcions.depositos(listDeposito);
                    codigoTxt.setEnabled(false);
                } else {
                    ClearCamp();
                    JOptionPane.showMessageDialog(null, "Articulo no encontrado");
                }
            } else {
                ClearCamp();
                JOptionPane.showMessageDialog(null, "Articulo no encontrado");
            }

        }

    }//GEN-LAST:event_codigoTxtKeyPressed


    private void listDepositoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listDepositoItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            if (listDeposito.getItemCount() != 0) {

                String nombreDeposito = listDeposito.getSelectedItem().toString();
                ArtDao.ObtenerUbic(Art, nombreDeposito);

                ubicTxt.setText(Art.getUbicConcat());
            }
        }
    }//GEN-LAST:event_listDepositoItemStateChanged

    private void VerFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerFotoMouseClicked
        String UrlFoto = null;
        if (Art != null) {
            if (!Art.getFoto().isEmpty()) {
                UrlFoto = Art.getFoto();
                //System.out.println("UrlFoto '" + UrlFoto+"'");
            }
            //System.out.println("Art != null " + UrlFoto);
        }

        if (imageV == null) {
            imageV = new ImageViewer(UrlFoto);
            imageV.setVisible(true);
            imageV.setLocationRelativeTo(null);
            imageV.setResizable(false);
        } else if (imageV != null) {
            if (imageV.isShowing()) {
                imageV.toFront();
            } else {
                imageV = null;
                imageV = new ImageViewer(UrlFoto);
                imageV.setVisible(true);
                imageV.setLocationRelativeTo(null);
                imageV.setResizable(false);
            }
        }
    }//GEN-LAST:event_VerFotoMouseClicked

    private void InteraccionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InteraccionBtnActionPerformed
        if (ventana == null) {//Cuando inicia el programa y la ventana es nula
            ventana = new AdvancedViewer();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            ventana.setResizable(false);
        } else if (ventana != null) {
            if (ventana.isShowing()) {//la ventana sigue es visible 
                System.out.println("Is Showing");
                ventana.toFront();//envia la ventana activa en frente de todo
            } else {//ya se cerro la ventana pero se mantuvo la informacion previa en la variable al no asignarle como nulo
                //ventana = null;
                //ventana = new AdvancedViewer();
                ventana.setVisible(true);
                ventana.setLocationRelativeTo(null);
                ventana.setResizable(false);
            }
        }
    }//GEN-LAST:event_InteraccionBtnActionPerformed

    private void codigoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyTyped
        if (codigoTxt.getText().length() > 9) {
            evt.setKeyChar((char) 0);
        }
    }//GEN-LAST:event_codigoTxtKeyTyped

    private void clearShBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearShBtnMouseClicked
        ClearCamp();
        codigoTxt.setEnabled(true);
    }//GEN-LAST:event_clearShBtnMouseClicked

    private void ClearCamp() {
        Art=null;
        descTxt.setText("");
        ubicTxt.setText("");
        codigoTxt.setText("");
        funcions.ClearTable(tablaStock);
        listDeposito.setVisible(false);
        listDeposito.removeAllItems();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JMenuItem InteraccionBtn;
    javax.swing.JButton VerFoto;
    javax.swing.JButton clearShBtn;
    javax.swing.JTextField codigoTxt;
    javax.swing.JLabel descTxt;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel3;
    javax.swing.JMenu jMenu1;
    javax.swing.JMenu jMenu2;
    javax.swing.JMenu jMenu3;
    javax.swing.JMenu jMenu4;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JMenuItem jMenuItem1;
    javax.swing.JMenuItem jMenuItem2;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JPanel jPanel4;
    javax.swing.JPanel jPanel5;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane4;
    javax.swing.JTable jTable4;
    javax.swing.JMenuItem listDepItem;
    javax.swing.JComboBox<String> listDeposito;
    javax.swing.JLabel relacionTxt;
    javax.swing.JTable tablaStock;
    javax.swing.JLabel titleCod;
    javax.swing.JLabel titleDesc;
    javax.swing.JLabel titleRelacion;
    javax.swing.JLabel titleRelacion1;
    javax.swing.JLabel titleUbic;
    javax.swing.JTextArea ubicTxt;
    // End of variables declaration//GEN-END:variables
}