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
    private static final int ANTAL_AKTIER = 100;
    private static final int PRIS_PÅ_AKTIE = 1000;
    
    /**
     * Skapar en ny <code>Aktie</code> instans.
     * 
     * @param namn Namn på <code>Aktie</code>.
     * @param antal Antal <code>Aktie</code>.
     * @param pris Pris på <code>Aktie</code>.
     */
    public Aktie(String namn, int antal, int pris) {
	super(namn);
        Objects.requireNonNull(antal, "Måste ange antal aktier!");
	this.antal = antal;
        Objects.requireNonNull(pris, "Måste ange pris på aktier!");
	this.pris = pris;
    }
    
    /**
     * Beräknar värdet på en <code>Aktie</code>.
     * 
     * @return Värde på <code>Aktie</code>.
     */
    @Override
    public int värde() {
        return antal*pris;
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
        return String.format("namn: %s, antal: %d, pris: %d, värde: %d", super.toString(), getAntal(), getPris(), värde());
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


