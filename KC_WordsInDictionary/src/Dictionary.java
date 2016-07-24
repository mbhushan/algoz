import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Dictionary {
	private static Set<String> dictionary = new HashSet<String>();
	private static List<String> [] phrases;
	
	public static void main(String[] args) {
		dictionary.addAll(Arrays.asList(new String []{"cats", "cat", "and", "dog"}));
		
		String str = "catsanddog";
		System.out.println("Input String: " + str);
		System.out.println("valid phrases:");
		List<String> validPhrases = putSpaces(str);
		System.out.println(validPhrases.toString());
		int len = str.length();
		System.out.println("printing phrases:");
		for (int i=0; i<len; i++) {	
			if (phrases[i] != null)
			System.out.println(phrases[i].toString());
		}
	}
	
	public static List<String> putSpaces(String str) {
		if (null == str) { return null; }
		int len = str.length();
		phrases = new List[len];
		return putSpaces(str, 0);
	}
	
	private static List<String> putSpaces(String str, int index) {
		if (phrases[index] != null) {
			return phrases[index];
		}
		List<String> result = new ArrayList<String>();
		int len = str.length();
		for (int i=0; i<len; i++) {
			String word = str.substring(0, i+1);
			if (dictionary.contains(word)) {
				if (word.equals(str)) {
					result.add(word);
				} else {
					List<String> next = putSpaces(str.substring(i+1), index+i+1);
					for (String st: next) {
						result.add(word + " " + st);
					}
				}
			}
		}
		return (phrases[index] = result);
	}
}
