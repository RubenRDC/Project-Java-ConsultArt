package com.rubenrdc.consultartoptimizado.IGU.Av;

import com.rubenrdc.consultartoptimizado.dao.ArticuloDao;
import com.rubenrdc.consultartoptimizado.funtionsComp.funtionsCom;
import com.rubenrdc.consultartoptimizado.models.Articulo;
import java.awt.BorderLayout;

/**
 *
 * @author Ruben
 */
public class EditUbics extends javax.swing.JPanel implements funtionsCom {

    EditUbic addOeditUbic;
    int idArt, IdUbicP;
    Articulo Art;
    ArticuloDao artDao = new ArticuloDao();

    /**
     * Creates new form editUbics01
     */
    public EditUbics(Articulo Art) {
        this.Art = Art;
        initComponents();
        JComboBoxDepositos(listDeposito);
        idArt = Art.getId();
        codigotxt.setText(Art.getCodigo());
        descTxt.setText(Art.getDesc());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titleDesc = new javax.swing.JLabel();
        descTxt = new javax.swing.JTextField();
        TableUbicExtra = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUbEx = new javax.swing.JTable();
        editBtnEx = new javax.swing.JButton();
        addBtnEx = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabUbP = new javax.swing.JTable();
        editBtnP = new javax.swing.JButton();
        addBtnP = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        codigotxt = new javax.swing.JTextField();
        titleCod = new javax.swing.JLabel();
        titleRelacion1 = new javax.swing.JLabel();
        listDeposito = new javax.swing.JComboBox<>();
        previusPageExt = new javax.swing.JButton();
        ContentExtra = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        previusPage = new javax.swing.JButton();

        jPanel5.setRequestFocusEnabled(false);

        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Editar Ubicaciones");

        titleDesc.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleDesc.setText("Descripcion:");

        descTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        descTxt.setEnabled(false);
        descTxt.setPreferredSize(new java.awt.Dimension(15, 30));

        jScrollPane1.setToolTipText("");
        jScrollPane1.setHorizontalScrollBar(null);

        javax.swing.table.DefaultTableModel tableModel2 = new javax.swing.table.DefaultTableModel(

            new Object [][] {
                {6,7},{8, 4}, {0,2}, {5,2}
            },
            new String [] {
                "id","Ubicaciones Extras"
            }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tabUbEx.setModel(tableModel2);
        tabUbEx.setFocusable(false);
        tabUbEx.setRowHeight(25);
        tabUbEx.setRowMargin(5);
        tabUbEx.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabUbEx.getTableHeader().setResizingAllowed(false);
        tabUbEx.getTableHeader().setReorderingAllowed(false);
        tabUbEx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabUbExMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabUbEx);

        editBtnEx.setText("Edit");
        editBtnEx.setEnabled(false);
        editBtnEx.setFocusPainted(false);
        editBtnEx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnExMouseClicked(evt);
            }
        });

        addBtnEx.setText("Add");
        addBtnEx.setFocusPainted(false);
        addBtnEx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnExMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TableUbicExtraLayout = new javax.swing.GroupLayout(TableUbicExtra);
        TableUbicExtra.setLayout(TableUbicExtraLayout);
        TableUbicExtraLayout.setHorizontalGroup(
            TableUbicExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TableUbicExtraLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TableUbicExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editBtnEx, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(addBtnEx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        TableUbicExtraLayout.setVerticalGroup(
            TableUbicExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TableUbicExtraLayout.createSequentialGroup()
                .addComponent(addBtnEx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(editBtnEx))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jScrollPane3.setToolTipText("");
        jScrollPane3.setHorizontalScrollBar(null);

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(

            new Object [][] {
                //{6,7},{8, 4}, {0,2}, {5,2}
            },
            new String [] {
                "id","Ubicacion Principal"
            }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tabUbP.setModel(tableModel);
        tabUbP.setFocusable(false);
        tabUbP.setRowHeight(25);
        tabUbP.setRowMargin(5);
        tabUbP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabUbP.getTableHeader().setResizingAllowed(false);
        tabUbP.getTableHeader().setReorderingAllowed(false);
        tabUbP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabUbPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabUbP);

        editBtnP.setText("Edit");
        editBtnP.setEnabled(false);
        editBtnP.setFocusPainted(false);
        editBtnP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnPMouseClicked(evt);
            }
        });

        addBtnP.setText("Add");
        addBtnP.setEnabled(false);
        addBtnP.setFocusPainted(false);
        addBtnP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editBtnP, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(addBtnP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addBtnP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(editBtnP)))
                .addContainerGap())
        );

        codigotxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        codigotxt.setEnabled(false);
        codigotxt.setMinimumSize(new java.awt.Dimension(15, 30));
        codigotxt.setPreferredSize(new java.awt.Dimension(15, 30));

        titleCod.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleCod.setText("Codigo:");

        titleRelacion1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleRelacion1.setText("Deposito:");

        listDeposito.setBorder(null);
        listDeposito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listDeposito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listDepositoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigotxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(titleRelacion1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(titleCod))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleRelacion1)
                    .addComponent(listDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleCod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(codigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 236, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TableUbicExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(titleDesc)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(TableUbicExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        previusPageExt.setText("VOLVER ATRAS");
        previusPageExt.setFocusPainted(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(previusPageExt)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previusPageExt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        ContentExtra.setVisible(false);

        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(419, 390));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        previusPage.setText("VOLVER ATRAS");
        previusPage.setFocusPainted(false);
        previusPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previusPageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ContentExtraLayout = new javax.swing.GroupLayout(ContentExtra);
        ContentExtra.setLayout(ContentExtraLayout);
        ContentExtraLayout.setHorizontalGroup(
            ContentExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContentExtraLayout.createSequentialGroup()
                .addContainerGap(443, Short.MAX_VALUE)
                .addComponent(previusPage)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContentExtraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContentExtraLayout.setVerticalGroup(
            ContentExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContentExtraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previusPage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ContentExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ContentExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabUbExMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabUbExMouseClicked
        int selectedRow = tabUbEx.getSelectedRow();
        addBtnEx.setEnabled(true);
        /*int adad = Integer.parseInt((tabUbEx.getValueAt(tabUbEx.getSelectedRow(),0)).toString());
        System.out.println("adad: "+adad+"es del tipo de dato: "+ ((Object)adad).getClass().getSimpleName());*/
        //tabUbEx.isFocusOwner();
        //System.out.println("jTable2 selectedRow" + selectedRow);
        if (selectedRow != -1) {
            tabUbP.clearSelection();
            editBtnP.setEnabled(false);
            addBtnP.setEnabled(false);
            editBtnEx.setEnabled(true);
            //delectBtnEx.setEnabled(true);

        } else {
            //delectBtnEx.setEnabled(false);
            editBtnEx.setEnabled(false);
            addBtnEx.setEnabled(false);

        }
    }//GEN-LAST:event_tabUbExMouseClicked

    private void editBtnExMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnExMouseClicked
        int idUbicEx = Integer.parseInt((tabUbEx.getValueAt(tabUbEx.getSelectedRow(), 0)).toString());

        if (editBtnEx.isEnabled()) {
            String D = listDeposito.getSelectedItem().toString();
            addOeditUbic = new EditUbic(idArt, idUbicEx, D, 1, 1);
            jPanel1.setVisible(false);
            ContentExtra.setVisible(true);
            showPanel(addOeditUbic, 419, 390, 0, 0, jPanel3);
        }
    }//GEN-LAST:event_editBtnExMouseClicked

    private void addBtnExMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnExMouseClicked
        if (addBtnEx.isEnabled()) {
            String D = listDeposito.getSelectedItem().toString();
            IdUbicP = Integer.parseInt(Art.getUbicPrinc()[0][0]);
            addOeditUbic = new EditUbic(idArt, IdUbicP, D, 0, 1);
            jPanel1.setVisible(false);
            ContentExtra.setVisible(true);
            showPanel(addOeditUbic, 419, 390, 0, 0, jPanel3);
        }
    }//GEN-LAST:event_addBtnExMouseClicked

    private void tabUbPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabUbPMouseClicked
        int selectedRow = tabUbP.getSelectedRow();

        //System.out.println("jTable1 selectedRow" + selectedRow);
        //jTable1.clearSelection();
        if (selectedRow != -1) {
            tabUbEx.clearSelection();
            editBtnP.setEnabled(true);
            editBtnEx.setEnabled(false);
            addBtnEx.setEnabled(false);
        } else {
            editBtnP.setEnabled(false);
            editBtnEx.setEnabled(true);
            addBtnEx.setEnabled(true);
        }
    }//GEN-LAST:event_tabUbPMouseClicked

    private void editBtnPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnPMouseClicked
        int idUbicP = Integer.parseInt((tabUbP.getValueAt(tabUbP.getSelectedRow(), 0)).toString());

        if (editBtnP.isEnabled()) {
            String D = listDeposito.getSelectedItem().toString();
            addOeditUbic = new EditUbic(idArt, idUbicP, D, 1, 0);
            jPanel1.setVisible(false);
            ContentExtra.setVisible(true);
            showPanel(addOeditUbic, 419, 390, 0, 0, jPanel3);
        }
    }//GEN-LAST:event_editBtnPMouseClicked

    private void addBtnPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnPMouseClicked
        if (addBtnP.isEnabled()) {
            String D = listDeposito.getSelectedItem().toString();
            addOeditUbic = new EditUbic(idArt, 0, D, 0, 0);
            jPanel1.setVisible(false);
            ContentExtra.setVisible(true);
            showPanel(addOeditUbic, 419, 390, 0, 0, jPanel3);
        }
    }//GEN-LAST:event_addBtnPMouseClicked

    private void listDepositoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listDepositoItemStateChanged

        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            artDao.ObtenerUbic(Art, listDeposito.getSelectedItem().toString());

            llenarTablaUbics(tabUbP, Art.getUbicPrinc());
            llenarTablaUbics(tabUbEx, Art.getUbicExtra());
            
            if (tabUbP.getRowCount() == 0) {
                addBtnP.setEnabled(true);
                addBtnEx.setEnabled(false);
            } else {
                addBtnEx.setEnabled(true);
                addBtnP.setEnabled(false);
            }
            //delectBtnEx.setEnabled(false);
            editBtnEx.setEnabled(false);
            editBtnP.setEnabled(false);
        }
    }//GEN-LAST:event_listDepositoItemStateChanged

    private void previusPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previusPageMouseClicked
        if (previusPage.isVisible()) {
            addOeditUbic = null;
            jPanel1.setVisible(true);
            ContentExtra.setVisible(false);
            JComboBoxDepositos(listDeposito);
        }
    }//GEN-LAST:event_previusPageMouseClicked
    public void llenarTablaUbics(javax.swing.JTable tb, String a[][]) {
        tb.clearSelection();
        tb.getColumnModel().getColumn(0).setMaxWidth(20);
        llenarTabla(tb, a, 2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentExtra;
    private javax.swing.JPanel TableUbicExtra;
    private javax.swing.JButton addBtnEx;
    private javax.swing.JButton addBtnP;
    private javax.swing.JTextField codigotxt;
    private javax.swing.JTextField descTxt;
    private javax.swing.JButton editBtnEx;
    private javax.swing.JButton editBtnP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> listDeposito;
    private javax.swing.JButton previusPage;
    public javax.swing.JButton previusPageExt;
    private javax.swing.JTable tabUbEx;
    private javax.swing.JTable tabUbP;
    private javax.swing.JLabel titleCod;
    private javax.swing.JLabel titleDesc;
    private javax.swing.JLabel titleRelacion1;
    // End of variables declaration//GEN-END:variables
}
