
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
 * @author miche, aaau, cAppelina
 */
public class Validering {

    //Metoden validerar datumformat
    public static boolean valideraDatum(String datum) {
        boolean resultat = false;
        //använder javas klass SimpleDateFormat för att parsa/tolka en datumsträng
        //När objetet skapas sätts formateringen till det önskade datumformatet (yyyy-mm-dd)
        SimpleDateFormat datumLasare = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //Konverterar datumet till javas datumtyp
            Date javaDatum = datumLasare.parse(datum);

            //Om datumvalideringen ovan gick bra sätts reultatet till true
            resultat = true;

//Felhantering med javas Exceptionklasser enligt Javas föreslag enl API. 
//Den första ger ett felmeddelande om ingen sträng finns. Den andra ger felmeddelande om man tex anger bokstäber. 
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ange datumet i korrekt format (yyyy-mm-dd)");
        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(null, "Ange datumet i korrekt format (yyyy-mm-dd)");
        }

        return resultat;
    }

    //Metoden kollar om rutan är tom genom att använda metoden matches i klassen Pattern.
    public static boolean textFaltEjTomtRegEx(String textAttKolla) {
        /*  
    Klassen pattern är Javas implementation av regular expresions. Regular expression är avancerade söksträngar där 
    man genom olika notationer kan söka efter teckenklasser (siffror, bokstäver, white space etc). 
    Ett regular expression är en sträng. ("^\\s*$") ^början, \\s white space, * 0 eller flera, $ slutet)
    Om man ska göra för heltal så blir det ("\d+") det matchas på siffror, en eller flera. 
    
         */
        boolean resultat = true;
        boolean rutaTom = Pattern.matches("^\\s*$", textAttKolla);

        if (rutaTom) {
            JOptionPane.showMessageDialog(null, "rutan är tom eller innehåller bara space, vänligen ange något i rutan");
            resultat = false;

        }
        return resultat;
    }

    //Koll så att användaren inte väljer "Välj" i comboboxen vid inmatning. 
    public static boolean kollaCboxRegEx(String textAttKolla) {

        boolean resultat = true;
        boolean rutaTom = Pattern.matches("\\W*((?i)välj(?-i))\\W*", textAttKolla);

        if (rutaTom) {
            JOptionPane.showMessageDialog(null, "Välj något av alternativen i dropdown menyn");
            resultat = false;

        }
        return resultat;
    }

    // Jämför användarens sparade lösenord från databasen med det användaren skriver
    //in som nuvarande lösen. Detta är extra säkerhetskoll när användaren byter till nytt lösen.
    public static boolean kollaLosen(String dbLosen, String nuvarandeLosen) {
        boolean resultat = true;
        System.out.println(dbLosen);
        if (!dbLosen.equals(nuvarandeLosen)) {
            JOptionPane.showMessageDialog(null, "Nuvarande lösenord är fel");
            resultat = false;
        }
        return resultat;
    }

    //@param ids en lista på alla Agent_ID från tabellen omradeschef
    //@param nyOmradeschef den nya områdeschefen användaren vill uppdatera till
    //Metoden kollar så att nyOmradeschef inte redan har ett område den är chef för
    //Det ska inte gå att vara chef för flera områden
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

    //@param admin Får in Ja eller Nej beroende på om agenten ska vara admin eller inte
    //Metoden gör om inputen till en bokstav, J eller N för att kunna ställa 
    //en fråga till databasen
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

    //@param namn Från in ett namn på en alien eller agent som användaren vill ta bort från databasen
    //Skapar en speciell dialogruta där användaren kan välja "Ja" ta bort, "Nej" ta inte bort eller "Avbryt"
    public static boolean kollaTaBort(String namn) {
        int response = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort " + namn, "Select option", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

}
