
import oru.inf.InfDB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author miche, aaau, cAppelina
 * Aliens välkomstsida med funktionaliteter: Ändra lösenord samt se infor om 
 * ansvarig områdeschef.
 * Kopplar databasen. Vi använder fälten för att spara värden som vi skickar med via metoder
 * i klassen när vi instantiserar nya objekt av andra klasser.
 *  
 */
public class AlienPage extends javax.swing.JFrame {

    private InfDB idb;
    private String alienPlats;
    private String alienUserName;
    private String password;
    private String valdUser;

    /**
     * Creates new form AlienPage
     *
     * @param idb
     * @param alienPlats
     * @param alienUserName
     * @param valdUser
     * @param password
     */
    public AlienPage(InfDB idb, String alienPlats, String alienUserName, String valdUser, String password) {
        initComponents();
        this.idb = idb;
        this.alienPlats = alienPlats;
        this.alienUserName = alienUserName;
        this.password = password;
        this.valdUser = valdUser;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBytLosen = new javax.swing.JButton();
        btnVisaAgentInfo = new javax.swing.JButton();
        lblValkommenAlien = new javax.swing.JLabel();
        lblBildAlien = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBytLosen.setText("Byt lösenord");
        btnBytLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytLosenActionPerformed(evt);
            }
        });

        btnVisaAgentInfo.setText("Agent Info");
        btnVisaAgentInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaAgentInfoActionPerformed(evt);
            }
        });

        lblValkommenAlien.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblValkommenAlien.setText("Välkommen Alien");

        lblBildAlien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MiBAlien.jpeg"))); // NOI18N
        lblBildAlien.setText("lblBild");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBildAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBytLosen)
                            .addGap(83, 83, 83))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnVisaAgentInfo)
                            .addGap(94, 94, 94)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblValkommenAlien)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(lblValkommenAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnVisaAgentInfo)
                .addGap(33, 33, 33)
                .addComponent(btnBytLosen)
                .addContainerGap(314, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblBildAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* 
    Denna metod är till för att Alien ska kunna se info om områdeschefen för sitt område.
    När knappen klickas instansieras objekt av 'VisaAgentInfo' som ställer relevant fråga till
    databasen.
     */
    private void btnVisaAgentInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaAgentInfoActionPerformed
        // TODO add your handling code here:
        new VisaAgentInfo(idb, alienPlats).setVisible(true);

    }//GEN-LAST:event_btnVisaAgentInfoActionPerformed
    /* 
    Denna metod instansierar ett objekt av klassen AndraLosenord (som kommer användas av alla
    användare). Klassen hanterar byte av lösenord.
     */
    private void btnBytLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBytLosenActionPerformed
        // TODO add your handling code here:
        new AndraLosenord(idb, alienUserName, valdUser, password).setVisible(true);
    }//GEN-LAST:event_btnBytLosenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBytLosen;
    private javax.swing.JButton btnVisaAgentInfo;
    private javax.swing.JLabel lblBildAlien;
    private javax.swing.JLabel lblValkommenAlien;
    // End of variables declaration//GEN-END:variables
}
