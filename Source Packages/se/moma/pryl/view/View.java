/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.view;

/**
 *
 * @author monde
 */
public class View {
    /*
    for(;;)
	    {
		
		System.out.print("\n"+"1-Skapa person \n"+"2-Skapa pryl\n"+"3-Visa alla\n"+"4-Visa rikaste \n"+"5-Visa viss person \n"+"6-B�rskrasch \n"+"7- Avsluta");
		System.out.println();
		int kommando = Integer.parseInt(sc.nextLine());
		
		switch(kommando)
		    {
		    case 1: 
			System.out.print("Personens namn: ");
			String namn = sc.nextLine();
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
			String person  = sc.nextLine();
			
			if(ny.hittaPerson(person))
			    {
				System.out.println("Vilken sorts pryl? ");
				String pryl = sc.nextLine();
				if(pryl.equals("Smycke"))
				    {
					System.out.print("Vilket sorts smycke? ");
					String smycke  = sc.nextLine();
					System.out.print("Vilken metall �r smycket gjord av? ");
					String metall = sc.nextLine();
					System.out.print("Antal �delstenar? ");
					int �delstenar = Integer.parseInt(sc.nextLine());
					Prylar sm = new Smycke(smycke,metall,�delstenar);
					ny.hamtaPerson(person).laggTillPryl(sm);
					
				    }
				else if(pryl.equals("Aktie"))
				    {
					System.out.print("Vilken typ av aktie? ");
					String aktie = sc.nextLine();
					System.out.print("Antal aktier? ");
					int antal = Integer.parseInt(sc.nextLine());
					System.out.print("Pris per aktie? ");
					int pris = Integer.parseInt(sc.nextLine());
					Prylar ak = new Aktie(aktie,antal,pris);
					ny.hamtaPerson(person).laggTillPryl(ak);
					
				    }
				else if(pryl.equals("Apparat"))
				    {
					System.out.print("Vilken typ av apparat? ");
					String apparat = sc.nextLine();
					System.out.print("Vilket ink�pspris har apparaten? ");
					int pris = Integer.parseInt(sc.nextLine());
					System.out.print("Hur sliten �r apparaten p� en skala fr�n 1-10? ");
					int slitage = Integer.parseInt(sc.nextLine());
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
			String na = sc.nextLine();
			if(ny.hittaPerson(na))
			    System.out.println(ny.hamtaPerson(na));
			else
			    System.out.println(na+" finns inte registrerad!");
			break;
			
		    case 6:
			ny.borsKrasch();
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
}