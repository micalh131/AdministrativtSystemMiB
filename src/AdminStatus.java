
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
 * till andra agenter som administrtörer i systemet.
 */
public class AdminStatus extends javax.swing.JFrame {

    private InfDB idb;

    public AdminStatus(InfDB idb) {
        initComponents();
        this.idb = idb;
        lblAgentHittad.setVisible(false);
        lblAgentFattAdmin.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSok = new javax.swing.JButton();
        txtNamnSok = new javax.swing.JTextField();
        lblAgentHittad = new javax.swing.JLabel();
        cbxAdminRatt = new javax.swing.JCheckBox();
        lblAgentFattAdmin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();


        jLabel2 = new javax.swing.JLabel();


        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        txtNamnSok.setColumns(6);

        lblAgentHittad.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblAgentHittad.setText("lblAgentHittad");

        cbxAdminRatt.setText("Ge admin rättighet");
        cbxAdminRatt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAdminRattActionPerformed(evt);
            }
        });

        lblAgentFattAdmin.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        lblAgentFattAdmin.setText("lblAgentFattAdminstatus");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N

        jLabel1.setText("Skriv in Agentens namn");

        jLabel1.setText("Skriv in agentens namn");


        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel2.setText("Ge Agent Adminstatus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxAdminRatt)
                    .addComponent(lblAgentFattAdmin)
                    .addComponent(jLabel1)
                    .addComponent(btnSok)
                    .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgentHittad)
                            .addComponent(cbxAdminRatt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAgentFattAdmin)))
                .addGap(0, 86, Short.MAX_VALUE))

                    .addComponent(lblAgentHittad))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(120, 120, 120))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()

                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSok)
                .addGap(24, 24, 24)
                .addComponent(lblAgentHittad)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAdminRatt)
                    .addComponent(lblAgentFattAdmin))
                .addContainerGap(75, Short.MAX_VALUE))

                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSok)
                .addGap(18, 18, 18)
                .addComponent(lblAgentHittad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxAdminRatt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lblAgentFattAdmin)
                .addGap(60, 60, 60))

        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        String soktNamn = txtNamnSok.getText();
        if (Validering.textFaltEjTomtRegEx(soktNamn)) {
            try {

                String fraga = "SELECT Namn FROM Agent WHERE Agent.namn = '" + soktNamn + "'";
                String svar = idb.fetchSingle(fraga);
                lblAgentHittad.setVisible(true);
                lblAgentHittad.setText(svar);

                if (svar == null) {
                    System.out.println("Agent hittades inte");
                    JOptionPane.showMessageDialog(null, "Agent hittades inte, skriv in rätt Agentnamn");
                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något gick fel, det gick inte att hitta användaren i databasen");
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSokActionPerformed

    private void cbxAdminRattActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAdminRattActionPerformed
        String agentNamn = lblAgentHittad.getText();
        String fraga = "UPDATE Agent SET Administrator = 'J' WHERE Namn =" + "'" + agentNamn + "'" + ";";
        try {
            idb.update(fraga);
            lblAgentFattAdmin.setVisible(true);
            lblAgentFattAdmin.setText(agentNamn + " har fått adminstatus");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel, det gick inte att lägga till administratörsstatus");
            System.out.println(e.getMessage());
        }
        System.out.println(fraga);
    }//GEN-LAST:event_cbxAdminRattActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSok;
    private javax.swing.JCheckBox cbxAdminRatt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAgentFattAdmin;
    private javax.swing.JLabel lblAgentHittad;
    private javax.swing.JTextField txtNamnSok;
    // End of variables declaration//GEN-END:variables
}
