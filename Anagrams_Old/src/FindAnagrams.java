import java.util.*;
import java.io.*;

public class FindAnagrams {
	public static void main(String [] args) throws IOException
	{
		log("anagram finder !");
		File dictionary = new File("C:\\manib\\items\\Aduni\\wordlist.txt"); 
		log("Original file contents: " + getContents(dictionary));
	}
	private static String getContents(File dictionary){
		StringBuffer contents = new StringBuffer();
		int count = 0;
		try{
			BufferedReader input = new BufferedReader(new FileReader(dictionary));
			try{
				String line = null;
				while(((line = input.readLine()) != null) && count != 10){
					contents.append(line);
					contents.append(" --> ");
					++count;
				}
			}
			finally{
				input.close();
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return contents.toString();
	}
	private static void log(String msg){
		System.out.println(msg);
	}

}
