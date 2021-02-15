/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.barometro;

import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author luisc
 */
public class FrameBarometro extends javax.swing.JFrame {

    private final ModeloBarometro modelo;
    
    Calendar fechaActual = new GregorianCalendar();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private String cogerFecha, cogerValor;
    private int predecir;
    private double presion, altitud;
    private LocalDateTime fecha;
    private boolean fechaHoraCogida = false;
    
    /**
     * Creates new form FrameBarometro
     */
    public FrameBarometro() {
        initComponents();
        this.modelo = new ModeloBarometro();
        ((CardLayout) pnlIconos.getLayout()).show(pnlIconos,"card2");
        lblTexto.setText("");
        fechaSistema();
        
        this.setLocationRelativeTo(null);
    }
    
    public double validaDouble(String number){
        double result = 0; //Valor default.
        try{
            if(number != null){
                result = Double.parseDouble(number);
            }
        }catch(NumberFormatException nfe){
            System.out.println("Ha habido un error al introducir la presión o la fecha, error: " + nfe.getMessage());
            //*No es numerico!
        }
        return result;
    }
    
    public void fechaSistema(){
        dtcFecha.setCalendar(fechaActual);
    }

    public int getprediccion(){
        return (modelo.prediccion());
    }
    
    public void addPresion(Double presion, LocalDateTime fecha){
        modelo.addPresion(presion, fecha);
    }
    
    public void setAltitud(Double altitud){
        modelo.setAltitud(altitud);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlTiempo = new javax.swing.JPanel();
        pnlIconos = new javax.swing.JPanel();
        lblSol = new javax.swing.JLabel();
        lblNubes = new javax.swing.JLabel();
        lblLluvia = new javax.swing.JLabel();
        lblViento = new javax.swing.JLabel();
        btnPredecir = new javax.swing.JButton();
        lblTexto = new javax.swing.JLabel();
        pnlPresionFecha = new javax.swing.JPanel();
        btnAddPresion = new javax.swing.JButton();
        txfPresion = new javax.swing.JTextField();
        dtcFecha = new com.toedter.calendar.JDateChooser();
        btnAddFecha = new javax.swing.JButton();
        pnlActitud = new javax.swing.JPanel();
        btnAltitud = new javax.swing.JButton();
        txfAltitud = new javax.swing.JTextField();
        pnlHistorico = new javax.swing.JPanel();
        btnHistorico = new javax.swing.JButton();
        spHistorico = new javax.swing.JScrollPane();
        listHistorico = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTiempo.setLayout(new java.awt.GridBagLayout());

        pnlIconos.setLayout(new java.awt.CardLayout());

        lblSol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSol.setIcon(new javax.swing.ImageIcon("C:\\Users\\luisc\\Documents\\NetBeansProjects\\Barometro\\barometro\\src\\main\\resources\\imagenes\\sol.png")); // NOI18N
        pnlIconos.add(lblSol, "card2");

        lblNubes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNubes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nubes.png"))); // NOI18N
        pnlIconos.add(lblNubes, "card3");

        lblLluvia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLluvia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lluvia.png"))); // NOI18N
        pnlIconos.add(lblLluvia, "card4");

        lblViento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/viento.png"))); // NOI18N
        pnlIconos.add(lblViento, "card5");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
        pnlTiempo.add(pnlIconos, gridBagConstraints);

        btnPredecir.setText("Predecir");
        btnPredecir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPredecirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 264);
        pnlTiempo.add(btnPredecir, gridBagConstraints);

