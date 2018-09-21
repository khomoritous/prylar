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
       
         personSamling = new PersonSamling(minaPersoner);
         person = new Person(NAMN_PÅ_PERSON, minaPrylar);
       
    }
    
   

    @Test
    public void testLaggTillPerson() {
        personSamling.laggTillPerson(person);
        String result = personSamling.toString();
        assertTrue("Person har inget namn!", result.contains(NAMN_PÅ_PERSON));
    }

    @Test
    public void testBörsKrasch() {
        pryl = new Aktie(NAMN_PÅ_AKTIE, ANTAL_AKTIER, PRIS_PÅ_AKTIER);
        person.läggTillPryl(pryl);
        personSamling.laggTillPerson(person);
        personSamling.börsKrasch();
        int expResultat = pryl.getVärde();
        int resultat = person.summaVärde();
        assertEquals(expResultat, resultat);
    }
    

    @Test
    public void testHittaPerson() {
        personSamling.laggTillPerson(person);
        assertTrue("Hittade ingen person med det namnet!", personSamling.hittaPerson(NAMN_PÅ_PERSON));
    }

    @Test
    public void testHämtaPerson() {
        personSamling.laggTillPerson(person);
        assertEquals(person, personSamling.hämtaPerson(NAMN_PÅ_PERSON));
 
    }

    @Test
    public void testVisaAlla() {
        personSamling.laggTillPerson(person);
        String expResult = personSamling.visaAlla();
        String result = person.getNamn();
        assertTrue("Den här personen finns inte i samlingen!", expResult.contains(result));

    }

    @Test
    public void testHämtaRikaste() {
        List<Pryl> minaPrylarTvå = null;
        Person rikastePerson = new Person(NAMN_PÅ_RIKASTE_PERSON, minaPrylarTvå);
        rikastePerson.läggTillPryl(new Aktie(NAMN_PÅ_DYRASTE_AKTIE, ANTAL_AKTIER_PÅ_RIKASTE_PERSON, PRIS_PÅ_AKTIE_FÖR_RIKASTE));
        personSamling.laggTillPerson(person);
        personSamling.laggTillPerson(rikastePerson);
        assertEquals(rikastePerson, personSamling.hämtaRikaste());
        
        
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