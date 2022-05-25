
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author miche, aaau, cAppelina experimenterar. Måste lösa hur valet i
 * comboboxen ska lagras för att kunna tas bort.
 */
public class TaBortAgent extends javax.swing.JFrame {

    private InfDB idb;
    private HjalpDbFunktioner konv;

    /**
     * Skapar ny TaBortAgent
     */
    public TaBortAgent(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjAgent();
        lblBorttagenAgent.setVisible(false);
        konv = new HjalpDbFunktioner(idb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRubrik = new javax.swing.JLabel();
        cmbAgenter = new javax.swing.JComboBox<>();
        lblBorttagenAgent = new javax.swing.JLabel();
        btnTaBort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrik.setText("Välj Agent att ta bort");

        cmbAgenter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        lblBorttagenAgent.setText("Agenten har tagits bort");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaBort))
                        .addGap(18, 18, 18)
                        .addComponent(lblBorttagenAgent))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(lblRubrik)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblRubrik)
                .addGap(18, 18, 18)
                .addComponent(cmbAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBorttagenAgent)
                    .addComponent(btnTaBort))
                .addGap(112, 112, 112))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// Tar bort vald agent ur databasen i samtliga tabeller
    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        String namn = cmbAgenter.getSelectedItem().toString();
        String agentId = konv.getAgentId(namn);

        if (Validering.kollaTaBort(namn) &&  kollaOmAgentÄrAnsvarigFörAlien(namn,agentId)) {
            try {
                idb.delete("DELETE FROM innehar_utrustning WHERE Agent_ID =" + agentId);
                idb.delete("DELETE FROM innehar_fordon WHERE Agent_ID =" + agentId);
                idb.delete("DELETE FROM faltagent WHERE Agent_ID =" + agentId);
                idb.delete("DELETE FROM kontorschef WHERE Agent_ID =" + agentId);
                idb.delete("DELETE FROM omradeschef WHERE Agent_ID =" + agentId);
                idb.delete("DELETE FROM agent WHERE Agent_ID =" + agentId);

                lblBorttagenAgent.setVisible(true);
                lblBorttagenAgent.setText(namn + "är borttagen ur systemet");
                //cmbAgenter.removeItem(namn);
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Gick inte att ta bort");
            }
        }
    }//GEN-LAST:event_btnTaBortActionPerformed

    //Fyller combobox med alla agenter från databasen 
    private void fyllValjAgent() {
        String fraga = "SELECT Namn FROM Agent";

        ArrayList<String> allaAgenter;

        try {
            allaAgenter = idb.fetchColumn(fraga);

            for (String plats : allaAgenter) {
                cmbAgenter.addItem(plats);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick ej att ladda agenter");
        }

    }
    
    private boolean kollaOmAgentÄrAnsvarigFörAlien(String namn, String agentId){
        boolean result = false;
        ArrayList<String> ansvarigaAgenter = null;
        try{
            ansvarigaAgenter = idb.fetchColumn("SELECT namn FROM alien WHERE Ansvarig_Agent ="+ agentId);
        }catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick ej att hämta ansvarig agent");
        }
        if(ansvarigaAgenter.size() < 1){
            result = true;
        }else{
            String text = "" + namn + " går inte att ta bort\n då hen är ansvarig för alien\n med namn: \n ";
            for(String n : ansvarigaAgenter){
                text += n + "\n";
            }
            text += "Ändra ansvarig agent innan borttagning!";
            
            JOptionPane.showMessageDialog(null, text);
        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaBort;
    private javax.swing.JComboBox<String> cmbAgenter;
    private javax.swing.JLabel lblBorttagenAgent;
    private javax.swing.JLabel lblRubrik;
    // End of variables declaration//GEN-END:variables
}

