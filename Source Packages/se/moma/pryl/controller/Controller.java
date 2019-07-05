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
import se.moma.pryl.model.factory.PrylFactoryProducent;
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
    
    
    
    /**
     * Skapar en instans av <code>Controller</code>.
     * 
     * @param personSamling Samling för instanser av <code>Person</code>.
     * @param prylFactory För att skapa <code>Pryl</code>.
     */
    public Controller(PersonSamling personSamling, PrylFactory prylFactory) {
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
        personSamling.läggTillPerson(new Person(namnPåNyPerson));
    }

    
    /**
     * Skapar en <code>Pryl</code> till en <code>Person</code>.
     * 
     * @param namnPåPerson
     * @param prylArgs 
     */
     public void skapaPrylTillPerson(String namnPåPerson, Map<String, String> prylArgs) {
      if (isPersonRegistrerad(namnPåPerson)) {
        Person person = personSamling.hämtaPerson(namnPåPerson);
        prylFactory = PrylFactoryProducent.getFactory(prylArgs);
        Pryl pryl = prylFactory.skapaPryl(prylArgs);
        person.läggTillPryl(pryl);
      } else
          throw new IllegalArgumentException("Hittar ingen med det namnet!");
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
    
    
    
    //är Person registrerad?
    private boolean isPersonRegistrerad(String namnpåperson){
      return personSamling.hittaPerson(namnpåperson);
    }
    
    
    public static void main(String[] args) {
    
      PrylFactory prylFactory = null;
      Controller controller = new Controller(new PersonSamling(), prylFactory);
      //skapa person
      controller.registreraNyPerson(NAMN);
     
      //skapa pryl
      Map<String, String> prylArgs = new HashMap<>();
      
      prylArgs.put("smycke", "ring");
      prylArgs.put("metall", "platina");
      prylArgs.put("ädelstenar", "10");
      controller.skapaPrylTillPerson(NAMN, prylArgs);
      
      System.out.println(controller.visaRikastePerson()+ "\n");
      System.out.println(controller.visaPersonSamling());
    }
}
