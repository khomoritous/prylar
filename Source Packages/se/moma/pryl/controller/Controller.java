/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.integration.PrylSamling;
import se.moma.pryl.integration.exceptions.PersistanceException;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.factory.PrylFactory;

/**
 * Är en <code>Controller</code>. Använder sig av <code>PersonSamling</code> för att skapa
 * instanser av <code>Person</code> och <code>PrylFactory</code> för att skapa instanser av <code>Pryl</code> till <code>Person</code>. 
 * 
 * @author monde
 */
public class Controller {
    
    private PersonSamling personSamling = null;
    private Map<String, String> prylArgs = new HashMap<>();
    
    
   /**
    * Skapar en instans av <code>Controller</code>.
    * 
    * @param personSamling Samling av personer som har en <code>PrylSamling</code>.
    * @param prylArgs Argument till <code>Pryl</code> som ska läggas till <code>PrylSamling</code>.
    */
    public Controller(PersonSamling personSamling,Map<String, String> prylArgs) {
      this.personSamling  = new PersonSamling();     
      this.prylArgs = prylArgs;
    } 
   
    
    /**
     * Registrerar ny <code>Person</code>. Namn på person får inte redan vara registrerat. 
     * 
     * @param namnPåNyPerson Namn på <code>Person</code> som ska registreras.
     * 
     * @throws IllegalArgumentException om namn på person redan är registrerat.
     */
    public void registreraNyPerson(String namnPåNyPerson) {
      if (isPersonRegistrerad(namnPåNyPerson)) throw new IllegalArgumentException(namnPåNyPerson + " finns redan registrerad!");
      personSamling.läggTillPerson(namnPåNyPerson);
    }

    
     /**
      * Skapar <code>Pryl</code> till <code>Person</code>. 
      * 
      * @param namnPåPerson Namn på <code>Person</code> som ska äga prylen.
      * @param namnPåPryl Namn på vilken typ av <code>Pryl</code> som ska försöka skapas. 
      * 
      * @throws NumberFormatException om det är fel på argumenten till <code>Pryl</code>. 
      */
     public void skapaPrylTillPerson(String namnPåPerson, String namnPåPryl) throws NumberFormatException {
       personSamling.hämtaPrylSamlingTillPerson(namnPåPerson).läggTillPryl(PrylFactory.getPryl(namnPåPryl, getPrylArgs()));
     }
     
     
     /**
      * Hämtar <code>PrylSamling</code> till <code>Person</code>. Namnet på <code>Person</code> måste 
      * redan vara registrerat. 
      * 
      * @param hämtaPerson Namn på <code>Person</code> med <code>PrylSamling</code>.
      * @return En persons <code>PrylSamling</code>.
      * 
      * @throws IllegalArgumentException om namn på person inte är registrerat.
      */
     public PrylSamling hämtaPrylSamling(String hämtaPerson) {
       if (!isPersonRegistrerad(hämtaPerson)) throw new IllegalArgumentException("Hittar ingen med det namnet!");
       return personSamling.hämtaPrylSamlingTillPerson(hämtaPerson);
     }

     
     /**
      * Sätter värdet av <code>Aktie</code> i samtliga personers prylsamlingar till 0. 
      * 
      */
     public void börsKraschFörSamtligaPrylSamlingar() {
       personSamling.börsKrasch();
     }
    
    
    /**
     * Visar personers prylsamlingars totala värde.
     * 
     * @return samliga personers prylsamlingars totala värde.
     */
    public String visaPersonSamling() {
      return personSamling.visaAllaPersoner();
    }
    
    
    /**
     * Sorterar och visar rikaste persons  <code>PrylSamling</code> i nedstigande ordning. 
     * 
     * Till exempel {Olle,smycke->värde=10}, {Pelle,aktie->värde=100} blir {Pelle,aktie->värde=100}, 
     * {Olle, smycke->värde=10} 
     * 
     * @return Alla personers prylsamlingar.
     */
    public Map<Person, PrylSamling> visaRikastePerson() {
      return personSamling.hämtaRikastePerson();
    }
    
     
    /**
     * Finns <code>Person</code>  i <code>PersonSamling</code>?
     * 
     * @param namnpåperson Namn på <code>Person</code> i <code>PersonSamling</code>.
     * @return <code>True</code>, om <code>Person</code> finns, <code>false</code> annars.
     */
    public boolean isPersonRegistrerad(String namnpåperson){
      return personSamling.isPersonRegistrerad(namnpåperson);
    }
    /**
     * Sparar <code>PersonSamling</code> till fil. 
     * 
     * @throws PersistanceException Om det är något fel på fil eller åtkomst till fil.
     */
    public void sparaPersonSamlingTillFil() throws PersistanceException {
      try {
        personSamling.sparaPersonSamling();
      } catch (IOException iex) {
          throw new PersistanceException(iex);
      }
    }
    
    
    /**
     * @return Textsträngsrepresentation av <code>PersonSamling</code>. 
     */
    @Override
    public String toString() {
      return personSamling.toString();
    }
    
    //getter, returnerar prylargument i prylArgs.
    private Map<String, String> getPrylArgs() {
      return prylArgs;
    }
    
    
   
    public static void main(String[] args) {
      
      Map<String, String> prylArgs = new HashMap<>();

      PersonSamling personSamling = null;
      Controller controller = new Controller(personSamling, prylArgs);
      //skapa person
//      controller.registreraNyPerson("Pelle");
      assert controller.isPersonRegistrerad("Pelle") == true;
      
      System.out.println(controller.visaPersonSamling());
     // System.out.println(controller.getPrylArgs());
      
      prylArgs.put("namn", "googl");
      prylArgs.put("antal", "10");
      prylArgs.put("pris", "10");
      
      
      controller.skapaPrylTillPerson("Pelle", "aktie");
      System.out.println(controller.visaPersonSamling());
      
      prylArgs.put("namn", "halsband");
      prylArgs.put("metall", "platina");
      prylArgs.put("ädelstenar", "2");
      
      controller.skapaPrylTillPerson("Pelle", "smycke");
      System.out.println(controller.visaPersonSamling());
      
      prylArgs.put("namn", "ugn");
      prylArgs.put("pris", "1000");
      prylArgs.put("slitage", "3");
       
      controller.skapaPrylTillPerson("Pelle", "apparat");
      System.out.println(controller.visaPersonSamling());
      
      //Ny person
     // controller.registreraNyPerson("Ludde");
      assert controller.isPersonRegistrerad("Ludde") == true;
      
      prylArgs.put("namn", "AAPL");
      prylArgs.put("antal", "100");
      prylArgs.put("pris", "10");
      
      controller.skapaPrylTillPerson("Ludde", "aktie");
      System.out.println(controller.visaPersonSamling());
      
      System.out.println(controller.toString());
      
      System.out.println(controller.hämtaPrylSamling("Pelle"));
      
      controller.börsKraschFörSamtligaPrylSamlingar();
      
      System.out.println(controller);
      
    }

    
}
