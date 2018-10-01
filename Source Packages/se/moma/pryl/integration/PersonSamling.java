package se.moma.pryl.integration;

import se.moma.pryl.model.Person;
import java.util.*;
import se.moma.pryl.model.interfaces.Pryl;
import se.moma.pryl.util.PersonVärdeComparator;

/**
 *  Skapar en samling av <code>Person</code>.
 * 
 *  @author monde
 */
public class PersonSamling {

    private List<Person> minaPersoner = null;
    private static final int RIKASTE_PERSON = 0;
   
   
    /**
     * Skapar en instans av <code>PersonSamling</code>.
     * 
     * @param minaPersoner Instans av <code>List</code> av <code>Person</code>.
     */
    public PersonSamling(List<Person> minaPersoner) { 
      this.minaPersoner = minaPersoner;
      this.minaPersoner = new ArrayList<>();
    }
    
    
    /**
     * Registrerar instans av <code>Person</code>. 
     * 
     * @param py Instans av <code>Person</code>.
     */
    public void laggTillPerson(Person py) {
      minaPersoner.add(py);
    }
    
    
    /**
     * Sätter <code>Pryl</code> av <code>Aktie</code> till noll.
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
      for(Person person: minaPersoner) {
        if(isPersonPresent(person, namnPåPerson)) {
          return person;
        }
      }
      return null;
    }
    

    
    /**
     * Visar alla <code>Person</code> i <code>PersonSamling</code>.
     * 
     * @return Textsträngrepresentation av <code>Person</code> i <code>PersonSamling</code>.
     */
    public String visaAlla() {
      StringBuilder stringBuilder = new StringBuilder();
      Formatter formatter = new Formatter(stringBuilder);
      for(Person person: minaPersoner) {
        formatter.format("person: %s, totalsumma: %d \n", person.getNamn(), person.summaVärde());
      }
      return stringBuilder.toString();
    }
    

    /**
     * Hämtar <code>Person</code> med mest värdefulla samling av <code>Pryl</code>.
     * 
     * @return <code>Person</code> <code>Person</code> värdefulla samling av <code>Pryl</code>. 
     */
    public Person hämtaRikaste() {
      minaPersoner.sort(new PersonVärdeComparator());
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
    
    
    private boolean isPersonPresent(Person person, String namnPåPerson) {
       return person.getNamn().equals(namnPåPerson);
    }
    
    
    
    public static void main(String[] args) {
        List<Person> personLista = null;
        PersonSamling personSamling = new PersonSamling(personLista);
        List<Pryl> prylLista = null;
        personSamling.laggTillPerson(new Person("Olle", prylLista));
        personSamling.laggTillPerson(new Person("Pelle",prylLista));
        System.out.println(personSamling);
        System.out.println(personSamling.visaAlla());
    }
}


