package com.rubenrdc.consultartoptimizado.IGU.Av;

import com.rubenrdc.consultartoptimizado.dao.ArticuloDao;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ruben
 */
public class AdvancedViewer extends javax.swing.JFrame {

    ListSearcherArt listArts = new ListSearcherArt();
    UpAndEditArt wCrearArt = new UpAndEditArt(0);//Crear
    //LogicPersistencia C = new LogicPersistencia();
    EditUbics editarUbicArt;
    UpAndEditArt altaArt2;

    /**
     * Creates new form articulos
     */
    public AdvancedViewer() {
        initComponents();
        java.awt.event.MouseAdapter Madapter = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listArtsMouseClicked(evt);
            }
        };
        //listArts = new ListSearcherArt();
        showPanel(listArts);

        listArts.artsTable.addMouseListener(Madapter);
        listArts.schCodBtn.addMouseListener(Madapter);
        listArts.schDesBtn.addMouseListener(Madapter);

        //listArts.schCodBtn.getSize();
        // schCodBtn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        listArtBtn = new javax.swing.JButton();
        altaArtBtn = new javax.swing.JButton();
        editArtBtn = new javax.swing.JButton();
        bajaArtBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        listArtBtn.setBackground(new java.awt.Color(0, 0, 255));
        listArtBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        listArtBtn.setForeground(new java.awt.Color(204, 204, 204));
        listArtBtn.setText("LISTADO");
        listArtBtn.setAlignmentY(0.0F);
        listArtBtn.setBorder(null);
        listArtBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listArtBtn.setFocusPainted(false);
        listArtBtn.setMaximumSize(null);
        listArtBtn.setMinimumSize(null);
        listArtBtn.setPreferredSize(new java.awt.Dimension(124, 28));
        listArtBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listArtBtnMouseClicked(evt);
            }
        });

        altaArtBtn.setBackground(new java.awt.Color(0, 0, 255));
        altaArtBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        altaArtBtn.setForeground(new java.awt.Color(204, 204, 204));
        altaArtBtn.setText("ALTA DE ART.");
        altaArtBtn.setAlignmentY(0.0F);
        altaArtBtn.setBorder(null);
        altaArtBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        altaArtBtn.setFocusPainted(false);
        altaArtBtn.setMaximumSize(null);
        altaArtBtn.setMinimumSize(null);
        altaArtBtn.setPreferredSize(new java.awt.Dimension(124, 28));
        altaArtBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                altaArtBtnMouseClicked(evt);
            }
        });

        editArtBtn.setBackground(new java.awt.Color(0, 0, 255));
        editArtBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editArtBtn.setForeground(new java.awt.Color(204, 204, 204));
        editArtBtn.setText("EDITAR ART.");
        editArtBtn.setAlignmentY(0.0F);
        editArtBtn.setBorder(null);
        editArtBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editArtBtn.setEnabled(false);
        editArtBtn.setFocusPainted(false);
        editArtBtn.setMaximumSize(null);
        editArtBtn.setMinimumSize(null);
        editArtBtn.setOpaque(true);
        editArtBtn.setPreferredSize(new java.awt.Dimension(124, 28));
        editArtBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editArtBtnMouseClicked(evt);
            }
        });

        bajaArtBtn.setBackground(new java.awt.Color(0, 0, 255));
        bajaArtBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bajaArtBtn.setForeground(new java.awt.Color(204, 204, 204));
        bajaArtBtn.setText("BAJA DE ART.");
        bajaArtBtn.setAlignmentY(0.0F);
        bajaArtBtn.setBorder(null);
        bajaArtBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bajaArtBtn.setEnabled(false);
        bajaArtBtn.setFocusPainted(false);
        bajaArtBtn.setOpaque(true);
        bajaArtBtn.setPreferredSize(new java.awt.Dimension(124, 28));
        bajaArtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaArtBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listArtBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(altaArtBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editArtBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bajaArtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(listArtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(altaArtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editArtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bajaArtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Busqueda Avanzada de Articulos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );

        content.setPreferredSize(new java.awt.Dimension(521, 472));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

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


    private void bajaArtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaArtBtnActionPerformed

        if (bajaArtBtn.isEnabled()) {

            int idArt = Integer.parseInt((listArts.artsTable.getValueAt(listArts.artsTable.getSelectedRow(), 0)).toString());
            int input = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Estas seguro que desea eliminar el articulo seleccionada?", "Eliminar Articulo", javax.swing.JOptionPane.YES_NO_OPTION);
            if (input == 0) {//yes
                eliminarArt(idArt);
                //listArts.llenarTablaConArt(listArts.artsTable, "", listArts.limitList);
            } else {

            }

        }
    }//GEN-LAST:event_bajaArtBtnActionPerformed

    private void listArtBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listArtBtnMouseClicked
        //System.out.println("listArts.isDisplayable() "+listArts.isDisplayable());
        if (listArtBtn.isEnabled()) {
            listArts.artsTable.clearSelection();

            editArtBtn.setEnabled(false);
            bajaArtBtn.setEnabled(false);

            if (!listArts.isDisplayable()) {
                //listArts.llenarTablaConArt(listArts.artsTable, "", listArts.limitList);
            }

            //en caso de que un inadaptado cambie de ventana mientras esta editando la ubicacion esto borra la informacion de esta ventana
            /*if (editarUbicArt != null) {
                    editarUbicArt.addOeditUbic=null;
            }*/
            showPanel(listArts);
        }


    }//GEN-LAST:event_listArtBtnMouseClicked

    private void editArtBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editArtBtnMouseClicked
        if (editArtBtn.isEnabled()) {
            bajaArtBtn.setEnabled(false);
            altaArt2 = null;
            int indexList = listArts.artsTable.getSelectedRow();
            altaArt2 = new UpAndEditArt(1, listArts.lista.get(indexList));
            showPanel(altaArt2);

            altaArt2.editUbicBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    altaArt2EditUbicBtnMouseClicked(evt);
                }
            });

            //Libera cualquier dato almacena en la ventana
            /*altaArt2 = null;
            
            
            
            int idArt = Integer.parseInt((listArts.artsTable.getValueAt(listArts.artsTable.getSelectedRow(), 0)).toString());
            altaArt2 = new UpAndEditArt(1, idArt);
            showPanel(altaArt2);

            /////////////////////////////////////////////
            altaArt2.editUbicBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    altaArt2EditUbicBtnMouseClicked(evt);
                }
            });
             */
        }
    }//GEN-LAST:event_editArtBtnMouseClicked

    private void altaArtBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_altaArtBtnMouseClicked
        if (altaArtBtn.isEnabled()) {

            //en caso de que un inadaptado cambie de ventana mientras esta editando la ubicacion esto borra la informacion de esta ventana
            if (editarUbicArt != null) {
                editarUbicArt.addOeditUbic = null;
            }

            editArtBtn.setEnabled(false);
            bajaArtBtn.setEnabled(false);
            showPanel(wCrearArt);
        }
    }//GEN-LAST:event_altaArtBtnMouseClicked

    private void altaArt2EditUbicBtnMouseClicked(MouseEvent evt) {

        if (altaArt2.editUbicBtn.isDisplayable()) {

            editarUbicArt = null;
            int indexSelectedRow = listArts.artsTable.getSelectedRow();
            editarUbicArt = new EditUbics(listArts.lista.get(indexSelectedRow));
            showPanel(editarUbicArt);

            editarUbicArt.previusPageExt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    previusPageExtMouseClicked(evt);
                }
            });

        }
    }

    private void previusPageExtMouseClicked(MouseEvent evt) {
        if (editarUbicArt.previusPageExt.isDisplayable() && editarUbicArt.previusPageExt.isEnabled()) {

            editarUbicArt = null;
            showPanel(altaArt2);
        }
    }

    private void listArtsMouseClicked(MouseEvent evt) {
        int selectedRow = listArts.artsTable.getSelectedRow();
        //System.out.println("listArts.artsTable.getSelectedRow() " + listArts.artsTable.getSelectedRow());
        //System.out.println("jTable1 selectedRow" + selectedRow);
        //jTable1.clearSelection();
        editArtBtn.setEnabled(false);
        bajaArtBtn.setEnabled(false);
        if (selectedRow > -1) {

            editArtBtn.setEnabled(true);
            bajaArtBtn.setEnabled(true);
        }
    }
    private void showPanel(javax.swing.JPanel p) {
        p.setSize(521, 472);
        p.setLocation(0, 0);
        content.removeAll();
        content.add(p);
        content.revalidate();
        content.repaint();
    }

    private void eliminarArt(int idArt) {
        ArticuloDao ArtDao = new ArticuloDao();
        ArtDao.eliminarArt(idArt);
        ArtDao = null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altaArtBtn;
    private javax.swing.JButton bajaArtBtn;
    private javax.swing.JPanel content;
    private javax.swing.JButton editArtBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton listArtBtn;
    // End of variables declaration//GEN-END:variables
}