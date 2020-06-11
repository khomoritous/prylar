package se.moma.pryl.startup;

import java.util.*;
import se.moma.pryl.controller.Controller;
import se.moma.pryl.integration.PersonSamling;
import se.moma.pryl.view.View;

public class Main {
    
  public static void main(String[] args)  {
      Map<String, String> prylArgs = new HashMap<>();
      Scanner scanner = null;
      View view;
      view = new View(prylArgs, new Controller(new PersonSamling(), prylArgs), scanner);
      
      view.vyn();
  }
}





