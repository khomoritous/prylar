/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monde
 */
public class ApparatTest {
    
    private Apparat apparat = null;
    private static final String NAMN = "Tandborste";
    private static final int PRIS = 10;
    private static final int SLITAGE = 8;
    private static final int SLITAGE_FAKTOR = 10;
    
    @Before
    public void setUp() {
        apparat = new Apparat(NAMN, PRIS, SLITAGE);
    }

    @Test
    public void testSomeMethod() {
        assertEquals((SLITAGE  / SLITAGE_FAKTOR) * PRIS, apparat.värde());
    }
    
}
