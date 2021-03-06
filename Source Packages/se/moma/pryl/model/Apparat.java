package se.moma.pryl.model;

import se.moma.pryl.model.interfaces.Pryl;

/**
 *  Skapar en <code>Apparat</code> med <code>pris</code> och <code>slitage</code>.
 * 
 *  @author monde
 */
public class Apparat extends Pryl {
    
    private final double pris;
    private final int slitage;
    private static final double SLITAGE_FAKTOR = 10;
    private static final double PRIS_PÅ_APPARAT = 5000;
    private static final int SLITAGE_PÅ_APPARAT = 6;
    private static final String NAMN_PÅ_APPARAT = "dator";
    
    
    /**
     * Skapar en ny instans av <code>Apparat</code>. Pris måste större eller lika med 0. Slitage måste
     * vara större eller lika med 0. 
     * 
     * 
     * 
     * @param namn Namn på <code>Apparat</code>.
     * @param pris Pris på <code>Apparat</code>.
     * @param slitage Slitage på <code>Apparat</code>.
     * 
     * @throws IllegalArgumentException om pris är mindre eller lika med 0, om slitage är mindre 
     * eller lika med 0.
     */
    public Apparat(String namn, double pris, int slitage) {
	    super(namn);
      if (pris <= 0) throw new IllegalArgumentException("Ange pris större än 0!");
	    this.pris = pris;
      if (slitage <= 0 ) throw new IllegalArgumentException("Ange slitage större än 0!");
	    this.slitage = slitage;
    }

    
    /**
     * Beräknar värde på <code>Apparat</code>.
     * 
     * @return Värde på <code>Apparat</code>.
     */
    @Override
    public double värde() {
	    return (long) getPris() * (getSlitage() / SLITAGE_FAKTOR);
    }
    
    
    /**
     * @return Textsträngrepresentation av <code>Apparat</code>.
     */
    @Override
    public String toString() {
      return String.format("namn: %s, pris: %.1f, slitage: %d, värde: %.1f", super.toString(),getPris(), getSlitage(), värde());
    }
    
    
    private double getPris() {
      return pris;
    }

    
    
    private int getSlitage() {
      return slitage;
    }
    
    
    public static void main(String[] args) {
      Apparat apparat = new Apparat(NAMN_PÅ_APPARAT, PRIS_PÅ_APPARAT, SLITAGE_PÅ_APPARAT);
      System.out.println(apparat);
      
    }

    
}
