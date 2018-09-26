/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.controller;

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
    private PersonSamling personsamling = null;
    private PrylFactory prylfactory = null;
    
    
    @Before
    public void setUp() {
        controller = new Controller(personsamling, prylfactory);
    }
    
   

    @Test
    public void testSkapaPerson() {
        System.out.println("skapaPerson");
        String namnpånyperson = "Pelle";
        Controller instance = null;
        instance.skapaPerson(namnpånyperson);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSkapaPrylTillPerson() {
        System.out.println("skapaPrylTillPerson");
        String namnpåperson = "";
        Map<String, String> prylargs = null;
        Controller instance = null;
        instance.skapaPrylTillPerson(namnpåperson, prylargs);
        fail("The test case is a prototype.");
    }
    
}
