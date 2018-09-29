package se.moma.pryl.model;

import se.moma.pryl.model.interfaces.Pryl;
/**
 *  Skapar en <code>Apparat</code> med pris och slitage.
 *  @author monde
 */
public class Apparat extends Pryl {
    
    private final int pris;
    private final int slitage;
    private static final int SLITAGE_FAKTOR = 10;
    private static final int PRIS_PÅ_APPARAT = 5000;
    private static final int SLITAGE_PÅ_APPARAT = 6;
    
    
    /**
     * Skapar en ny instans.
     * @param namn Namn på <code>Apparat</code>.
     * @param pris Pris på <code>Apparat</code>.
     * @param slitage Slitage på <code>Apparat</code>.
     */
    public Apparat(String namn, int pris, int slitage) {
	super(namn);
	this.pris = pris;
	this.slitage = slitage;
    }

    
    /**
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
         return String.format("namn: %s, pris: %d, slitage: %d", super.toString(),getPris(), getSlitage(), värde());
    }
    
    
    /**
     * @return Pris på <code>Apparat</code>. 
     */
    public int getPris() {
        return pris;
    }

    
    /**
     * @return Slitage på <code>Apparat</code>. 
     */
    public int getSlitage() {
        return slitage;
    }
    
    
    public static void main(String[] args) {
        System.out.println(new Apparat("dator", PRIS_PÅ_APPARAT, SLITAGE_PÅ_APPARAT));
    }

    
}
