package se.moma.pryl.integration;

import se.moma.pryl.model.Person;
import java.util.*;
import static java.util.stream.Collectors.toMap;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.Apparat;
import se.moma.pryl.model.Smycke;
import se.moma.pryl.util.PrylSamlingComparator;

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
     * @param nyttNamn Namn på <code>Person</code>.
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
     public boolean isPersonRegistrerad(String namnPåPerson) {
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
      if (isPersonRegistrerad(namnPåPerson)) 
        prylSamling = personSamling.get(new Person(namnPåPerson));
      return prylSamling;
    }
      
    
    /**
     * Sätter värdet av <code>Aktie</code> till noll.
     */
    public void börsKrasch() {
      personSamling.values().forEach(aktie -> aktie.setAktierTillNoll());
    }
    
    
    /**
     * Hämtar <code>Person</code> med mest värdefulla samling av <code>Pryl</code> i <code>PersonSamling</code>.
     * 
     * @return <code>Person</code> <code>Person</code> värdefulla samling av <code>Pryl</code>. 
     */
    public Map<Person, PrylSamling> hämtaRikastePerson() {
     Map<Person, PrylSamling> sorterad = personSamling.entrySet()
             .stream()
             .sorted(Map.Entry.<Person, PrylSamling>comparingByValue(new PrylSamlingComparator()).reversed())
             .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
     return sorterad;
    }
   
    
    /**
     * Visar alla <code>Person</code> i <code>PersonSamling</code> med namn och värde på <code>PrylSamling</code> av <code>Pryl</code>.
     * 
     * @return Textsträngrepresentation av <code>Person</code> i <code>PersonSamling</code>.
     */
   /*  public String visaAllaPersoner() {
      StringBuilder stringBuilder = new StringBuilder();
      Formatter formatter = new Formatter(stringBuilder);
      personSamling.entrySet().forEach(entry -> entry.toString());
      
      formatter.format("person: %s, totalsumma: %.1f \n", person.getNamn(), person.summaVärde());
      
    } */
   

  
    
    /**
     * @return Textsträngsrepresentation av <code>PersonSamling</code>. 
     */
    @Override
    public String toString() {
      StringBuilder stringBuilderPerson = new StringBuilder();
      Formatter formatterPerson = new Formatter(stringBuilderPerson);
      StringBuilder stringBuilderPrylSamling = new StringBuilder();
      Formatter formatterPrylSamling = new Formatter(stringBuilderPrylSamling);
      personSamling.keySet().forEach((person) -> {
        formatterPerson.format("person: %s\n", person.getNamn());
      });
      personSamling.values().forEach((prylSamling) -> {
        formatterPrylSamling.format("prylsamling -> %s\n", prylSamling.toString());
      });
      
      return stringBuilderPerson.toString() + "\n" + stringBuilderPrylSamling.toString();
    }

    
    
    public static void main(String[] args) {
      PersonSamling personSamling = new PersonSamling();
       
      personSamling.läggTillPerson("Pelle");
        
      System.out.println(personSamling.isPersonRegistrerad("Pelle"));
        
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Smycke("halsband","platina", 2));
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Aktie("googl", 10, 10));
      personSamling.hämtaPrylSamlingTillPerson("Pelle").läggTillPryl(new Apparat("ugn", 1000, 3));
        
        
      System.out.println(personSamling.hämtaPrylSamlingTillPerson("Pelle"));
      
      personSamling.läggTillPerson("Ludde");
      
      personSamling.hämtaPrylSamlingTillPerson("Ludde").läggTillPryl(new Smycke("ring","guld", 4));
      personSamling.hämtaPrylSamlingTillPerson("Ludde").läggTillPryl(new Aktie("AAPL", 10, 10));
      personSamling.hämtaPrylSamlingTillPerson("Ludde").läggTillPryl(new Apparat("skärm", 1500, 4));
       
     
      System.out.println(personSamling.hämtaPrylSamlingTillPerson("Ludde"));
      
      personSamling.börsKrasch();
      System.out.println(personSamling.hämtaPrylSamlingTillPerson("Pelle"));
      System.out.println(personSamling.hämtaPrylSamlingTillPerson("Ludde"));
      
      System.out.println(personSamling.hämtaPrylSamlingTillPerson("Pelle").summaVärde());
      System.out.println(personSamling.hämtaPrylSamlingTillPerson("Ludde").summaVärde());
      
      
      System.out.println(personSamling);
      
      System.out.println(personSamling.hämtaRikastePerson());
      
      System.out.println(personSamling);    
       
    }
}


