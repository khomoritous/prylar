package se.moma.pryl.model;

import se.moma.pryl.model.interfaces.Pryl;

/**
 *  Skapar en <code>Apparat</code> med <code>pris</code> och <code>slitage</code>.
 * 
 *  @author monde
 */
public class Apparat extends Pryl {
    
    private final int pris;
    private final int slitage;
    private static final int SLITAGE_FAKTOR = 10;
    private static final int PRIS_PÅ_APPARAT = 5000;
    private static final int SLITAGE_PÅ_APPARAT = 6;
    
    
    /**
     * Skapar en ny instans av <code>Apparat</code>.
     * 
     * @param namn Namn på <code>Apparat</code>.
     * @param pris Pris på <code>Apparat</code>.
     * @param slitage Slitage på <code>Apparat</code>.
     */
    public Apparat(String namn, int pris, int slitage) {
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
    public int värde() {
	    return (getSlitage() / SLITAGE_FAKTOR) * getPris();
    }
    
    
    /**
     * @return Textsträngrepresentation av <code>Apparat</code>.
     */
    @Override
    public String toString() {
      return String.format("namn: %s, pris: %d, slitage: %d, värde: %d", super.toString(),getPris(), getSlitage(), värde());
    }
    
    
    private int getPris() {
      return pris;
    }

    
    
    private int getSlitage() {
      return slitage;
    }
    
    
    public static void main(String[] args) {
      System.out.println(new Apparat("dator", PRIS_PÅ_APPARAT, SLITAGE_PÅ_APPARAT));
    }

    
}
