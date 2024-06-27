/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package red.interfaz.paneles;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import net.datastructures.Entry;
import net.datastructures.TreeMap;
import red.logica.Calculo;
import red.modelo.Equipo;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Mariano
 */
public class Panel_ping extends javax.swing.JPanel {
    
    /**
     * Creates new form Panel_ping
     */
    public Panel_ping() {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
        initComponents();
        getAllIps();
    }

    private void getAllIps() {
        // Obtener todas las IPs del TreeMap y almacenarlas en un arreglo de Strings
        String[] equiposArray = new String[Calculo.getInstance().getIpMap().size()];
        int i = 0;
        for (Entry<String, Equipo> entry : Calculo.getInstance().getIpMap().entrySet()) {
            equiposArray[i] = entry.getValue().getClass().getSimpleName() + ": " + entry.getKey();
            i++;
        }

        // Actualizar el modelo del JComboBox ips con el arreglo de IPs
        ips.setModel(new DefaultComboBoxModel<>(equiposArray));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_equipo = new javax.swing.JLabel();
        ips = new javax.swing.JComboBox<>();
        message = new javax.swing.JLabel();
        bt_ping = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1030, 520));

        lbl_equipo.setText("Equipo: ");

        ips.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        ips.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ips.setPreferredSize(new java.awt.Dimension(30, 22));

        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bt_ping.setText("Ping");
        bt_ping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl_equipo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ips, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt_ping)))
                                .addContainerGap(259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ips, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_equipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_ping))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(340, 340, 340))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_pingActionPerformed(ActionEvent evt) {//GEN-FIRST:event_bt_pingActionPerformed
        String[] aux = ips.getItemAt(ips.getSelectedIndex()).split(": ");
        String ip = aux[1];
        if (Calculo.getInstance().getIpMap().get(ip).isStatus()) {
            message.setText("Equipo Activo");
        } else {
            message.setText("Equipo Inactivo");
        }
    }//GEN-LAST:event_bt_pingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ping;
    private javax.swing.JComboBox<String> ips;
    private javax.swing.JLabel lbl_equipo;
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables
}
