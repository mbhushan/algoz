import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class ContiguousSequence {
	
	public static void main(String[] args) {
		int [] A = {2, 3, 9, 10, 11, 4, 13, 5, 15, 6, 17, 7};
		largestContiguousSeq(A);
		
		int [] B = {1,6,10,4,7,9,5};
		largestContiguousSeq(B);
	}
	
	public static void largestContiguousSeq(int [] A) {
		if (null == A) { return ; }
		HashMap<Integer, Integer> seqMap = new HashMap<Integer, Integer>();
		
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			int key = A[i];
			Integer leftCount = seqMap.get(key-1);
			if (leftCount == null) {
				leftCount = 0;
			} else {
				++leftCount;
			}
			seqMap.put(key-1,leftCount);
			
			Integer rightCount = seqMap.get(key+1);
			if (rightCount == null) {
				rightCount = 0;
			} else {
				++rightCount;
			}
			seqMap.put(key+1, rightCount);
			
			seqMap.put(key, leftCount+rightCount);
		}
		
		int max = 0;
		Iterator<Entry<Integer, Integer>> it = seqMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>)it.next();
			int value = pair.getValue();
			if ( value > max) {
				max = value;
			}
		}
		
		System.out.println("Max length of congiuous elements: " + max);
	}
}
