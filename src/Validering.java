
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author carolinaappel
 */
public class Validering {

    public static boolean textFaltHarVarde(JTextField rutaAttKolla) {
        boolean resultat = true;
        if (rutaAttKolla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "inmatningsrutan är tom");
            resultat = false;
            rutaAttKolla.requestFocus();
        }
        return resultat;
    }
//Metoden validerar datumformat

    public static boolean valideraDatum(String datum) {
        boolean resultat = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //Konverterar datumet till en sträng
            Date javaDatum = sdf.parse(datum);

            //Om datumet inte är null sätts valideringen till true
            if (javaDatum != null) {
                resultat = true;
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ange datumet i korrekt format (yyyy-mm-dd)");
        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(null, "Ange datumet i korrekt format (yyyy-mm-dd)");
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
    public static boolean textFaltEjTomtRegEx(String textAttKolla) {
        /* Metoden kollar om rutan är tom genom att använda metoden matches i klassen Pattern. 

    Klassen pattern är Javas implementation av regular expresions. Regular expression är avancerade söksträngar där 
    man genom olika notationer kan söka efter teckenklasser (siffror, bokstäver, white space etc). 
    Ett regular expression är en sträng. ("^\\s*$") ^början, \\s white space, * 0 eller flera, $ slutet)
    Om man ska göra för heltal så blir det ("\d+") det matchas på siffror, en eller flera. 
    
         */
        boolean resultat = true;
        //Pattern Pat= new Pattern("\s*");
        boolean rutaTom = Pattern.matches("^\\s*$", textAttKolla);

        if (rutaTom) {
            JOptionPane.showMessageDialog(null, "rutan är tom eller innehåller bara space, vänligen ange något i rutan");
            resultat = false;

        }
        return resultat;
    }

    public static boolean kollaCboxRegEx(String textAttKolla) {

        boolean resultat = true;
        //Pattern Pat= new Pattern("\s*");
        boolean rutaTom = Pattern.matches("\\W*((?i)välj(?-i))\\W*", textAttKolla);

        if (rutaTom) {
            JOptionPane.showMessageDialog(null, "Välj något av alternativen i dropdown menyn");
            resultat = false;

        }
        return resultat;
    }

    public static boolean isHeltal(JTextField rutaAttKolla) {
        boolean resultat = true;

        try {
            String inStrang = rutaAttKolla.getText();
            Integer.parseInt(inStrang);
            rutaAttKolla.requestFocus();

        } catch (NumberFormatException e) {
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

    public static boolean kollaLosen(String dbLosen, String nyttLosen) {
        boolean resultat = true;
        System.out.println(dbLosen);
        if (!dbLosen.equals(nyttLosen)) {
            JOptionPane.showMessageDialog(null, "Nuvarande lösenord är fel");
            resultat = false;
        }
        return resultat;
    }

    public static boolean kollaAgentId(ArrayList<String> ids, String nyOmradesChef) {
        boolean resultat = true;
        for (String i : ids) {
            if (i.equalsIgnoreCase(nyOmradesChef)) {
                JOptionPane.showMessageDialog(null, "Denna agent är redan asvarig för ett område \n Vänligen välj en annan agent");
                resultat = false;
            }
        }

        return resultat;
    }

    public static String kollaIsAdmin(String admin) {
        String val = admin;
        if (!admin.equalsIgnoreCase("Välj")) {
            if (admin.equals("Ja")) {
                val = "J";
            } else {
                val = "N";
            }
        }
        return val;
    }

    public static boolean kollaTaBort(String namn) {
        int response = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort " + namn, "Select option", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

}
