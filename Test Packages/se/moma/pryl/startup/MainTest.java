/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.startup;

import org.junit.Before;
import org.junit.Test;
import se.moma.pryl.controller.Controller;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.model.factory.PrylFactory;

/**
 *
 * @author monde
 */
public class MainTest {
    
    private Controller controller = null;
    private PersonSamling personSamling = null;
    private PrylFactory prylFactory = null;
    private static final String NAMN = "Göran";
    
    @Before
    public void setUp() {
        controller = new Controller(personSamling, prylFactory);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testLäggerTillPerson_kastar_undantag_om_person_är_registrerad() {
        controller.skapaPerson(NAMN);
        controller.skapaPerson(NAMN);
    }
    
}
