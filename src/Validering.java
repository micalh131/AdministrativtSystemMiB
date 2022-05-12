
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
        valideringsklassen som skrivits ovan. 
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
     
    
}
