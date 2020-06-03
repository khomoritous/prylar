package se.moma.pryl.util;

import java.util.*;
import se.moma.pryl.integration.PrylSamling;

public class PrylSamlingComparator implements Comparator<PrylSamling> {
    
    @Override
    public int compare(PrylSamling p1, PrylSamling p2) {
	    return (int) (p2.summaVärde() - p1.summaVärde());
    }
}
















