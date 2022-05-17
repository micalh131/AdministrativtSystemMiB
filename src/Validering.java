
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author carolinaappel
 */
public class Validering {

public static boolean textFaltHarVarde(JTextField rutaAttKolla)
{
    boolean resultat = true;
    if (rutaAttKolla.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "inmatningsrutan är tom");
        resultat = false;
        rutaAttKolla.requestFocus();
    }
    return resultat;
}
    
    /* Nedandstående kod är exempel på kod i klasser som ska använda 
        valideringsklassen som skrivits ovan: 
    if (Validering.textFaltHarVarde(variabelNamnA)){
        
        try{
        String id = variabelNamnA.getText();
        String fraga = "SELECT x FROM y WHERE n=" + id;
        String svar = idb.fetchSingle(fraga);
        String resultat = svar;
        varabelNamnB.setText(resultat);
        }
        catch(InfException e){
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
    */
    
public static boolean isHeltal(JTextField rutaAttKolla)
{
    boolean resultat = true;
    
    try{
        String inStrang = rutaAttKolla.getText();
        Integer.parseInt(inStrang);
        rutaAttKolla.requestFocus();
        
    }
    catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Var god ange ett heltal!");
        resultat = false;
        System.out.println("Heltal skrevs ej in");
    }
         
    return resultat; 

    /*if (Validering.isHeltal(variabelNamnA)){
        
        try{
        String id = variabelNamnA.getText();
        String fraga = "SELECT x FROM y WHERE n=" + id;
        String svar = idb.fetchSingle(fraga);
        String resultat = svar;
        varabelNamnB.setText(resultat);
        }
        catch(InfException e){
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
    */
}
public static boolean kollaLosen(String dbLosen, String nyttLosen)
{
    boolean resultat = true;
    System.out.println(dbLosen);
    if (!dbLosen.equals(nyttLosen)) {
        JOptionPane.showMessageDialog(null, "Nuvarande lösenord är fel");
        resultat = false;
    }
    return resultat;
}

public static boolean kollaAgentId(ArrayList<String> ids, String nyOmradesChef)
{
    boolean resultat = true;
    for(String i : ids){
        if (i.equalsIgnoreCase(nyOmradesChef)) {
        JOptionPane.showMessageDialog(null, "Denna agent är redan asvarig för ett område \n Vänligen välj en annan agent");
        resultat = false;
        }
    }
   
    return resultat;
}
     
    
}
