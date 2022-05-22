
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
    
    
    



public String faUtAgentID(String agentNamn){
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
}