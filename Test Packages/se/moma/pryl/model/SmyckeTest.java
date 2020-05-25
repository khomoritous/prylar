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
public class SmyckeTest {
    
    private Smycke smycke = null;
    private Smycke guldSmycke = null;
    private final static String TYP_AV_SMYCKE = "Halsband";
    private final static String METALL = "Platina";
    private final static String NotValidMetall = "";
    private final static String METALL_GULD = "Guld";
    private final static int ANTAL_ÄDELSTENAR = 10;
    private final static int NON_VALID_ANTAL_ÄDELSTENAR = -1;
    private final static int ÄDELSTEN_FAKTOR = 700;
    private final static int ÄDELSTEN_VÄRDE = 500;
    private final static int GULDFAKTOR = 2000;
    
    
    @Before
    public void setUp() {
      smycke = new Smycke(TYP_AV_SMYCKE, METALL, ANTAL_ÄDELSTENAR);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructorShouldThrowIAEForNonValidMetall() {
      new Smycke(TYP_AV_SMYCKE,NotValidMetall,ANTAL_ÄDELSTENAR);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructorShouldThrowIAEForNonValidAntalÄdelstenar() {
      new Smycke(TYP_AV_SMYCKE,METALL,NON_VALID_ANTAL_ÄDELSTENAR);
    }
    

    @Test
    public void testGetValue() {
      assertEquals((ÄDELSTEN_VÄRDE * ANTAL_ÄDELSTENAR) + 700, smycke.värde(), 0.1);
    }
   
    @Test
    public void testGetValueWhenGold() {
      guldSmycke = new Smycke(TYP_AV_SMYCKE,METALL_GULD, ANTAL_ÄDELSTENAR);
      assertEquals((ÄDELSTEN_VÄRDE * ANTAL_ÄDELSTENAR ) + GULDFAKTOR, guldSmycke.värde(), 0.1);
    }

    
    
}
