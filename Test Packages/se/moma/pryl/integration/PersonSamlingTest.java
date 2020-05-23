/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.integration;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.interfaces.Pryl;

/**
 *
 * @author monde
 */
public class PersonSamlingTest {
    
    private PersonSamling personSamling = null;
    private List<Person> minaPersoner = null;
    private List<Pryl> minaPrylar = null;
    private Person person = null;
    private Pryl pryl = null;
    private static final String NAMN_PÅ_PERSON = "Ludde";
    private static final int ANTAL_AKTIER = 10;
    private static final int PRIS_PÅ_AKTIER = 100;
    private static final String NAMN_PÅ_AKTIE = "googl";
    private static final int ANTAL_AKTIER_PÅ_RIKASTE_PERSON = 1000;
    private static final int PRIS_PÅ_AKTIE_FÖR_RIKASTE = 1000;
    private static final String NAMN_PÅ_RIKASTE_PERSON = "Stig";
    private static final String NAMN_PÅ_DYRASTE_AKTIE = "aapl";
   
    
    @Before
    public void setUp() {
       
         personSamling = new PersonSamling();
         person = new Person(NAMN_PÅ_PERSON);
       
    }
    
   
    @Test
    public void testLäggTillPerson() {
        personSamling.läggTillPerson(person);
        String result = personSamling.toString();
        assertTrue("Person har inget namn!", result.contains(NAMN_PÅ_PERSON));
    }

    
    @Test
    public void testBörsKrasch() {
        pryl = new Aktie(NAMN_PÅ_AKTIE, ANTAL_AKTIER, PRIS_PÅ_AKTIER);
        person.läggTillPryl(pryl);
        personSamling.läggTillPerson(person);
        personSamling.börsKrasch();
        double expResultat = pryl.getVärde();
        double resultat = person.summaVärde();
        assertEquals(expResultat, resultat, 0.1);
    }
    

    @Test
    public void testHittaPerson() {
        personSamling.läggTillPerson(person);
        assertTrue("Hittade ingen person med det namnet!", personSamling.hittaPerson(NAMN_PÅ_PERSON));
    }
    
    
    @Test(expected=NullPointerException.class)
    public void testHittaPersonShouldThrowNPEForNonValidPerson() {
     personSamling = new PersonSamling();
     personSamling.hittaPerson(null);
    }
    
    
    @Test(expected=NullPointerException.class)
    public void testLäggTillPersonShouldThrowNPEForNonValidPerson() {
     personSamling = new PersonSamling();
     personSamling.läggTillPerson(null);
    }
    
    @Test(expected=NullPointerException.class)
    public void testHämtaPersonShouldThrowNPEForNonValidPerson() {
     personSamling = new PersonSamling();
     personSamling.hämtaPerson(null);
    }
    

    @Test
    public void testHämtaPerson() {
        personSamling.läggTillPerson(person);
        assertEquals(person, personSamling.hämtaPerson(NAMN_PÅ_PERSON));
 
    }

    @Test
    public void testVisaAllaPersoner() {
        personSamling.läggTillPerson(person);
        String expResult = personSamling.visaAllaPersoner();
        String result = person.getNamn();
        assertTrue("Den här personen finns inte i samlingen!", expResult.contains(result));

    }

    @Test
    public void testHämtaRikastePerson() {
        Person rikastePerson = new Person(NAMN_PÅ_RIKASTE_PERSON);
        rikastePerson.läggTillPryl(new Aktie(NAMN_PÅ_DYRASTE_AKTIE, ANTAL_AKTIER_PÅ_RIKASTE_PERSON, PRIS_PÅ_AKTIE_FÖR_RIKASTE));
        personSamling.läggTillPerson(person);
        personSamling.läggTillPerson(rikastePerson);
        assertEquals(rikastePerson, personSamling.hämtaRikastePerson());
        
        
    }
//
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        PersonSamling instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//    
}
