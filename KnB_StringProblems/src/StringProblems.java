import java.util.Arrays;


public class StringProblems {
	
	public StringProblems() {
	}
	
	public boolean isAnagram(String first, String second) {
		if (null == first || null == second) {
			return false;
		}
		int firstLen = first.length();
		int secondLen = second.length();
		
		if (firstLen != secondLen) {
			return false;
		}
		
		char [] firstArr = first.toLowerCase().toCharArray();
		char [] secondArr = second.toLowerCase().toCharArray();
		
		Arrays.sort(firstArr);
		Arrays.sort(secondArr);
		
		for (int i=0; i<firstLen; i++) {
			if (firstArr[i] != secondArr[i]) {
				return false;
			}
		}
		return true;
	}
}
