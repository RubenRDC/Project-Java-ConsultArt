/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.rubenrdc.consultartoptimizado.IGU;

import java.net.MalformedURLException;
import javax.swing.ImageIcon;

/**
 *
 * @author Ruben
 */
public class ImageViewer extends javax.swing.JFrame {

    /**
     * Creates new form ImageViewer
     */
    public ImageViewer(String imgUrl) {
        initComponents();
        javax.swing.ImageIcon icon;
        //icon = new javax.swing.ImageIcon("src/main/java/com/rubenrdc/consultartoptimizado/miselaneos/icon-image-not-found.jpg");
        //jLabel1.setIcon(icon);

        if (imgUrl != null) {
            //System.out.println("imgUrl "+imgUrl);
            icon = createImageIcon(imgUrl);
            //System.out.println("icon "+icon);
            if (icon != null) {
                java.awt.Image img = icon.getImage();
                java.awt.Image imgS = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH);
                javax.swing.ImageIcon iconS = new javax.swing.ImageIcon(imgS);
                jLabel1.setIcon(iconS);
            } else {
                icon = new javax.swing.ImageIcon("src/main/java/com/rubenrdc/consultartoptimizado/miselaneos/icon-image-not-found.jpg");
                jLabel1.setIcon(icon);
            }
        }
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setToolTipText("");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("src/main/java/com/rubenrdc/consultartoptimizado/miselaneos/icon-image-not-found.jpg"));
        jLabel1.setIconTextGap(0);
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    protected ImageIcon createImageIcon(String path) {
        if (path != null) {
            path = "https://" + path;
            //java.net.URL imgURL = getClass().getResource(path);
            try {
                java.net.URL imgURL = new java.net.URL(path);
                if (imgURL != null) {
                    //System.out.println("new ImageIcon(imgURL) "+new ImageIcon(imgURL));
                    return new ImageIcon(imgURL);

                } else {
                    System.err.println("Couldn't find file: " + path);
                    return null;
                }
            } catch (Exception ex) {
                System.out.println("createImageIcon " + ex);
            }

        }
        return null;
    }

    protected ImageIcon iconScaled(javax.swing.ImageIcon icon) {
        java.awt.Image img = icon.getImage();
        java.awt.Image imgS = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        javax.swing.ImageIcon iconS = new javax.swing.ImageIcon(imgS);
        return iconS;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}