
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfException;
import oru.inf.InfDB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author miche, aaau, cAppelina
 */
public class NyregistreraAlien extends javax.swing.JFrame {

    private InfDB idb;
    //Klassen består av ett antal metoder som konverterar olika namn och benämningar till dess primärnyckel (id)
    private HjalpDbFunktioner konv;
    // Funktion för att ändra ras
    private RasFunktioner fuAndraRas;

    /**
     * Creates new form NygeristreraAlien
     */
    public NyregistreraAlien(InfDB idb) {
        initComponents();
        this.idb = idb;
        lblAlienId.setText(getNextAlienId());
        lblReg.setVisible(false);
        konv = new HjalpDbFunktioner(idb);
        fuAndraRas = new RasFunktioner(idb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLosen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblAlienId = new javax.swing.JLabel();
        lblReg = new javax.swing.JLabel();
        cboxPlats = new javax.swing.JComboBox<>();
        cboxAnsvarigAgent = new javax.swing.JComboBox<>();
        cboxRas = new javax.swing.JComboBox<>();
        txtRasAttribut = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblRasAttribut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Namn");

        jLabel2.setText("Lösenord");

        jLabel3.setText("Telefon");

        jLabel4.setText("Datum");

        jLabel5.setText("Plats");

        jLabel6.setText("Ansvarig Agent");

        jButton1.setText("Registrera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Alien Id");

        lblAlienId.setText("jLabel8");

        lblReg.setText("Alien är registrerad");

        cboxPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Örebro", "Västerås", "Vilhelmina", "Borås" }));

        cboxAnsvarigAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Agent O", "Agent K", "Agent J", "Agent Z" }));

        cboxRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Boglodite", "Squid", "Worm" }));
        cboxRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRasActionPerformed(evt);
            }
        });

        jLabel8.setText("Ras");

        lblRasAttribut.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboxRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboxAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAlienId)
                                    .addComponent(cboxPlats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDatum)
                                    .addComponent(txtTel)
                                    .addComponent(txtLosen)
                                    .addComponent(txtNamn))))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblReg, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(txtRasAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRasAttribut))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblAlienId))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboxPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lblRasAttribut))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(lblReg))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRasAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Kollar sista id som finns i tabellen och returnerar nästommande index
    private String getNextAlienId() {
        String nextId = "";
        try {
            nextId = idb.getAutoIncrement("alien", "Alien_ID");
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte att hämta Alien id");
        }
        return nextId;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String namn = txtNamn.getText();
        String losen = txtLosen.getText();
        String tel = txtTel.getText();
        String datum = txtDatum.getText();
        String plats = cboxPlats.getSelectedItem().toString();
        String ansvarigAgent = cboxAnsvarigAgent.getSelectedItem().toString();
        String ras = cboxRas.getSelectedItem().toString();
        String rasAttribut = txtRasAttribut.getText();
        Boolean isLikaNamn = kollaAlienNamnReadanFinns(namn);
        Boolean isLosenRattLangd = Validering.kollaLosenLangd(losen);

        if (Validering.textFaltEjTomtRegEx(namn) && Validering.textFaltEjTomtRegEx(losen)
                && Validering.textFaltEjTomtRegEx(tel) && Validering.textFaltEjTomtRegEx(datum)
                && Validering.kollaCboxRegEx(plats) && Validering.kollaCboxRegEx(ansvarigAgent)
                && Validering.kollaCboxRegEx(ras) && Validering.textFaltEjTomtRegEx(rasAttribut)
                && !isLikaNamn && isLosenRattLangd) {
            try {
                String platsId = konv.getPlatsId(plats);
                String ansvarigAgentId = konv.getAgentId(ansvarigAgent);
                String nextId = getNextAlienId();
                //Lägg till ny ras
                fuAndraRas.andraRas(nextId, ras, rasAttribut);

                String fraga = "INSERT INTO alien (Alien_ID, Registreringsdatum, Losenord, "
                        + "Namn, Telefon, Plats, Ansvarig_Agent) \n"
                        + "VALUES ( " + nextId + ", '" + datum + "', '" + losen + "', '" + namn
                        + "', '" + tel + "'," + platsId + ", " + ansvarigAgentId + ")";
                idb.insert(fraga);

                txtNamn.setText("");
                txtLosen.setText("");
                txtTel.setText("");
                txtDatum.setText("");

                lblReg.setVisible(true);
            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Något gick fel");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboxRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRasActionPerformed
        // TODO add your handling code here:
        String ras = cboxRas.getSelectedItem().toString();

        if (ras.equalsIgnoreCase("boglodite")) {
            lblRasAttribut.setText("Antal Boogies");
            lblRasAttribut.setVisible(true);
            txtRasAttribut.setVisible(true);

        } else if (ras.equalsIgnoreCase("squid")) {
            lblRasAttribut.setText("Antal Armar");
            lblRasAttribut.setVisible(true);
            txtRasAttribut.setVisible(true);
        } else if (ras.equalsIgnoreCase("worm")) {
            txtRasAttribut.setText("1");
            lblRasAttribut.setVisible(false);
            txtRasAttribut.setVisible(false);
        }
    }//GEN-LAST:event_cboxRasActionPerformed

     private boolean kollaAlienNamnReadanFinns(String namn) {
        ArrayList<String> alienNamn = null;
        boolean result = false;
        try {

            String fraga = "SELECT Namn FROM alien";
            alienNamn = idb.fetchColumn(fraga);

        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte hämta namn från alien");

        }

        for (String n : alienNamn) {
            if (n.equals(namn)) {
                result = true;
                JOptionPane.showMessageDialog(null, "Finns redan en Alien med det namnet");
            }
        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxAnsvarigAgent;
    private javax.swing.JComboBox<String> cboxPlats;
    private javax.swing.JComboBox<String> cboxRas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAlienId;
    private javax.swing.JLabel lblRasAttribut;
    private javax.swing.JLabel lblReg;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtLosen;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtRasAttribut;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
