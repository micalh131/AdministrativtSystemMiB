
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
 * @author miche, aaau, cAppelina
 */
public class NyregistreraAgent extends javax.swing.JFrame {

    private InfDB idb;
    //Klassen består av ett antal metoder som konverterar olika namn och benämningar till dess primärnyckel (id)
    private HjalpDbFunktioner konv;

    /**
     * Skapar ny NyregistreraAgent
     */
    public NyregistreraAgent(InfDB idb) {
        initComponents();
        this.idb = idb;
        lblReg.setVisible(false);
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

        txtNamn = new javax.swing.JTextField();
        txtLosen = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtAnstDatum = new javax.swing.JTextField();
        btnRegistrera = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblReg = new javax.swing.JLabel();
        cboxOmrade = new javax.swing.JComboBox<>();
        cboxAdmin = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegistrera.setText("Registrera");
        btnRegistrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreraActionPerformed(evt);
            }
        });

        jLabel1.setText("Namn");

        jLabel2.setText("Lösenord");

        jLabel3.setText("Telefon");

        jLabel4.setText("Anställningsdatum");

        jLabel5.setText("Område");

        jLabel6.setText("Administratör");

        lblReg.setText("Agent har registrerats");

        cboxOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Svealand", "Götaland", "Norrland" }));

        cboxAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Ja", "Nej" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnRegistrera))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnstDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
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
                    .addComponent(txtAnstDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrera)
                    .addComponent(lblReg))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Kollar sista id som finns i tabellen och returnerar nästommande index
    private String getNextAgentId() {
        String nextId = "";
        try {
            nextId = idb.getAutoIncrement("agent", "Agent_ID");
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte att hämta Agent id");
        }
        return nextId;
    }

   
    private boolean kollaAgentNamnReadanFinns(String namn) {
        ArrayList<String> AgentNamn = null;
        boolean result = false;
        try {

            String fraga = "SELECT Namn FROM agent";
            AgentNamn = idb.fetchColumn(fraga);

        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte hämta namn från agent");

        }

        for (String n : AgentNamn) {
            if (n.equals(namn)) {
                result = true;
                JOptionPane.showMessageDialog(null, "Finns redan en Agent med det namnet");
            }
        }
        return result;
    }


    private void btnRegistreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistreraActionPerformed
        // TODO add your handling code here:
        String namn = txtNamn.getText();
        String losen = txtLosen.getText();
        String tel = txtTel.getText();
        String datum = txtAnstDatum.getText();
        String omrade = cboxOmrade.getSelectedItem().toString();
        String isAdmin = Validering.kollaIsAdmin(cboxAdmin.getSelectedItem().toString());
        Boolean isLikaNamn = kollaAgentNamnReadanFinns(namn);
        Boolean isLosenRattLangd = Validering.kollaLosenLangd(losen);

        //Behöver lägga till en koll så användaren har valt ett område 
        if (Validering.textFaltEjTomtRegEx(namn) && Validering.textFaltEjTomtRegEx(losen)
                && Validering.textFaltEjTomtRegEx(tel) && Validering.textFaltEjTomtRegEx(datum)
                && Validering.kollaCboxRegEx(omrade) && Validering.kollaCboxRegEx(isAdmin)
                && !isLikaNamn && isLosenRattLangd) {
            try {
                String omradeId = konv.getOmradeId(omrade);
                String nextId = getNextAgentId();

                String fraga = "INSERT INTO agent (Agent_ID, Namn, Telefon, Anstallningsdatum, "
                        + "Administrator, Losenord, Omrade) \n"
                        + "VALUES ( " + nextId + ", '" + namn + "', '" + tel + "', '" + datum
                        + "', '" + isAdmin + "'," + losen + ", " + omradeId + ")";
                idb.insert(fraga);

                txtNamn.setText("");
                txtLosen.setText("");
                txtTel.setText("");
                txtAnstDatum.setText("");

                lblReg.setVisible(true);
            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Något gick fel");
            }
        }
    }//GEN-LAST:event_btnRegistreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrera;
    private javax.swing.JComboBox<String> cboxAdmin;
    private javax.swing.JComboBox<String> cboxOmrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblReg;
    private javax.swing.JTextField txtAnstDatum;
    private javax.swing.JTextField txtLosen;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
