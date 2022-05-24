
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfException;
import oru.inf.InfDB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 ** @author miche, aaau, cAppelina
 *
 * Klassen möjliggör för användaren att ändra all information om en alien. När
 * alien väljs från en lista fylls först den nuvarande informationen på.
 */
public class AndraInfoAlien extends javax.swing.JFrame {

    private InfDB idb;
    //Klassen består av ett antal metoder som konverterar olika namn och benämningar till dess primärnyckel (id)
    private HjalpDbFunktioner konv;
    // Funktion för att ändra ras
    private AndraRasFunktion fuAndraRas;

    /**
     * Creates new form AndraInfoAlien
     */
    public AndraInfoAlien(InfDB idb) {
        initComponents();
        this.idb = idb;
        konv = new HjalpDbFunktioner(idb);
        fuAndraRas = new AndraRasFunktion(idb);
        fyllValjAlienNamn();
        fyllValjAnsvarigAgent();
        fyllValjPlats();
        lblAndra.setVisible(false);
        lblRasAttribut.setVisible(false);
        txtRasAttribut.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboxValAlien = new javax.swing.JComboBox<>();
        txtNamn = new javax.swing.JTextField();
        txtLosen = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtDatum = new javax.swing.JTextField();
        cboxRas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cboxPlats = new javax.swing.JComboBox<>();
        cboxAnsvarigAgent = new javax.swing.JComboBox<>();
        lblAndra = new javax.swing.JLabel();
        lblRasAttribut = new javax.swing.JLabel();
        txtRasAttribut = new javax.swing.JTextField();

        cboxValAlien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));
        cboxValAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxValAlienActionPerformed(evt);
            }
        });

        cboxRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Worm", "Squid", "Boglodite" }));
        cboxRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRasActionPerformed(evt);
            }
        });

        jLabel1.setText("Namn");

        jLabel2.setText("Lösenord");

        jLabel3.setText("Telefon");

        jLabel4.setText("Datum");

        jLabel5.setText("Plats");

        jLabel6.setText("Ansvarig Agent");

        jLabel7.setText("Ras");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel8.setText("Ändra info för Alien");

        jButton1.setText("Ändra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Alien");

        cboxPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        cboxAnsvarigAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Agent O", "Agent K", "Agent J", "Agent Z" }));

        lblAndra.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        lblAndra.setText("Ändringar har sparats");

        lblRasAttribut.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel9))
                                        .addGap(58, 58, 58))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(120, 120, 120)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboxRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxValAlien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(txtTel))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRasAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRasAttribut)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(lblAndra, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxValAlien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboxPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboxAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRasAttribut))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtRasAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(lblAndra))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        Läser av alla inmatningsfält 
        Validerar så att alla textrutorna inte är tomma efter inmatning. 
        Validerar även så att användaren väljer ett värde frå listan så att inte 
        "välj" ligger som vald.
        Anropar metoden för att uppdatera aliens ras, plus tar bort den gamla rasen
        Uppdaterar sedan all info om en viss alien.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String alienId = konv.getAlienId(cboxValAlien.getSelectedItem().toString());
        String namn = txtNamn.getText();
        String losen = txtLosen.getText();
        String tel = txtTel.getText();
        String datum = txtDatum.getText();
        //Får in namn på plats och hämtar platsens id
        String plats = konv.getPlatsId(cboxPlats.getSelectedItem().toString());
        //Får in namn på ansvarig agent och hämtar angentens id
        String ansvarigAgent = konv.getAgentId(cboxAnsvarigAgent.getSelectedItem().toString());
        String ras = cboxRas.getSelectedItem().toString();
        String rasAttribut = txtRasAttribut.getText();

        if (Validering.textFaltEjTomtRegEx(namn) && Validering.textFaltEjTomtRegEx(losen)
                && Validering.textFaltEjTomtRegEx(tel) && Validering.textFaltEjTomtRegEx(datum)
                && Validering.kollaCboxRegEx(ras) && Validering.kollaCboxRegEx(plats)
                && Validering.textFaltEjTomtRegEx(ansvarigAgent) && Validering.textFaltEjTomtRegEx(rasAttribut)) {
            //tar bort gammal ras
            taBortRas(alienId);
            //Lägg till ny ras
            fuAndraRas.andraRas(alienId, ras, rasAttribut);
            try {
                String fraga = "UPDATE alien SET Namn = '" + namn + "', Losenord = '" 
                        + losen + "', Telefon = '" + tel + "', Registreringsdatum= '" 
                        + datum + "', Plats = " + plats + ", Ansvarig_Agent = " + ansvarigAgent 
                        + " WHERE Alien_ID = " + alienId + "";
                idb.update(fraga);

                txtNamn.setText("");
                txtLosen.setText("");
                txtTel.setText("");
                txtDatum.setText("");

                lblAndra.setVisible(true);
            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Gick inte att uppdatera");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//Visar rasattribut och möjliggör ändring
    private void cboxRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRasActionPerformed
        // TODO add your handling code here:
        String ras = cboxRas.getSelectedItem().toString();

        if (ras.equalsIgnoreCase("boglodite")) {
            lblRasAttribut.setText("Antal Boogies");
            lblRasAttribut.setVisible(true);
            txtRasAttribut.setVisible(true);

        } else if (ras.equalsIgnoreCase("squid")) {
            lblRasAttribut.setText("Antal Armar");
            lblRasAttribut.setVisible(true);
            txtRasAttribut.setVisible(true);
        } else if (ras.equalsIgnoreCase("worm")) {
            lblRasAttribut.setText("1");
            lblRasAttribut.setVisible(false);
            txtRasAttribut.setVisible(false);
        }
    }//GEN-LAST:event_cboxRasActionPerformed
 //När användaren valt Alien att ändra hämtas all info om alien
 //Infon fylls i respektive textruta så att användaren inte behöver fylla i allt själv
    private void cboxValAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxValAlienActionPerformed
        
        HashMap<String, String> soktAlien;

        try {
            String alienNamn = cboxValAlien.getSelectedItem().toString();
            String fraga = "SELECT alien.Losenord, alien.Telefon, Registreringsdatum, "
                    + "plats.Benamning, agent.Namn FROM alien \n"
                    + "JOIN plats ON plats.Plats_ID=alien.Plats JOIN agent "
                    + "ON alien.Ansvarig_Agent = Agent_ID WHERE alien.Namn='" + alienNamn + "'";
            
            soktAlien = idb.fetchRow(fraga);
        
            System.out.println(soktAlien);

            txtNamn.setText(alienNamn);
            txtLosen.setText(soktAlien.get("Losenord"));
            txtTel.setText(soktAlien.get("Telefon"));
            txtDatum.setText(soktAlien.get("Registreringsdatum"));
            cboxPlats.setSelectedItem(soktAlien.get("Benamning"));
            cboxAnsvarigAgent.setSelectedItem(soktAlien.get("Namn"));

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick inte att hämta info om alien");

        }

    }//GEN-LAST:event_cboxValAlienActionPerformed

    //Fyller i comboboxen för väljAlien 
    private void fyllValjAnsvarigAgent() {
        String fraga = "SELECT Namn FROM agent";

        ArrayList<String> allaAgenter;

        try {
            allaAgenter = idb.fetchColumn(fraga);

            for (String namn : allaAgenter) {
                cboxAnsvarigAgent.addItem(namn);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick inte att fylla combobox");
        }
    }

    private void fyllValjPlats() {
        String fraga = "SELECT Benamning FROM plats";

        ArrayList<String> allaPlatser;

        try {
            allaPlatser = idb.fetchColumn(fraga);

            for (String plats : allaPlatser) {
                cboxPlats.addItem(plats);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick inte att fylla combobox");
        }
    }

    
    //Fyller i comboboxen för väljAlien 
    private void fyllValjAlienNamn() {
        String fraga = "SELECT Namn FROM alien";

        ArrayList<String> allaAliens;

        try {
            allaAliens = idb.fetchColumn(fraga);

            for (String namn : allaAliens) {
                cboxValAlien.addItem(namn);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick inte att fylla combobox");
        }
    }
   

    // Letar i varje ras tabell för att se vilken ras alien tillhörde
    // Hittar den aliens id så tar den bort hela den raden ur databasen.
    private void taBortRas(String alienID) {
        

        try {
            String fraga = "SELECT Alien_ID FROM boglodite WHERE Alien_ID ='" + alienID + "'";
            String svarAlienId = idb.fetchSingle(fraga);
            if (svarAlienId != null) {
                String fragaDelete = "DELETE FROM boglodite WHERE Alien_ID ='" + svarAlienId + "'";
                idb.delete(fragaDelete);
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte att ta bort alien från ras");
        }

        try {
            String fraga = "SELECT Alien_ID FROM worm WHERE Alien_ID ='" + alienID + "'";
            String svarAlienId = idb.fetchSingle(fraga);
            if (svarAlienId != null) {
                String fragaDelete = "DELETE FROM worm WHERE Alien_ID ='" + svarAlienId + "'";
                idb.delete(fragaDelete);
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte att ta bort alien från ras");
        }

        try {
            String fraga = "SELECT Alien_ID FROM squid WHERE Alien_ID ='" + alienID + "'";
            String svarAlienId = idb.fetchSingle(fraga);
            if (svarAlienId != null) {
                String fragaDelete = "DELETE FROM squid WHERE Alien_ID ='" + svarAlienId + "'";
                idb.delete(fragaDelete);
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte att ta bort alien från ras");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxAnsvarigAgent;
    private javax.swing.JComboBox<String> cboxPlats;
    private javax.swing.JComboBox<String> cboxRas;
    private javax.swing.JComboBox<String> cboxValAlien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAndra;
    private javax.swing.JLabel lblRasAttribut;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtLosen;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtRasAttribut;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
