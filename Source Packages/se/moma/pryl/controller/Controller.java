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
    private List<Person> personLista = null;
    PrylFactory prylFactory = null;
    
    public Controller(PersonSamling personSamling, PrylFactory prylFactory) {
       this.personSamling  = new PersonSamling(personLista);
       this.prylFactory = prylFactory;      
       
    } 
   
   
    public void skapaPerson(String namnpånyperson) {
       validering(namnpånyperson);
       List<Pryl> personPrylar = null;
       personSamling.laggTillPerson(new Person(namnpånyperson, personPrylar));
    }

    
   
    
    public void skapaPrylTillPerson(String namnpåperson, Map<String, String> prylargs) {
       if(isPersonRegistrerad(namnpåperson)) {
            prylFactory.skapaPryl(prylargs);
       } else
           throw new IllegalArgumentException("Hittar ingen med det namnet!");
    }
   
    private void validering(String namnpånyperson) throws IllegalArgumentException {
        Objects.requireNonNull(namnpånyperson, "Måste ange ett namn!");
        if (namnpånyperson instanceof String)
            if (namnpånyperson.equals("")) throw new IllegalArgumentException("Måste ange att namn!");
               if (isPersonRegistrerad(namnpånyperson)) throw new IllegalArgumentException(namnpånyperson + " finns redan registrerat!");
    }
    
    private boolean isPersonRegistrerad(String namnpåperson){
       return personSamling.hittaPerson(namnpåperson);
    }
    
    public static void main(String[] args) {
        List<Person> personLista = null;
        PrylFactory prylFactory = null;
        Controller controller = new Controller(new PersonSamling(personLista), prylFactory);
        controller.skapaPerson("Kalle");
        //controller.skapaPerson("Kalle");
 
    }
    
    
    
    
}
