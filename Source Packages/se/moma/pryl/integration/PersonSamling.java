package se.moma.pryl.integration;

import se.moma.pryl.model.Person;
import java.util.*;
import static java.util.Comparator.comparing;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.Apparat;
import se.moma.pryl.model.Smycke;
import se.moma.pryl.model.interfaces.Pryl;
import se.moma.pryl.util.PersonVärdeComparator;

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
    public void läggTillPerson(Person nyPerson) {
      if (nyPerson == null) throw new IllegalArgumentException("Inget nullobjekt tillåts!");
      personSamling.put(nyPerson, new PrylSamling());
    }
    
    /**
     * Hittar registrerad <code>Person</code> i <code>PersonSamling</code>.
     * 
     * @param namnPåPerson Namn på <code>Person</code> 
     * @return <code>True</code>, om <code>Person</code> hittats. <code>False</code>, annars.
     */
    public boolean hittaPerson(String namnPåPerson) {
      Objects.requireNonNull(namnPåPerson);
      for(Person person: minaPersoner) {
        if(isPersonPresent(person, namnPåPerson)) {
          return true;
        }
      }
      return false;
    }
    
    
    
    /**
     * Sätter värdet av <code>Aktie</code> till noll.
     */
    public void börsKrasch() {
      for(Person person: minaPersoner) {
        person.setAktierTillNoll();
      }
    }
    
    
    
   
    /**
     * Hämtar <code>Person</code> i <code>PersonSamling</code>.
     * 
     * @param namnPåPerson Namn på <code>Person</code>.
     * @return Sökt <code>Person</code>, <code>null</code> annars.
     */
    public Person hämtaPerson(String namnPåPerson) {
      Objects.requireNonNull(namnPåPerson);
      for(Person person: minaPersoner) {
        if(isPersonPresent(person, namnPåPerson)) {
          return person;
        }
      }
      return null;
    }
    

    
    /**
     * Visar alla <code>Person</code> i <code>PersonSamling</code> med namn och värde på samling av <code>Pryl</code>.
     * 
     * @return Textsträngrepresentation av <code>Person</code> i <code>PersonSamling</code>.
     */
    public String visaAllaPersoner() {
      StringBuilder stringBuilder = new StringBuilder();
      Formatter formatter = new Formatter(stringBuilder);
      for(Person person: minaPersoner) {
        formatter.format("person: %s, totalsumma: %.1f \n", person.getNamn(), person.summaVärde());
      }
      return stringBuilder.toString();
    }
    

    /**
     * Hämtar <code>Person</code> med mest värdefulla samling av <code>Pryl</code> i <code>PersonSamling</code>.
     * 
     * @return <code>Person</code> <code>Person</code> värdefulla samling av <code>Pryl</code>. 
     */
    public Person hämtaRikastePerson() {
      minaPersoner.sort(new PersonVärdeComparator());
//      Comparator<Person> rikastePersonComparator = Comparator.comparing(Person::summaVärde);
//      Collections.sort(minaPersoner,rikastePersonComparator);
      return minaPersoner.get(RIKASTE_PERSON);
    }
   
    
    /**
     * @return Textsträngsrepresentation av <code>PersonSamling</code>. 
     */
    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      for(Person person: minaPersoner) {
        stringBuilder.append(person.toString());
      }
      return stringBuilder.toString();
    }
    
    //kollar om Person är registrerad i PersonSamling.
    private boolean isPersonPresent(Person person, String namnPåPerson) {
       return person.getNamn().equals(namnPåPerson);
    }
    
    
    
    public static void main(String[] args) {
        //List<Person> personLista = null;
        PersonSamling personSamling = new PersonSamling();
        //List<Pryl> prylLista = null
        Person olle = new Person("Olle");
        Person pelle = new Person("Pelle");
        
        personSamling.läggTillPerson(olle);
        personSamling.läggTillPerson(pelle);
        
        olle.läggTillPryl(new Smycke("ring", "guld", 1));
        olle.läggTillPryl(new Apparat("brödost", 500, 2));
        olle.läggTillPryl(new Aktie("googl", 10, 150));
        
        
        pelle.läggTillPryl(new Smycke("halsband","platina", 1));
        pelle.läggTillPryl(new Apparat("ugn", 2000, 3));
        pelle.läggTillPryl(new Aktie("Ikea", 15, 50));
        
        
        //System.out.println(personSamling);
        System.out.println(personSamling.visaAllaPersoner());
    }
}


