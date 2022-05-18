
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
 * @author carolinaappel
 * experimenterar. Måste lösa hur valet i comboboxen ska lagras för att kunna tas bort.
 */
public class TaBortAgent extends javax.swing.JFrame {
    private InfDB idb;
    /**
     * Creates new form TaBortAgent
     */
    public TaBortAgent(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjAgent();
        lblBorttagenAgent.setVisible(false);
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
        cbxTaBortAgent = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrik.setText("Välj Agent");

        cmbAgenter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        lblBorttagenAgent.setText("Agenten har tagits bort");

        cbxTaBortAgent.setText("Ta bort Agent");
        cbxTaBortAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTaBortAgentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBorttagenAgent)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(cbxTaBortAgent))
                    .addComponent(lblRubrik))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblRubrik)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTaBortAgent))
                .addGap(24, 24, 24)
                .addComponent(lblBorttagenAgent)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTaBortAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTaBortAgentActionPerformed
        // OBS! Va försiktig med att klicka i rutan då data tas bort från tabell
        String agentNamn = cmbAgenter.getSelectedItem().toString();
        
        String fraga = "DELETE FROM Agent WHERE Namn =" + "'" + agentNamn + "'" + ";";
        try {
            idb.delete(fraga);
            lblBorttagenAgent.setVisible(true);
            System.out.println("funkar");
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
    }//GEN-LAST:event_cbxTaBortAgentActionPerformed

    private void fyllValjAgent(){
        String fraga = "SELECT Namn FROM Agent";
        
        ArrayList<String> allaAgenter; 
        
        try {
            allaAgenter = idb.fetchColumn(fraga);

            for (String plats : allaAgenter) {
                cmbAgenter.addItem(plats);
            }
                    
        }
        catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbxTaBortAgent;
    private javax.swing.JComboBox<String> cmbAgenter;
    private javax.swing.JLabel lblBorttagenAgent;
    private javax.swing.JLabel lblRubrik;
    // End of variables declaration//GEN-END:variables
}



/* skräp:
try{
            String soktNamn = cmbAgenter.getName();
            String agentFraga = "SELECT Namn FROM Agent WHERE Agent.namn = '" + soktNamn + "'";
            String svar = idb.fetchSingle(agentFraga);
            lblValdAgent.setText(svar);
            
            if(svar == null) {
                System.out.println("Agent hittades inte");
                JOptionPane.showMessageDialog(null, "Agent hittades inte, skriv in rätt Agentnamn"); 
            }
            
        }
        catch(InfException e){
            System.out.println("Något gick fel");
            JOptionPane.showMessageDialog(null, "Något gick fel");  
    }
*/