
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author miche, aaau, cAppelina
 * 
 * Denna klass möjliggör för en adminagent att lägga 
 * till andra agenter som administratörer i systemet.
 */
public class AdminStatus extends javax.swing.JFrame {

    private InfDB idb;
    private HjalpDbFunktioner konv;

    public AdminStatus(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjAgent();
        lblAgentFattAdmin.setVisible(false);
        konv = new HjalpDbFunktioner(idb);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAgentFattAdmin = new javax.swing.JLabel();
        lblAgentRubrik = new javax.swing.JLabel();
        lblRubrik = new javax.swing.JLabel();
        cmbAgenter = new javax.swing.JComboBox<>();
        btnGeAdminRatt = new javax.swing.JButton();

        lblAgentFattAdmin.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        lblAgentFattAdmin.setText("lblAgentFattAdminstatus");

        lblAgentRubrik.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblAgentRubrik.setText("Välj Agent");

        lblRubrik.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        lblRubrik.setText("Ge Agent Adminstatus");

        cmbAgenter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        btnGeAdminRatt.setText("Ge adminbehörighet");
        btnGeAdminRatt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeAdminRattActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(lblRubrik)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGeAdminRatt)
                    .addComponent(cmbAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgentFattAdmin)
                    .addComponent(lblAgentRubrik))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblRubrik)
                .addGap(18, 18, 18)
                .addComponent(lblAgentRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGeAdminRatt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(lblAgentFattAdmin)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeAdminRattActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeAdminRattActionPerformed
        String namn = cmbAgenter.getSelectedItem().toString();
        String agentId = konv.getAgentId(namn);
        String fraga = "UPDATE Agent SET Administrator = 'J' WHERE Namn =" + "'" + namn + "'" + ";";
        if (Validering.kollaCboxRegEx(namn)) {
            try {
                idb.update(fraga);
                lblAgentFattAdmin.setVisible(true);
                lblAgentFattAdmin.setText(namn + " har fått adminstatus");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något gick fel, det gick inte att lägga till administratörsstatus");
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_btnGeAdminRattActionPerformed

    private void fyllValjAgent() {
        String fraga = "SELECT Namn FROM Agent";

        ArrayList<String> allaAgenter;

        try {
            allaAgenter = idb.fetchColumn(fraga);

            for (String plats : allaAgenter) {
                cmbAgenter.addItem(plats);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick ej att ladda agenter");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeAdminRatt;
    private javax.swing.JComboBox<String> cmbAgenter;
    private javax.swing.JLabel lblAgentFattAdmin;
    private javax.swing.JLabel lblAgentRubrik;
    private javax.swing.JLabel lblRubrik;
    // End of variables declaration//GEN-END:variables
}
