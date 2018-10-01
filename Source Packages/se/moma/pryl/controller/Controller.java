/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.factory.PrylFactory;
import se.moma.pryl.model.interfaces.Pryl;

/**
 *
 * @author monde
 */
public class Controller {
    
    
    private PersonSamling personSamling = null;
    //private List<Person> personLista = null;
    private PrylFactory prylFactory = null;
    private static final String NAMN = "Kalle";
    
    public Controller(PersonSamling personSamling, PrylFactory prylFactory) {
       List<Person> personLista = null;
       this.personSamling  = new PersonSamling(personLista);
       this.prylFactory = prylFactory;      
       
    } 
   
   
    public void skapaPerson(String namnPåNyPerson) {
      // valideraPersonData(namnPåNyPerson);
       List<Pryl> personPrylar = null;
       personSamling.laggTillPerson(skapaPersonInstans(namnPåNyPerson, personPrylar));
    }

    
   /*
    
    public void skapaPrylTillPerson(String namnpåperson, Map<String, String> prylargs) {
       if(isPersonRegistrerad(namnpåperson)) {
            prylFactory.skapaPryl(prylargs);
       } else
           throw new IllegalArgumentException("Hittar ingen med det namnet!");
    }
    */
    
    private Person skapaPersonInstans(String namnPåNyPerson, List<Pryl> personPrylar) {
        valideraPersonData(namnPåNyPerson);
        return new Person(namnPåNyPerson, personPrylar);
    }
    
   
    private void valideraPersonData(String namnPåNyPerson) throws IllegalArgumentException {
        Objects.requireNonNull(namnPåNyPerson, "Måste ange ett namn!");
        if (namnPåNyPerson instanceof String)
          if (namnPåNyPerson.equals("")) throw new IllegalArgumentException("Måste ange att namn!");
            if (isPersonRegistrerad(namnPåNyPerson)) throw new IllegalArgumentException(namnPåNyPerson + " finns redan registrerat!");
    }
    
    private boolean isPersonRegistrerad(String namnpåperson){
       return personSamling.hittaPerson(namnpåperson);
    }
    
    public static void main(String[] args) {
        List<Person> personLista = null;
        PrylFactory prylFactory = null;
        Controller controller = new Controller(new PersonSamling(personLista), prylFactory);
        controller.skapaPerson(NAMN);
        //controller.skapaPerson("Kalle");
 
    }
    
    
    
    
}
