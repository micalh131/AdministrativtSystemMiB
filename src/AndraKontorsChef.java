
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
 @author miche, aaau, cAppelina
 * Klassen skapades efter att åsa tittade på en film. 
 * Klassen ser vilka Aliens som befinner sig på en angiven plats.
 * Konstruktorn fyller på en combobox som används i metoden 'fyllValjPlatsNamn'
 * som hämtar platser från databasen.
 */
public class AndraKontorsChef extends javax.swing.JFrame {
    private InfDB idb;

    /**
     * Creates new form AliensPlats
     */
    public AndraKontorsChef(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjKontor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboKontor = new javax.swing.JComboBox<>();
        scpAliens = new javax.swing.JScrollPane();
        txtAreaVisaInfo = new javax.swing.JTextArea();
        lblNuvarandeChef = new javax.swing.JLabel();
        txtNuChefInfo = new javax.swing.JTextField();
        lblNyChef = new javax.swing.JLabel();
        CboxNyChefLista = new javax.swing.JComboBox<>();
        Spara = new javax.swing.JButton();
        lblRubrik = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboKontor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));
        cboKontor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKontorActionPerformed(evt);
            }
        });

        txtAreaVisaInfo.setColumns(20);
        txtAreaVisaInfo.setRows(5);
        scpAliens.setViewportView(txtAreaVisaInfo);

        lblNuvarandeChef.setText("Nuvarande chef");
        lblNuvarandeChef.setToolTipText("");

        txtNuChefInfo.setColumns(6);
        txtNuChefInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuChefInfoActionPerformed(evt);
            }
        });

        lblNyChef.setText("Välj en ny chef i listan");

        CboxNyChefLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        Spara.setText("Spara");

        lblRubrik.setText("Ändra kontorschef ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scpAliens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cboKontor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblNuvarandeChef, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)
                                    .addComponent(txtNuChefInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblRubrik)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(lblNyChef)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CboxNyChefLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(Spara)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblRubrik)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboKontor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNuvarandeChef)
                    .addComponent(txtNuChefInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scpAliens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNyChef)
                    .addComponent(CboxNyChefLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Spara)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Metoden visar vilken alien som finns på den valda platsen (Beroende på vilken 
    plats som valts i fyllValjPlats) och finns ingen alien så får man ett felmeddelande.
    */
    private void cboKontorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKontorActionPerformed
      
    }//GEN-LAST:event_cboKontorActionPerformed

    private void txtNuChefInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuChefInfoActionPerformed
         txtNuChefInfo.setText("");

        ArrayList<HashMap<String, String>> soktaChefer; 

        try {
            String valtKontor = cboKontor.getSelectedItem().toString();
            String fraga = "SELECT Namn FROM agent JOIN kontorschef ON kontorschef.`Agent_ID`=agent.`Agent_ID`WHERE kontorschef.`Kontorsbeteckning`= '" + valtKontor + "'";
            // "='"+var+"'"
            soktaChefer = idb.fetchRows(fraga);
            // txtAreaVisaInfo.append("Nåning");
            System.out.println(valtKontor);
            if (soktaChefer.size() < 1) {
                txtNuChefInfo.setText("Det finns ingen chef på detta kontor");
            }
            for (HashMap<String, String> chefer : soktaChefer) {
                txtNuChefInfo.setText(chefer.get("Namn"));
                //txtAreaVisaInfo.append("Alien_ID");
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");

        }
    }//GEN-LAST:event_txtNuChefInfoActionPerformed
    /*
    Hämtar information från db om alla platser som finns.
    */
    private void fyllValjKontor(){
        String fraga = "SELECT Kontorsbeteckning FROM kontorschef";

        ArrayList<String> allaKontor;

        try {
            allaKontor = idb.fetchColumn(fraga);

            for (String ettKontor : allaKontor) {
                cboKontor.addItem(ettKontor);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboxNyChefLista;
    private javax.swing.JButton Spara;
    private javax.swing.JComboBox<String> cboKontor;
    private javax.swing.JLabel lblNuvarandeChef;
    private javax.swing.JLabel lblNyChef;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JScrollPane scpAliens;
    private javax.swing.JTextArea txtAreaVisaInfo;
    private javax.swing.JTextField txtNuChefInfo;
    // End of variables declaration//GEN-END:variables
}