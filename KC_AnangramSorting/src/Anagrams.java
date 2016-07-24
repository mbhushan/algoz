import java.util.Arrays;
import java.util.Comparator;


public class Anagrams {
	
	public static void main(String [] args) {
		String [] strArr = {"smite", "angel", "times", "tea", "emits", "angle","shear", "eat", "items",
							"reset", "hears", "lopes", "steer", "poles", "share", "trees", "slope"
							};
		//sort the words in the array such that all the anagrams are next to each other.
		sortAnagramStrings(strArr);
	}
	
	public static void sortAnagramStrings(String [] strArr) {
		if (strArr == null || strArr.length < 1) {
			return;
		}
		
		Arrays.sort(strArr, new AnagramComparator());
		
		int len = strArr.length;
		
		for (int i=0; i<len; i++) {
			System.out.println(strArr[i]);
		}
	}
}

class AnagramComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return sortChars(o1).compareTo(sortChars(o2));
	}
	
	public String sortChars(String str) {
		char [] arr = str.toCharArray();
		Arrays.sort(arr);
		
		return new String(arr);
	}
	
}
