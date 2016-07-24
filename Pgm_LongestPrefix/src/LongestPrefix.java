import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class LongestPrefix {
	private String [] words;
	private String [] revWords;
	
	
	public static void main(String [] args) {
		LongestPrefix lp =  new LongestPrefix();
		lp.readInput();
		//lp.printWords();
		lp.sortWordsLexicographically();
		//lp.printWords();
		System.out.println("longest prefix is: " + lp.findLongestPrefix());
		System.out.println("longest suffix is: " + lp.findLongestSuffix());
		//lp.printWords();
	}
	public void printWords() {
		System.out.println("**printing words**");
		for (int i=0; i<words.length; i++)  {
			System.out.println(words[i]);
		}
	}
	
	public String findLongestSuffix()  {
		for (int i=0; i< words.length; i++)  {
			int len = words[i].length();
			StringBuilder sb = new StringBuilder();
			for (int j=len-1; j>=0; j--) {
				sb.append(words[i].charAt(j));			
			}
			words[i] = sb.toString();
		}
		
		String suffix =  findLongestPrefix();
		int len = suffix.length();
		StringBuilder sb = new StringBuilder();
		for (int i=len-1; i>=0; i--) {
			sb.append(suffix.charAt(i));
		}
		
		return sb.toString();
	}
	
		
	public String findLongestPrefix()  {
		String longestPrefix = "";
		
		for (int i=0; i<words.length-1; i++)  {
			int len = words[i].length() < words[i+1].length()  ? words[i].length() : words[i+1].length();
			String prefix = "";
			
			for (int j=0; j<len; j++) {
				if (words[i].charAt(j) == words[i+1].charAt(j)) {
					prefix += words[i].charAt(j);
				} else {
					if (prefix.length() > longestPrefix.length()) {
						longestPrefix = prefix;
					}
					break;
				}
			}
		}
		return longestPrefix;
	}
	public void sortWordsLexicographically()  {
		Arrays.sort(words, new StringComparator());
	}
	
	class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			if (arg0.compareTo(arg1) > 0) {
				return 1;
			} else if (arg0.compareTo(arg1) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	public void readInput()  {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			words = new String[n];
			int i=0;
			while  (n > 0) {
				words[i] = br.readLine();
				++i;
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
