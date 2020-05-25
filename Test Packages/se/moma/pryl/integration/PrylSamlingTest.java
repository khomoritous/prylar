/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.integration;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.Smycke;

/**
 *
 * @author monde
 */
public class PrylSamlingTest {
  
  PrylSamling prylar = null;
  
 
    private static final String NAMN_PÅ_AKTIE = "googl";
    private static final int ANTAL = 10;
    private static final int PRIS = 100;
    private static final int ÄDELSTENFAKTOR = 700;
    private static final int VÄRDE = 1000;
    private static final int ANTAL_ÄDELSTENAR = 10;
    
    @Before
    public void setUp() {
      prylar = new PrylSamling();
    }
  
  

    @Test
    public void testLäggTillPryl() {
      prylar.läggTillPryl(new Aktie(NAMN_PÅ_AKTIE,ANTAL, PRIS));
      String result = prylar.toString();
      
      assertTrue("Pryl har inget namn!",result.contains("googl"));
    }

    @Test
    public void testSummaVärde() {
      prylar.läggTillPryl(new Aktie(NAMN_PÅ_AKTIE,ANTAL, PRIS));
      assertEquals(VÄRDE, prylar.summaVärde(), 0.1);
       
    }

    @Test
    public void testSetAktier() {
      prylar.läggTillPryl(new Aktie(NAMN_PÅ_AKTIE,ANTAL, PRIS));
      prylar.läggTillPryl(new Smycke("Halsband", "Platina", ANTAL_ÄDELSTENAR));
      prylar.setAktierTillNoll();
        
      assertEquals("Aktier har inte satts till noll!", 5700, prylar.summaVärde(), 0.1);
    }
}
