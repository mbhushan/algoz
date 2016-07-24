
public class MajorityVote {
	public static void main(String[] args) {
		char [] arr = {'A', 'A', 'A', 'C', 'C', 'B', 'B', 'C', 'C', 'C', 'B', 'C', 'C'};
		System.out.println("Majority Element: " + findMajorityElement(arr));
	}
	
	public static char findMajorityElement(char [] A) {
		char candidate = ' ';
		int vote = 0;
		
		int len = A.length;
		candidate = A[0];
		vote = 1;
		for (int i=1; i<len; i++) {
			if (A[i] == candidate) {
				++vote;
			} else {
				if (vote > 0) {
					--vote;
				} else {
					candidate = A[i];
					++vote;
				}
			}
		}
		
		return candidate;
	}
}
