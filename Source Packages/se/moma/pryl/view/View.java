/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import se.moma.pryl.controller.Controller;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.model.Person;
import se.moma.pryl.model.factory.PrylFactory;

/**
 *
 * @author monde
 */
public class View {
    /*
    for(;;)
	    {
		
		System.out.print("\n"+"1-Skapa person \n"+"2-Skapa pryl\n"+"3-Visa alla\n"+"4-Visa rikaste \n"+"5-Visa viss person \n"+"6-B�rskrascannerh \n"+"7- Avsluta");
		System.out.println();
		int kommando = Integer.parseInt(scanner.nextLine());
		
		switch(kommando)
		    {
		    case 1: 
			System.out.print("Personens namn: ");
			String namn = scanner.nextLine();
			if(ny.hittaPerson(namn))
			    System.out.println("Namnet "+namn+ " finns redan registrerat!");
			else
			    {
				Person ny = new Person(namn);
				ny.laggTillPerson(ny);
			    }
			break;
		    case 2:
			
			System.out.print("Vilken person �ger prylen? ");
			String person  = scanner.nextLine();
			
			if(ny.hittaPerson(person))
			    {
				System.out.println("Vilken sorts pryl? ");
				String pryl = scanner.nextLine();
				if(pryl.equals("Smycke"))
				    {
					System.out.print("Vilket sorts smycke? ");
					String smycke  = scanner.nextLine();
					System.out.print("Vilken metall �r smycket gjord av? ");
					String metall = scanner.nextLine();
					System.out.print("Antal �delstenar? ");
					int �delstenar = Integer.parseInt(scanner.nextLine());
					Prylar sm = new Smycke(smycke,metall,�delstenar);
					ny.hamtaPerson(person).laggTillPryl(sm);
					
				    }
				else if(pryl.equals("Aktie"))
				    {
					System.out.print("Vilken typ av aktie? ");
					String aktie = scanner.nextLine();
					System.out.print("Antal aktier? ");
					int antal = Integer.parseInt(scanner.nextLine());
					System.out.print("Pris per aktie? ");
					int pris = Integer.parseInt(scanner.nextLine());
					Prylar ak = new Aktie(aktie,antal,pris);
					ny.hamtaPerson(person).laggTillPryl(ak);
					
				    }
				else if(pryl.equals("Apparat"))
				    {
					System.out.print("Vilken typ av apparat? ");
					String apparat = scanner.nextLine();
					System.out.print("Vilket ink�pspris har apparaten? ");
					int pris = Integer.parseInt(scanner.nextLine());
					System.out.print("Hur sliten �r apparaten p� en skala fr�n 1-10? ");
					int slitage = Integer.parseInt(scanner.nextLine());
					Prylar ap = new Apparat(apparat,pris,slitage);
					ny.hamtaPerson(person).laggTillPryl(ap);
					
				    }
			    }
			else
			    
			    System.out.println("Den personen finns inte registrerad!");
			break;
			
		    case 3:
			
			System.out.print("I registret finns: \n "+ny.visaAlla());
			break;
		    case 4: 
			
			System.out.print(ny.hämtaRikastePerson());
			break;
			
		    case 5:
			System.out.print("Skriv ett namn: ");
			String na = scanner.nextLine();
			if(ny.hittaPerson(na))
			    System.out.println(ny.hamtaPerson(na));
			else
			    System.out.println(na+" finns inte registrerad!");
			break;
			
		    case 6:
			ny.borsKrascannerh();
			System.out.println(ny.toString());
			break;
		    case 7:
			System.exit(0);	
			break;    
		    default:
			System.out.println("Felaktigt kommando");
		    }
		
	    }
 */  
  
     
      PrylFactory prylFactory = null;
      Map<String, String> prylArgs = null;
      Controller controller = null;
	    Scanner scanner = null;
      
