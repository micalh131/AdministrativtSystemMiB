
import java.util.ArrayList;
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
 *
 * Klassen ser vilka Aliens som befinner sig på en angiven plats. Konstruktorn
 * fyller på en combobox som används i metoden 'fyllValjPlatsNamn' som hämtar
 * platser från databasen.
 */
public class AliensPlats extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Creates new form AliensPlats
     */
    public AliensPlats(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjPlatsNamn();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboPlatser = new javax.swing.JComboBox<>();
        scpAliens = new javax.swing.JScrollPane();
        txtAreaVisaInfo = new javax.swing.JTextArea();
        lblValjPlats = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboPlatser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));
        cboPlatser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPlatserActionPerformed(evt);
            }
        });

        txtAreaVisaInfo.setColumns(20);
        txtAreaVisaInfo.setRows(5);
        scpAliens.setViewportView(txtAreaVisaInfo);

        lblValjPlats.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblValjPlats.setText("Välj plats");

        lblId.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblId.setText("Alien ID");

        lblNamn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblNamn.setText("Namn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblId)
                        .addGap(51, 51, 51)
                        .addComponent(lblNamn))
                    .addComponent(lblValjPlats)
                    .addComponent(scpAliens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPlatser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblValjPlats)
                .addGap(3, 3, 3)
                .addComponent(cboPlatser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblNamn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpAliens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Metoden visar vilken alien som finns på den valda platsen (Beroende på vilken 
    plats som valts i fyllValjPlats) och finns ingen alien så får man ett felmeddelande.
     */
    private void cboPlatserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPlatserActionPerformed

        //Nollställer texten i textrutan där information ska visas
        txtAreaVisaInfo.setText("");

        ArrayList<HashMap<String, String>> soktaAliens;

        try {
            String valdPlats = cboPlatser.getSelectedItem().toString();
            String fraga = "SELECT Alien_ID, Namn, Plats, plats.Benamning FROM alien \n"
                    + "JOIN plats ON plats.Plats_ID=alien.Plats WHERE Benamning='" + valdPlats + "'";
            // "='"+var+"'"
            soktaAliens = idb.fetchRows(fraga);
            // txtAreaVisaInfo.append("Nåning");
            System.out.println(valdPlats);
            if (soktaAliens.size() < 1) {
                txtAreaVisaInfo.append("Det finns ingen ailien på denna plats");
            }
            for (HashMap<String, String> alien : soktaAliens) {
                txtAreaVisaInfo.append(alien.get("Alien_ID") + "\t" + alien.get("Namn") + "\n");
                //txtAreaVisaInfo.append("Alien_ID");
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_cboPlatserActionPerformed
    /*
    Hämtar information från db om alla platser som finns.
     */
    private void fyllValjPlatsNamn() {
        String fraga = "SELECT Benamning FROM plats";

        ArrayList<String> allaPlatser;

        try {
            allaPlatser = idb.fetchColumn(fraga);

            for (String plats : allaPlatser) {
                cboPlatser.addItem(plats);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboPlatser;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblValjPlats;
    private javax.swing.JScrollPane scpAliens;
    private javax.swing.JTextArea txtAreaVisaInfo;
    // End of variables declaration//GEN-END:variables
}
