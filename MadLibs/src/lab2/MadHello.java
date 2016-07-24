package lab2;

/** Hello World!, Mad Libs-style **/
public class MadHello {

  public static void main(String[] args) {

    MadLib ml = new MadLib("Hello!");
    UserInterface ui = new StdStreamUI();

    ml.addString("Hello ");
    ml.addSlot("noun");
    ml.addString("!");
    
    // now go and do it!
    ml.doLib(ui);

    System.out.println("template:");
    ml.printAsTemplate(ui);
    
  }
  
}
