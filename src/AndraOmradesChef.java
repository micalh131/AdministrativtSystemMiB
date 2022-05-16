
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author carolinaappel
 */
public class AndraOmradesChef extends javax.swing.JFrame {
    private InfDB idb;
    private String agentID;
    /**
     * Creates new form AndraOmrådesChef
     */
    public AndraOmradesChef(InfDB idb) {
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

        txtSokOmrade = new javax.swing.JTextField();
        btnSok = new javax.swing.JButton();
        lblNuvarandeOmradeschef = new javax.swing.JLabel();
        lblRubrik = new javax.swing.JLabel();
        btnAndraChef = new javax.swing.JButton();
        lblNyOmradeschef = new javax.swing.JLabel();
        txtNyOmradeschef = new javax.swing.JTextField();
        lblOmradeschefAndrad = new javax.swing.JLabel();
        lblRubrikOmradesChef = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSokOmrade.setColumns(8);

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        lblNuvarandeOmradeschef.setText("lblNuvarandeOmradesChef");

        lblRubrik.setText("Skriv in område i sökfältet");

        btnAndraChef.setText("Ändra områdeschef");
        btnAndraChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraChefActionPerformed(evt);
            }
        });

        lblNyOmradeschef.setText("Skriv in ny Områdeschef");

        txtNyOmradeschef.setColumns(8);

        lblOmradeschefAndrad.setText("lblOmradeschefAndrad");

        lblRubrikOmradesChef.setText("Nuvarande Omradeschef:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNyOmradeschef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRubrik)
                    .addComponent(txtSokOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNyOmradeschef)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAndraChef)
                            .addComponent(lblRubrikOmradesChef)
                            .addComponent(btnSok))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNuvarandeOmradeschef)
                            .addComponent(lblOmradeschefAndrad))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSokOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSok)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNuvarandeOmradeschef)
                    .addComponent(lblRubrikOmradesChef))
                .addGap(13, 13, 13)
                .addComponent(lblNyOmradeschef)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNyOmradeschef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAndraChef)
                    .addComponent(lblOmradeschefAndrad))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        try{
            String soktOmrade = txtSokOmrade.getText();
            String fraga = "SELECT agent.Namn FROM agent \n"
                    + "    JOIN omradeschef ON omradeschef.Agent_ID = agent.Agent_ID\n"
                    + "        JOIN omrade ON omrade.Omrades_ID=omradeschef.Agent_ID\n"
                    + "            WHERE omrade.Benamning= '" + soktOmrade + "'";
            
            
            String svar = idb.fetchSingle(fraga);
            lblNuvarandeOmradeschef.setText(svar);
            System.out.println(svar);
            this.agentID = faUtAgentID(svar);
            
            
            if(svar == null) {
                System.out.println("Agent hittades inte");
                JOptionPane.showMessageDialog(null, "Agent hittades inte, skriv in rätt Agentnamn"); 
            }
            
        }
        catch(InfException e){
            System.out.println("Något gick fel");
            JOptionPane.showMessageDialog(null, "Något gick fel");  
        }
    }//GEN-LAST:event_btnSokActionPerformed

    private String faUtAgentID(String agentNamn){
        String idAgent ="";
        try{
           
            String fraga = "SELECT Agent_ID FROM Agent WHERE Namn = '"+ agentNamn + "'";
            idAgent = idb.fetchSingle(fraga);
            
        }
        catch(InfException e){
            JOptionPane.showMessageDialog(null, "Nått gick fel");
        }
      return idAgent;
    
    }
    
    
    private void btnAndraChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraChefActionPerformed
        
        String nyOmradeschef = txtNyOmradeschef.getText();
        
        String fragaAgentID = "SELECT Agent_ID FROM Agent WHERE Namn = '"+ nyOmradeschef + "'";
       System.out.println(fragaAgentID);
        try {
            
            String agentIDnyOmradeschef = idb.fetchSingle(fragaAgentID);
             System.out.println(agentID + agentIDnyOmradeschef);
            String fraga = "UPDATE Omradeschef SET Agent_ID = " + agentIDnyOmradeschef + " WHERE agent_ID = " + agentID + "";
            idb.update(fraga);
            System.out.println("funkar");
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
        //System.out.println(fraga);
        
    }//GEN-LAST:event_btnAndraChefActionPerformed

    
    
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraChef;
    private javax.swing.JButton btnSok;
    private javax.swing.JLabel lblNuvarandeOmradeschef;
    private javax.swing.JLabel lblNyOmradeschef;
    private javax.swing.JLabel lblOmradeschefAndrad;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblRubrikOmradesChef;
    private javax.swing.JTextField txtNyOmradeschef;
    private javax.swing.JTextField txtSokOmrade;
    // End of variables declaration//GEN-END:variables
}
