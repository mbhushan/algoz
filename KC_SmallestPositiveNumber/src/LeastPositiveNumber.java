import java.util.HashMap;


public class LeastPositiveNumber {
	public static void main(String[] args) {
		int [] A = {2, 3, 7, 6, 8, -1, -10, 15};		
		System.out.println("Least positive number not in the array: " + getLeastPositiveNumber(A));
		
		int [] B = { 2, 3, -7, 6, 8, 1, -10, 15 };
		System.out.println("Least positive number not in the array: " + getLeastPositiveNumber(B));
	}
	
	public static Integer getLeastPositiveNumber(int [] A) {
		if (null == A) { return null; }
		int len = A.length;
		
		HashMap<Integer, Boolean> cacheMap = new HashMap<Integer, Boolean>();
		for (int i=0; i<len; i++) {
			cacheMap.put(A[i], true);
		}
		
		int result = 1;
		while (true) {
			if (cacheMap.containsKey(result)) {
				++result;
			} else {
				return result;
			}
		}
	}
}
