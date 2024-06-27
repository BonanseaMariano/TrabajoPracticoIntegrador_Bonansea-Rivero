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
import java.util.List;

/**
 * @author Mariano
 */
public class Panel_traceroute extends javax.swing.JPanel {
    
    /**
     * Creates new form Panel_ping
     */
    public Panel_traceroute() {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
        initComponents();
        initStyles();
        getAllIps();
    }

    private void initStyles(){
        ta_message.putClientProperty("FlatLaf.style", "font: 16 $light.font");
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
        ips1.setModel(new DefaultComboBoxModel<>(equiposArray));
        ips2.setModel(new DefaultComboBoxModel<>(equiposArray));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_equipo1 = new javax.swing.JLabel();
        ips1 = new javax.swing.JComboBox<>();
        bt_trcroute = new javax.swing.JButton();
        lbl_equipo2 = new javax.swing.JLabel();
        ips2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_message = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1030, 520));

        lbl_equipo1.setText("Equipo Origen: ");

        ips1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ips1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ips1.setPreferredSize(new java.awt.Dimension(30, 22));

        bt_trcroute.setText("Traceroute");
        bt_trcroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_trcrouteActionPerformed(evt);
            }
        });

        lbl_equipo2.setText("Equipo Destino: ");

        ips2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ips2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ips2.setPreferredSize(new java.awt.Dimension(30, 22));

        ta_message.setEditable(false);
        ta_message.setBackground(new java.awt.Color(255, 255, 255));
        ta_message.setColumns(20);
        ta_message.setRows(5);
        ta_message.setBorder(null);
        jScrollPane1.setViewportView(ta_message);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_equipo1)
                    .addComponent(lbl_equipo2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ips2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ips1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_trcroute)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ips1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_equipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ips2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_equipo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_trcroute)
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_trcrouteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_bt_trcrouteActionPerformed
        String[] aux = ips1.getItemAt(ips1.getSelectedIndex()).split(": ");
        Equipo origen = Calculo.getInstance().getIpMap().get(aux[1]);
        aux = ips2.getItemAt(ips2.getSelectedIndex()).split(": ");
        Equipo destino = Calculo.getInstance().getIpMap().get(aux[1]);

        List<Equipo> path = Calculo.getInstance().traceroute(origen, destino);
        if (path.isEmpty()) {
            ta_message.setText("No se encontro ruta");
        } else {
            String message = "";
            for (Equipo e : path) {
                if (!path.get(path.size() - 1).equals(e)) {
                    message += e + " -> \n";
                } else {
                    message += e;
                }
            }
            ta_message.setText(message);
        }

    }//GEN-LAST:event_bt_trcrouteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_trcroute;
    private javax.swing.JComboBox<String> ips1;
    private javax.swing.JComboBox<String> ips2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_equipo1;
    private javax.swing.JLabel lbl_equipo2;
    private javax.swing.JTextArea ta_message;
    // End of variables declaration//GEN-END:variables
}
