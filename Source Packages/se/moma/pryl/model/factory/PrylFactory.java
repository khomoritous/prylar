/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.model.factory;

import java.util.Map;
import se.moma.pryl.model.interfaces.Pryl;

/**
 * Ett interface för att skapa en <code>PrylFactory</code> som returnerar en <code>Pryl</code>.
 * 
 * @author monde
 */
public interface PrylFactory {
    
    /**
     * @param argsMap  Innehåller argument för skapande av <code>Pryl</code>.
     * @return En instans av <code>Pryl</code>.
     */
    Pryl skapaPryl(Map<String, String> argsMap);
    
}
