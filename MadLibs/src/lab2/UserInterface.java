package lab2;

/**
 *
 * A UserInterface object provides an easy way to contact the user and
 * ask for data.
 *
 *
 **/
public interface UserInterface {

  /**
   *
   * Prompt the user with the given prompt and return the user's
   * response.
   *
   **/
  public String promptUser(String prompt);

  /**
   *
   * Write s to the user.
   *
   **/
  public void writeString(String s);
}
  
