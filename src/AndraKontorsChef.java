
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
 * Klassen visar nuvarande kontorschef för ett angivet kontor. Klassen kan även
 * uppdatera det angivna kontoret med en ny chef genom att välja en av de
 * agenter som finns i listan.  *
 */
public class AndraKontorsChef extends javax.swing.JFrame {

    private InfDB idb;
    private HjalpDbFunktioner konv;

    /**
     *
     */
    public AndraKontorsChef(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjKontor();
        konv = new HjalpDbFunktioner(idb);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboKontor = new javax.swing.JComboBox<>();
        lblNuvarandeChef = new javax.swing.JLabel();
        txtNuChefInfo = new javax.swing.JTextField();
        lblNyChef = new javax.swing.JLabel();
        cboxNyChefLista = new javax.swing.JComboBox<>();
        spara = new javax.swing.JButton();
        lblRubrik = new javax.swing.JLabel();
        lblRubrik1 = new javax.swing.JLabel();

        cboKontor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));
        cboKontor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKontorActionPerformed(evt);
            }
        });

        lblNuvarandeChef.setText("Nuvarande chef");
        lblNuvarandeChef.setToolTipText("");

        txtNuChefInfo.setColumns(6);

        lblNyChef.setText("Välj en ny chef i listan");

        cboxNyChefLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        spara.setText("Spara");
        spara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sparaActionPerformed(evt);
            }
        });

        lblRubrik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRubrik.setText("Ändra kontorschef ");

        lblRubrik1.setText("Välj kontor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRubrik1)
                    .addComponent(cboKontor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRubrik)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNuvarandeChef, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNuChefInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblNyChef)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spara)
                                .addComponent(cboxNyChefLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRubrik1)
                .addGap(5, 5, 5)
                .addComponent(cboKontor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNuvarandeChef)
                    .addComponent(txtNuChefInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboxNyChefLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNyChef))
                .addGap(34, 34, 34)
                .addComponent(spara)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cboKontorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKontorActionPerformed

        /*Hämtar information från databasen om vilken agent som är chef på det 
        aktuella kontoret som valts i dropdownlistan. Resultatet visas i textrutan */
        txtNuChefInfo.setText("");

        ArrayList<HashMap<String, String>> soktaChefer;
        String valtKontor = cboKontor.getSelectedItem().toString();
        String fraga = "SELECT Namn FROM agent JOIN kontorschef ON kontorschef.`Agent_ID`=agent.`Agent_ID`"
                + "WHERE kontorschef.`Kontorsbeteckning`= '" + valtKontor + "'";
        //validerar så att användaren har valt ett kontor
        if (Validering.kollaCboxRegEx(valtKontor)) {
            try {

                soktaChefer = idb.fetchRows(fraga);

                if (soktaChefer.size() < 1) {
                    txtNuChefInfo.setText("Det finns ingen chef på detta kontor");
                }
                for (HashMap<String, String> chefer : soktaChefer) {
                    txtNuChefInfo.setText(chefer.get("Namn"));

                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något gick fel \n" + e.getMessage());
                System.out.println(e.getMessage());

            }
            //fyller på i listan väljnychef med de agenter som finns
            fyllValjAgenter();
        }
    }//GEN-LAST:event_cboKontorActionPerformed
//Uppdaterar ny kontorschef på det valda kontoret
    private void sparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaActionPerformed

        String valtKontor = cboKontor.getSelectedItem().toString();
        String valdChefsAgent = cboxNyChefLista.getSelectedItem().toString();
        String valdChefsAgentId = konv.getAgentId(valdChefsAgent);

        if (Validering.kollaCboxRegEx(valdChefsAgent)) {
            try {

                String fraga = "UPDATE kontorschef SET Agent_ID = '" + valdChefsAgentId + "'"
                        + "WHERE Kontorsbeteckning = '" + valtKontor + "'";

                idb.update(fraga);
                JOptionPane.showMessageDialog(null, valdChefsAgent + " är nu ny chef för " + valtKontor);

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
                System.out.println(e.getMessage());

            }
        }
    }//GEN-LAST:event_sparaActionPerformed
    /*
    Hämtar information från db om alla kontor som finns.
     */
    private void fyllValjKontor() {
        String fraga = "SELECT Kontorsbeteckning FROM kontorschef";

        ArrayList<String> allaKontor;

        try {
            allaKontor = idb.fetchColumn(fraga);

            for (String ettKontor : allaKontor) {
                cboKontor.addItem(ettKontor);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
            System.out.println(e.getMessage());
        }

    }

    private void fyllValjAgenter() {
        String fraga = "SELECT Namn FROM agent";

        ArrayList<String> allaAgenter;

        try {
            allaAgenter = idb.fetchColumn(fraga);

            for (String enAgent : allaAgenter) {
                cboxNyChefLista.addItem(enAgent);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
            System.out.println(e.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboKontor;
    private javax.swing.JComboBox<String> cboxNyChefLista;
    private javax.swing.JLabel lblNuvarandeChef;
    private javax.swing.JLabel lblNyChef;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblRubrik1;
    private javax.swing.JButton spara;
    private javax.swing.JTextField txtNuChefInfo;
    // End of variables declaration//GEN-END:variables
}
