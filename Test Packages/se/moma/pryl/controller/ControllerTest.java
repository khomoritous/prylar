/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    private PrylFactory prylfactory = null;
    private List<Person> personLista = null;
    private static final String NAMN_PÅ_PERSON = "Boris";
    private static final String NON_VALID_NAMN = "Boris";
    
    @Before
    public void setUp() {
        personSamling = new PersonSamling();
        controller = new Controller(personSamling, prylfactory);
    }
    
   

    @Test(expected = IllegalArgumentException.class)
    public void testSkapaPersonShouldThrowIAEForNonValidName() {
        controller.skapaPerson(NAMN_PÅ_PERSON);
        controller.skapaPerson(NON_VALID_NAMN);
    }
    
    //ok test, kan göras bättre.
    @Test
    public void testSkapaPrylTillPerson() {
       
        String namnPåPerson = NAMN_PÅ_PERSON;
        Map<String, String> prylArgs = new HashMap<>();
        prylArgs.put("smycke", "ring");
        prylArgs.put("metall", "platina");
        prylArgs.put("ädelstenar", "10");
        controller.skapaPerson(NAMN_PÅ_PERSON);
        controller.skapaPrylTillPerson(NAMN_PÅ_PERSON, prylArgs);
        String resultat = controller.visaPersonSamling();
        String expResultat = namnPåPerson;
        
        assertTrue("Det finns ingen med det namnet!", resultat.contains(expResultat));
    } 
    
}
