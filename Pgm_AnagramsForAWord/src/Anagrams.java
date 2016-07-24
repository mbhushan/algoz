import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Anagrams {
	
	private static BufferedReader br;
	private static List<String> wordList;
	private static String source;
	
	public static void main(String[] args) throws IOException {
		readFromConsole();		
		findAnagrams();
	}
	public static void findAnagrams() {
		System.out.println("Sorted String: " + sortString(source));
		Map<String,List> wordMap = new HashMap<String,List>();
		
		Iterator<String> iter = wordList.iterator();
		while(iter.hasNext()) {
			String word = iter.next();
			String wordKey = sortString(word);
			if (wordMap.containsKey(wordKey)) {
				List <String> list = new ArrayList<String>();
				list = (ArrayList)wordMap.get(wordKey);
				list.add(word);
				wordMap.put(wordKey, list);
			} else {
				List <String> list = new ArrayList<String>();
				list.add(word);
				wordMap.put(wordKey, list);
			}
		}
		//you can get all the anagram sets here.
		//for now lets get the specific one as required in the pgm.
		List <String> list = new ArrayList<String>();
		list = (ArrayList<String>)wordMap.get(sortString(source));
		if  (list !=null && !list.isEmpty()) {
			System.out.println("Anagrams for: " + source);
			Iterator<String> i = list.iterator();
			while(i.hasNext()) {
				System.out.println(i.next());
			}
		} else {
			System.out.println("No anagrams exist for: " + source);
		}
		
	}
	private static String sortString(String word) {
		char [] c = word.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<c.length; i++) {
			for (int j=i; j<c.length; j++) {
				if (c[i] > c[j]) {
					char temp = c[i]; c[i]=c[j]; c[j]=temp;
				}
			}			
			sb.append(c[i]);
		}
		return sb.toString();
	}
	
	public static void readFromConsole() throws IOException {
		wordList = new ArrayList<String>();
		
		br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		s = br.readLine();
		int n = Integer.parseInt(s);
		//StringBuilder sb = new StringBuilder();
		
		while (n>0) {
			wordList.add(br.readLine());
			//sb.append(br.readLine() + "\n");
			--n;
		}
		//System.out.println(sb.toString());
		Iterator<String> iter = wordList.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		source = br.readLine();
		System.out.println("Find anagrams for: " + source);
	}
}
