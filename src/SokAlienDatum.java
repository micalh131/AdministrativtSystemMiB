
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
 * @author aaau
 */
public class SokAlienDatum extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Skapar ny SokAlienDatum
     */
    public SokAlienDatum(InfDB idb) {
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

        lblRubrik = new javax.swing.JLabel();
        lblRubrikFranDatum = new javax.swing.JLabel();
        lblRubrikTillDatum1 = new javax.swing.JLabel();
        btnSok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAliens = new javax.swing.JTextArea();
        txtfFranDatum = new javax.swing.JTextField();
        txtfTillDatum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrik.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblRubrik.setText("Registrerade alien mellan vissa datum");

        lblRubrikFranDatum.setText("Skriv in sökdatum från (yyyy-mm-dd)");

        lblRubrikTillDatum1.setText("Skriv in sökdatum till (yyyy-mm-dd)");

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        txtaAliens.setColumns(20);
        txtaAliens.setRows(5);
        jScrollPane1.setViewportView(txtaAliens);

        txtfFranDatum.setColumns(6);

        txtfTillDatum.setColumns(6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRubrikFranDatum)
                            .addComponent(lblRubrikTillDatum1)
                            .addComponent(lblRubrik))

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ftxtfFranDatum)
                            .addComponent(ftxtfTillDatum))
                        .addGap(17, 17, 17))))

                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfTillDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfFranDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSok)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblRubrik)

                .addGap(18, 18, 18)

                .addGap(31, 31, 31)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRubrikFranDatum)
                    .addComponent(txtfTillDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRubrikTillDatum1)
                    .addComponent(txtfFranDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnSok)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Får in två olika datum och söker fram alla aliens som är registrerade mellan dessa 
    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed

        txtaAliens.setText("");
        String soktFranDatum = txtfFranDatum.getText();
        String soktTillDatum = txtfTillDatum.getText();

        ArrayList<HashMap<String, String>> soktaAliens;
        if (Validering.valideraDatum(soktFranDatum) && Validering.valideraDatum(soktTillDatum)) {
            try {

                String fraga = "SELECT Alien_ID, Namn FROM alien \n"
                        + "WHERE Registreringsdatum BETWEEN '" + soktFranDatum + "'AND'" + soktTillDatum + "'";

                soktaAliens = idb.fetchRows(fraga);
                txtaAliens.append("Alien_ID" + "\t" + "Namn" + "\n");
                for (HashMap<String, String> enAlien : soktaAliens) {
                    txtaAliens.append(enAlien.get("Alien_ID") + "\t" + enAlien.get("Namn") + "\n");
                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något gick fel");

            }

        }
    }//GEN-LAST:event_btnSokActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblRubrikFranDatum;
    private javax.swing.JLabel lblRubrikTillDatum1;
    private javax.swing.JTextArea txtaAliens;
    private javax.swing.JTextField txtfFranDatum;
    private javax.swing.JTextField txtfTillDatum;
    // End of variables declaration//GEN-END:variables
}
