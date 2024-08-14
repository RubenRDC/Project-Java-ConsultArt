package com.rubenrdc.consultartoptimizado.IGU.Av;

import com.rubenrdc.consultartoptimizado.dao.UbicacionExtraDao;
import com.rubenrdc.consultartoptimizado.dao.UbicacionPrincDao;
import com.rubenrdc.consultartoptimizado.models.UbicacionExtra;
import com.rubenrdc.consultartoptimizado.models.UbicacionPrincipal;
import com.rubenrdc.consultartoptimizado.models.interfaces.funtionsCom;
import com.rubenrdc.consultartoptimizado.models.interfaces.DialogsFunt;
import com.rubenrdc.consultartoptimizado.models.modelAbstract.Ubicaciones;

/**
 *
 * @author Ruben
 */
public class EditUbic extends javax.swing.JPanel implements funtionsCom, DialogsFunt {

    private int tipoUbicacion, tipoVentana;
    private String s = "", p = "", e = "", c = "", a = "";
    public static final int PRINCIPAL = 0, EXTRA = 1, ADD = 0, EDIT = 1;
    private Ubicaciones Ubic;

    public <T extends Ubicaciones> EditUbic(T Ubic, int tipoVentana, int tipoUbicacion) {
        initComponents();
        this.Ubic = Ubic;
        this.tipoUbicacion = tipoUbicacion;
        this.tipoVentana = tipoVentana;

        if (tipoUbicacion == PRINCIPAL) {
            if (tipoVentana == ADD) {
                titletxt.setText("Agregar Ubicacion Principal");
            } else if (tipoVentana == EDIT) {
                titletxt.setText("Editar Ubicacion Principal");
                setCampos(Ubic);
            }
        } else if (tipoUbicacion == EXTRA) {
            stocktxt.setEnabled(false);
            stocktxt.setToolTipText("La asignacion o correccion del Stock solo se encuentra disponible el alta o edicion de la ubicacion principal de cada deposito.");
            if (tipoVentana == ADD) {
                titletxt.setText("Agregar Ubicacion Extra");

            } else if (tipoVentana == EDIT) {
                titletxt.setText("Editar Ubicacion Extra");
                setCampos(Ubic);
            }
        }

    }

