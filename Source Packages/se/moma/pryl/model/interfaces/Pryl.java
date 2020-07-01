package se.moma.pryl.model.interfaces;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * En <code>abstract</code> klass för <code>Pryl</code>.
 * 
 * @author monde
 */
public abstract class Pryl {
  
  
    private String namn = null;
    private String patt = "^[A-ZÅÄÖa-zåäö]+$";
    private Pattern p = Pattern.compile(patt);
    //compile(patt, Pattern.UNICODE_CHARACTER_CLASS)
    
    /**
     * Skapar namn för <code>Pryl</code>.
     * 
     * @param namn Namn på <code>Pryl</code>.
     */
    public Pryl(String namn) {
      Objects.requireNonNull(namn, "Inga nullobjekt tillåts!");
      if (namn.equals("")) throw new IllegalArgumentException("En pryl måste ha ett namn!");
      Matcher m = p.matcher(namn);
      if (!m.find()) throw new IllegalArgumentException(namn + "...ett namn på en pryl måste bestå av bokstäver!");
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




