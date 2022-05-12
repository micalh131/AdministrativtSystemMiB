/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author carolinaappel
 */
public class AlienDatabasSokningar extends javax.swing.JFrame {

    /**
     * Creates new form AlienDatabasSokningar
     */
    public AlienDatabasSokningar() {
        initComponents();
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
        btnAndraAlienInfo = new javax.swing.JButton();
        btnListaAlienPlats = new javax.swing.JButton();
        btnListaAlienRas = new javax.swing.JButton();
        btnListaAlienReg = new javax.swing.JButton();
        btnSokEnskildAlien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("Sökningar på Aliens");

        btnAndraAlienInfo.setText("Ändra Information om Alien");

        btnListaAlienPlats.setText("Lista Aliens på plats");

        btnListaAlienRas.setText("Lista Aliens på ras");

        btnListaAlienReg.setText("Lista Alien registrerade MELLAN TVÅ datum");

        btnSokEnskildAlien.setText("Sökning på enskild Alien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListaAlienReg)
                    .addComponent(btnAndraAlienInfo)
                    .addComponent(btnListaAlienRas)
                    .addComponent(btnListaAlienPlats)
                    .addComponent(btnSokEnskildAlien)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSokEnskildAlien)
                .addGap(18, 18, 18)
                .addComponent(btnListaAlienPlats)
                .addGap(18, 18, 18)
                .addComponent(btnListaAlienRas)
                .addGap(18, 18, 18)
                .addComponent(btnAndraAlienInfo)
                .addGap(18, 18, 18)
                .addComponent(btnListaAlienReg)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlienDatabasSokningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlienDatabasSokningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlienDatabasSokningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlienDatabasSokningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlienDatabasSokningar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraAlienInfo;
    private javax.swing.JButton btnListaAlienPlats;
    private javax.swing.JButton btnListaAlienRas;
    private javax.swing.JButton btnListaAlienReg;
    private javax.swing.JButton btnSokEnskildAlien;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