    public EditUbic() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSeters = new javax.swing.JPanel();
        panelStock = new javax.swing.JPanel();
        stocktxt = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        panelSector = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        SelSector = new javax.swing.JSpinner();
        panelPasillo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SelPasillo = new javax.swing.JSpinner();
        panelEstante = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SelEstante = new javax.swing.JSpinner();
        panelCajon = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        SelCajon = new javax.swing.JSpinner();
        panelAltura = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        SelAltura = new javax.swing.JSpinner();
        sendInfoBtn = new javax.swing.JButton();
        titletxt = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(390, 390));

        panelStock.setPreferredSize(new java.awt.Dimension(284, 43));

        stocktxt.setModel(new javax.swing.SpinnerNumberModel(1, 0, 9999, 1));
        stocktxt.setToolTipText("");
        stocktxt.setBorder(null);
        stocktxt.setPreferredSize(new java.awt.Dimension(87, 32));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Setear el Stock:");

        javax.swing.GroupLayout panelStockLayout = new javax.swing.GroupLayout(panelStock);
        panelStock.setLayout(panelStockLayout);
        panelStockLayout.setHorizontalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelStockLayout.setVerticalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStockLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6))
        );

        panelSector.setPreferredSize(new java.awt.Dimension(284, 43));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Setear el Sector:");

        SelSector.setModel(new javax.swing.SpinnerListModel(new String[] {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"}));
        SelSector.setBorder(null);
        SelSector.setPreferredSize(new java.awt.Dimension(87, 32));

        javax.swing.GroupLayout panelSectorLayout = new javax.swing.GroupLayout(panelSector);
        panelSector.setLayout(panelSectorLayout);
        panelSectorLayout.setHorizontalGroup(
            panelSectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSectorLayout.setVerticalGroup(
            panelSectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSectorLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelSectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6))
        );

        panelPasillo.setPreferredSize(new java.awt.Dimension(284, 43));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Setear el Nr. de Pasillo:");

        SelPasillo.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        SelPasillo.setBorder(null);
        SelPasillo.setPreferredSize(new java.awt.Dimension(87, 32));

        javax.swing.GroupLayout panelPasilloLayout = new javax.swing.GroupLayout(panelPasillo);
        panelPasillo.setLayout(panelPasilloLayout);
        panelPasilloLayout.setHorizontalGroup(
            panelPasilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPasilloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelPasillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPasilloLayout.setVerticalGroup(
            panelPasilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPasilloLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelPasilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelPasillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6))
        );

        panelEstante.setPreferredSize(new java.awt.Dimension(284, 43));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Setear el Nr. de Estante:");

        SelEstante.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        SelEstante.setBorder(null);
        SelEstante.setPreferredSize(new java.awt.Dimension(87, 32));

        javax.swing.GroupLayout panelEstanteLayout = new javax.swing.GroupLayout(panelEstante);
        panelEstante.setLayout(panelEstanteLayout);
        panelEstanteLayout.setHorizontalGroup(
            panelEstanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstanteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SelEstante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelEstanteLayout.setVerticalGroup(
            panelEstanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEstanteLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelEstanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelEstante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6))
        );

        panelCajon.setPreferredSize(new java.awt.Dimension(284, 43));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Setear el Nr. de Cajon:");

        SelCajon.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        SelCajon.setBorder(null);
        SelCajon.setPreferredSize(new java.awt.Dimension(87, 32));

        javax.swing.GroupLayout panelCajonLayout = new javax.swing.GroupLayout(panelCajon);
        panelCajon.setLayout(panelCajonLayout);
        panelCajonLayout.setHorizontalGroup(
            panelCajonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCajonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SelCajon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelCajonLayout.setVerticalGroup(
            panelCajonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCajonLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelCajonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelCajon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6))
        );

        panelAltura.setPreferredSize(new java.awt.Dimension(284, 43));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Setear la Altura:");

        SelAltura.setModel(new javax.swing.SpinnerNumberModel(10, 10, 90, 10));
        SelAltura.setBorder(null);
        SelAltura.setPreferredSize(new java.awt.Dimension(87, 32));

        javax.swing.GroupLayout panelAlturaLayout = new javax.swing.GroupLayout(panelAltura);
        panelAltura.setLayout(panelAlturaLayout);
        panelAlturaLayout.setHorizontalGroup(
            panelAlturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlturaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SelAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelAlturaLayout.setVerticalGroup(
            panelAlturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlturaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelAlturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6))
        );

        sendInfoBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sendInfoBtn.setText("Validar y Enviar Datos");
        sendInfoBtn.setFocusPainted(false);
        sendInfoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendInfoBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSetersLayout = new javax.swing.GroupLayout(panelSeters);
        panelSeters.setLayout(panelSetersLayout);
        panelSetersLayout.setHorizontalGroup(
            panelSetersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSetersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSetersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPasillo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelEstante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCajon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAltura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelSetersLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sendInfoBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelSetersLayout.setVerticalGroup(
            panelSetersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSetersLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelSector, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelPasillo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelEstante, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelCajon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(sendInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titletxt.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titletxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titletxt.setText("Edit Ubicacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(panelSeters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addComponent(titletxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titletxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSeters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendInfoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendInfoBtnMouseClicked
        if (sendInfoBtn.isEnabled()) {
            setCampsInUbic(Ubic);

            if (tipoUbicacion == PRINCIPAL) {//Tipo Ubicacion Principal
                if (tipoVentana == ADD) {
                    //Tipo Ventana de Add Ubicacion
                    msgInfoOperation(UbicacionPrincDao.AddUbicP((UbicacionPrincipal) Ubic));

                } else if (tipoVentana == EDIT) {
                    //Tipo Ventana de Edit Ubicacion
                    msgInfoOperation(UbicacionPrincDao.UpdateUbicP((UbicacionPrincipal) Ubic));
                }
            } else if (tipoUbicacion == EXTRA) {//Tipo Ubicacion Extra
                if (tipoVentana == ADD) {
                    //Agregar
                    msgInfoOperation(UbicacionExtraDao.AddUbicExtra((UbicacionExtra) Ubic));
                } else if (tipoVentana == EDIT) {
                    //Editar
                    msgInfoOperation(UbicacionExtraDao.UpdateUbicExtra((UbicacionExtra) Ubic));
                }
            }
            setPanelEnabled(panelSeters, false);
        }
    }//GEN-LAST:event_sendInfoBtnMouseClicked

    private <T extends Ubicaciones> void setCampos(T Ubicacion) {

        String UbicConcat = Ubicacion.getConcatUbic();
        for (int i = 0; i < UbicConcat.length(); i++) {
            if (i == 0) {
                s = String.valueOf(UbicConcat.charAt(i));
            }
            if (i > 0 && i < 3) {
                p += String.valueOf(UbicConcat.charAt(i));
            }
            if (i > 3 && i < 6) {
                e += String.valueOf(UbicConcat.charAt(i));
            }
            if (i > 5 && i < 8) {
                c += String.valueOf(UbicConcat.charAt(i));
            }
            if (i > 8) {
                a += String.valueOf(UbicConcat.charAt(i));
            }
        }
        if (tipoUbicacion == PRINCIPAL) {
            stocktxt.setValue(((UbicacionPrincipal) Ubicacion).getExist());
        }
        SelSector.setValue(s);
        SelPasillo.setValue(Integer.valueOf(p));
        SelEstante.setValue(Integer.valueOf(e));
        SelCajon.setValue(Integer.valueOf(c));
        SelAltura.setValue(Integer.valueOf(a));
    }

    private <T extends Ubicaciones> void setCampsInUbic(T Ubicacion) {

        s = SelSector.getValue().toString();
        p = String.valueOf(SelPasillo.getValue());
        e = String.valueOf(SelEstante.getValue());
        c = String.valueOf(SelCajon.getValue());
        a = String.valueOf(SelAltura.getValue());

        if (p.length() < 2) {
            p = "0" + p;
        }
        if (e.length() < 2) {
            e = "0" + e;
        }
        if (c.length() < 2) {
            c = "0" + c;
        }

        Ubicacion.setConcatUbic((s + p + "-" + e + c + "-" + a));

        if (tipoUbicacion == PRINCIPAL) {
            ((UbicacionPrincipal) Ubicacion).setExist((int) stocktxt.getValue());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SelAltura;
    private javax.swing.JSpinner SelCajon;
    private javax.swing.JSpinner SelEstante;
    private javax.swing.JSpinner SelPasillo;
    private javax.swing.JSpinner SelSector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel panelAltura;
    private javax.swing.JPanel panelCajon;
    private javax.swing.JPanel panelEstante;
    private javax.swing.JPanel panelPasillo;
    private javax.swing.JPanel panelSector;
    private javax.swing.JPanel panelSeters;
    private javax.swing.JPanel panelStock;
    private javax.swing.JButton sendInfoBtn;
    private javax.swing.JSpinner stocktxt;
    private javax.swing.JLabel titletxt;
    // End of variables declaration//GEN-END:variables

}
