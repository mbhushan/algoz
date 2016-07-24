
public class MainString {
	
	public static void main(String [] args) {
		String first = "cort";
		String second = "torc";
		String third = "corc";
		
		StringProblems stringProb = new StringProblems();
		
		System.out.println("Is anagram? " + stringProb.isAnagram(first, second));
		System.out.println("Is anagram? " + stringProb.isAnagram(first, third));
	}
}
