
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
 */
public class ChefOmrade extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Creates new form ChefOmrade
     */
    public ChefOmrade(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjOmrade();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtaChefInfo = new javax.swing.JTextArea();
        cboxOmrade = new javax.swing.JComboBox<>();
        lblOmrade = new javax.swing.JLabel();
        lblAnsvarigOmradeschef = new javax.swing.JLabel();
        lblRubrik = new javax.swing.JLabel();

        txtaChefInfo.setColumns(20);
        txtaChefInfo.setRows(5);
        jScrollPane1.setViewportView(txtaChefInfo);

        cboxOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));
        cboxOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxOmradeActionPerformed(evt);
            }
        });

        lblOmrade.setText("Välj område");

        lblAnsvarigOmradeschef.setText("Ansvarig områdeschef:");

        lblRubrik.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRubrik.setText("Se vem som är områdeschef");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRubrik)
                    .addComponent(lblAnsvarigOmradeschef)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOmrade))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lblRubrik)
                .addGap(18, 18, 18)
                .addComponent(lblOmrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAnsvarigOmradeschef)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxOmradeActionPerformed
        String soktOmrade = cboxOmrade.getSelectedItem().toString();
        txtaChefInfo.setText("");
        if (Validering.kollaCboxRegEx(soktOmrade)) {
            try {

                String fraga = "SELECT agent.Namn FROM agent \n"
                        + "    JOIN omradeschef ON omradeschef.Agent_ID = agent.Agent_ID\n"
                        + "        JOIN omrade ON omrade.Omrades_ID=omradeschef.Omrade\n"
                        + "            WHERE omrade.Benamning= '" + soktOmrade + "'";

                String svar = idb.fetchSingle(fraga);
                txtaChefInfo.append(svar);

                

                if (svar == null) {
                    txtaChefInfo.append("Området har ingen chef");
                    //JOptionPane.showMessageDialog(null, "Området hittades inte, skriv in rätt område");
                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
                System.out.println(e.getMessage());
            }
        }
        
    }//GEN-LAST:event_cboxOmradeActionPerformed
    //Fyller dynamiskt på comboboxen med alla områden som finns i databasen

    private void fyllValjOmrade() {
        String fraga = "SELECT Benamning FROM omrade";

        ArrayList<String> allaOmraden;

        try {
            allaOmraden = idb.fetchColumn(fraga);

            for (String plats : allaOmraden) {
                cboxOmrade.addItem(plats);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxOmrade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnsvarigOmradeschef;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTextArea txtaChefInfo;
    // End of variables declaration//GEN-END:variables
}
