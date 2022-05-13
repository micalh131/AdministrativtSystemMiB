
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
 * @author miche
 */
public class SokEnskildAgent extends javax.swing.JFrame {
    private InfDB idb;
    /**
     * Creates new form SokEnskildAlien
     */
    public SokEnskildAgent(InfDB idb) {
        initComponents();
        this.idb = idb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAgentInfo = new javax.swing.JTextArea();
        txtNamnSok = new javax.swing.JTextField();
        btnSok = new javax.swing.JButton();
        lblRubrik = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtaAgentInfo.setColumns(20);
        txtaAgentInfo.setRows(5);
        jScrollPane1.setViewportView(txtaAgentInfo);

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        lblRubrik.setText("Sök info om en agent");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnSok))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRubrik))
                .addGap(28, 28, 28)
                .addComponent(btnSok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        // TODO add your handling code here:
        txtaAgentInfo.setText("");

        ArrayList<HashMap<String, String>> soktaNamn;

        try {

            String soktNamn = txtNamnSok.getText();
            String fraga = "SELECT agent.`Agent_ID`Agent_ID, agent.`Namn`, agent.`Telefon`, agent.`Administrator`, \n"
                    + "omrade.Benamning, fordon.Fordons_ID, fordon.Fordonsbeskrivning  FROM agent\n"
                    + "    JOIN omrade ON omrade.`Omrades_ID`=agent.`Omrade`\n"
                    + "        JOIN innehar_fordon ON innehar_fordon.`Agent_ID`= agent.`Agent_ID`\n"
                    + "            JOIN fordon ON fordon.`Fordons_ID`= innehar_fordon.`Fordons_ID`\n"
                    + "                WHERE agent.`Namn`= '" + soktNamn + "'";

            soktaNamn = idb.fetchRows(fraga);
            txtaAgentInfo.append("AgentID" + "\t" + "Agentnamn" + "\t" + "telefonnr" + "\t" + "Admin J/N" + "\t" + "Område" + "\t" + "FordonsID" + "\t" + "UtlånatFordon" + "\n");
            for (HashMap<String, String> ettNamn : soktaNamn) {
                txtaAgentInfo.append(ettNamn.get("Aget_ID") + "\t" + ettNamn.get("Namn") + "\t" + ettNamn.get("Telefon") + "\t" + ettNamn.get("Administrator") + "\t" + ettNamn.get("Benamnning") + "\t" + ettNamn.get("Telefon") + "\t" + ettNamn.get("Fordons_ID") + "\t" + ettNamn.get("Fordonsbeskrivning"));
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");

        }

    }//GEN-LAST:event_btnSokActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTextField txtNamnSok;
    private javax.swing.JTextArea txtaAgentInfo;
    // End of variables declaration//GEN-END:variables
}