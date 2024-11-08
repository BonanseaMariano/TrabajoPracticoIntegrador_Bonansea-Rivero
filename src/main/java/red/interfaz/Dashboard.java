/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.interfaz;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.swing.mxGraphComponent;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.*;

import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import red.interfaz.paneles.Panel_ping;
import red.interfaz.paneles.Panel_traceroute;
import red.logica.Calculo;
import red.modelo.Equipo;

/**
 * @author Antonio
 */
public class Dashboard extends javax.swing.JFrame {
    private Equipo origen, destino;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
        initComponents();
        initStyles();
        SetDate();
        InitContent();
    }

    private void initStyles() {
        navText.putClientProperty("FlatLaf.style", "font: bold $h3.regular.font");
        navText.setForeground(Color.white);
        dateText.putClientProperty("FlatLaf.style", "font: 24 $light.font");
        dateText.setForeground(Color.white);
//        appName.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
//        appName.setForeground(Color.white);
    }

    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        dateText.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }

    private void visualGrafo(Graph<String, Integer> graph) {
        // Crear el adaptador para JGraphX
        JGraphXAdapter<String, Integer> graphAdapter = new JGraphXAdapter<>(graph);

        // Crear el panel para la visualización
        mxGraphComponent graphComponent = new mxGraphComponent(graphAdapter);
        graphComponent.setPreferredSize(new Dimension(1030, 520));

        // Crear un layout para ajustar la posición de los nodos
        mxFastOrganicLayout layout = new mxFastOrganicLayout(graphAdapter);
        layout.setForceConstant(60);

        // Ejecutar el layout para ajustar la posición de los nodos
        layout.execute(graphAdapter.getDefaultParent());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(graphComponent, BorderLayout.CENTER);

        ShowJPanel(panel);
    }

    private void InitContent() {
        visualGrafo(Calculo.getInstance().getGraph());
    }

    public static void ShowJPanel(JPanel p) {
        p.setBounds(0, 0, content.getWidth(), content.getHeight());
        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    public static void ShowJScrollPanel(JScrollPane p) {
        p.setBounds(0, 0, content.getWidth(), content.getHeight());
        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        btn_actgraf = new javax.swing.JButton();
        btn_ping = new javax.swing.JButton();
        btn_traceroute = new javax.swing.JButton();
        btn_transentrerout = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        navText = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Red de computadoras");
        setMinimumSize(new java.awt.Dimension(1050, 660));
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(187, 187, 187));
        menu.setPreferredSize(new java.awt.Dimension(270, 640));

        btn_actgraf.setBackground(new java.awt.Color(102, 102, 102));
        btn_actgraf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_actgraf.setForeground(new java.awt.Color(255, 255, 255));
        btn_actgraf.setText("Actualizar grafo");
        btn_actgraf.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_actgraf.setBorderPainted(false);
        btn_actgraf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_actgraf.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_actgraf.setIconTextGap(13);
        btn_actgraf.setInheritsPopupMenu(true);
        btn_actgraf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actgrafActionPerformed(evt);
            }
        });

        btn_ping.setBackground(new java.awt.Color(102, 102, 102));
        btn_ping.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ping.setForeground(new java.awt.Color(255, 255, 255));
        btn_ping.setText("Ping");
        btn_ping.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_ping.setBorderPainted(false);
        btn_ping.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_ping.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_ping.setIconTextGap(13);
        btn_ping.setInheritsPopupMenu(true);
        btn_ping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pingActionPerformed(evt);
            }
        });

        btn_traceroute.setBackground(new java.awt.Color(102, 102, 102));
        btn_traceroute.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_traceroute.setForeground(new java.awt.Color(255, 255, 255));
        btn_traceroute.setText("Traceroute");
        btn_traceroute.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_traceroute.setBorderPainted(false);
        btn_traceroute.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_traceroute.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_traceroute.setIconTextGap(13);
        btn_traceroute.setInheritsPopupMenu(true);
        btn_traceroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tracerouteActionPerformed(evt);
            }
        });

        btn_transentrerout.setBackground(new java.awt.Color(102, 102, 102));
        btn_transentrerout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_transentrerout.setForeground(new java.awt.Color(255, 255, 255));
        btn_transentrerout.setText("Transmicion entre routers");
        btn_transentrerout.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_transentrerout.setBorderPainted(false);
        btn_transentrerout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_transentrerout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_transentrerout.setIconTextGap(13);
        btn_transentrerout.setInheritsPopupMenu(true);
        btn_transentrerout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transentreroutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(0, 303, Short.MAX_VALUE)
                .addComponent(btn_actgraf, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ping, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_traceroute, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_transentrerout, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_actgraf, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ping, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_traceroute, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_transentrerout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        header.setBackground(new java.awt.Color(153, 153, 153));
        header.setPreferredSize(new java.awt.Dimension(744, 150));

        navText.setText("Red de Computadoras");

        dateText.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(navText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateText, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actgrafActionPerformed(java.awt.event.ActionEvent evt) {
        visualGrafo(Calculo.getInstance().getGraph());
    }

    private void btn_pingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pingActionPerformed
        ShowJPanel(new Panel_ping());
    }//GEN-LAST:event_btn_pingActionPerformed

    private void btn_tracerouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tracerouteActionPerformed
        ShowJPanel(new Panel_traceroute());
    }//GEN-LAST:event_btn_tracerouteActionPerformed

    private void btn_transentreroutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transentreroutActionPerformed
        String message = "";
        for (String i : Calculo.getInstance().transmisionEntreRouters()) {
            message += i + "\n";
        }
        JTextArea textArea = new JTextArea(message);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.putClientProperty("FlatLaf.style", "font: 22 $light.font");

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ShowJScrollPanel(scrollPane);
    }//GEN-LAST:event_btn_transentreroutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_actgraf;
    private javax.swing.JButton btn_ping;
    private javax.swing.JButton btn_traceroute;
    private javax.swing.JButton btn_transentrerout;
    private static javax.swing.JPanel content;
    private javax.swing.JLabel dateText;
    private javax.swing.JPanel header;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel navText;
    // End of variables declaration//GEN-END:variables
}