      public View(Map<String, String> prylArgs, Controller controller, Scanner scanneranner) {
        this.prylArgs = prylArgs;
        this.prylArgs = new HashMap<>();
        this.controller = controller;
        this.scanner = scanneranner;
        this.scanner = new Scanner(System.in);
      }
      
      
      public void displayMeny() {
        System.out.print("\n"+"1-Skapa person \n" + "2-Skapa pryl \n" /*+ "3-Visa alla\n"+"4-Visa rikaste \n"+"5-Visa viss person \n"+"6-B�rskrascannerh \n"+"7- Avsluta"*/);
		    System.out.println();
      }
	
      
     public void vyn() {
       for(;;) {
         
         try {
         displayMeny();
         int kommando = Integer.parseInt(scanner.nextLine());
     
         switch(kommando) {
           case 1:
             //SkapaPerson
             System.out.print("Namn på en person: ");
             String namn = scanner.nextLine();
             controller.registreraNyPerson(namn);
           break;
           case 2:
             
             //Skapa pryl
             System.out.println("Vad heter personen som ska äga prylen? ");
             
             String namnPåPerson = scanner.nextLine();
             if (!controller.isPersonRegistrerad(namnPåPerson)) throw new IllegalArgumentException("Det finns ingen registrerad med det namnet!");
             System.out.print("Vad för sorts pryl ska skapas - smycke, apparat eller aktie? ");
     
             String namnPåPryl = scanner.nextLine();
             System.out.println("");
             if (namnPåPryl.equalsIgnoreCase("Smycke")) {
               System.out.println("Vilket sorts smycke? ");
	             String smycke  = scanner.nextLine();
	             System.out.println("Vilken metall är smycket gjord av? ");
	             String metall = scanner.nextLine();
	             System.out.println("Antal ädelstenar? ");
	             String ädelStenar = scanner.nextLine();
               
               prylArgs.put("smycke", smycke);
               prylArgs.put("metall", metall);
               prylArgs.put("ädelstenar",ädelStenar);
               controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
            } else if (namnPåPryl.equalsIgnoreCase("Apparat")) {
                 System.out.print("Vilken sorts apparat? ");
                 String apparat = scanner.nextLine();
                 System.out.print("Vad har apparaten för pris? ");
                 String pris = scanner.nextLine();
                 System.out.print("Vad har apparaten för slitage? ");
                 String slitage = scanner.nextLine();
                 prylArgs.put("apparat", apparat);
                 prylArgs.put("pris", pris);
                 prylArgs.put("slitage", slitage);
                 controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
            } else if (namnPåPryl.equalsIgnoreCase("aktie")) {
                System.out.print("Vilken sort aktie? ");
                String aktieNamn = scanner.nextLine();
                System.out.print("Antal aktier? ");
                String antal = scanner.nextLine();
                System.out.println("Pris på aktie? ");
                String pris = scanner.nextLine();
                prylArgs.put("namn", aktieNamn);
                prylArgs.put("antal", antal);
                prylArgs.put("pris", pris);
                controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
             } else {
                 throw new IllegalArgumentException(namnPåPryl + " finns inte!");
               }
             
             default:
               System.out.println("Felaktigt kommando! Försök igen!");
             
         }
         
         } catch(NumberFormatException nfe) {
             System.out.println("Ange en siffra!");
         }         
       }
       
     }
      /*
      prylArgs.put("namn", namn);
        
      //Skapa pryl
      System.out.println("Vad heter personen som ska äga prylen? ");
      String namnPåPerson = scanner.nextLine();
      System.out.print("Vad för sorts pryl ska skapas? ");
     
      String namnPåPryl = scanner.nextLine();
      if (namnPåPryl.equalsIgnoreCase("Smycke")) {
        System.out.print("Vilket sorts smycke? ");
	      String smycke  = scanner.nextLine();
	      System.out.print("Vilken metall är smycket gjord av? ");
	      String metall = scanner.nextLine();
	      System.out.print("Antal ädelStenar? ");
	      String ädelStenar = scanner.nextLine();
        prylArgs.put("smycke", smycke);
        prylArgs.put("metall", metall);
        prylArgs.put("ädelStenar", ädelStenar);
        controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
      } else if (namnPåPryl.equalsIgnoreCase("Apparat")) {
          System.out.print("Vilken sorts apparat? ");
          String apparat = scanner.nextLine();
          System.out.print("Vad har apparaten för pris? ");
          String pris = scanner.nextLine();
          System.out.print("Vad har apparaten för slitage? ");
          String slitage = scanner.nextLine();
          prylArgs.put("apparat", apparat);
          prylArgs.put("pris", pris);
          prylArgs.put("slitage", slitage);
          controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
        } else if (namnPåPryl.equalsIgnoreCase("aktie")) {
            System.out.print("Vilken sort aktie? ");
            String aktieNamn = scanner.nextLine();
            System.out.print("Antal aktier? ");
            String antal = scanner.nextLine();
            System.out.println("Pris på aktie? ");
            String pris = scanner.nextLine();
            prylArgs.put("namn", aktieNamn);
            prylArgs.put("antal", antal);
            prylArgs.put("pris", pris);
            controller.skapaPrylTillPerson(namnPåPerson, prylArgs);
        } else 
            throw new IllegalArgumentException(namnPåPryl + " finns inte!");
        }
*/
}