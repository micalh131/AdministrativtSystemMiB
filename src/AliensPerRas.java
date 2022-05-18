
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
public class AliensPerRas extends javax.swing.JFrame {
    private InfDB idb;

    /**
     * Creates new form AliensPerRas
     */
    public AliensPerRas(InfDB idb) {
        initComponents();
        this.idb= idb;
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
        cboxRaser = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAlienLista = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrik.setText("Aliens per ras");

        cboxRaser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Squid", "Worm", "Boglodite" }));
        cboxRaser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRaserActionPerformed(evt);
            }
        });

        txtaAlienLista.setColumns(20);
        txtaAlienLista.setRows(5);
        jScrollPane1.setViewportView(txtaAlienLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cboxRaser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRubrik)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblRubrik)
                .addGap(56, 56, 56)
                .addComponent(cboxRaser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxRaserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRaserActionPerformed
        // TODO add your handling code here:

        txtaAlienLista.setText("");
        ArrayList<HashMap<String, String>> soktaAliens;
        String valdRas = cboxRaser.getSelectedItem().toString();
        try {

            if (valdRas.equals("Squid")) {

                String fragaSquid = "SELECT squid.Alien_ID, alien.Namn FROM squid JOIN alien ON alien.`Alien_ID`= squid.`Alien_ID`";
                soktaAliens = idb.fetchRows(fragaSquid);
                //System.out.println("squidAlien" );
                for (HashMap<String, String> enAlien : soktaAliens) {
                    txtaAlienLista.append(enAlien.get("Alien_ID") + "\t" + enAlien.get("Namn") + "\n");
                    return;
                }
            }
                
              if (valdRas.equals("Worm"))
                      {

                String fragaWorm = "SELECT worm.Alien_ID, alien.Namn FROM worm JOIN alien ON alien.`Alien_ID`= worm.`Alien_ID`";
                soktaAliens = idb.fetchRows(fragaWorm);
               
                for (HashMap<String, String> enAlien : soktaAliens) {
                    txtaAlienLista.append(enAlien.get("Alien_ID") + "\t" + enAlien.get("Namn") + "\n");
                    return;
                }
            }
              if (valdRas.equals("Boglodite"))
                      {

                String fragaBoglodite = "SELECT boglodite.Alien_ID, alien.Namn FROM boglodite JOIN alien ON alien.`Alien_ID`= boglodite.`Alien_ID`";
                soktaAliens = idb.fetchRows(fragaBoglodite);
               
                for (HashMap<String, String> enAlien : soktaAliens) {
                    txtaAlienLista.append(enAlien.get("Alien_ID") + "\t" + enAlien.get("Namn") + "\n");
                    return;
                }
            }

        
    }//GEN-LAST:event_cboxRaserActionPerformed
       
   catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");

        }          
    }
        
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxRaser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTextArea txtaAlienLista;
    // End of variables declaration//GEN-END:variables
}