package se.moma.pryl.model;

import se.moma.pryl.model.interfaces.Pryl;
import java.util.*;


/**
 * Skapar en <code>Person</code>  med samling av <code>Pryl</code>.
 * @author monde
 */
public class Person {
    
    private final String namn;
    private List<Pryl> minaPrylar = null;
    private static final String NAMN_PÅ_PERSON = "Pelle";
    private static final int PRIS_PÅ_PRYL = 1000;
    private static final int ANTAL_PRYLAR = 1000;
    private static final String NAMN = "googl";
    
    
    /**
     * Skapar en ny instans.
     * @param namn Namn på <code>Person</code>.
     * @param minaPrylar Instans av <code> List<Pryl> </code>.
     */
    public Person(String namn, List<Pryl> minaPrylar) {
	this.namn = namn;
	this.minaPrylar = minaPrylar;
        this.minaPrylar = new ArrayList<>();
       
        
    }
    
    /*
    /**
     * @return Namn på <code>Person</code>.
     */
    public String getNamn() {
	return namn;
    }
    
    /**
     * Lägger till <code>Pryl</code> till samling.
     * @param py Instans av <code>Pryl</code>.
     */
    public void läggTillPryl(Pryl py){
	minaPrylar.add(py);
    }
    
    /**
     * @return Totala värdet på samling av <code>Pryl</code>.
     */
    public int summaVärde() {
	int totalSumma = 0;
	
        for(Pryl py: minaPrylar) {
            totalSumma += py.getVärde();
        }
        return totalSumma;
    }

    /**
     * Sätter <code>Aktie</code> till noll.
     */
    public void setAktierTillNoll() {
        for(Pryl pryl: minaPrylar) {
            if(pryl instanceof Aktie) {
                ((Aktie) pryl).setPrisTillNoll();
            }
        }
    }   
    
    
    
    /**
     * @return <code>Pryl</code> samling.
     */
    @Override
    public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("person: ");
          stringBuilder.append(this.getNamn());
          stringBuilder.append("\n");
           for(Pryl pryl: minaPrylar) {
                stringBuilder.append(pryl.toString());
                stringBuilder.append(",");
            }
	return stringBuilder.toString();
    }
    
    
    public static void main(String[] args) {
        Person person = new Person(NAMN_PÅ_PERSON, new ArrayList<>());
        person.läggTillPryl(new Aktie(NAMN, PRIS_PÅ_PRYL, ANTAL_PRYLAR));
        System.out.println(person);
    }

}


