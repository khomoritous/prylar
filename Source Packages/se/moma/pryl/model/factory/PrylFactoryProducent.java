/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.pryl.model.factory;

import java.util.Map;

/**
 *
 * @author monde
 */
public class PrylFactoryProducent {
    
    public static PrylFactory getFactory(Map<String, String> argsMap) {
        
        if (argsMap.containsKey("smycke"))
          return new SmyckeFactory();
        else if (argsMap.containsKey("aktie"))
          return new AktieFactory();
        else if (argsMap.containsKey("apparat"))
          return new ApparatFactory();
        else
          return null;
    }
    
}
