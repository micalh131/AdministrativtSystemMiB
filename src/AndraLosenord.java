
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 * @author miche, aaau, cAppelina 
 * Klassen hanterar byte av lösenord och anropas
 * av metoder i andra klasser/användare. Databasuppkoppling sker, fält lagrar
 * värden som ska användas i metoderna för att frågorna vi ställer till
 * databasen utgår från vilken användare som försöker ändra lösenord.
 *
 */
public class AndraLosenord extends javax.swing.JFrame {

    private InfDB idb;
    private String userName;
    private String password;
    private String valdUser;

    /**
     * Creates new form AndraLosenord
     */
    public AndraLosenord(InfDB idb, String userName, String valdUser, String password) {
        initComponents();
        lblLosenIsUpdated.setVisible(false);
        this.idb = idb;
        this.userName = userName;
        this.password = password;
        this.valdUser = valdUser;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNuvarandeLosen = new javax.swing.JTextField();
        txtNyttLosen = new javax.swing.JTextField();
        lblNyttLosen = new javax.swing.JLabel();
        lblNuvarandeLosen = new javax.swing.JLabel();
        btnBytLosen = new javax.swing.JButton();
        lblLosenIsUpdated = new javax.swing.JLabel();

        lblNyttLosen.setText("Skriv in nytt lösenord");

        lblNuvarandeLosen.setText("Skriv in nuvarande lösenord");

        btnBytLosen.setText("Byt lösenord");
        btnBytLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytLosenActionPerformed(evt);
            }
        });

        lblLosenIsUpdated.setText("Ditt lösenord har ändrats");
        lblLosenIsUpdated.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBytLosen)
                        .addGap(46, 46, 46)
                        .addComponent(lblLosenIsUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNuvarandeLosen)
                    .addComponent(lblNyttLosen)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNyttLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNuvarandeLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblNuvarandeLosen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNuvarandeLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblNyttLosen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNyttLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLosenIsUpdated, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBytLosen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* 
    metoden hämtar det nya lösenordet som användaren skriver in och försöker i en try catch 
    uppdatera lösenordet till det nya. 
    Om lösenordet byts blir textrutan tom och en label visas att du bytt lösenord.
     */
    private void btnBytLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBytLosenActionPerformed

        String nyttLosen = txtNyttLosen.getText();
        String nuvarandeLosen = txtNuvarandeLosen.getText();

        if (Validering.textFaltEjTomtRegEx(nyttLosen) && Validering.textFaltEjTomtRegEx(nuvarandeLosen) && Validering.kollaLosenLangd(nyttLosen)) {

            if (Validering.kollaLosen(password, nuvarandeLosen)) {
                String valtID = kollaValdUser(valdUser);
                String fragaUpdateLosenord = "UPDATE " + valdUser + " SET Losenord = '" + nyttLosen + "' WHERE "
                        + valtID + " =" + userName;
                try {
                    idb.update(fragaUpdateLosenord);
                    txtNyttLosen.setText("");
                    txtNuvarandeLosen.setText("");
                    lblLosenIsUpdated.setVisible(true);
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
                    System.out.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnBytLosenActionPerformed

    private String kollaValdUser(String valdUser) {
        if (valdUser.equalsIgnoreCase("agent")) {
            return "Agent_ID";
        } else {
            return "Alien_ID";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBytLosen;
    private javax.swing.JLabel lblLosenIsUpdated;
    private javax.swing.JLabel lblNuvarandeLosen;
    private javax.swing.JLabel lblNyttLosen;
    private javax.swing.JTextField txtNuvarandeLosen;
    private javax.swing.JTextField txtNyttLosen;
    // End of variables declaration//GEN-END:variables
}
