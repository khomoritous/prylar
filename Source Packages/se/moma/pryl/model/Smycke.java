package se.moma.pryl.model;

import se.moma.pryl.model.interfaces.Pryl;

/**
 *  Skapar ett <code>Smycke</code> som består av en metall och ädelstenar.
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
     * Skapar ny instans.
     * @param namn Namn på <code>Smycke</code>.
     * @param metall Namn på metall av <code>Smycke</code>
     * @param ädelstenar Antal ädelstenar <code>Smycke</code> består av.
     */
    public Smycke(String namn, String metall, int ädelstenar) {
	super(namn);
	this.metall = metall;
	this.ädelstenar = ädelstenar;
    }	
    
    
    /**
     * @return Namn på metall på <code>Smycke</code>
     */
    public String getMetall() {
        return metall;
    }

    
    /**
     * @return  Antal ädelstenar på <code>Smycke</code>.
     */
    public int getÄdelstenar() {
        return ädelstenar;
    }
    
    
    /**
     * @return Värdet på <code>Smycke</code>
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
    
    
    public static void main(String[] args) {
        System.out.println(new Smycke("pärlan", "platina", ANTAL_VÄRDESTENAR));
    }
}
