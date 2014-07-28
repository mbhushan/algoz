import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Anagrams {
	
	private static String [] dict;
	private static HashMap<String, ArrayList<String>> hmap ;
	
	public static void main(String [] args) {
		readInput();
		printArray(dict);
		
		hmap = anagramsSets(dict);
		printAnagramSets(hmap);
	}
	
	public static HashMap<String, ArrayList<String>> anagramsSets(String [] dict) {
		if (null == dict) { return null; }
		
		HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
		int len = dict.length;
		
		for (int i=0; i<len; i++) {
			String word = dict[i];
			char [] chArr = word.toCharArray();
			Arrays.sort(chArr);
			String sortedWord = new StringBuffer().append(chArr).toString();
			
			ArrayList<String> alist = new ArrayList<String>();
			if (hmap.containsKey(sortedWord)) {
				alist = hmap.get(sortedWord);
			}
			alist.add(word);
			hmap.put(sortedWord, alist);
		}
		return hmap;
	}
	
	public static void printAnagramSets(HashMap<String, ArrayList<String>> hmap) {
		if (null == hmap) { return ; }
		
		Set<String> keySet = hmap.keySet();
		
		Iterator<String> iter = keySet.iterator();
		
		int count = 1;
		while (iter.hasNext()) {
			String key = iter.next();
			ArrayList<String> list = hmap.get(key);
			if (list.size() > 1) {
				System.out.println("anagram set " + count + ": ");
				Iterator<String> it = list.iterator();
				while (it.hasNext()) {
					System.out.print(it.next() + " ");
				}
				++count;
				System.out.println();
			}
		}
	}
	
	public static void printArray(String [] A) {
		if (null == A) {
			return ;
		}
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.println(A[i]);
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine().trim());
			dict = new String[n];
			
			for (int i=0; i<n; i++) {
				dict[i] = br.readLine().trim();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
