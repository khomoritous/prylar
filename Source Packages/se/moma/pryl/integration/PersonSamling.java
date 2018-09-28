package se.moma.pryl.integration;

import se.moma.pryl.model.Person;
import java.util.*;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.util.PersonVärdeComparator;

/**
 * Skapar en samling av <code>Person</code>.
 * @author monde
 */
public class PersonSamling {

    private List<Person> minaPersoner = null;
    private static final int RIKASTE_PERSON = 0;
   
    /**
     * Skapar en ny instans.
     * @param minaPersoner Instans av <code>List<Person></code>.
     */
    public PersonSamling(List<Person> minaPersoner) {
	this.minaPersoner = minaPersoner;
        this.minaPersoner = new ArrayList<>();
    }
    
    /**
     * @param py Instans av <code>Person</code>.
     */
    public void laggTillPerson(Person py) {
	minaPersoner.add(py);
    }
    
    
    /**
     * Sätter <code>Aktie</code> till noll.
     */
    public void börsKrasch() {
        for(Person person: minaPersoner) {
            person.setAktierTillNoll();
        }
    }
    
    /**
     * 
     * @param namnPåPerson Namn på <code>Person</code> 
     * @return <code>True</code>, om <code>Person</code> hittats. <code>False</code>, annars
     * 
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
     * @return Textsträngrepresentation av alla <code>Person</code> i samling med 
     * namn och värde på <code>Pryl</code> i samling.
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
     * @return <code>Person</code> med mest värdefulla samling av <code>Pryl</code>. 
     */
    public Person hämtaRikaste() {
        minaPersoner.sort(new PersonVärdeComparator());
        return minaPersoner.get(RIKASTE_PERSON);
    }
   
	
    

    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
                for(Person person: minaPersoner) {
                    stringBuilder.append(person.toString());
                    stringBuilder.append("\n");
                }
        return stringBuilder.toString();
    }
    
    
    private boolean isPersonPresent(Person person, String namnPåPerson) {
       return person.getNamn().equals(namnPåPerson);
    }
    
    
    public static void main(String[] args) {
        PersonSamling personSamling = new PersonSamling(new ArrayList<>());
        Person person = new Person("Olle", new ArrayList<>());
        person.läggTillPryl(new Aktie("googl", 1000, 1000));
        personSamling.laggTillPerson(person);
        System.out.println(personSamling);
        System.out.println(personSamling.visaAlla());
    }
}


