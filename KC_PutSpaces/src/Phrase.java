import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Phrase {
	private static Set<String> dictionary = new HashSet<String>();
	private static List<String> [] phrases;
	
	public static void main(String [] args) {		
		dictionary.addAll(Arrays.asList(new String[]{"his", "bin", "ary", "in", "binary", "tree", "this", "i", "a", "is", "an", "interest", 
				"inter", "rest", "sting", "interesting", "sent", "ten", 
				"saw", "awe", "we", "some", "awesome", "sentence"}));
		
		//printDictionary(dictionary);	
		
		String str = "thisisaninterestingsentence";
		//String str = "binarytree";
		//String str = "thisisawesome";
		List<String> validPhrases = putSpaces(dictionary, str);
		System.out.println("Input String: " + str);
		System.out.println("The valid phrases are:");
        System.out.println(validPhrases);
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> putSpaces(Set<String> dictionary, String str) {
		phrases = new List[str.length()];		
		return putSpaces(str, 0);
	}
	
	public static List<String> putSpaces(String str, int index) {
		if (phrases[index] != null) {
			return phrases[index];
		}
		List<String> result = new ArrayList<String>();
		for (int i=0; i<str.length(); i++) {
			String word = str.substring(0,i+1);
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
	
	public static void printDictionary(Set<String> dict) {
		Iterator<String> iter = dict.iterator();
		System.out.println("Words in the dictionary are: ");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}		
	}
}
