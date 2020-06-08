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
   //Map<String, String> argsMap = new HashMap<>();
    
    public static Pryl getPryl(String pryl, Map<String, String> argsMap) {
      if (pryl.equalsIgnoreCase("smycke"))
        return new Smycke(argsMap.get("namn"),argsMap.get("metall"),parseInt(argsMap.get("ädelstenar")));
      else if (pryl.equalsIgnoreCase("aktie"))
        return new Aktie(argsMap.get("namn"), parseInt(argsMap.get("antal")),parseInt(argsMap.get("pris")));
      else if (pryl.equalsIgnoreCase("apparat"))
        return new Apparat(argsMap.get("namn"), parseDouble(argsMap.get("pris")), parseInt(argsMap.get("slitage")));
      else
        throw new IllegalArgumentException("Den prylen finns inte!");
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
