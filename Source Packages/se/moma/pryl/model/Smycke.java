package se.moma.pryl.model;

import java.util.Objects;
import se.moma.pryl.model.interfaces.Pryl;

/**
 *  Skapar ett <code>Smycke</code> som består av en <code>metall</code> och <code>ädelstenar</code>.
 * 
 *  @author monde
 */
public class Smycke extends Pryl {
    
    private String metall = null;
    private int ädelstenar;
    private static final int GULDFAKTOR = 2000;
    private static final int ÄDELSTENFAKTOR = 700;
    private static final int VÄRDE = 500;
    private static final int ANTAL_VÄRDESTENAR = 100;
    private static final String GULD = "guld";
    
    
    /**
     * Skapar ny <code>Smycke</code> instans.
     * 
     * @param namn Namn på <code>Smycke</code>.
     * @param metall Namn på metall av <code>Smycke</code>
     * @param ädelstenar Antal ädelstenar <code>Smycke</code> består av.
     */
    public Smycke(String namn, String metall, int ädelstenar) {
	super(namn);
        Objects.requireNonNull(metall, "Måste ange metall på smycke!");
        if (metall.equalsIgnoreCase("")) throw new IllegalArgumentException("Måste ange metall på smycke!");
	this.metall = metall;
        Objects.requireNonNull(ädelstenar, "Måste ange antal ädelstenar!");
	this.ädelstenar = ädelstenar;
    }	
    
    
    /**
     * Beräknar värdet på ett <code>Smycke</code>.
     * 
     * @return Värdet på ett <code>Smycke</code>.
     */
    @Override
    public int värde() {
	if(getMetall().equalsIgnoreCase(GULD)) {
		return (VÄRDE * getÄdelstenar()) + GULDFAKTOR;
        }
	return (VÄRDE * getÄdelstenar()) + ÄDELSTENFAKTOR;
	
    }
    
    
    /**
     * @return Teststrängrepresentation av <code>Smycke</code>. 
     */
    @Override
    public String toString() {
         return String.format("namn: %s, metall: %s, antal ädelstenar: %d, värde: %d", super.toString(),getMetall(),getÄdelstenar(), värde());
    }
    
    
    private String getMetall() {
        return metall;
    }

    
    private int getÄdelstenar() {
        return ädelstenar;
    }
    
    
    public static void main(String[] args) {
        System.out.println(new Smycke("pärlan", "platina", ANTAL_VÄRDESTENAR));
    }
}
