
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author miche, aaau, cAppelina
 */

/*
    Klassen innehåller metoder som gör om namn till id
    Många klasser behöver använda dessa metoder innan de skickar fråga till databasen
 */
public class HjalpDbFunktioner {

    private InfDB idb;

    public HjalpDbFunktioner(InfDB idb) {
        this.idb = idb;

    }

    // Gör om alien namn till alien id
    // Returnerar id
    public String getAlienId(String Namn) {
        String alienId = "";
        try {
            String fraga = "SELECT Alien_ID FROM alien WHERE Namn = '" + Namn + "'";
            alienId = idb.fetchSingle(fraga);
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte att hämta alien id");
        }
        return alienId;
    }

    // Gör om agent namn till agent id
    // Returnerar id
    public String getAgentId(String agentNamn) {
        String idAgent = "";
        try {

            String fraga = "SELECT Agent_ID FROM Agent WHERE Namn = '" + agentNamn + "'";
            idAgent = idb.fetchSingle(fraga);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
            System.out.println(e.getMessage());
        }
        return idAgent;

    }

    // Gör om plats namn till plats id
    // Returnerar id
    public String getPlatsId(String platsNamn) {
        String platsId = "";
        try {
            String fraga = "SELECT Plats_ID FROM plats WHERE Benamning = '" + platsNamn + "'";
            platsId = idb.fetchSingle(fraga);
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte att hämta platsent id");
        }
        return platsId;
    }
    
     // Gör om omrade namn till omrade id
    // Returnerar id
    public String getOmradeId(String omrade){
        String omradeId = omrade;
        
        try{
            String fraga = "SELECT Omrades_ID FROM omrade WHERE Benamning = '"+ omrade +"'";
            omradeId = idb.fetchSingle(fraga);
        }
        catch(InfException ex){
                JOptionPane.showMessageDialog(null, "Gick inte att hämta områdets id");
            }
        
        return omradeId;
    }
}
