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
    private List<Person> personLista = null;
    private PrylFactory prylFactory = null;
    private static final String NAMN = "Kalle";
    
    private Map<String, String> prylArgs = new HashMap<>();
    
    
    
    /**
     * Skapar en instans av <code>Controller</code>.
     * 
     * @param personSamling Samling för instanser av <code>Person</code>.
     * @param prylFactory För att skapa <code>Pryl</code>.
     */
    public Controller(PersonSamling personSamling) {
      this.personSamling  = new PersonSamling();
      this.prylFactory = prylFactory;      
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
     public void skapaPrylTillPerson(String namnPåPerson, Map<String, String> prylArgs) {
      if (!isPersonRegistrerad(namnPåPerson)) {
        throw new IllegalArgumentException("Hittar ingen med det namnet!");
      } else {
          this.prylArgs = prylArgs;
          Person person = personSamling.hämtaPrylSamlingTillPerson(namnPåPerson);
          prylFactory = PrylFactory.getFactory(prylArgs);
          Pryl pryl = prylFactory.skapaPryl(prylArgs);
          person.läggTillPryl(pryl);
        }
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
     * Visar rikaste <code>Person</code> ur <code>PersonSamling</code>.
     * 
     * @return Rikaste <code>Person</code>.
     */
    public Person visaRikastePerson() {
      return personSamling.hämtaRikastePerson();
    }
    
    
    
    /**
     * Finns <code>Person</code>  i <code>PersonSamling</code>.
     * 
     * @param namnpåperson Namn på <code>Person</code> i <code>PersonSamling</code>.
     * @return <code>True</code>, om <code>Person</code> finns i <code>PersonSamling</code>, <code>False</code> annars.
     */
    public boolean isPersonRegistrerad(String namnpåperson){
      return personSamling.isPersonRegistrerad(namnpåperson);
    }
    
    
    public static void main(String[] args) {
    
      PersonSamling personSamling = null;
      Controller controller = new Controller(personSamling);
      //skapa person
      controller.registreraNyPerson("Pelle");
      assert controller.isPersonRegistrerad("Pelle");
     
      
      
     
    }
}
