
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
 ** @author miche, aaau, cAppelina
 *
 * Klassen möjliggör för användaren att i en lista välja en viss ras. De aliens
 * som tillhör den rasen visas.
 *
 */
public class AliensPerRas extends javax.swing.JFrame {

    private InfDB idb;

    public AliensPerRas(InfDB idb) {
        initComponents();
        this.idb = idb;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblValgRas = new javax.swing.JLabel();
        cboxRaser = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAlienLista = new javax.swing.JTextArea();
        lblRubrik = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();

        lblValgRas.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblValgRas.setText("Välj Alienras");

        cboxRaser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Squid", "Worm", "Boglodite" }));
        cboxRaser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRaserActionPerformed(evt);
            }
        });

        txtaAlienLista.setColumns(20);
        txtaAlienLista.setRows(5);
        jScrollPane1.setViewportView(txtaAlienLista);

        lblRubrik.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        lblRubrik.setText("Aliens av viss ras");

        lblId.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblId.setText("Alien ID");

        lblNamn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblNamn.setText("Namn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblId)
                        .addGap(47, 47, 47)
                        .addComponent(lblNamn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxRaser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValgRas)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblRubrik)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValgRas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxRaser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblNamn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxRaserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRaserActionPerformed
        /*Metoden hämtar information från respektive tabell i databasen som motsvarar 
        det namn på ras som användare väljer. Alien ID och namn på alien visas.
        
         */

        txtaAlienLista.setText("");
        ArrayList<HashMap<String, String>> soktaAliens;
        String valdRas = cboxRaser.getSelectedItem().toString();
        try {

            if (valdRas.equals("Squid")) {

                String fragaSquid = "SELECT squid.Alien_ID, alien.Namn FROM squid JOIN alien ON alien.`Alien_ID`= squid.`Alien_ID`";
                soktaAliens = idb.fetchRows(fragaSquid);

                for (HashMap<String, String> enAlien : soktaAliens) {
                    txtaAlienLista.append(enAlien.get("Alien_ID") + "\t" + enAlien.get("Namn") + "\n");
                    return;
                }
            }
            if (valdRas.equals("Worm")) {

                String fragaWorm = "SELECT worm.Alien_ID, alien.Namn FROM worm JOIN alien ON alien.`Alien_ID`= worm.`Alien_ID`";
                soktaAliens = idb.fetchRows(fragaWorm);

                for (HashMap<String, String> enAlien : soktaAliens) {
                    txtaAlienLista.append(enAlien.get("Alien_ID") + "\t" + enAlien.get("Namn") + "\n");
                    return;
                }
            }
            if (valdRas.equals("Boglodite")) {

                String fragaBoglodite = "SELECT boglodite.Alien_ID, alien.Namn FROM boglodite JOIN alien ON alien.`Alien_ID`= boglodite.`Alien_ID`";
                soktaAliens = idb.fetchRows(fragaBoglodite);

                for (HashMap<String, String> enAlien : soktaAliens) {
                    txtaAlienLista.append(enAlien.get("Alien_ID") + "\t" + enAlien.get("Namn") + "\n");
                    return;
                }
            }

    }//GEN-LAST:event_cboxRaserActionPerformed
       
        catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
            System.out.println(e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxRaser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblValgRas;
    private javax.swing.JTextArea txtaAlienLista;
    // End of variables declaration//GEN-END:variables
}
