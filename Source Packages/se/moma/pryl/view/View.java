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
  
     
    //  PrylFactory prylFactory = null;
      Map<String, String> prylArgs = new HashMap<>();
      Controller controller = null;
	    Scanner scanner = null;
      
      public View(Map<String, String> prylArgs, Controller controller, Scanner scanner) {
        this.prylArgs = prylArgs;
        this.controller = controller;
        this.scanner = scanner;
        this.scanner = new Scanner(System.in);
      }
      
      
      public void displayMeny() {
        System.out.print("\n"+"1-Skapa person \n" + "2-Skapa pryl \n" + "3-Visa alla\n" +"4-Visa rikaste \n" +"5-Visa viss person \n"+"6-Börskrasch \n"/*+"7- Avsluta"*/);
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
              System.out.print("Namn på person: ");
              String namn = scanner.nextLine();
              controller.registreraNyPerson(namn);
            break;
            case 2:
             
              //Skapa pryl
              System.out.print("Vad heter personen som ska äga prylen? ");
             
              String namnPåPerson = scanner.nextLine();
              if (!controller.isPersonRegistrerad(namnPåPerson)) throw new IllegalArgumentException("Det finns ingen registrerad med det namnet!");
              System.out.print("Vad för sorts pryl ska skapas - smycke, apparat eller aktie? ");
     
              String typAvPryl = scanner.nextLine();
              System.out.println();
              if (typAvPryl.equalsIgnoreCase("Smycke")) {
                System.out.print("Vilket sorts smycke? ");
	              String smycke  = scanner.nextLine();
                System.out.println("");
	              System.out.print("Vilken metall är smycket gjord av? ");
	              String metall = scanner.nextLine();
                System.out.println("");
	              System.out.print("Antal ädelstenar? ");
	              String ädelStenar = scanner.nextLine();
                System.out.println();
               
                prylArgs.put("namn", smycke);
                prylArgs.put("metall", metall);
                prylArgs.put("ädelstenar",ädelStenar);
                controller.skapaPrylTillPerson(namnPåPerson, "smycke");
             } else if (typAvPryl.equalsIgnoreCase("Apparat")) {
                 System.out.print("Vilken sorts apparat? ");
                 String apparat = scanner.nextLine();
                 System.out.println("");
                 System.out.print("Vad har apparaten för pris? ");
                 String pris = scanner.nextLine();
                 System.out.println("");
                 System.out.print("Vad har apparaten för slitage? ");
                 String slitage = scanner.nextLine();
                 System.out.println();
                 
                 prylArgs.put("namn", apparat);
                 prylArgs.put("pris", pris);
                 prylArgs.put("slitage", slitage);
                 controller.skapaPrylTillPerson(namnPåPerson, "apparat");
             } else if (typAvPryl.equalsIgnoreCase("Aktie")) {
                 System.out.print("Vilken sort aktie? ");
                 String aktieNamn = scanner.nextLine();
                 System.out.println();
                 System.out.print("Antal aktier? ");
                 String antal = scanner.nextLine();
                 System.out.println();
                 System.out.print("Pris på aktie? ");
                 String pris = scanner.nextLine();
                 System.out.println();
                 
                 prylArgs.put("namn", aktieNamn);
                 prylArgs.put("antal", antal);
                 prylArgs.put("pris", pris);
                 controller.skapaPrylTillPerson(namnPåPerson, "aktie");
             } else {
                 throw new IllegalArgumentException(typAvPryl + " finns inte!");
               }
             break;
            case 3:
              System.out.println(controller.toString());
              break;
            case 4: 
              //String namnPåRikastePerson = scanner.nextLine();
		          System.out.println(controller.visaRikastePerson());
              System.out.println();
			        break;
            case 5:
			        System.out.print("Skriv ett namn: ");
			        String hämtaPerson = scanner.nextLine();
              System.out.println();
			        System.out.println(controller.hämtaPrylSamling(hämtaPerson));
			        break;
            case 6:
			          controller.börsKraschFörPrylSamling();
			          System.out.println(controller.toString());
			          break;
            default:
              System.out.println("Felaktigt kommando! Försök igen!");
             
          }
         
         } catch(NumberFormatException nfe) {
             System.out.println("Ange en siffra!");
         }         
       }
       
     }
      
}