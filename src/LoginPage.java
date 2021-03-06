
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
 * Inloggningssida för alla användare (Alien,
 * Agent och Admin). Konstruktorn tar in InfDB idb som parameter för att skapa
 * koppling till databasen och sparar det i fältet Infdb idb.
 *
 */
public class LoginPage extends javax.swing.JFrame {

    private InfDB idb;
    private HjalpDbFunktioner konv;

    /**
     * Creates new form LoginPage
     */
    public LoginPage(InfDB idb) {

        initComponents();
        this.idb = idb;
        konv = new HjalpDbFunktioner(idb);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginImg = new javax.swing.JLabel();
        loginTitle = new javax.swing.JLabel();
        loginSelectUser = new javax.swing.JComboBox<>();
        loginUsername = new javax.swing.JTextField();
        loginPassword = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        lblHjalptext2 = new javax.swing.JLabel();
        lblHjalptext1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        loginImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MiB LoginPage.jpeg"))); // NOI18N

        loginTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginTitle.setText("Inloggning");

        loginSelectUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Agent", "Alien" }));

        loginButton.setText("Logga in");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        lblHjalptext2.setText("Lösenord");

        lblHjalptext1.setText("Användarnamn (ditt ID)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(loginImg)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginSelectUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton)
                    .addComponent(loginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHjalptext2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHjalptext1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(loginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(loginSelectUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHjalptext1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHjalptext2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(loginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* hämtar in värdet användaren skriver in, och även vilken typ av användare det är.
    i 'try' vill vi kolla om det inmatade användarnamnet och lösenordet finns i databasen.
    om det matchar sker inloggning. Om inloggning misslyckas går 'catch' in och meddelar
    användaren att inloggningen misslyckades och varför. 
    Valideringsklassen används för att hantera om fältet är tomt och läggs som en wrap runt
    'try catch-koden'.
     */
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String userName = loginUsername.getText();
        String password = loginPassword.getText();
        String valdUser = loginSelectUser.getSelectedItem().toString();

        if (Validering.textFaltEjTomtRegEx(userName) && (Validering.textFaltEjTomtRegEx(password))
                && Validering.kollaCboxRegEx(valdUser)) {

            try {
                if (valdUser.equalsIgnoreCase("Agent")) {

                    String fragaUserName = "SELECT Agent_ID FROM agent WHERE Agent_ID=" + userName;
                    String fragaPassword = "SELECT Losenord FROM agent WHERE Agent_ID=" + userName;
                    String fragaIsAdmin = "SELECT Administrator FROM agent WHERE Agent_ID=" + userName;
                    String svarIsAdmin = idb.fetchSingle(fragaIsAdmin);
                    String svarUserName = idb.fetchSingle(fragaUserName);
                    String svarPassword = idb.fetchSingle(fragaPassword);

                    if (userName.equals(svarUserName) && Validering.kollaLosen(svarPassword, password)) {
                        new AgentPage(idb, userName, valdUser, password, svarIsAdmin).setVisible(true);
                    }
                } else if (valdUser.equalsIgnoreCase("Alien")) {
                    String fragaUserName = "SELECT Alien_ID FROM alien WHERE Alien_ID=" + userName;
                    String fragaPassword = "SELECT Losenord FROM alien WHERE Alien_ID=" + userName;
                    String fragaPlats = "SELECT plats FROM alien WHERE Alien_ID=" + userName;
                    String svarPlats = idb.fetchSingle(fragaPlats);
                    String svarUserName = idb.fetchSingle(fragaUserName);
                    String svarPassword = idb.fetchSingle(fragaPassword);

                    if (userName.equals(svarUserName) && Validering.kollaLosen(svarPassword, password)) {
                        new AlienPage(idb, svarPlats, userName, valdUser, password).setVisible(true);
                    }
                }

            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Du har skrivit in fel användaruppgifter, försök igen");
            }
        }

    }//GEN-LAST:event_loginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHjalptext1;
    private javax.swing.JLabel lblHjalptext2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginImg;
    private javax.swing.JTextField loginPassword;
    private javax.swing.JComboBox<String> loginSelectUser;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JTextField loginUsername;
    // End of variables declaration//GEN-END:variables
}
