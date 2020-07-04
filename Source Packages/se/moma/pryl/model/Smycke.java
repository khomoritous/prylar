package se.moma.pryl.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import se.moma.pryl.model.interfaces.Pryl;

/**
 *  Skapar ett <code>Smycke</code> som består av en metall, ädelstenar och ett namn.
 *  Ärver från <code>Pryl</code>.
 * 
 *  @author monde
 */
public class Smycke extends Pryl {
    
    private String metall = null;
    private String namn = null;
    private int ädelstenar;
    
    private static final String METALL = "platina";
    private static final String NAMN = "pärlan";
    private static final int GULDFAKTOR = 2000;
    private static final int ÄDELSTENFAKTOR = 700;
    private static final int VÄRDE = 500;
    private static final int ANTAL_ÄDELSTENAR = 2;
    private static final String GULD = "guld";
    
    private String patt = "^[A-ZÅÄÖa-zåäö]+$";
    private Pattern p = Pattern.compile(patt);
    
    
    /**
     * Skapar ny <code>Smycke</code> instans. Metall får inte vara null. Måste ha ett namn. Måste bestå av max 15 tecken 
     * som alla måste vara bokstäver. Ädelstenar får inte vara negativt. 
     * 
     * 
     * 
     * @param namn Namn på <code>Smycke</code>.
     * @param metall Namn på metall av <code>Smycke</code>
     * @param ädelstenar Antal ädelstenar som <code>Smycke</code> består av.
     * 
     * @throws IllegalArgumentException om metall inte har ett namn, består av mer än 15 tecken som 
     * inte är bokstäver och antal ädelstenar är mindre än 0.
     */
    public Smycke(String namn, String metall, int ädelstenar) {
	    super(namn);
      Objects.requireNonNull(metall, "Nullobjekt tillåts inte!");
      if (metall.equals("")) throw new IllegalArgumentException("Måste ange metall på smycke!");
      Matcher m = p.matcher(metall);
      if (!m.find()) throw new IllegalArgumentException(metall + "...ett namn på en metall måste bestå av bokstäver!");
      if (metall.length() > 15) throw new IllegalArgumentException("Ett namn får bestå av max 15 bokstäver.");
	    this.metall = metall;
      if (ädelstenar < 0) throw new IllegalArgumentException("Antal ädelstenar får inte vara negativt!");
	    this.ädelstenar = ädelstenar;
    }	
    
    
    /**
     * Beräknar värdet på ett <code>Smycke</code>.
     * 
     * @return Värdet på ett <code>Smycke</code>.
     */
    @Override
    public double värde() {
	    if(getMetall().equalsIgnoreCase(GULD)) {
		    return ((long) VÄRDE * getÄdelstenar()) + GULDFAKTOR;
      } else { 
	        return ((long) VÄRDE * getÄdelstenar()) + ÄDELSTENFAKTOR;
        }
    }
    
    
    /**
     * @return Teststrängrepresentation av <code>Smycke</code>. 
     */
    @Override
    public String toString() {
      return String.format("namn: %s, metall: %s, antal ädelstenar: %d, värde: %.1f", super.toString(), getMetall(), getÄdelstenar(), värde());
    }
    
    
    private String getMetall() {
      return metall;
    }

    
    private int getÄdelstenar() {
      return ädelstenar;
    }
    
    
    public static void main(String[] args) {
      System.out.println(new Smycke(NAMN, METALL, ANTAL_ÄDELSTENAR));
      
      //System.out.println(new Smycke("ring", "silver", -1));
    }
}
