package lab2;

/** Parts of Hamlet's favorite soliloquy, in Mad Libs. **/
public class MadHamlet {

  public static void main(String[] args) {

    MadLib ml = new MadLib("Hamlet");
    UserInterface ui = new StdStreamUI();

    ml.addString("To be, or not to be--that is the ");
    ml.addSlot("noun");
    ml.addString("\nWhether 'tis ");
    ml.addSlot("adjective");
    ml.addString(" in the mind to ");
    ml.addSlot("verb");
    ml.addString("\nThe slings and arrows of ");
    ml.addSlot("adjective");
    ml.addString(" ");
    ml.addSlot("noun");
    ml.addString("\nOr to ");
    ml.addSlot("verb");
    ml.addString(" arms against a sea of troubles");
    ml.addString("\nAnd by ");
    ml.addSlot("verb ending in \"ing\"");
    ml.addString(" end them. To ");
    ml.addSlot("verb");
    ml.addString(", to ");
    ml.addSlot("verb");
    ml.addString("--\n");

    /* Here's the rest of the Soliloquy if you want to add more:
    
    No more--and by a sleep to say we end
    The heartache, and the thousand natural shocks
    That flesh is heir to. 'Tis a consummation
    Devoutly to be wished. To die, to sleep--
    To sleep--perchance to dream: ay, there's the rub,
    For in that sleep of death what dreams may come
    When we have shuffled off this mortal coil,
    Must give us pause. 

    */
    
    ml.doLib(ui);
  }

}
 
