package se.moma.pryl.util;

import se.moma.pryl.model.Person;
import java.util.*;

public class PersonVärdeComparator implements Comparator<Person> {
    
    @Override
    public int compare(Person p1, Person p2) {
	    return (int) (p2.summaVärde() - p1.summaVärde());
    }
}
















