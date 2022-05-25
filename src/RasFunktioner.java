
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
public class RasFunktioner {
    private InfDB idb;
    
    public RasFunktioner(InfDB idb) {
        this.idb = idb;
        
    }
    //Kollar vilken ras som är vald som ny ras , anropar metoden för att 
    //ta bort den gamla rasen och lägger sedan till aliens id i den nya rasens tabell
    public void andraRas(String alienID, String ras, String rasAttribut) {

        
        if (ras.equals("Worm")) {
            try {
                String fraga = "INSERT INTO worm (Alien_ID) VALUES ('" + alienID + "')";
                idb.insert(fraga);
            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Gick inte att lägga till ras");
            }
        } else if (ras.equals("Squid")) {
            try {
                String fraga = "INSERT INTO squid (Alien_ID, Antal_Armar) VALUES "
                        + "('" + alienID + "','" + rasAttribut + "')";
                idb.insert(fraga);
            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Gick inte att lägga till ras");
            }
        } else if (ras.equals("Boglodite")) {
            try {
                String fraga = "INSERT INTO boglodite (Alien_ID,Antal_Boogies) VALUES "
                        + "('" + alienID + "','" + rasAttribut + "')";
                idb.insert(fraga);
            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Gick inte att lägga till ras");
            }
        }
    }
    
    // Letar i varje ras tabell för att se vilken ras alien tillhörde
    // Hittar den aliens id så tar den bort hela den raden ur databasen.
    public void taBortRas(String alienID) {
        

        try {
            
            idb.delete("DELETE FROM boglodite WHERE Alien_ID =" + alienID);
            idb.delete("DELETE FROM squid WHERE Alien_ID =" + alienID);
            idb.delete("DELETE FROM worm WHERE Alien_ID =" + alienID);
            
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Gick inte att ta bort alien från ras");
        }

       
        
    }

}
