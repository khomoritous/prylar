/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.model.factory;

import static java.lang.Integer.parseInt;
import java.util.Map;
import se.moma.pryl.model.Apparat;
import se.moma.pryl.model.interfaces.Pryl;

/**
 *
 * @author monde
 */
public class ApparatFactory implements PrylFactory {
    
    /**
     * @param argsMap Innehåller argument för skapande av <code>Pryl</code>.
     * @return En instans av <code>Pryl</code>.
     */
    @Override
    public Pryl skapaPryl(Map<String, String> argsMap) {
        Pryl pryl = null;
        if(argsMap.containsKey("apparat")) {
            pryl = new Apparat(argsMap.get("namn"), parseInt(argsMap.get("pris")), parseInt(argsMap.get("slitage")));
        }
        return pryl;
    }
    
    
}
