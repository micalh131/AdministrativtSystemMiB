
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
 * @author miche, aaau, cAppelina
 */
public class SokEnskildAlien extends javax.swing.JFrame {
    
    private InfDB idb;

    /**
     * Skapar ny SokEnskildAlien
     */
    public SokEnskildAlien(InfDB idb) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAlienInfo = new javax.swing.JTextArea();
        txtNamnSok = new javax.swing.JTextField();
        btnSok = new javax.swing.JButton();
        lblNamn = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        lblRubrik = new javax.swing.JLabel();

        txtaAlienInfo.setColumns(35);
        txtaAlienInfo.setRows(5);
        jScrollPane1.setViewportView(txtaAlienInfo);

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        lblNamn.setText("Skriv in Aliens namn");

        lblInfo.setText("Information:");

        lblRubrik.setText("Sök information om en alien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRubrik)
                            .addComponent(lblInfo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSok)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNamn)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblRubrik)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamnSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamn))
                .addGap(18, 18, 18)
                .addComponent(btnSok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Hämtar värden om en alien och lägger till dem i textrutan
    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        txtaAlienInfo.setText("");
        String soktNamn = txtNamnSok.getText();
        ArrayList<HashMap<String, String>> soktaNamn;
        
        if (Validering.textFaltEjTomtRegEx(soktNamn)) {
            try {
                
                String fraga = "SELECT alien.Alien_ID, alien.Namn, alien.Telefon, alien.Registreringsdatum, plats.Benamning, agent.Namn FROM alien\n"
                        + "    JOIN plats ON alien.Plats=plats.Plats_ID\n"
                        + "        JOIN agent ON alien.Ansvarig_Agent=agent.Agent_ID\n"
                        + "            WHERE alien.Namn= '" + soktNamn + "'";
                
                soktaNamn = idb.fetchRows(fraga);
                
                 
                
                txtaAlienInfo.append("AlienID" + "\t" + "telefonnr" + "\t" + "Registrerad" + "\t"
                   + "Plats" + "\t" + "Ansvarig Agent" + "\n");
                if (soktaNamn.size() < 1) {
                    txtaAlienInfo.setText("Det finns ingen alien med detta namn, försök igen!");
                }
                for (HashMap<String, String> ettNamn : soktaNamn) {
                    txtaAlienInfo.append(ettNamn.get("Alien_ID") + "\t" 
                            + ettNamn.get("Telefon") + "\t" +ettNamn.get("Registreringsdatum") + "\t" +
                            ettNamn.get("Benamning") + "\t" + ettNamn.get("Namn"));
                }
                   
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Kunde inte nå databasen");
            }
        }
    }//GEN-LAST:event_btnSokActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTextField txtNamnSok;
    private javax.swing.JTextArea txtaAlienInfo;
    // End of variables declaration//GEN-END:variables
}
