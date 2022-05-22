
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miche
 * carolina kommenterar
 * åsa har också kommenterat :)
 * 
 * Databasen InfDB är en klass skapad av ORU och här skapar vi databaskopplingen
 * 
 */
public class Start {
    /**
     * @param args the command line arguments
     * main metod som loggar in på databasen/upprättar kopplingen till databasen
     */
    private static InfDB idb;
    
    public static void main(String args[]) {
        try {
            idb = new InfDB("mibdb", "3306", "mibdba","mibkey");
            System.out.println("Koppling fungerade");
        
        } catch(InfException ex){
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form
        initialiserar klassen LoginPage (fönster med logginsida öppnas) 
        skickar med parametern idb
        */

         new LoginPage(idb).setVisible(true);

           new AndraInfoAgent(idb).setVisible(true);



    }
}
