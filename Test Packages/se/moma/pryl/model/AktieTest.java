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
public class AktieTest {
    
    private Aktie aktie = null;
    private static final int PRIS = 12;
    private static final int NON_VALID_PRIS = -1;
    private static final int ANTAL = 100;
    private static final int NON_VALID_ANTAL = 0;
    private static final String NAMN = "GOOG";
    private static final int VÄRDE = 0;
    
    
    @Before
    public void setUp() {
        aktie = new Aktie(NAMN, ANTAL, PRIS);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructorShouldThrowIAEFORNonValidAntalAktier() {
      new Aktie(NAMN,NON_VALID_ANTAL, PRIS);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructorShouldThrowIAEFORNonValidPris() {
      new Aktie(NAMN,ANTAL, NON_VALID_PRIS);
    }
    

    @Test
    public void testVärdeOfAktie() {
        assertEquals(PRIS * ANTAL, aktie.värde());
    }
    
    @Test
    public void testSetPrisTillNoll() {
        aktie.setPrisTillNoll();
        assertEquals("Priset på aktien sattes inte till noll!",0, aktie.getVärde());
    }
    
   
    
}
