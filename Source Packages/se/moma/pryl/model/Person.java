package se.moma.pryl.model;

import se.moma.pryl.model.interfaces.Pryl;
import java.util.*;


/**
 * Skapar en <code>Person</code> med samling av <code>Pryl</code>.
 * 
 * @author monde
 */
public class Person {
    
    private final String namn;
    
    
    
    /**
     * Skapar en ny instans av <code>Person</code>.
     * 
     * @param namn Namn på <code>Person</code>.
     */
    public Person(String namn) {
      if (namn.equals("")) throw new IllegalArgumentException("Måste ange ett namn!");
      this.namn = namn;
    }
    
    
    /**
     * @return Namn på <code>Person</code>.
     */
    public String getNamn() {
      return namn;
    }
    
    public String toString() {
      return getNamn();
    }
    
    public static void main(String[] args) {
      Person person = new Person("Olle");
      System.out.println(person);
    }

}


