import java.io.BufferedWriter;
import java.io.FileWriter;


public class FileWrite {
	public static void main(String args[])
	  {
	  try{
	  // Create file 
	  FileWriter fstream = new FileWriter("mbhushanJava.txt");
	  BufferedWriter out = new BufferedWriter(fstream);
	  out.write("Hello Java");
	  //Close the output stream
	  out.close();
	  }catch (Exception e){//Catch exception if any
	  System.err.println("Error: " + e.getMessage());
	  }
	  }
}
