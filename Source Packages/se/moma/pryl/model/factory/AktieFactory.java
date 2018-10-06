/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.model.factory;

import static java.lang.Integer.parseInt;
import java.util.Map;
import se.moma.pryl.model.Aktie;
import se.moma.pryl.model.interfaces.Pryl;

/**
 *
 * @author monde
 */
public class AktieFactory implements PrylFactory {
    
    
    /**
     * Skapar en <code>Pryl</code>.
     * 
     * @param argsMap Innehåller argument för skapande av <code>Pryl</code>.
     * @return En instans av <code>Pryl</code>.
     */
    @Override
    public Pryl skapaPryl(Map<String, String> argsMap) {
        
        return new Aktie(argsMap.get("aktie"), parseInt(argsMap.get("antal")), parseInt(argsMap.get("pris")));
    }
    
}
