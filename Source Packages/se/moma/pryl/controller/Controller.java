/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.integration.PrylSamling;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.factory.PrylFactory;
import se.moma.pryl.model.factory.PrylFactory;
import se.moma.pryl.model.interfaces.Pryl;

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
     * @param personSamling Samling för instanser av <code>Person</code>.
     * @param prylFactory För att skapa <code>Pryl</code>.
     */
    public Controller(PersonSamling personSamling,Map<String, String> prylArgs) {
      this.personSamling  = new PersonSamling();     
     // this.prylArgs = new HashMap<>();
      this.prylArgs = prylArgs;
    } 
   
    
    /**
     * Registrerar ny <code>Person</code>.
     * 
     * @param namnPåNyPerson Namn på <code>Person</code>.
     */
    public void registreraNyPerson(String namnPåNyPerson) {
      if (isPersonRegistrerad(namnPåNyPerson)) throw new IllegalArgumentException(namnPåNyPerson + " finns redan registrerad!");
        personSamling.läggTillPerson(namnPåNyPerson);
    }

    
    /**
     * Skapar en <code>Pryl</code> till en <code>Person</code>.
     * 
     * @param namnPåPerson
     * @param prylArgs 
     */
     public void skapaPrylTillPerson(String namnPåPerson, String namnPåPryl) {
      if (!isPersonRegistrerad(namnPåPerson)) throw new IllegalArgumentException("Hittar ingen med det namnet!");
      personSamling.hämtaPrylSamlingTillPerson(namnPåPerson).läggTillPryl(PrylFactory.getPryl(namnPåPryl, getPrylArgs()));
     }

  
    
    
    /**
     * Visar <code>PersonSamling</code> med <code>Person</code> och samling av <code>Pryl</code>.
     * 
     * @return <code>PersonSamling</code>
     */
    public String visaPersonSamling() {
      return personSamling.visaAllaPersoner();
    }
    
    
    /**
     * Visar rikaste <code>Person</code> i <code>PersonSamling</code>.
     * 
     * @return Rikaste <code>Person</code>.
     */
    public Map<Person, PrylSamling> visaRikastePerson() {
      return personSamling.hämtaRikastePerson();
    }
    
     
    /**
     * Finns <code>Person</code>  i <code>PersonSamling</code>?
     * 
     * @param namnpåperson Namn på <code>Person</code> i <code>PersonSamling</code>.
     * @return <code>True</code>, om <code>Person</code> finns i <code>PersonSamling</code>, <code>False</code> annars.
     */
    public boolean isPersonRegistrerad(String namnpåperson){
      return personSamling.isPersonRegistrerad(namnpåperson);
    }
    
    public String toString() {
      return personSamling.toString();
    }
    
    
    private Map<String, String> getPrylArgs() {
      return prylArgs;
    }
    
    
   
    
    
    public static void main(String[] args) {
      
      Map<String, String> prylArgs = new HashMap<>();

      
      
    
      PersonSamling personSamling = null;
      Controller controller = new Controller(personSamling, prylArgs);
      //skapa person
      controller.registreraNyPerson("Pelle");
      assert controller.isPersonRegistrerad("Pelle");
      
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
      controller.registreraNyPerson("Ludde");
      assert controller.isPersonRegistrerad("Ludde");
      
      prylArgs.put("namn", "AAPL");
      prylArgs.put("antal", "100");
      prylArgs.put("pris", "10");
      
      controller.skapaPrylTillPerson("Ludde", "aktie");
      System.out.println(controller.visaPersonSamling());
      
      System.out.println(controller.toString());
      
    }

    
}
