import java.util.HashMap;
import java.util.Map;


public class CompareArrays {
	
	private int [] A = {2,4,6,6};
	private int [] B = {2,6,4,6};
	
	public boolean compareArray() {
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		int lenA = A.length;
		int lenB = B.length;
		if (lenA != lenB) { return false; }
		for (int i=0; i<lenA; i++) {
			if (!numMap.containsKey(A[i])) {
				numMap.put(A[i], 1);
			} else {
				int count = numMap.get(A[i]);
				numMap.put(A[i], count+1);
			}
		}
		for (int i=0; i<lenB; i++) {
			if (!numMap.containsKey(B[i])) {
				return false;
			} else {
				int count = numMap.get(B[i]);
				if (count > 1) {
					numMap.put(B[i], count-1);
				} else {
					numMap.remove(B[i]);
				}
			}
		}
		if (numMap.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}