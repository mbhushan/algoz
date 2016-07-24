import java.util.ArrayList;
import java.util.List;


public class LongestWord {
	private static String [] words = { "test", "tester", "testertest", "testing",
	                                 "testingtester", "testingpostering", "teslinderingintheend"};
	private static List<String> wordList;
	
	public static void main(String [] args) {
		wordList = new ArrayList<String>();
		for (String s: words) {
			wordList.add(s);
		}
		System.out.println("Longest words ans is: " + longestWord());
	}
	
	private static String longestWord() {
		for (int j=words.length-1; j>=0; j--) {
			String candidate = words[j];
			String first = "";
			String second = "";
			for (int i=0;i < candidate.length()-2; i++) {
				first = candidate.substring(0, i+1);
				second = candidate.substring(i+1, candidate.length());
				
				if (wordList.contains(first) && wordList.contains(second)) {
					return candidate;
				}
			}
		}
		
		return "";
	}
	
	private static void sortStringArray() {
		StringBuffer sBuf = new StringBuffer();
	}
}

// Algo
//1. Sort the words in increasing order.
//2. Take the biggest word and divide the word in all possible splits and see if the splits
// are hashing to the same values in the hash table.