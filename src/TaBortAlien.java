
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
public class TaBortAlien extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Skapar ny TaBortAlien
     */
    public TaBortAlien(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllValjAlienNamn();
        lblTaBort.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboxValAlien = new javax.swing.JComboBox<>();
        btnTaBort = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTaBort = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboxValAlien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        btnTaBort.setText("Ta bort");
        btnTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("Välj Alien att ta bort");

        lblTaBort.setText("Alien har tagits bort");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxValAlien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTaBort)
                        .addGap(18, 18, 18)
                        .addComponent(lblTaBort, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboxValAlien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaBort)
                    .addComponent(lblTaBort))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Tar bort vald alien ur databasen i samtliga tabeller
    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed

        String namn = cboxValAlien.getSelectedItem().toString();
        if (Validering.kollaTaBort(namn)) {
            try {
                String fraga = "DELETE FROM alien WHERE Namn = '" + namn + "'";
                idb.delete(fraga);

                lblTaBort.setVisible(true);
                lblTaBort.setText(namn + "är borttagen ur systemet");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Gick inte att ta bort");
            }
        }
    }//GEN-LAST:event_btnTaBortActionPerformed

    //Fyller combobox med alla alien från databasen
    private void fyllValjAlienNamn() {
        String fraga = "SELECT Namn FROM alien";

        ArrayList<String> allaAliens;

        try {
            allaAliens = idb.fetchColumn(fraga);

            for (String namn : allaAliens) {
                cboxValAlien.addItem(namn);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Gick inte att ladda Aliens");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaBort;
    private javax.swing.JComboBox<String> cboxValAlien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTaBort;
    // End of variables declaration//GEN-END:variables
}
