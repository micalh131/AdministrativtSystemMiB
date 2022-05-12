
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
    private String valdUser;
    /**
     * Creates new form AlienPage
     * @param idb
     * @param alienPlats
     * @param alienUserName
     * @param valdUser
     */
    public AlienPage(InfDB idb,String alienPlats, String alienUserName, String valdUser ) {
        initComponents();
        this.idb = idb;
        this.alienPlats = alienPlats;
        this.alienUserName = alienUserName;
        this.valdUser = valdUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBytLosen = new javax.swing.JButton();
        btnVisaAgentInfo = new javax.swing.JButton();
        lblValkommenAlien = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBytLosen.setText("Byt lösenord");
        btnBytLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytLosenActionPerformed(evt);
            }
        });

        btnVisaAgentInfo.setText("AgentInfo");
        btnVisaAgentInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaAgentInfoActionPerformed(evt);
            }
        });

        lblValkommenAlien.setText("Välkommen Alien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnBytLosen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnVisaAgentInfo)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(lblValkommenAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblValkommenAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBytLosen)
                    .addComponent(btnVisaAgentInfo))
                .addGap(126, 126, 126))
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
        new AndraLosenord(idb,alienUserName,valdUser).setVisible(true);
    }//GEN-LAST:event_btnBytLosenActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBytLosen;
    private javax.swing.JButton btnVisaAgentInfo;
    private javax.swing.JLabel lblValkommenAlien;
    // End of variables declaration//GEN-END:variables
}
