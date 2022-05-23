
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
 * @author miche, cappelina, aaau
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        txtNamnSok.setColumns(6);

        lblAgentHittad.setText("lblAgentHittad");

        cbxAdminRatt.setText("Ge admin rättighet");
        cbxAdminRatt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAdminRattActionPerformed(evt);
            }
        });

        lblAgentFattAdmin.setText("lblAgentFattAdminstatus");

        jLabel1.setText("Skriv in agentens namn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnSok)
                    .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAgentHittad)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgentFattAdmin)
                            .addComponent(cbxAdminRatt))))
                .addGap(0, 94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnSok)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgentHittad)
                    .addComponent(cbxAdminRatt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgentFattAdmin)
                .addContainerGap(117, Short.MAX_VALUE))
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
    private javax.swing.JLabel lblAgentFattAdmin;
    private javax.swing.JLabel lblAgentHittad;
    private javax.swing.JTextField txtNamnSok;
    // End of variables declaration//GEN-END:variables
}
