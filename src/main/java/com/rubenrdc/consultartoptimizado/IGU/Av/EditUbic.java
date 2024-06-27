package com.rubenrdc.consultartoptimizado.IGU.Av;

import com.rubenrdc.consultartoptimizado.dao.DaoConnection;
import com.rubenrdc.consultartoptimizado.funtionsComp.funtionsCom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class EditUbic extends javax.swing.JPanel implements funtionsCom {

    private int stock, idUbic, tipoU, tipoV, idArt;
    private String s = "", p = "", e = "", c = "", a = "", ubicC, Dep;
    private DaoConnection dao = new DaoConnection();
    private List<String> paramsSQL = new ArrayList<>();
    public static final int PRINCIPAL = 0,EXTRA=1,ADD=0,EDIT=1;
    
    /**
     *
     *
     * @param idArt
     * @param idUbic
     * @param Dep Deposito
     * @param tipoV Tipo de Ventana(0-Add | 1-Edit)
     * @param tipoU Tipo de Ubicacion(0-Principal | 1-Extra)
     */
    public EditUbic(int idArt, int idUbic, String Dep, int tipoV, int tipoU) {
        initComponents();
        if (tipoU == PRINCIPAL) {
            if (tipoV == ADD) {
                titletxt.setText("Agregar Ubicacion Principal");
            } else if (tipoV == EDIT) {
                titletxt.setText("Editar Ubicacion Principal");
                ObtenerUbic(idUbic, tipoU);
            }
        } else if (tipoU == EXTRA) {
            stocktxt.setEnabled(false);
            stocktxt.setToolTipText("La asignacion o correccion del Stock solo se encuentra disponible el alta o edicion de la ubicacion principal de cada deposito.");
            if (tipoV == ADD) {
                titletxt.setText("Agregar Ubicacion Extra");

            } else if (tipoV == EDIT) {
                titletxt.setText("Editar Ubicacion Extra");
                ObtenerUbic(idUbic, tipoU);
            }
        }
        this.idUbic = idUbic;
        this.tipoU = tipoU;//tipo Ubicacion (Principal)
        this.tipoV = tipoV;//ti´p
        this.idArt = idArt;

        this.Dep = Dep;
    }

    public EditUbic() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        SelSector = new javax.swing.JSpinner();
        SelPasillo = new javax.swing.JSpinner();
        SelEstante = new javax.swing.JSpinner();
        SelCajon = new javax.swing.JSpinner();
        SelAltura = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        stocktxt = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sendInfoBtn = new javax.swing.JButton();
        titletxt = new javax.swing.JLabel();

        SelSector.setModel(new javax.swing.SpinnerListModel(new String[] {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"}));
        SelSector.setBorder(null);

        SelPasillo.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        SelPasillo.setBorder(null);

        SelEstante.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        SelEstante.setBorder(null);

        SelCajon.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        SelCajon.setBorder(null);

        SelAltura.setModel(new javax.swing.SpinnerNumberModel(10, 10, 90, 10));
        SelAltura.setBorder(null);

        stocktxt.setModel(new javax.swing.SpinnerNumberModel(1, 0, 9999, 1));
        stocktxt.setToolTipText("");
        stocktxt.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Stock");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(stocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(SelSector, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelPasillo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelEstante, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelCajon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelSector, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelPasillo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelEstante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelCajon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sendInfoBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sendInfoBtn.setText("Validar y Enviar Datos");
        sendInfoBtn.setFocusPainted(false);
        sendInfoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendInfoBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendInfoBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(sendInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        titletxt.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titletxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titletxt.setText("Edit Ubicacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titletxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titletxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendInfoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendInfoBtnMouseClicked
        if (sendInfoBtn.isEnabled()) {
            boolean exito = false;
            String querys = "";
            if (dao.ExtablecerC() != null) {

                s = SelSector.getValue().toString();
                p = String.valueOf(SelPasillo.getValue());
                e = String.valueOf(SelEstante.getValue());
                c = String.valueOf(SelCajon.getValue());
                a = String.valueOf(SelAltura.getValue());
                stock = (int) stocktxt.getValue();

                if (p.length() < 2) {
                    p = "0" + p;
                }
                if (e.length() < 2) {
                    e = "0" + e;
                }
                if (c.length() < 2) {
                    c = "0" + c;
                }

                ubicC = s + p + "-" + e + c + "-" + a;

                if (tipoU == 0) {//Tipo Ubicacion Principal
                    if (tipoV == 0) {
                        //Tipo Ventana de Add Ubicacion
                        String ObtenerIdDep = String.format("SELECT id FROM depositos WHERE descrip = \"%s\"", Dep);
                        int idDep = dao.RetornarId(ObtenerIdDep);
                        paramsSQL.add(0, String.valueOf(idArt));
                        paramsSQL.add(1, String.valueOf(idDep));
                        paramsSQL.add(2, String.valueOf(stock));
                        paramsSQL.add(3, ubicC);
                        querys = "INSERT INTO ubicaciones (idArt,idDep,exist, ubic) VALUES (?,?,?,?)";
                        exito = dao.GenericUpdate(querys, paramsSQL);

                    } else if (tipoV == 1) {
                        //Tipo Ventana de Edit Ubicacion
                        paramsSQL.add(0, String.valueOf(stock));
                        paramsSQL.add(1, ubicC);
                        paramsSQL.add(2, String.valueOf(idUbic));
                        querys = "UPDATE ubicaciones SET exist = ?,ubic = ? WHERE id=?";
                        exito = dao.GenericUpdate(querys, paramsSQL);
                        System.out.println("Tipo Ventana de Edit Ubicacion Principal");
                    }
                } else if (tipoU == 1) {//Tipo Ubicacion Extra
                    if (tipoV == 0) {
                        //Agregar
                        querys = "INSERT INTO ubicacion_extra (idUbic,ubic) VALUES (?,?)";
                        
                        paramsSQL.add(0, String.valueOf(idUbic));
                        paramsSQL.add(1, ubicC);
                        
                        exito = dao.GenericUpdate(querys, paramsSQL);
                        System.out.println("Tipo Ventana de Add Ubicacion Extra");
                    } else if (tipoV == 1) {
                        //Editar
                        querys="UPDATE ubicacion_extra SET ubic = ? WHERE id = ?";
                        paramsSQL.add(0, ubicC);
                        paramsSQL.add(1, String.valueOf(idUbic));
                        exito = dao.GenericUpdate(querys, paramsSQL);
                        System.out.println("Tipo Ventana de Edit Ubicacion Extra");
                    }
                }

                if (exito) {
                    setPanelEnabled(jPanel4, false);
                    setPanelEnabled(jPanel5, false);
                    sendInfoBtn.setEnabled(false);
                    msgInfo(1);
                } else {
                    msgInfo(0);
                }
                querys = null;
                paramsSQL.clear();
                dao.getCloseC();
            }

        }
    }//GEN-LAST:event_sendInfoBtnMouseClicked


    private void ObtenerUbic(int id, int tipoUbicacion) {
        if (dao.ExtablecerC() != null) {
            String consulta = "";
            if (tipoUbicacion == 0) {//Si es una ubicacion principal
                consulta = String.format("SELECT * FROM ubicaciones WHERE id = ?");
            } else if (tipoUbicacion == 1) {//Si es una ubicacion extra
                consulta = String.format("SELECT * FROM ubicacion_extra WHERE id = ?");
            }
            String Ubic = "";
            java.sql.ResultSet rs = dao.QueryById(consulta, id);
            try {
                if (rs.next()) {
                    Ubic = rs.getString("ubic");
                    stock = rs.getInt("exist");
                    //System.out.println("stock "+ stock);
                }

            } catch (java.sql.SQLException ex) {

            }

            for (int i = 0; i < Ubic.length(); i++) {
                if (i == 0) {
                    s = String.valueOf(Ubic.charAt(i));
                }
                if (i > 0 && i < 3) {
                    p += String.valueOf(Ubic.charAt(i));
                }
                if (i > 3 && i < 6) {
                    e += String.valueOf(Ubic.charAt(i));
                }
                if (i > 5 && i < 8) {
                    c += String.valueOf(Ubic.charAt(i));
                }
                if (i > 8) {
                    a += String.valueOf(Ubic.charAt(i));
                }
            }

            stocktxt.setValue(stock);
            SelSector.setValue(s);
            SelPasillo.setValue(Integer.valueOf(p));
            SelEstante.setValue(Integer.valueOf(e));
            SelCajon.setValue(Integer.valueOf(c));
            SelAltura.setValue(Integer.valueOf(a));

            consulta=null;
            dao.getCloseC();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SelAltura;
    private javax.swing.JSpinner SelCajon;
    private javax.swing.JSpinner SelEstante;
    private javax.swing.JSpinner SelPasillo;
    private javax.swing.JSpinner SelSector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton sendInfoBtn;
    private javax.swing.JSpinner stocktxt;
    private javax.swing.JLabel titletxt;
    // End of variables declaration//GEN-END:variables

}