        lblTexto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTexto.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 11, 264);
        pnlTiempo.add(lblTexto, gridBagConstraints);

        pnlPresionFecha.setLayout(new java.awt.GridBagLayout());

        btnAddPresion.setText("Añadir Presión");
        btnAddPresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPresionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        pnlPresionFecha.add(btnAddPresion, gridBagConstraints);

        txfPresion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 9, 1);
        pnlPresionFecha.add(txfPresion, gridBagConstraints);

        dtcFecha.setDateFormatString("yyyy-MMM-dd HH:mm:ss");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 6, 8, 4);
        pnlPresionFecha.add(dtcFecha, gridBagConstraints);

        btnAddFecha.setText("Añadir Fecha");
        btnAddFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFechaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 10);
        pnlPresionFecha.add(btnAddFecha, gridBagConstraints);

        pnlActitud.setLayout(new java.awt.GridBagLayout());

        btnAltitud.setText("Cambiar altitud");
        btnAltitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltitudActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        pnlActitud.add(btnAltitud, gridBagConstraints);

        txfAltitud.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 11, 10);
        pnlActitud.add(txfAltitud, gridBagConstraints);

        btnHistorico.setText("Histórico");
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        spHistorico.setViewportView(listHistorico);

        javax.swing.GroupLayout pnlHistoricoLayout = new javax.swing.GroupLayout(pnlHistorico);
        pnlHistorico.setLayout(pnlHistoricoLayout);
        pnlHistoricoLayout.setHorizontalGroup(
            pnlHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlHistoricoLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btnHistorico)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        pnlHistoricoLayout.setVerticalGroup(
            pnlHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spHistorico)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlPresionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlActitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPresionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlActitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPredecirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPredecirActionPerformed
        predecir = getprediccion();
        switch(predecir){
            case 1:
                //Borrasca lejana CARD3(nubes)
                ((CardLayout) pnlIconos.getLayout()).show(pnlIconos,"card3");
                lblTexto.setText("Va a haber una borrasca, pero pasará lejos");
                break;
            case 2:
                //Gran borrasca CARD4(lluvia)
                ((CardLayout) pnlIconos.getLayout()).show(pnlIconos,"card4");
                lblTexto.setText("Va a haber una gran borrasca");
                break;
            case 3:
                //Seco y encalmado CARD5(viento)
                ((CardLayout) pnlIconos.getLayout()).show(pnlIconos,"card5");
                lblTexto.setText("Va a hacer un tiempo seco y encalmado de anticiclón");
                break;
            case 4:
                //mejoria CARD2(sol)
                ((CardLayout) pnlIconos.getLayout()).show(pnlIconos,"card2");
                lblTexto.setText("Va a haber una mejoría");
                break;
            case 5:
                //No cambia
                lblTexto.setText("No va a haber muchos cambios");
                break;
        }
    }//GEN-LAST:event_btnPredecirActionPerformed

    private void btnAddPresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPresionActionPerformed
        presion=validaDouble(txfPresion.getText());
        if(fechaHoraCogida){
            modelo.addPresion(presion, fecha);
            fechaHoraCogida = false;
        }
        else{
            fechaHoraCogida = true;
        }
    }//GEN-LAST:event_btnAddPresionActionPerformed

    private void btnAltitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltitudActionPerformed
        altitud = validaDouble(txfAltitud.getText());
        setAltitud(altitud);
    }//GEN-LAST:event_btnAltitudActionPerformed

    private void btnAddFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFechaActionPerformed
        try{
            cogerFecha = df.format(dtcFecha.getDate());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            fecha = LocalDateTime.parse(cogerFecha, formatter);
            if(fechaHoraCogida){
                modelo.addPresion(presion, fecha);
                fechaHoraCogida = false;
            }
            else{
                fechaHoraCogida = true;
            }
        }
        catch(Exception e){
            System.out.println("Ha habido un error al añadir la fecha y/o la hora, error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAddFechaActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        //No me va
        DefaultListModel listModel = new DefaultListModel();
        for (int i=0; i<modelo.listaValores.size(); i++){
            listModel.addElement(modelo.listaValores.get(i).toString());
        }
        listHistorico.setModel(listModel);
    }//GEN-LAST:event_btnHistoricoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameBarometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameBarometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameBarometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameBarometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameBarometro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFecha;
    private javax.swing.JButton btnAddPresion;
    private javax.swing.JButton btnAltitud;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnPredecir;
    private com.toedter.calendar.JDateChooser dtcFecha;
    private javax.swing.JLabel lblLluvia;
    private javax.swing.JLabel lblNubes;
    private javax.swing.JLabel lblSol;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JLabel lblViento;
    private javax.swing.JList<String> listHistorico;
    private javax.swing.JPanel pnlActitud;
    private javax.swing.JPanel pnlHistorico;
    private javax.swing.JPanel pnlIconos;
    private javax.swing.JPanel pnlPresionFecha;
    private javax.swing.JPanel pnlTiempo;
    private javax.swing.JScrollPane spHistorico;
    private javax.swing.JTextField txfAltitud;
    private javax.swing.JTextField txfPresion;
    // End of variables declaration//GEN-END:variables
}
