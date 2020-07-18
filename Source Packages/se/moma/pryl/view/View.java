/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.view;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import se.moma.pryl.controller.Controller;
import se.moma.pryl.integration.exceptions.PersistanceException;
import se.moma.pryl.util.ErrorMessageHandler;
import se.moma.pryl.util.LogHandler;

/**
 *
 * @author monde
 */
public class View {
    
      private Map<String, String> prylArgs = new HashMap<>();
      private Controller controller = null;
	    private Scanner scanner = null;
      private ErrorMessageHandler errorMsgHandler = null;
      private LogHandler logger = null;
      
      //private final static Logger theLogger = LoggerFactory.getLogger(View.class);
     // private static final String LOGG = "pryl-log.txt";
    //  private PrintWriter loggfil = null;
      
      public View(Map<String, String> prylArgs, Controller controller, Scanner scanner) {
        this.prylArgs = prylArgs;
        this.controller = controller;
        errorMsgHandler = new ErrorMessageHandler();
        this.scanner = scanner;
        this.scanner = new Scanner(System.in);
        try {
          logger = new LogHandler();
        } catch (IOException ex) {
          System.out.println("Kan inte skapa loghandler. Avslutar...");
          System.exit(1);
        }
      }
      
      
      public void displayMeny() {
        System.out.println("******************************MENY****************************************");
        System.out.print("\n"+"1-Skapa person \n" + "2-Skapa pryl \n" + "3-Visa alla\n" +"4-Visa rikaste \n" +"5-Visa viss person \n"+"6-Börskrasch \n" +"7-Avsluta\n");
		    System.out.println();
      }
	
      
     public void vyn() {
       DateTimeFormatter ntz = DateTimeFormatter.ofPattern("d MMMM, yyyy h:mm a");
       System.out.println("\nDagens datum är: " + ZonedDateTime.now().format(ntz) + "\n\n");
       for(;;) {
         
         try {
           displayMeny();
           int kommando = Integer.parseInt(scanner.nextLine().trim());
     
           switch(kommando) {
             case 1:
               //SkapaPerson
               System.out.print("Namn på person: ");
               String namn = scanner.nextLine().trim();
               System.out.println();
               controller.registreraNyPerson(namn);
              
               
              break;
              case 2:
                try {
                String typAvPryl = "";
            
                //Skapa pryl
                System.out.print("Vad heter personen som ska äga prylen? ");
             
                String namnPåPerson = scanner.nextLine().trim();
                if (!controller.isPersonRegistrerad(namnPåPerson)) throw new IllegalArgumentException("Det finns ingen med det namnet registrerat!"); 
                  System.out.print("Vad för sorts pryl ska skapas - smycke, apparat eller aktie? ");
     
                  typAvPryl = scanner.nextLine().trim();
               
                if (typAvPryl.equalsIgnoreCase("Smycke")) {
                  System.out.print("Vilket sorts smycke? ");
	                String smycke  = scanner.nextLine().trim();
                  System.out.println();
	                System.out.print("Vilken metall är smycket gjord av? ");
	                String metall = scanner.nextLine().trim();
                  System.out.println();
	                System.out.print("Antal ädelstenar? Ange en siffra. ");
	                String ädelStenar = scanner.nextLine().trim();
                  System.out.println();
               
                  prylArgs.put("namn", smycke);
                  prylArgs.put("metall", metall);
                  prylArgs.put("ädelstenar",ädelStenar);
                  controller.skapaPrylTillPerson(namnPåPerson, "smycke");
                 
                 
             } else if (typAvPryl.equalsIgnoreCase("Apparat")) {
                 System.out.print("Vilken sorts apparat? ");
                 String apparat = scanner.nextLine().trim();
                 System.out.println("");
                 System.out.print("Vad har apparaten för pris? ");
                 String pris = scanner.nextLine().trim();
                 System.out.println("");
                 System.out.print("Vad har apparaten för slitage? ");
                 String slitage = scanner.nextLine().trim();
                 System.out.println();
                 
                 prylArgs.put("namn", apparat);
                 prylArgs.put("pris", pris);
                 prylArgs.put("slitage", slitage);
                 controller.skapaPrylTillPerson(namnPåPerson, "apparat");
                 
                 
             } else if (typAvPryl.equalsIgnoreCase("Aktie")) {
                 System.out.print("Vilken sort aktie? ");
                 String aktieNamn = scanner.nextLine().trim();
                 System.out.println();
                 System.out.print("Antal aktier? ");
                 String antal = scanner.nextLine().trim();
                 System.out.println();
                 System.out.print("Pris på aktie? ");
                 String pris = scanner.nextLine().trim();
                 System.out.println();
                 
                 prylArgs.put("namn", aktieNamn);
                 prylArgs.put("antal", antal);
                 prylArgs.put("pris", pris);
                 controller.skapaPrylTillPerson(namnPåPerson, "aktie");
               } else throw new IllegalArgumentException(typAvPryl + " du måste välja pryl..smycke, aktie eller apparat");
             
                }catch(NumberFormatException nfe) {
                  errorMsgHandler.showErrorMsg(nfe.getMessage() + " skapades ingen pryl. Är alla argument rätt ifyllda?");
                  logger.logException(nfe);
                }catch(Exception ex) {
                  errorMsgHandler.showErrorMsg(ex.getMessage());
                  logger.logException(ex);
              }
              break;
              case 3:
                System.out.println(controller.toString());
              break;
              case 4: 
		            System.out.println(controller.visaRikastePerson());
                System.out.println();
			        break;
              case 5:
			          System.out.print("Skriv ett namn: ");
			          String hämtaPerson = scanner.nextLine().trim();
                System.out.println();
			          System.out.println(controller.hämtaPrylSamling(hämtaPerson));
			        break;
              case 6:
			          controller.börsKraschFörSamtligaPrylSamlingar();
			        break;
              case 7:
                try {
                    controller.sparaPersonSamlingTillFil();
                }catch(PersistanceException pe) {
                   errorMsgHandler.showErrorMsg("Filsystemet är inte tillgängligt för tillfället. Var god och försök senare.");
                   logger.logException(pe);
                }catch(Exception ex) {
                  logger.logException(ex);
                }
              
                System.out.println("Hej då!");
			          System.exit(0);
              break;
              default:
                System.out.println("Felaktigt kommando! Försök igen!");
           }
           
            }catch(NumberFormatException nfe) {
               errorMsgHandler.showErrorMsg(nfe.getMessage() + ". Du behöver använda dig av siffror för att komma åt menyn.");
               logger.logException(nfe);
             }catch(NoSuchElementException nse) {
                errorMsgHandler.showErrorMsg(nse.getMessage());
                logger.logException(nse);
              }catch(Exception ex) {
                errorMsgHandler.showErrorMsg(ex.getMessage());
                logger.logException(ex);
              }         
        }
       
     }
      
}