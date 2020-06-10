/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.factory.PrylFactory;

/**
 *
 * @author monde
 */
public class ControllerTest {
    
    
    private Controller controller = null;
    private PersonSamling personSamling = null;
    private Map<String, String> prylArgs = null;
    private PrylFactory prylfactory = null;
    private List<Person> personLista = null;
    private static final String NAMN_PÅ_PERSON = "Boris";
    private static final String NON_VALID_NAMN = "Boris";
    
    @Before
    public void setUp() {
      personSamling = new PersonSamling();
      prylArgs = new HashMap<>();
      controller = new Controller(personSamling, prylArgs);
      controller.registreraNyPerson("Pelle");
    }
    
   @Test
    public void testRegistreraNyPerson() {
      assertTrue("Det finns ingen sådan person registrerad!", controller.isPersonRegistrerad("Pelle"));
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void testRegisteraNyPersonShouldThrowIAEForNonValidName() {
      //controller.registreraNyPerson("Pelle");
      controller.registreraNyPerson("Pelle");
    }
    
    
    @Test
    public void testSkapaPrylTillPerson() {
     
     
      prylArgs.put("namn", "ring");
      prylArgs.put("metall", "platina");
      prylArgs.put("ädelstenar", "10");
      
      controller.skapaPrylTillPerson("Pelle", "smycke");
      String resultat = controller.toString();
      String expResultat = "ring";
        
      assertTrue("Det finns inget smycke med det namnet!", resultat.contains(expResultat));
    } 
    
}
