package se.moma.pryl.integration;

import se.moma.pryl.model.Person;
import java.util.*;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.Apparat;
import se.moma.pryl.model.Smycke;

/**
 *  Skapar en <code>PersonSamling</code> av <code>Person</code>.
 * 
 *  @author monde
 */
public class PersonSamling {

    private Map<Person, PrylSamling> personSamling = null;
   
   
    /**
     * Skapar en instans av <code>PersonSamling</code>.
     * 
     */
    public PersonSamling() { 
      personSamling = new HashMap<>();
    }
    
    
    /**
     * Lägger till instans av <code>Person</code> till <code>PersonSamling</code>.
     * 
     * @param nyPerson Instans av <code>Person</code>.
     */
    public void läggTillPerson(String nyttNamn) {
      Objects.requireNonNull(nyttNamn,"Inget nullobjekt tillåts!");
      if (nyttNamn.equals("")) throw new IllegalArgumentException("Måste skriva namn på person!");
      Person nyPerson = new Person(nyttNamn);
      personSamling.put(nyPerson, new PrylSamling());
    } 
    
    
     /**
     * Hittar registrerad <code>Person</code> i <code>PersonSamling</code>.
     * 
     * @param namnPåPerson Namn på <code>Person</code> 
     * @return <code>True</code>, om <code>Person</code> hittats <code>False</code> annars.
     */
     public boolean hittaPerson(String namnPåPerson) {
       Objects.requireNonNull(namnPåPerson, "Inget nullobjekt tillåts!");
       if (namnPåPerson.equals("")) throw new IllegalArgumentException("Måste skriva namn på person!");
       if (personSamling.containsKey(new Person(namnPåPerson)))
         return true;
       return false;
     }
    
    
    
    /**
     * Hämtar <code>Person</code> i <code>PersonSamling</code>.
     * 
     * @param namnPåPerson Namn på <code>Person</code>.
     * @return Sökt <code>Person</code>, <code>null</code> annars.
     */
    public PrylSamling hämtaPrylSamlingTillPerson(String namnPåPerson) {
      Objects.requireNonNull(namnPåPerson,"Inget nullobjekt tillåts!");
      if (namnPåPerson.equals("")) throw new IllegalArgumentException("Måste skriva namn på person!");
      PrylSamling prylSamling = null;
      if (hittaPerson(namnPåPerson)) 
        prylSamling = personSamling.get(new Person(namnPåPerson));
      return prylSamling;
    }
      
    
    /**
     * Sätter värdet av <code>Aktie</code> till noll.
     */
//    public void börsKrasch() {
//      for(Person person: minaPersoner) {
//        person.setAktierTillNoll();
//      }
//    }
//    
    
    
   
    

    
    /**
     * Visar alla <code>Person</code> i <code>PersonSamling</code> med namn och värde på <code>PrylSamling</code> av <code>Pryl</code>.
     * 
     * @return Textsträngrepresentation av <code>Person</code> i <code>PersonSamling</code>.
     */
 //    public String visaAllaPersoner() {
//       StringBuilder stringBuilder = new StringBuilder();
//      Formatter formatter = new Formatter(stringBuilder);
//      for(Person person: minaPersoner) {
//        formatter.format("person: %s, totalsumma: %.1f \n", person.getNamn(), person.summaVärde());
//      }
//      return stringBuilder.toString();
//    }
//    

    /**
     * Hämtar <code>Person</code> med mest värdefulla samling av <code>Pryl</code> i <code>PersonSamling</code>.
     * 
     * @return <code>Person</code> <code>Person</code> värdefulla samling av <code>Pryl</code>. 
     */
//    public Person hämtaRikastePerson() {
//      minaPersoner.sort(new PersonVärdeComparator());
////      Comparator<Person> rikastePersonComparator = Comparator.comparing(Person::summaVärde);
////      Collections.sort(minaPersoner,rikastePersonComparator);
//      return minaPersoner.get(RIKASTE_PERSON);
//    }
   
    
    /**
     * @return Textsträngsrepresentation av <code>PersonSamling</code>. 
     */
//    @Override
//    public String toString() {
//      StringBuilder stringBuilder = new StringBuilder();
//      for(Person person: minaPersoner) {
//        stringBuilder.append(person.toString());
//      }
//      return stringBuilder.toString();
//    }
//    
    //kollar om Person är registrerad i PersonSamling.
//    private boolean isPersonPresent(Person person, String namnPåPerson) {
//       return person.getNamn().equals(namnPåPerson);
//    }
//    
    
    
    public static void main(String[] args) {
        PersonSamling personSamling = new PersonSamling();
       
        personSamling.läggTillPerson("Pelle");
        
        System.out.println(personSamling.hittaPerson("Pelle"));
        
        personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Smycke("halsband","platina", 2));
        personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Aktie("googl", 10, 10));
        personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Apparat("ugn", 1000, 3));
        
        
        System.out.println(personSamling.hämtaPrylSamlingTillPerson("Pelle"));
    }
}


