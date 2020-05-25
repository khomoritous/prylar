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
public class PersonTest {
    
    
   // private List<Pryl> minaPrylar = null; 
    private Person person = null;
    private static final String NAMN_PÅ_PERSON = "Pelle";
    private static final String NON_VALID_NAMN_PÅ_PERSON = "";
    private static final String NAMN_PÅ_PRYL = "googl";
    private static final int ANTAL = 10;
    private static final int PRIS = 100;
    private static final int ÄDELSTENFAKTOR = 700;
    private static final int VÄRDE = 500;
    private static final int ANTAL_ÄDELSTENAR = 10;
    
    
    @Before
    public void setUp() {
        
        person = new Person(NAMN_PÅ_PERSON);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructorShouldThrowIAEForNonValidNamn() {
     person = new Person(NON_VALID_NAMN_PÅ_PERSON);
    }
    

    @Test
    public void testGetNamn() {
        assertEquals(NAMN_PÅ_PERSON, person.getNamn());
        
    }

}
