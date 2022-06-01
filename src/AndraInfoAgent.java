
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
 * @author miche, aaau, cAppelina
 *
 * Klassen möjliggör för användaren att ändra all information om en agent. När
 * agenten väljs från en lista fylls först den nuvarande informationen på.
 */
public class AndraInfoAgent extends javax.swing.JFrame {

    private InfDB idb;
     //Klassen består av ett antal metoder som konverterar olika namn och benämningar till dess primärnyckel (id)
    private HjalpDbFunktioner konv;

    /**
     * Creates new form AndraInfoAlien
     */
    public AndraInfoAgent(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjAlienNamn();
        fyllValjOmrade();
        lblAndra.setVisible(false);
        konv = new HjalpDbFunktioner(idb);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboxValAgent = new javax.swing.JComboBox<>();
        txtNamn = new javax.swing.JTextField();
        txtLosen = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtDatum = new javax.swing.JTextField();
        lblNamn = new javax.swing.JLabel();
        lblLosen = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        lblRubrik = new javax.swing.JLabel();
        btnAndra = new javax.swing.JButton();
        lblAgent = new javax.swing.JLabel();
        cboxOmrade = new javax.swing.JComboBox<>();
        cboxAdmin = new javax.swing.JComboBox<>();
        lblAndra = new javax.swing.JLabel();

        cboxValAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));
        cboxValAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxValAgentActionPerformed(evt);
            }
        });

        lblNamn.setText("Namn");

        lblLosen.setText("Lösenord");

        lblTel.setText("Telefon");

        lblDatum.setText("Anställningsdatum");

        lblOmrade.setText("Område");

        lblAdmin.setText("Administratör");

        lblRubrik.setText("Ändra info för Agent");

        btnAndra.setText("Ändra");
        btnAndra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraActionPerformed(evt);
            }
        });

        lblAgent.setText("Agent");

        cboxOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        cboxAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Ja", "Nej" }));

        lblAndra.setText("Ändringar har sparats");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRubrik)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamn)
                            .addComponent(lblLosen)
                            .addComponent(lblTel)
                            .addComponent(lblDatum)
                            .addComponent(lblOmrade)
                            .addComponent(lblAdmin)
                            .addComponent(lblAgent))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxValAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTel, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(txtDatum))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAndra)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblAndra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxValAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLosen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOmrade)
                    .addComponent(cboxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdmin)
                            .addComponent(cboxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAndra)
                        .addGap(24, 24, 24)))
                .addComponent(btnAndra)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraActionPerformed

        String agentId = konv.getAgentId(cboxValAgent.getSelectedItem().toString());
        String namn = txtNamn.getText();
        String losen = txtLosen.getText();
        String tel = txtTel.getText();
        String datum = txtDatum.getText();
        //Får in namn på plast och hämtar platsens id
        String omrade = konv.getOmradeId(cboxOmrade.getSelectedItem().toString());
        //Får in namn på ansvarig agent och hämtar angentens id
        String isAdmin = Validering.kollaIsAdmin(cboxAdmin.getSelectedItem().toString());

        if (Validering.kollaCboxRegEx(isAdmin)&& Validering.kollaCboxRegEx(omrade)
                && Validering.textFaltEjTomtRegEx(namn) && Validering.textFaltEjTomtRegEx(losen)
                && Validering.textFaltEjTomtRegEx(tel) && Validering.textFaltEjTomtRegEx(datum)) {
          
            try {
                String fraga = "UPDATE agent SET Namn = '" + namn + "', Losenord = '" + losen
                        + "', Telefon = '" + tel + "', Anstallningsdatum= '" + datum
                        + "', Omrade = " + omrade + ", Administrator = '" + isAdmin
                        + "' WHERE Agent_ID = " + agentId + "";
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
    }//GEN-LAST:event_btnAndraActionPerformed

    //När användaren valt Agent att ändra hämtas all info om agent
    //Infon fylls i respektive textruta så att användaren inte behöver fylla i allt själv
    private void cboxValAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxValAgentActionPerformed

        HashMap<String, String> soktAgent;

        try {
            String agentNamn = cboxValAgent.getSelectedItem().toString();
            String fraga = "SELECT Namn, Losenord, Telefon, Anstallningsdatum, "
                    + "Administrator, omrade.Benamning FROM agent \n"
                    + "JOIN omrade ON Omrades_ID= agent.Omrade WHERE Namn='" + agentNamn + "'";

            soktAgent = idb.fetchRow(fraga);

            txtNamn.setText(soktAgent.get("Namn"));
            txtLosen.setText(soktAgent.get("Losenord"));
            txtTel.setText(soktAgent.get("Telefon"));
            txtDatum.setText(soktAgent.get("Anstallningsdatum"));
            cboxOmrade.setSelectedItem(soktAgent.get("Benamning"));
            String admin = soktAgent.get("Administrator");
            if (admin.equals("J")) {
                cboxAdmin.setSelectedItem("Ja");
            } else {
                cboxAdmin.setSelectedItem("Nej");
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick att hämta information om agent");
            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_cboxValAgentActionPerformed

    private void fyllValjAlienNamn() {
        String fraga = "SELECT Namn FROM agent";

        ArrayList<String> allaAgenter;

        try {
            allaAgenter = idb.fetchColumn(fraga);

            for (String namn : allaAgenter) {
                cboxValAgent.addItem(namn);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick inte att fylla combobox");
        }
    }

    //Fyller i comboboxen för väljAlien 
    private void fyllValjOmrade() {
        String fraga = "SELECT Benamning FROM omrade";

        ArrayList<String> allaOmraden;

        try {
            allaOmraden = idb.fetchColumn(fraga);

            for (String namn : allaOmraden) {
                cboxOmrade.addItem(namn);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick inte att fylla combobox");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndra;
    private javax.swing.JComboBox<String> cboxAdmin;
    private javax.swing.JComboBox<String> cboxOmrade;
    private javax.swing.JComboBox<String> cboxValAgent;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAgent;
    private javax.swing.JLabel lblAndra;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblLosen;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblTel;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtLosen;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
