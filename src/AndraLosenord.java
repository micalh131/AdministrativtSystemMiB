
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
public class AndraLosenord extends javax.swing.JFrame {
    private InfDB idb;
    private String userName;
    private String valdUser;
    /**
     * Creates new form AndraLosenord
     */
    public AndraLosenord(InfDB idb, String userName, String valdUser) {
        initComponents();
        lblLosenIsUpdated.setVisible(false);
        this.idb = idb;
        this.userName = userName;
        this.valdUser = valdUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNuvarandeLosen = new javax.swing.JTextField();
        txtNyttLosen = new javax.swing.JTextField();
        lblNyttLosen = new javax.swing.JLabel();
        lblNuvarandeLosen = new javax.swing.JLabel();
        btnChagePassword = new javax.swing.JButton();
        lblLosenIsUpdated = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNyttLosen.setText("Skriv in nytt lösenord");

        lblNuvarandeLosen.setText("Skriv in nuvarande lösenord");

        btnChagePassword.setText("Byt lösenord");
        btnChagePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChagePasswordActionPerformed(evt);
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
                        .addComponent(btnChagePassword)
                        .addGap(46, 46, 46)
                        .addComponent(lblLosenIsUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNuvarandeLosen)
                    .addComponent(lblNyttLosen)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNyttLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNuvarandeLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
                    .addComponent(btnChagePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChagePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChagePasswordActionPerformed
        // TODO add your handling code here:
        String nyttLosenord = txtNyttLosen.getText();
        String fragaUpdateLosenord = "UPDATE " + valdUser + " SET Losenord = '" + nyttLosenord +"' WHERE Alien_ID =" + userName;
        try{
            idb.update(fragaUpdateLosenord);
            txtNyttLosen.setText("");
            lblLosenIsUpdated.setVisible(true);
        }
        catch(InfException e){
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
    }//GEN-LAST:event_btnChagePasswordActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChagePassword;
    private javax.swing.JLabel lblLosenIsUpdated;
    private javax.swing.JLabel lblNuvarandeLosen;
    private javax.swing.JLabel lblNyttLosen;
    private javax.swing.JTextField txtNuvarandeLosen;
    private javax.swing.JTextField txtNyttLosen;
    // End of variables declaration//GEN-END:variables
}