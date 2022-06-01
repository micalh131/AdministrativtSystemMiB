
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 * @author miche, aaau, cAppelina
 *
 * Klassen innehåller att antal knappar som länkar till nya fönster med olika
 * funktioner som en inloggad agent kommer åt.
 */
public class AgentPage extends javax.swing.JFrame {

    private InfDB idb;
    private String userName;
    private String password;
    private String valdUser;
    private String isAdmin;

    /**
     * Konstruktorn tar in 5 parametrar för att kunna skicka vidare den
     * informationen vidare till andra sidor med andra funktioner.
     */
    public AgentPage(InfDB idb, String userName, String valdUser, String password, String isAdmin) {
        initComponents();
        this.idb = idb;
        this.userName = userName;
        this.valdUser = valdUser;
        this.password = password;
        this.isAdmin = isAdmin;
        btnAdminInlogg.setVisible(kollaIsAdmin(isAdmin));
        getAgentNamn(userName);

    }

    // Sätter knappen "Administratör inloggning" synlig om man har statusen isAdmin. 
    private boolean kollaIsAdmin(String isAdmin) {
        if (isAdmin.equals("J")) {
            return true;
        }
        return false;
    }
    
    private void getAgentNamn(String userName){
        
          String Namn = userName;
          lblValkommenAgent.setText("");
        
        try{
            String fraga = "SELECT Namn FROM agent WHERE Agent_ID = '"+ userName +"'";
            Namn = idb.fetchSingle(fraga);
        }
        catch(InfException ex){
                JOptionPane.showMessageDialog(null, "Gick inte att hämta agentens namn");
            }
        
        lblValkommenAgent.setText("Välkommen " + Namn);
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        lblBild = new javax.swing.JLabel();
        btnBytLosen = new javax.swing.JButton();
        lblValkommenAgent = new javax.swing.JLabel();
        btnNyregistreraAlien = new javax.swing.JButton();
        btnAlienInfo = new javax.swing.JButton();
        btnRegistreraUtr = new javax.swing.JButton();
        btnAgentInfo = new javax.swing.JButton();
        btnAdminInlogg = new javax.swing.JButton();
        btnListaAlienPlats = new javax.swing.JButton();
        btnListaAlienRas = new javax.swing.JButton();
        btnSokAlienDatum = new javax.swing.JButton();
        btnAndraInfoAlien = new javax.swing.JButton();
        btnEnskildAlien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MiB Agenter.png"))); // NOI18N
        lblBild.setText("jLabel1");
        lblBild.setPreferredSize(new java.awt.Dimension(220, 326));

        btnBytLosen.setText("Byt Lösenord");
        btnBytLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytLosenActionPerformed(evt);
            }
        });

        lblValkommenAgent.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblValkommenAgent.setText("Välkommen ");

        btnNyregistreraAlien.setText("Registrera ny Alien");
        btnNyregistreraAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyregistreraAlienActionPerformed(evt);
            }
        });

        btnAlienInfo.setText("Sök Ansvarig Agent för Alien");
        btnAlienInfo.setToolTipText("");
        btnAlienInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlienInfoActionPerformed(evt);
            }
        });

        btnRegistreraUtr.setText("Registrera utrustning");
        btnRegistreraUtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreraUtrActionPerformed(evt);
            }
        });

        btnAgentInfo.setText("Sök områdeschef");
        btnAgentInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgentInfoActionPerformed(evt);
            }
        });

        btnAdminInlogg.setText("Administratör Inloggning");
        btnAdminInlogg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminInloggActionPerformed(evt);
            }
        });

        btnListaAlienPlats.setText("Sök Alien utifrån plats");
        btnListaAlienPlats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaAlienPlatsActionPerformed(evt);
            }
        });

        btnListaAlienRas.setText("Sök Alien utifrån ras");
        btnListaAlienRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaAlienRasActionPerformed(evt);
            }
        });

        btnSokAlienDatum.setText("Sök när Alien registrerats");
        btnSokAlienDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokAlienDatumActionPerformed(evt);
            }
        });

        btnAndraInfoAlien.setText("Ändra info om Alien");
        btnAndraInfoAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraInfoAlienActionPerformed(evt);
            }
        });

        btnEnskildAlien.setText("Sök information om enskild alien");
        btnEnskildAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnskildAlienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBytLosen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdminInlogg)
                                .addGap(19, 19, 19))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNyregistreraAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAndraInfoAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegistreraUtr)
                                    .addComponent(btnAgentInfo))
                                .addContainerGap(131, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnListaAlienRas, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSokAlienDatum)
                                    .addComponent(btnListaAlienPlats)
                                    .addComponent(btnAlienInfo)
                                    .addComponent(btnEnskildAlien))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(lblValkommenAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblValkommenAgent)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNyregistreraAlien)
                    .addComponent(btnRegistreraUtr))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgentInfo)
                    .addComponent(btnAndraInfoAlien))
                .addGap(12, 12, 12)
                .addComponent(btnAlienInfo)
                .addGap(18, 18, 18)
                .addComponent(btnListaAlienPlats)
                .addGap(18, 18, 18)
                .addComponent(btnListaAlienRas)
                .addGap(23, 23, 23)
                .addComponent(btnSokAlienDatum)
                .addGap(18, 18, 18)
                .addComponent(btnEnskildAlien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdminInlogg)
                    .addComponent(btnBytLosen))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgentInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgentInfoActionPerformed
        // TODO add your handling code here:
        new ChefOmrade(idb).setVisible(true);
    }//GEN-LAST:event_btnAgentInfoActionPerformed

    private void btnAlienInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlienInfoActionPerformed
        // TODO add your handling code here:
        new SokEnskildAlien(idb).setVisible(true);
    }//GEN-LAST:event_btnAlienInfoActionPerformed

    private void btnBytLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBytLosenActionPerformed
        // TODO add your handling code here:
        new AndraLosenord(idb, userName, valdUser, password).setVisible(true);
    }//GEN-LAST:event_btnBytLosenActionPerformed

    private void btnNyregistreraAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyregistreraAlienActionPerformed
        // TODO add your handling code here:
        new NyregistreraAlien(idb).setVisible(true);
    }//GEN-LAST:event_btnNyregistreraAlienActionPerformed

    private void btnAndraInfoAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraInfoAlienActionPerformed
        // TODO add your handling code here:
        new AndraInfoAlien(idb).setVisible(true);
    }//GEN-LAST:event_btnAndraInfoAlienActionPerformed

    private void btnListaAlienPlatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaAlienPlatsActionPerformed
        // TODO add your handling code here:
        new AliensPlats(idb).setVisible(true);
    }//GEN-LAST:event_btnListaAlienPlatsActionPerformed

    private void btnListaAlienRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaAlienRasActionPerformed
        // TODO add your handling code here:
        new AliensPerRas(idb).setVisible(true);
    }//GEN-LAST:event_btnListaAlienRasActionPerformed

    private void btnSokAlienDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokAlienDatumActionPerformed
        // TODO add your handling code here:
        new SokAlienDatum(idb).setVisible(true);
    }//GEN-LAST:event_btnSokAlienDatumActionPerformed

    private void btnRegistreraUtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistreraUtrActionPerformed
        // TODO add your handling code here:
        new NyregistreraUtrustning(idb).setVisible(true);
    }//GEN-LAST:event_btnRegistreraUtrActionPerformed

    private void btnAdminInloggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminInloggActionPerformed
        // TODO add your handling code here:
        new AdminPage(idb, userName).setVisible(true);
    }//GEN-LAST:event_btnAdminInloggActionPerformed

    private void btnEnskildAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnskildAlienActionPerformed
        // TODO add your handling code here:
        new SokEnskildAlien(idb).setVisible(true);
    }//GEN-LAST:event_btnEnskildAlienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminInlogg;
    private javax.swing.JButton btnAgentInfo;
    private javax.swing.JButton btnAlienInfo;
    private javax.swing.JButton btnAndraInfoAlien;
    private javax.swing.JButton btnBytLosen;
    private javax.swing.JButton btnEnskildAlien;
    private javax.swing.JButton btnListaAlienPlats;
    private javax.swing.JButton btnListaAlienRas;
    private javax.swing.JButton btnNyregistreraAlien;
    private javax.swing.JButton btnRegistreraUtr;
    private javax.swing.JButton btnSokAlienDatum;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblBild;
    private javax.swing.JLabel lblValkommenAgent;
    // End of variables declaration//GEN-END:variables
}
