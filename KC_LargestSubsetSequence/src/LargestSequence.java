import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class LargestSequence {
	public static void main(String[] args) {
		//int [] A = {1,6,10,4,7,9,5};
		int [] A = {2, 3, 9, 10, 11, 4, 13, 5, 15, 6, 17, 7};
		
		HashSet<Integer> sequenceList = getLargestSequence(A);
		Iterator<Integer> iter = sequenceList.iterator();
		System.out.println("Subset which forms the longest consecutive sequence: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		//System.out.println("Done!");
	}
	
	public static HashSet<Integer> getLargestSequence(int [] A) {
		HashSet<Integer> result = new HashSet<Integer>();
		if (A == null) {
			return result;
		}
		int len = A.length;
		Map<Integer, HashSet<Integer>> dataMap = new HashMap<Integer, HashSet<Integer>>();
		
		for (int i=0; i<len; i++) {
			int less = A[i] - 1;
			int more = A[i] + 1;
			HashSet<Integer> list = new HashSet<Integer>();
			boolean leftUpdated = false;
			boolean rightUpdated = false;
			if (dataMap.containsKey(less)) {
				list = dataMap.get(less);
				list.add(A[i]);
				dataMap.put(less, list);
				
				HashSet<Integer > keylist = dataMap.get(A[i]);
				if (keylist != null) {
					keylist.add(less);
					keylist.addAll(list);					
				} else {
					keylist = new HashSet<Integer>();
					keylist.addAll(list);
				}
				dataMap.put(A[i], keylist);
				
				leftUpdated = true;
			}
			if (dataMap.containsKey(more)) {
				list = dataMap.get(more);
				list.add(A[i]);
				dataMap.put(more, list);
				
				HashSet<Integer > keylist = dataMap.get(A[i]);
				if (keylist != null) {
					list.add(more);
					//keylist.add(more);
					keylist.addAll(list);					
				} else {
					keylist = new HashSet<Integer>();
					keylist.addAll(list);
				}
				dataMap.put(A[i], keylist);
				
				rightUpdated = true;
			} 
			if (!leftUpdated && !rightUpdated) {
				list.add(A[i]);
				dataMap.put(A[i], list);
			}
		}
		Iterator<Entry<Integer, HashSet<Integer>>> it = dataMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, HashSet<Integer>> pair = (Map.Entry<Integer, HashSet<Integer>>)it.next();
			if (pair.getValue().size() > result.size()) {
				result = pair.getValue();
			}
		}
		
		return result;
		
	}
}
