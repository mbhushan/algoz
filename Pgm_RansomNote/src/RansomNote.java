import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class RansomNote {
	
	private static BufferedReader br;
	private static String note;
	private static String mags;
	
	public static void main(String[] args) throws IOException {
		readInput();
		System.out.println("Is Ransom Note possible? " + isRansomNotePossible());
	}
	
	public static boolean isRansomNotePossible() {
		Map<String, Integer> charMap = new HashMap<String, Integer>();
		
		for(int i=0; i<mags.length(); i++) {
			String s =  String.valueOf(mags.charAt(i));
			if (charMap.containsKey(s)) {
				Integer count = charMap.get(s);
				++count;
				charMap.put(s, count);
			} else {
				charMap.put(s, Integer.valueOf(1));
			}
		}
		
		boolean isNotePossible = true;
		for (int i=0; i<note.length(); i++)  {
			String s = String.valueOf(note.charAt(i));
			if (charMap.containsKey(s)) {
				Integer count = charMap.get(s);
				if (count > 0) {
					--count;
					charMap.put(s, count);
				} else {
					isNotePossible = false;
					break;
				}
			} else {
				isNotePossible = false;
				break;
			}
		}
		
		return isNotePossible;
	}
	
	public static void readInput() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		note = br.readLine();
		
		StringBuffer sb = new StringBuffer();
		int n = Integer.valueOf(br.readLine());
		
		while(n>0)  {
			String s = br.readLine();
			sb.append(s);
			--n;
		}
		mags = sb.toString();
	}
}
