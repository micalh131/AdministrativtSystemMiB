
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
 * @author miche
 */
public class VisaAgentInfo extends javax.swing.JFrame {

    private InfDB idb;
    private String alienPlats;

    /**
     * Creates new form VisaAgentInfo
     */
    public VisaAgentInfo(InfDB idb, String alienPlats) {
        initComponents();
        this.idb = idb;
        this.alienPlats = alienPlats;
        visaInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAgentInformation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAgentInformation.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblAgentInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(lblAgentInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void visaInfo() {
        //String id = cmbValjAgent.getItemAt(1);
        try {
            //String fraga = "SELECT Agent_ID, Namn, Telefon, Anstallningsdatum FROM Agent WHERE Omrade = 1";
            String fraga = "SELECT agent.Agent_ID, Namn, Telefon FROM agent \n"
                    + "JOIN omradeschef ON omradeschef.`Agent_ID` = agent.`Agent_ID`\n"
                    + "JOIN omrade ON omradeschef.`Agent_ID` = omrade.`Omrades_ID`\n"
                    + "JOIN plats ON omrade.`Omrades_ID` = plats.`Plats_ID` WHERE Plats_ID =" + alienPlats;
            HashMap<String, String> svar = idb.fetchRow(fraga);
            String namn = svar.get("Namn");
            String telefon = svar.get("Telefon");

            System.out.println(namn + telefon);

            lblAgentInformation.setText(" " + namn + " " + telefon);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAgentInformation;
    // End of variables declaration//GEN-END:variables
}