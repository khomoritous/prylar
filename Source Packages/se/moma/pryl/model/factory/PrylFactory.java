/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.model.factory;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import java.util.HashMap;
import java.util.Map;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.Apparat;
import se.moma.pryl.model.Smycke;
import se.moma.pryl.model.interfaces.Pryl;

/**
 * Returnerar olika factory av <code>Pryl</code>.
 * 
 * @author monde
 */
public class PrylFactory {
    //private static Map<String, String>  map = new HashMap<>();
    
    public static Pryl getPryl(String namnPåPryl, Map<String, String> map) throws NumberFormatException {
      
        if (namnPåPryl.equalsIgnoreCase("smycke")) return new Smycke(map.get("namn"), map.get("metall"), parseInt(map.get("ädelstenar")));
        if (namnPåPryl.equalsIgnoreCase("aktie")) return new Aktie(map.get("namn"), parseInt(map.get("antal")), parseInt(map.get("pris")));
        if (namnPåPryl.equalsIgnoreCase("apparat")) return new Apparat(map.get("namn"), parseDouble(map.get("pris")), parseInt(map.get("slitage")));
      return null;
    }
    
    public static void main(String[] args) {
      Map<String, String> map = new HashMap<>();
      map.put("namn", "halsband");
      map.put("metall", "platina");
      map.put("ädelstenar", "2");
      
      Pryl prylsmycke = PrylFactory.getPryl("smycke", map);
      System.out.println(prylsmycke);
      
      map.put("namn", "googl");
      map.put("antal", "10");
      map.put("pris", "10");
      
      Pryl prylaktie = PrylFactory.getPryl("aktie", map);
      System.out.println(prylaktie);
      
      map.put("namn", "ugn");
      map.put("pris", "1000");
      map.put("slitage", "3");
      
      Pryl prylapparat = PrylFactory.getPryl("apparat", map);
      System.out.println(prylapparat);
      
     
    }
    
}
