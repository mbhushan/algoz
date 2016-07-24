package lab2;

/**
 *
 * The superclass for MadLibs.  An MadLibTemplate object contains all
 * of the data associated with a particular MadLib story.
 *
 **/

public abstract class MadLibTemplate
{

  private String title;
  
  /**
   *
   * Create a new MadLibTemplate with the given title.
   *
   **/
  MadLibTemplate(String title) {
    this.title = title;
  }

  /**
   *
   * Get the title of this MadLib.
   *
   **/
  public String getTitle() {
    return this.title;
  }
   

  /**
   *
   * Add boilerplate text to this.
   *
   **/
  abstract void addString(String text);

  /**
   *
   * Add a slot of the given type to this.
   *
   **/
  abstract void addSlot(String type);

  /**
   *
   * Print out the mad lib as a template.
   *
   * This is for debugging purposes; print out the mad lib with the
   * slot type names substituted instead of slots. For example, a lib
   * containing the text entry "Hi," followed by a slot with type name
   * "proper noun" would print out ``Hi, -proper noun-''.
   *
   **/
  abstract void printAsTemplate(UserInterface ui);

  /**
   *
   * Ask the user for words for each slot, in order, then substitute
   * the words in, and print out the lib.
   *
   * This function should prompt the user 
   *
   **/
  abstract void doLib(UserInterface ui);
}
