/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author miche, aaau, cAppelina
 *
 * Klassen innehåller att antal knappar som länkar till nya fönster med
 * funktioner som endast en administratör kommer åt.
 */
public class AdminPage extends javax.swing.JFrame {

    private InfDB idb;
    private String userName;

    /*
    Konstruktorn tar 2 parametrar, databasen och användarnamnet från LoginPage)
     */
    public AdminPage(InfDB idb, String userName) {
        initComponents();
        this.idb = idb;
        this.userName = userName;
        loginTitle.setText("Välkommen till administratörssidan");
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginTitle = new javax.swing.JLabel();
        lblBild = new javax.swing.JLabel();
        btnTaBortAlien = new javax.swing.JButton();
        btnTaBortUtr = new javax.swing.JButton();
        btnNyregAgent = new javax.swing.JButton();
        btnAgentSokningar = new javax.swing.JButton();
        btnAdminStatus = new javax.swing.JButton();
        btnTaBortAgent = new javax.swing.JButton();
        btnAndraInfoAgent = new javax.swing.JButton();
        btnAndraOmradeschef = new javax.swing.JButton();
        btnAndraKontorschef = new javax.swing.JButton();

        loginTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        loginTitle.setText("Välkommen Super Admin");

        lblBild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MiB SuperAdmin3.jpeg"))); // NOI18N
        lblBild.setText("jLabel1");

        btnTaBortAlien.setText("Ta bort Alien");
        btnTaBortAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortAlienActionPerformed(evt);
            }
        });

        btnTaBortUtr.setText("Ta bort utrustning");
        btnTaBortUtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortUtrActionPerformed(evt);
            }
        });

        btnNyregAgent.setText("Nyregistrera Agenter");
        btnNyregAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyregAgentActionPerformed(evt);
            }
        });

        btnAgentSokningar.setText("Sök info enskild agent");
        btnAgentSokningar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgentSokningarActionPerformed(evt);
            }
        });

        btnAdminStatus.setText("Ge annan Agent admin status");
        btnAdminStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminStatusActionPerformed(evt);
            }
        });

        btnTaBortAgent.setText("Ta bort agent");
        btnTaBortAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortAgentActionPerformed(evt);
            }
        });

        btnAndraInfoAgent.setText("Ändra info om Agent");
        btnAndraInfoAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraInfoAgentActionPerformed(evt);
            }
        });

        btnAndraOmradeschef.setText("Ändra områdeschef");
        btnAndraOmradeschef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraOmradeschefActionPerformed(evt);
            }
        });

        btnAndraKontorschef.setText("Ändra kontorschef");
        btnAndraKontorschef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraKontorschefActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgentSokningar)
                            .addComponent(btnNyregAgent)
                            .addComponent(btnAdminStatus)
                            .addComponent(btnAndraInfoAgent)
                            .addComponent(btnAndraOmradeschef)
                            .addComponent(btnAndraKontorschef))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaBortUtr)
                            .addComponent(btnTaBortAlien)
                            .addComponent(btnTaBortAgent))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(loginTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(loginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgentSokningar)
                            .addComponent(btnTaBortAgent))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNyregAgent)
                            .addComponent(btnTaBortAlien))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdminStatus)
                            .addComponent(btnTaBortUtr))
                        .addGap(18, 18, 18)
                        .addComponent(btnAndraInfoAgent)
                        .addGap(18, 18, 18)
                        .addComponent(btnAndraOmradeschef)
                        .addGap(18, 18, 18)
                        .addComponent(btnAndraKontorschef)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminStatusActionPerformed
        new AdminStatus(idb).setVisible(true);
    }//GEN-LAST:event_btnAdminStatusActionPerformed

    private void btnAgentSokningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgentSokningarActionPerformed
        // TODO add your handling code here:
        new SokEnskildAgent(idb).setVisible(true);
    }//GEN-LAST:event_btnAgentSokningarActionPerformed

    private void btnNyregAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyregAgentActionPerformed
        // TODO add your handling code here:
        new NyregistreraAgent(idb).setVisible(true);
    }//GEN-LAST:event_btnNyregAgentActionPerformed

    private void btnAndraInfoAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraInfoAgentActionPerformed
        // TODO add your handling code here:
        new AndraInfoAgent(idb).setVisible(true);
    }//GEN-LAST:event_btnAndraInfoAgentActionPerformed

    private void btnAndraOmradeschefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraOmradeschefActionPerformed
        // TODO add your handling code here:
        new AndraOmradesChef(idb).setVisible(true);
    }//GEN-LAST:event_btnAndraOmradeschefActionPerformed

    private void btnAndraKontorschefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraKontorschefActionPerformed
        // TODO add your handling code here:
        new AndraKontorsChef(idb).setVisible(true);
    }//GEN-LAST:event_btnAndraKontorschefActionPerformed

    private void btnTaBortAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortAgentActionPerformed
        // TODO add your handling code here:
        new TaBortAgent(idb).setVisible(true);
    }//GEN-LAST:event_btnTaBortAgentActionPerformed

    private void btnTaBortAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortAlienActionPerformed
        // TODO add your handling code here:
        new TaBortAlien(idb).setVisible(true);
    }//GEN-LAST:event_btnTaBortAlienActionPerformed

    private void btnTaBortUtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortUtrActionPerformed
        // TODO add your handling code here:
        new TaBortUtrustning(idb).setVisible(true);
    }//GEN-LAST:event_btnTaBortUtrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminStatus;
    private javax.swing.JButton btnAgentSokningar;
    private javax.swing.JButton btnAndraInfoAgent;
    private javax.swing.JButton btnAndraKontorschef;
    private javax.swing.JButton btnAndraOmradeschef;
    private javax.swing.JButton btnNyregAgent;
    private javax.swing.JButton btnTaBortAgent;
    private javax.swing.JButton btnTaBortAlien;
    private javax.swing.JButton btnTaBortUtr;
    private javax.swing.JLabel lblBild;
    private javax.swing.JLabel loginTitle;
    // End of variables declaration//GEN-END:variables
}
