import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Anagrams {
	
	public static int N;
	public static String [] string;
	
	public static void main(String [] args) {
		readInput();
		printStrings();
		findAnagrams(string);
		testMethod();
	}
	
	public static void testMethod() {
		String s = "mani";
		char [] ch = s.toCharArray();
		Arrays.sort(ch);
		s = new StringBuffer().append(ch).toString();
		System.out.println("String is: " + s);
	}
	
	public static void findAnagrams(String [] string) {
		Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
		
		for (String key: string) {
			String value = key;
			
			//sort the "key" string lexicographically.
			char [] ch = key.toCharArray();
			Arrays.sort(ch);
			key = new StringBuffer().append(ch).toString();

			if (anagrams.containsKey(key)) {
				List<String> wordList = new ArrayList<String>();
				wordList = anagrams.get(key);
				wordList.add(value);
				anagrams.put(key, wordList);
			} else {
				List<String> wordList = new ArrayList<String>();
				wordList.add(value);
				anagrams.put(key, wordList);
			}
		}
		printMap(anagrams);
	}
	
	public static void printMap(Map<String, List<String>> map) {
		System.out.println("Anagram sets are: ");
		for (Entry<String, List<String>> e : map.entrySet()) {
			List<String> anagramSet = (ArrayList<String>)e.getValue();
			Iterator<String> iter = anagramSet.iterator();
			
			while (iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println();
		}
	}
	
	public static void printStrings() {
		System.out.println("printing words: ");
		for(String s: string) {
			System.out.println(s);
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			N = Integer.parseInt(br.readLine());
			string = new String[N];
			
			int n = N;
			int i=0;
			
			while (n>0) {
				string[i] = br.readLine();
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
