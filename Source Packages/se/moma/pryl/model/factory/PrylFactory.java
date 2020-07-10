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
 * Är en factory av <code>Pryl</code> som returnerar instans av <code>Smycke</code>, <code>Aktie</code> eller
 * <code>Apparat</code>.
 * 
 * @author monde
 */
public class PrylFactory {
    
     /**
     * Skapar en instans av <code>Pryl</code> antingen <code>Smycke</code>, <code>Aktie</code> eller 
     * <code>Apparat</code>.
     * 
     * @param namnPåPryl Textsträng som är namn på <code>Pryl</code>.
     * @param map Innehåller argument till <code>Pryl</code> som ska skapas.
     * 
     * @return Instans av <code>Smycke</code>, <code>Aktie</code> eller <code>Apparat</code>.
     * 
     * @throws NumberFormatException Om det är fel på argumenten till vald <code>Pryl</code> 
     * och ingen <code>Pryl</code> skapades. 
     */   
    public static Pryl getPryl(String namnPåPryl, Map<String, String> map) throws NumberFormatException {
      if (namnPåPryl.equalsIgnoreCase("smycke")) 
        return new Smycke(map.get("namn"), map.get("metall"), parseInt(map.get("ädelstenar")));
      else if (namnPåPryl.equalsIgnoreCase("aktie")) 
        return new Aktie(map.get("namn"), parseInt(map.get("antal")), parseInt(map.get("pris")));
      else if (namnPåPryl.equalsIgnoreCase("apparat")) 
        return new Apparat(map.get("namn"), parseDouble(map.get("pris")), parseInt(map.get("slitage")));
      else return null;
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
      
      Pryl ingepryl = PrylFactory.getPryl("", map);
      System.out.println(ingepryl);
      
     
    }
    
}
