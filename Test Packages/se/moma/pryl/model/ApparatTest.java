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
    private static final int NON_VALID_PRIS = 0;
    private static final int SLITAGE = 8;
    private static final int NON_VALID_SLITAGE = 0;
    private static final int VÄRDE = 8;
    
    @Before
    public void setUp() {
        apparat = new Apparat(NAMN, PRIS, SLITAGE);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructorShouldThrowIAEFORNonValidPris() {
     apparat = new Apparat(NAMN, NON_VALID_PRIS, SLITAGE);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructorShouldThrowIAEFORNonValidSlitage() {
     apparat = new Apparat(NAMN, NON_VALID_PRIS, NON_VALID_SLITAGE);
    }

    @Test
    public void testVärdePåApparat() {
        assertEquals(VÄRDE, apparat.värde(), 0.1);
    }
    
}
