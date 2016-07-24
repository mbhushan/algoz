import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class LongestWord {
	
	private List<String> wordList = new ArrayList<String>();
	
	public static void main(String[] args) {
		LongestWord lw = new LongestWord();
		lw.readInput();
		lw.findLongestWord();
	}
	
	public void findLongestWord()  {
		Collections.sort(wordList, new ByWordLength());
		
		Iterator<String> it = wordList.iterator();
		String longest = "";
		
		while (it.hasNext()) {
			String s = it.next();
			System.out.print(s + " ");
			int len = s.length();
			for (int i=0; i<len; i++)  {
				String src = s.substring(0, i);
				String target = s.substring(i);
				if ((wordList.contains(src) && wordList.contains(target)) &&  (len > longest.length())) {
					longest = s;
				}
			}
		}
		System.out.println();
		System.out.println("Longest word: " + longest);
	}
	
	class ByWordLength implements Comparator{
		@Override
		public int compare(Object arg0, Object arg1) {
			int diff = ((String)arg0).length() - ((String)arg1).length();
			if (diff < 0) {
				return 1;
			} else if (diff  > 0) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			while (n>0)  {
				String [] s = br.readLine().split(" ");
				
				for (int i=0; i<s.length; i++) {
					wordList.add(s[i]);
				}
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
