/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.model.factory;

import static java.lang.Integer.parseInt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.moma.pryl.model.Smycke;
import se.moma.pryl.model.interfaces.Pryl;

/**
 * Är en klass om skapar en <code>Pryl</code> av typ <code>Smycke</code>.
 * 
 * @author monde
 */
public class SmyckeFactory implements PrylFactory {

    
    /**
     * Skapar en <code>Pryl</code>.
     * 
     * @param argsMap Innehåller argument för skapande av <code>Pryl</code>.
     * @return En instans av <code>Pryl</code>.
     */
    @Override
    public Pryl skapaPryl(Map<String, String> argsMap) {
        
        return new Smycke(argsMap.get("smycke"), argsMap.get("metall"), parseInt(argsMap.get("ädelstenar")));
    }

}
