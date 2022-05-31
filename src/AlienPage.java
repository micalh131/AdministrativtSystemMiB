
import java.util.HashMap;
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
        visaInfo();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBytLosen = new javax.swing.JButton();
        lblValkommenAlien = new javax.swing.JLabel();
        lblBildAlien = new javax.swing.JLabel();
        lblRubrik = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblTfn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBytLosen.setText("Byt lösenord");
        btnBytLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytLosenActionPerformed(evt);
            }
        });

        lblValkommenAlien.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblValkommenAlien.setText("Välkommen Alien");

        lblBildAlien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MiBAlien.jpeg"))); // NOI18N
        lblBildAlien.setText("lblBild");

        lblRubrik.setText("Kontaktinformation till din chefsagent i");

        lblOmrade.setText("Område");

        lblNamn.setText("Namn");

        lblTfn.setText("Telefon");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBildAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 402, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(lblValkommenAlien)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBytLosen)
                                .addGap(63, 63, 63))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOmrade)
                                    .addComponent(lblRubrik))
                                .addGap(0, 7, Short.MAX_VALUE)))
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamn)
                            .addComponent(lblTfn))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(lblValkommenAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOmrade)
                .addGap(28, 28, 28)
                .addComponent(lblNamn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTfn)
                .addGap(108, 108, 108)
                .addComponent(btnBytLosen)
                .addContainerGap(179, Short.MAX_VALUE))
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
   
             
       private void visaInfo() {
        

        try {
            //String fraga = "SELECT Agent_ID, Namn, Telefon, Anstallningsdatum FROM Agent WHERE Omrade = 1";
            String fraga = "SELECT agent.Agent_ID, Namn, Telefon, omrade.Benamning FROM agent \n"
                    + "JOIN omradeschef ON omradeschef.Agent_ID = agent.Agent_ID\n"
                    + "JOIN omrade ON omradeschef.Agent_ID = omrade.Omrades_ID\n"
                    + "JOIN plats ON omrade.Omrades_ID = plats.Plats_ID WHERE Plats_ID =" + alienPlats;
            HashMap<String, String> svar = idb.fetchRow(fraga);
            String namn = svar.get("Namn");
            String telefon = svar.get("Telefon");
            String omrade = svar.get("Benamning");

            lblOmrade.setText(omrade);
            if (namn == null) {
                lblNamn.setText("Det finns ingen chef för detta område");
                lblTfn.setText("");
            } 

            else {
                lblNamn.setText("Agent: " + namn);
                 lblTfn.setText("Telefonnummer: " + telefon);
            }



        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
            System.out.println(e.getMessage());
        }  } /* 
         Denna metod instansierar ett objekt av klassen AndraLosenord (som kommer användas av alla
    användare). Klassen hanterar byte av lösenord.
     */
    private void btnBytLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBytLosenActionPerformed
        // TODO add your handling code here:
        new AndraLosenord(idb, alienUserName, valdUser, password).setVisible(true);
    }//GEN-LAST:event_btnBytLosenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBytLosen;
    private javax.swing.JLabel lblBildAlien;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblTfn;
    private javax.swing.JLabel lblValkommenAlien;
    // End of variables declaration//GEN-END:variables
}
