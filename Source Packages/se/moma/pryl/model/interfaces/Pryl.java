package se.moma.pryl.model.interfaces;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * En <code>abstract</code> klass för <code>Pryl</code>. Subklasser går att skapa genom 
 * att ärva egenskaper från denna. 
 * 
 * @author monde
 */
public abstract class Pryl {
  
  
    private String namn = null;
    private String patt = "^[A-ZÅÄÖa-zåäö]+$";
    private Pattern p = Pattern.compile(patt);
   
    
    /**
     * Skapar instans av <code>Pryl</code>.
     * Namn får inte vara null, måste ha ett namn, måste bestå av max tio tecken som måste vara bokstäver.
     * 
     * 
     * 
     * @param namn Namn på <code>Pryl</code>.
     * 
     * @throws NullPointerException om namn är null.
     * @throws IllegalArgumentException om namn inte har ett namn, består av mer än 10 tecken som inte 
     * är bokstäver.
     */
    public Pryl(String namn) {
      Objects.requireNonNull(namn, "Inga nullobjekt tillåts!");
      if (namn.equals("")) throw new IllegalArgumentException("En pryl måste ha ett namn!");
      Matcher m = p.matcher(namn);
      if (!m.find()) throw new IllegalArgumentException(namn + "...ett namn på en pryl måste bestå av bokstäver!");
      if (namn.length() > 10) throw new IllegalArgumentException("Ett namn får bestå av max tio bokstäver.");
      this.namn = namn;
    }
    
    
    
    abstract protected double värde();
    
    /**
     * En <code>Pryl</code> har ett värde.
     * 
     * @return Värde på <code>Pryl</code>.
     */
    public double getVärde() {
      return värde();
    }
    
    private String getNamn() {
      return namn;
    }
    
    /**
     * @return Textsträngrepresentation av <code>Pryl</code>.
     */
    @Override
    public String toString() {
      return ""+ getNamn(); 
    }
}




