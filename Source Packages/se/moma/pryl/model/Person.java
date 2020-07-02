package se.moma.pryl.model;

import se.moma.pryl.model.interfaces.Pryl;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Skapar en <code>Person</code> med samling av <code>Pryl</code>.
 * 
 * @author monde
 */
public class Person {
    
    private final String namn;
    private String patt = "^[A-ZÅÄÖa-zåäö]+$";
    private Pattern p = Pattern.compile(patt);

    
    
    
    /**
     * Skapar en ny instans av <code>Person</code>.
     * 
     * @param namnPåPerson Namn på <code>Person</code>.
     */
    public Person(String namnPåPerson) {
      Objects.requireNonNull(namnPåPerson, "null");
      if (namnPåPerson.equals("")) throw new IllegalArgumentException("Måste ange ett namn!");
      Matcher m = p.matcher(namnPåPerson);
      if (!m.find()) throw new IllegalArgumentException(namnPåPerson + "...ett namn på en person måste bestå av bokstäver!");
      if (namnPåPerson.length() > 10) throw new IllegalArgumentException("Ett namn får bestå av max tio bokstäver.");
     
      this.namn = namnPåPerson;
    }
    
    
    /**
     * @return Namn på <code>Person</code>.
     */
    public String getNamn() {
      return namn;
    }
    
    @Override
    public String toString() {
      return getNamn();
    }
    
   

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 59 * hash + Objects.hashCode(this.namn);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Person other = (Person) obj;
    if (!Objects.equals(this.namn, other.namn)) {
      return false;
    }
    return true;
  }
  
   public static void main(String[] args) {
      Person person = new Person("Olle");
      System.out.println(person);
      Person person1 = new Person("Olle");
    
      assert person.equals(person1);
   }

}


