package se.moma.pryl.model;

import se.moma.pryl.model.interfaces.Pryl;
import java.util.*;


/**
 * Skapar en <code>Person</code> med samling av <code>Pryl</code>.
 * 
 * @author monde
 */
public class Person {
    
    private final String namn;
    private List<Pryl> minaPrylar = null;
    private static final String NAMN_PÅ_PERSON = "Pelle";
    private static final int PRIS_PÅ_PRYL = 1000;
    private static final int ANTAL_PRYLAR = 1000;
    private static final String NAMN = "googl";
    
    
    /**
     * Skapar en ny instans av <code>Person</code>.
     * 
     * @param namn Namn på <code>Person</code>.
     */
    public Person(String namn) {
      if (namn.equalsIgnoreCase("")) throw new IllegalArgumentException("Måste ange ett namn!");
      this.namn = namn;
      this.minaPrylar = new ArrayList<>();
    }
    
    
    /**
     * @return Namn på <code>Person</code>.
     */
    public String getNamn() {
      return namn;
    }
    
    
    /**
     * Lägger till <code>Pryl</code> till samling.
     * 
     * @param py Instans av <code>Pryl</code>.
     */
    public void läggTillPryl(Pryl py) {
      minaPrylar.add(py);
    }
    
    
    /**
     * Beräknar värdet på en <code>Person</code> samling av <code>Pryl</code>.
     * 
     * @return Totala värdet på samling av <code>Pryl</code>.
     */
    public double summaVärde() {
      int totalSumma = 0;
	
      for(Pryl py: minaPrylar) {
        totalSumma += py.getVärde();
      }
      return totalSumma;
    }

    
    /**
     * Sätter priset för <code>Aktie</code> till noll.
     * 
     */
    public void setAktierTillNoll() {
      for(Pryl pryl: minaPrylar) {
        if(pryl instanceof Aktie) {
          ((Aktie) pryl).setPrisTillNoll();
        }
      }
    }   
    
    
    
    /**
     * @return Textsträngrepresentation av namn på <code>Person</code > och samling av <code>Pryl</code>.
     */
    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("person: ");
      stringBuilder.append(this.getNamn());
      stringBuilder.append("\n");
      for(Pryl pryl: minaPrylar) {
        stringBuilder.append(pryl.toString());
        stringBuilder.append("," + "\n");
      }
      return stringBuilder.toString();
    }
    
    
    public static void main(String[] args) {
      Person person = new Person(NAMN_PÅ_PERSON);
      person.läggTillPryl(new Aktie(NAMN, PRIS_PÅ_PRYL, ANTAL_PRYLAR));
      person.läggTillPryl(new Apparat("rost", 1000, 2));
      System.out.println(person);
    }

}


