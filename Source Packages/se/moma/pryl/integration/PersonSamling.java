package se.moma.pryl.integration;

import se.moma.pryl.model.Person;
import java.util.*;
import static java.util.Comparator.comparing;
import se.moma.pryl.model.interfaces.Pryl;
import se.moma.pryl.util.PersonVärdeComparator;

/**
 *  Skapar en <code>PersonSamling</code> av <code>Person</code>.
 * 
 *  @author monde
 */
public class PersonSamling {

    private List<Person> minaPersoner = null;
    private static final int RIKASTE_PERSON = 0;
   
   
    /**
     * Skapar en instans av <code>PersonSamling</code>.
     * 
     */
    public PersonSamling() { 
      this.minaPersoner = new ArrayList<>();
    }
    
    
    /**
     * Lägger till instans av <code>Person</code> till <code>PersonSamling</code>. 
     * 
     * @param person Instans av <code>Person</code>.
     */
    public void läggTillPerson(Person person) {
      Objects.requireNonNull(person);
      minaPersoner.add(person);
    }
    
    
    /**
     * Sätter <code>Pryl</code> av typ <code>Aktie</code> till noll.
     */
    public void börsKrasch() {
      for(Person person: minaPersoner) {
        person.setAktierTillNoll();
      }
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
        formatter.format("person: %s, totalsumma: %f \n", person.getNamn(), person.summaVärde());
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
        //List<Pryl> prylLista = null;
        personSamling.läggTillPerson(new Person("Olle"));
        personSamling.läggTillPerson(new Person("Pelle"));
        
        //System.out.println(personSamling);
        System.out.println(personSamling.visaAllaPersoner());
    }
}


