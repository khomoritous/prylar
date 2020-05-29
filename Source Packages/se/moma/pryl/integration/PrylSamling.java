/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.integration;

import java.util.ArrayList;
import java.util.List;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.Apparat;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.Smycke;
import se.moma.pryl.model.interfaces.Pryl;

/**
 *
 * @author monde
 */
public class PrylSamling {
  
  private List<Pryl> prylar = null;
  
    public PrylSamling() {
      prylar = new ArrayList<>();
    }
  
    /**
     * Lägger till <code>Pryl</code> till samling.
     * 
     * @param nyPryl Instans av <code>Pryl</code>.
     */
    public void läggTillPryl(Pryl nyPryl) {
      if (nyPryl == null) throw new IllegalArgumentException("Inget nullobjekts tillåts!");
      prylar.add(nyPryl);
    }
    
    /**
     * Beräknar värdet på en <code>PrylSamling</code> av <code>Pryl</code>.
     * 
     * @return Värdet på <code>PrylSamling</code>
     */
    public double summaVärde() {
      int totalSumma = 0;
	
      for(Pryl pryl: prylar) {
        totalSumma += pryl.getVärde();
      }
      return totalSumma;
    }
    
    /**
     * Sätter priset för <code>Pryl</code> <code>Aktie</code> till noll.
     * 
     */
    public void setAktierTillNoll() {
      for(Pryl pryl: prylar) {
        if(pryl instanceof Aktie) {
          ((Aktie) pryl).setPrisTillNoll();
        }
      }
    }   
    
    
    /**
     * En textrepresentation av <code>PrylSamling</code>.
     * 
     * @return En samling av <code>Pryl</code>. 
     */
    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      for(Pryl pryl: prylar) {
        stringBuilder.append(pryl.toString());
        stringBuilder.append("," + "\n");
      }
      return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
      
      PrylSamling ollesprylar = new PrylSamling();
      PrylSamling kallesprylar = new PrylSamling();
      
      
      ollesprylar.läggTillPryl(new Aktie("googl", 100, 10));
      ollesprylar.läggTillPryl(new Apparat("rost", 250, 2));
      
      kallesprylar.läggTillPryl(new Smycke("ring","platina", 3));
      kallesprylar.läggTillPryl(new Apparat("ugn", 1000, 3));
      
      System.out.println(ollesprylar);
      System.out.println(kallesprylar);
      
      System.out.println(ollesprylar.summaVärde());
    }
}
