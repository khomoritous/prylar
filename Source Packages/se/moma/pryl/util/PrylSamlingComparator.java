package se.moma.pryl.util;

import java.util.*;
import se.moma.pryl.integration.PrylSamling;

public class PrylSamlingComparator implements Comparator<PrylSamling> {

  @Override
  public int compare(PrylSamling o1, PrylSamling o2) {
   if (o1.summaVärde() == o2.summaVärde()) return 0;
   else if (o1.summaVärde() > o2.summaVärde()) return 1;
   else return -1;
  }
}
















