package lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * A StdStreamUserInterface is a UserInterface that uses stdin for
 * input and stdout for output.
 *
 **/
public class StdStreamUI implements UserInterface {

  private BufferedReader input;
  
  public StdStreamUI() {
    this.input = new BufferedReader(new InputStreamReader(System.in));
  }

  public String promptUser(String prompt) {
    System.out.println(prompt);
    try {
      return this.input.readLine();
    } catch (IOException e) {
      System.err.println
	("ERROR: there was a problem reading your input.  " +
	 "Returning an empty string.");
      System.err.println(e);
      e.printStackTrace();
      return "";
    }
  }

  public void writeString(String s) {
    System.out.println(s);
  }
}
