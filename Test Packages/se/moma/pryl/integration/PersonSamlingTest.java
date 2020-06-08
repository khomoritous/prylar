/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.integration;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.Apparat;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.Smycke;

/**
 *
 * @author monde
 */
public class PersonSamlingTest {
    
    private PersonSamling personSamling = null;
   
    
    private static final String NAMN_PÅ_PERSON = "Ludde";
    private static final int ANTAL_AKTIER = 10;
    private static final int PRIS_PÅ_AKTIER = 10;
    private static final int PRIS_PÅ_APPARAT = 1000;
    private static final int SLITAGE = 3;
    private static final int ANTAL_ÄDELSTENAR = 2;
   
    
    @Before
    public void setUp() {
       personSamling = new PersonSamling();
    }
    
   
    @Test
    public void testLäggTillPerson() {
      personSamling.läggTillPerson(NAMN_PÅ_PERSON);
      assertTrue("Den här personen finns inte samlingen!", personSamling.isPersonRegistrerad(NAMN_PÅ_PERSON));
    }
    
    @Test(expected=NullPointerException.class)
    public void testLäggTillPersonShouldThrowNPEForNonValidPerson() {
      personSamling.läggTillPerson(null);
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testLäggTillPersonShouldThrowIAEForNonValidPerson() {
      personSamling.läggTillPerson("");
    }
    
    
    
    @Test(expected=NullPointerException.class)
    public void testHittaPersonShouldThrowNPEForNonValidPerson() {
      personSamling.isPersonRegistrerad(null);
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testHittaPersonShouldThrowIAEForNonValidPerson() {
      personSamling.isPersonRegistrerad("");
    }
    
    @Test(expected=NullPointerException.class)
    public void testHämtaPersonShouldThrowNPEForNonValidPerson() {
      personSamling = new PersonSamling();
      personSamling.hämtaPrylSamlingTillPerson(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testHämtaPersonShouldThrowIEAForNonValidPerson() {
      personSamling = new PersonSamling();
      personSamling.hämtaPrylSamlingTillPerson("");
    }
    
    
    
    
    @Test
    public void testHämtaPrylSamlingTillPerson() {
      personSamling.läggTillPerson(NAMN_PÅ_PERSON);
      
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Smycke("halsband", "platina", ANTAL_ÄDELSTENAR));
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Aktie("googl", ANTAL_AKTIER, PRIS_PÅ_AKTIER));
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Apparat("ugn", PRIS_PÅ_APPARAT, SLITAGE));
      
      String result = personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).toString();
      assertTrue("Den här personen har ingen samling!", result.contains("googl"));
    }
    
    
    @Test(expected=NullPointerException.class)
    public void testHämtaPrylSamlingTillPersonShouldThrowNPEForNonValidPerson() {
      personSamling.hämtaPrylSamlingTillPerson(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testHämtaPrylSamlingTillPersonShouldThrowIEAForNonValidPerson() {
      personSamling.hämtaPrylSamlingTillPerson("");
    }
   
    
    @Test
    public void testBörsKrasch() {
      //given:
      personSamling.läggTillPerson(NAMN_PÅ_PERSON);
      
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Smycke("halsband","platina", ANTAL_ÄDELSTENAR));
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Aktie("googl", 10, 10));
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Apparat("ugn", 1000, 3));
      
      //System.out.println(personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).summaVärde());
      
      personSamling.läggTillPerson("Pelle");
      
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Smycke("ring","guld", 4));
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Aktie("AAPL", 10, 10));
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Apparat("skärm", 1500, 4));
      
       
      
      //when:
      personSamling.börsKrasch();
        
      //then:
      assertEquals(2000, personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).summaVärde(), 0.1);
      
      //and then:
      assertEquals(4600, personSamling.hämtaPrylSamlingTillPerson("Pelle").summaVärde(), 0.1);
    }
    

    @Test
    public void testVisaAllaPersoner() {
        personSamling.läggTillPerson("Pelle");
        personSamling.läggTillPerson("Ludde");
        String expResult = personSamling.visaAllaPersoner();
        assertTrue("Den här personen finns inte i samlingen!", expResult.contains("Pelle"));
    }
    

   /* @Test
    public void testHämtaRikastePerson() {
       //given:
      personSamling.läggTillPerson(NAMN_PÅ_PERSON);
      
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Smycke("halsband","platina", ANTAL_ÄDELSTENAR));
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Aktie("googl", 10, 10));
      personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).läggTillPryl(new Apparat("ugn", 1000, 3));
      
      //System.out.println(personSamling.hämtaPrylSamlingTillPerson(NAMN_PÅ_PERSON).summaVärde());
      
      personSamling.läggTillPerson("Pelle");
      
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Smycke("ring","guld", 4));
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Aktie("AAPL", 10, 10));
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Apparat("skärm", 1500, 4));
      
       
      
      //when:
      Map<Person, PrylSamling> sorterad = personSamling.hämtaRikastePerson();
        
      //then:
      assertThat();
      
        
    } */

}
