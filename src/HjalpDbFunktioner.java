
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aaau
 */
public class HjalpDbFunktioner {
    private InfDB idb;
    
    public HjalpDbFunktioner(InfDB idb) {
        this.idb = idb;
        
    }
    
    
 public String getAlienId(String Namn){
        String alienId = "";
        try{
            String fraga = "SELECT Alien_ID FROM alien WHERE Namn = '"+ Namn +"'";
            alienId = idb.fetchSingle(fraga);
        }
        catch(InfException ex){
                JOptionPane.showMessageDialog(null, "Gick inte att hämta alien id");
            }
        return alienId;
    }

public String getAgentId(String agentNamn){
        String idAgent ="";
        try{
           
            String fraga = "SELECT Agent_ID FROM Agent WHERE Namn = '"+ agentNamn + "'";
            idAgent = idb.fetchSingle(fraga);
            
        }
        catch(InfException e){
            JOptionPane.showMessageDialog(null, "Något gick fel med uppkopplingen till databasen");
            System.out.println(e.getMessage());
        }
      return idAgent;
    
    }

 // Får in ett valt platsnamn och returnerar platsens id
    public String getPlatsId(String platsNamn){
        String platsId = "";
        try{
            String fraga = "SELECT Plats_ID FROM plats WHERE Benamning = '"+ platsNamn +"'";
            platsId = idb.fetchSingle(fraga);
        }
        catch(InfException ex){
                JOptionPane.showMessageDialog(null, "Gick inte att hämta platsent id");
            }
        return platsId;
    }
}