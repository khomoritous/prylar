package se.moma.pryl.model.interfaces;
/**
 * Abstract klass och interface för <code>Pryl</code>.
 * @author monde
 */
public abstract class Pryl {
    
    private String namn = null;
    
    /**
     * Skapar namn för <code>Pryl</code>.
     * @param namn Namn på <code>Pryl</code>.
     */
    public Pryl(String namn) {
	this.namn = namn;
    }
    
    
    abstract protected int värde();
    
    /**
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




