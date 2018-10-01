package se.moma.pryl.startup;

import java.util.*;
import se.moma.pryl.controller.Controller;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.factory.PrylFactory;

public class Main {
    
    public static void main(String[] args)  {
        List<Person> lista = null;
        PrylFactory prylfactory = null;
        Map<String, String> prylargs = new HashMap<>();
        PersonSamling personsamling = new PersonSamling(lista);
        
        Controller controller = new Controller(personsamling, prylfactory);
	
        Scanner sc = new Scanner(System.in);
        System.out.print("Namn på en person: ");
        String namn = sc.nextLine();
        //prylargs.put("namn", namn);
        controller.skapaPerson(namn);
        
        
        
        /*
        System.out.println("Vad heter personen som ska äga prylen? ");
        String namnpåperson = sc.nextLine();
        System.out.println("Vad för sorts pryl ska skapas? ");
     
        String namnpåpryl = sc.nextLine();
        if(namnpåpryl.equalsIgnoreCase("Smycke")) {
            System.out.print("Vilket sorts smycke? ");
	    String smycke  = sc.nextLine();
	    System.out.print("Vilken metall är smycket gjord av? ");
	    String metall = sc.nextLine();
	    System.out.print("Antal ädelstenar? ");
	    String ädelstenar = sc.nextLine();
            prylargs.put("smycke", smycke);
            prylargs.put("metall", metall);
            prylargs.put("ädelstenar", ädelstenar);
           // controller.skapaPrylTillPerson(namnpåperson, prylargs);
        }
        
        
     
        
       */
        
        
	
        
	
	
    }
}





