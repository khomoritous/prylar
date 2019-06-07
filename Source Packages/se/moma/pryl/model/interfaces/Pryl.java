package se.moma.pryl.model.interfaces;

import java.util.Objects;

/**
 * En <code>abstract</code> klass för <code>Pryl</code>.
 * 
 * @author monde
 */
public abstract class Pryl {
    
    private String namn = null;
    
    /**
     * Skapar namn för <code>Pryl</code>.
     * 
     * @param namn Namn på <code>Pryl</code>.
     */
    public Pryl(String namn) {
      Objects.requireNonNull(namn, "Måste ha ett namn!");
      if (namn.equalsIgnoreCase("")) throw new IllegalArgumentException("En pryl måste ha ett namn!");
	    this.namn = namn;
    }
    
    
    abstract protected int värde();
    
    /**
     * En <code>Pryl</code> har ett värde.
     * 
     * @return Värde på <code>Pryl</code>.
     */
    public int getVärde() {
      return värde();
    }
    
    /**
     * @return Textsträngrepresentation av <code>Pryl</code>.
     */
    @Override
    public String toString() {
      return ""+ namn; 
    }
}




