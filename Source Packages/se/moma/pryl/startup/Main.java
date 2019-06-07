package se.moma.pryl.startup;

import java.util.*;
import se.moma.pryl.controller.Controller;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.factory.PrylFactory;

public class Main {
    
    public static void main(String[] args)  {
      List<Person> lista = null;
      PrylFactory prylFactory = null;
      Map<String, String> prylArgs = new HashMap<>();
      PersonSamling personSamling = new PersonSamling(lista);
        
      Controller controller = new Controller(personSamling, prylFactory);
	
      Scanner sc = new Scanner(System.in);
      //SkapaPerson
      System.out.print("Namn på en person: ");
      String namn = sc.nextLine();
      prylArgs.put("namn", namn);
      controller.skapaPerson(namn);
        
      //Skapa pryl
      System.out.println("Vad heter personen som ska äga prylen? ");
      String namnPåPerson = sc.nextLine();
      System.out.print("Vad för sorts pryl ska skapas? ");
     
      String namnPåPryl = sc.nextLine();
      if (namnPåPryl.equalsIgnoreCase("Smycke")) {
        System.out.print("Vilket sorts smycke? ");
	      String smycke  = sc.nextLine();
	      System.out.print("Vilken metall är smycket gjord av? ");
	      String metall = sc.nextLine();
	      System.out.print("Antal ädelstenar? ");
	      String ädelstenar = sc.nextLine();
        prylArgs.put("smycke", smycke);
        prylArgs.put("metall", metall);
        prylArgs.put("ädelstenar", ädelstenar);
        controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
        } else if (namnPåPryl.equalsIgnoreCase("Apparat")) {
            System.out.print("Vilken sorts apparat? ");
            String apparat = sc.nextLine();
            System.out.print("Vad har apparaten för pris? ");
            String pris = sc.nextLine();
            System.out.print("Vad har apparaten för slitage? ");
            String slitage = sc.nextLine();
            prylArgs.put("apparat", apparat);
            prylArgs.put("pris", pris);
            prylArgs.put("slitage", slitage);
            controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
        } else if (namnPåPryl.equalsIgnoreCase("aktie")) {
            System.out.print("Vilken sort aktie? ");
            String aktieNamn = sc.nextLine();
            System.out.print("Antal aktier? ");
            String antal = sc.nextLine();
            System.out.println("Pris på aktie? ");
            String pris = sc.nextLine();
            prylArgs.put("namn", aktieNamn);
            prylArgs.put("antal", antal);
            prylArgs.put("pris", pris);
            controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
        } else 
            throw new IllegalArgumentException(namnPåPryl + " finns inte!");
        }
}





