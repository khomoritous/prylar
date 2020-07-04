package se.moma.pryl.model;

import java.util.Objects;
import se.moma.pryl.model.interfaces.Pryl;

/**
 * Skapar en <code>Aktie</code> med <code>namn</code>, <code>pris</code> och <code>antal</code>.
 * 
 * @author monde
 */
public class Aktie extends Pryl {
    
    private final int antal;
    private int pris; 
    private static final String NAMN_PÅ_AKTIE = "googl"; 
    private static final int ANTAL_AKTIER = 1000000000;
    private static final int PRIS_PÅ_AKTIE = 1000000000;
    
    /**
     * Skapar en ny instans av <code>Aktie</code>. Antal måste vara större eller lika med 0. 
     * Pris får inte vara negativt.
     * 
     *
     * 
     * @param namn Namn på <code>Aktie</code>.
     * @param antal Antal <code>Aktie</code>.
     * @param pris Pris på <code>Aktie</code>.
     * 
     * @throws IllegalArgumentException om antal är mindre eller lika med 0. Om pris är mindre än 0.
     */
    public Aktie(String namn, int antal, int pris) {
	    super(namn);
      if (antal <= 0) throw new IllegalArgumentException("Antal aktier måste vara större än 0!");
	    this.antal = antal;
      if (pris < 0) throw new IllegalArgumentException("Priset på en aktie får inte vara mindre än 0!");
	    this.pris = pris;
    }
    
    /**
     * Beräknar värdet på en <code>Aktie</code>.
     * 
     * @return Värde på <code>Aktie</code>.
     */
    @Override
    public double värde() {
      return (long) antal*pris;
    }
    
    /**
     * Sätter pris för en <code>Aktie</code> till noll.
     */
    public void setPrisTillNoll() {
      pris = 0;
    }
    
    /**
     * @return TextSträngrepresentation av <code>Aktie</code>.
     */
    @Override
    public String toString() { 
      return String.format("namn: %s, antal: %d, pris: %d, värde: %.1f", super.toString(), getAntal(), getPris(), värde());
    }
    
    
    
    private int getAntal() {
      return antal;
    }
    
    
    
    private int getPris() {
      return pris;
    }
    
    public static void main(String[] args) {
      System.out.println(new Aktie(NAMN_PÅ_AKTIE, ANTAL_AKTIER, PRIS_PÅ_AKTIE));
    }
    
}


