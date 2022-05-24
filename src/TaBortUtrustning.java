
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
 */
public class TaBortUtrustning extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Skapar ny TaBortUtrustning
     */
    public TaBortUtrustning(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjUtrustning();
        lblBorttagenUtrustning.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbUtrustning = new javax.swing.JComboBox<>();
        lblRubrik = new javax.swing.JLabel();
        lblBorttagenUtrustning = new javax.swing.JLabel();
        btnTaBort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbUtrustning.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        lblRubrik.setText("Välj utrusting att ta bort");

        lblBorttagenUtrustning.setText("Utr har tagits bort");

        btnTaBort.setText("Ta bort");
        btnTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(lblRubrik)
                .addGap(140, 140, 140))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBorttagenUtrustning)
                            .addComponent(btnTaBort))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblRubrik)
                .addGap(18, 18, 18)
                .addComponent(cmbUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnTaBort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBorttagenUtrustning)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        String benamning = cmbUtrustning.getSelectedItem().toString();
        String utrusningsId = getUtrustningsId(benamning);

        if (Validering.kollaTaBort(benamning)) {
            String fragaUtrustning = "DELETE FROM Utrustning WHERE Utrustnings_ID ='" + utrusningsId + "'";
            String fragaVapen = "DELETE FROM vapen WHERE Utrustnings_ID ='" + utrusningsId + "'";
            String fragaTeknik = "DELETE FROM teknik WHERE Utrustnings_ID ='" + utrusningsId + "'";
            String fragaKommunikation = "DELETE FROM kommunikation WHERE Utrustnings_ID ='" + utrusningsId + "'";
            //Fråga för att hämta ut agent id i tabell inneahar_utrustning för att kunna deleta
            String inneharUtrustning_AgentId = "SELECT Agent_ID FROM innehar_utrustning WHERE Utrustnings_ID ='" + utrusningsId + "'";
            System.out.println(inneharUtrustning_AgentId);
            try {
                //Hämtar id för agent som innehar utrustning
                String svarAgentId = idb.fetchSingle(inneharUtrustning_AgentId);
                System.out.println(svarAgentId);
                String fragaInneharUtrusning = "DELETE FROM innehar_utrustning WHERE (Utrustnings_ID, Agent_ID) IN ('" + utrusningsId + "','" + svarAgentId + "')";
                idb.delete(fragaUtrustning);
                idb.delete(fragaVapen);
                idb.delete(fragaTeknik);
                idb.delete(fragaKommunikation);
                idb.delete(fragaInneharUtrusning);
                lblBorttagenUtrustning.setVisible(true);
                lblBorttagenUtrustning.setText(benamning + " är borttagen ur systemet");

            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Gick inte att ta bort");
            }
        }
    }//GEN-LAST:event_btnTaBortActionPerformed

    //Fyller combobox med alla utrustning från databasen
    private void fyllValjUtrustning() {
        String fraga = "SELECT Benamning FROM Utrustning";

        ArrayList<String> allUtrustning;

        try {
            allUtrustning = idb.fetchColumn(fraga);

            for (String plats : allUtrustning) {
                cmbUtrustning.addItem(plats);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }

    }

    //Tar in utrustningens namn och returnerar utrustningens id
    private String getUtrustningsId(String benamning) {
        String svar = "";
        String fraga = "SELECT Utrustnings_ID FROM utrustning WHERE Benamning ='" + benamning + "'";
        try {
            svar = idb.fetchSingle(fraga);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick inte att hämta id till utrustning");
        }
        return svar;

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaBort;
    private javax.swing.JComboBox<String> cmbUtrustning;
    private javax.swing.JLabel lblBorttagenUtrustning;
    private javax.swing.JLabel lblRubrik;
    // End of variables declaration//GEN-END:variables
}

