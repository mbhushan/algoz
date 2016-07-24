import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class ElemFrequency {
	public static void main(String[] args) {
		//int [] A = {5, 4, 4, 3, 2, 3, 4, 5, 5, 8};
		int [] A = {5,6,7,8, 10, 10, 10,10,10,10, 4,4, 4, 4,4,1, 1,1,1,4};
		findKRepeatedElements(A, 4); //K=4
	}
	
	public static void findKRepeatedElements(int [] A, int K) {
		Map<Integer, Integer> kBagMap = new HashMap<Integer, Integer>();
		List<Integer> removeList = new ArrayList<Integer>();
		
		int len = A.length;
		int freq = len/K;
		int value = 0;
		
		for (int i=0; i<len; i++) {
			if (kBagMap.size() == K) {
				removeList = new ArrayList<Integer>();
				Set<Integer> keySet = kBagMap.keySet();
				Iterator<Integer> iter = keySet.iterator();
				while (iter.hasNext()) {
					int key = iter.next();
					value = kBagMap.get(key);
					if (value > 1) {
						kBagMap.put(key, --value);
					} else {
						removeList.add(key);
					}
				}
				if (removeList.size() > 0) {
					Iterator<Integer> rmIter = removeList.iterator();
					while (rmIter.hasNext()) {
						int rmKey = rmIter.next();
						kBagMap.remove(rmKey);
					}
				}
					
			}
			value = 0;
			if (kBagMap.containsKey(A[i])) {
				value = kBagMap.get(A[i]);
			} 
			++value;
			kBagMap.put(A[i], value);
		}
		if (kBagMap.size() == K) {
			removeList = new ArrayList<Integer>();
			Set<Integer> keySet = kBagMap.keySet();
			Iterator<Integer> iter = keySet.iterator();
			while (iter.hasNext()) {
				int key = iter.next();
				value = kBagMap.get(key);
				if (value > 1) {
					kBagMap.put(key, --value);
				} else {
					removeList.add(key);
				}
			}
			if (removeList.size() > 0) {
				Iterator<Integer> rmIter = removeList.iterator();
				while (rmIter.hasNext()) {
					int rmKey = rmIter.next();
					kBagMap.remove(rmKey);
				}
			}
				
		}
		
		Set<Integer> finalSet = new HashSet<Integer>();
		finalSet = kBagMap.keySet();
		kBagMap = new HashMap<Integer, Integer>();
		for (int i=0; i<len; i++) {
			if (finalSet.contains(A[i])) {
				value = 0;
				if (kBagMap.containsKey(A[i])) {
					value = kBagMap.get(A[i]);
				}
				kBagMap.put(A[i], ++value);
			}
		}
		
		Iterator<Entry<Integer, Integer>> mapIter = kBagMap.entrySet().iterator();
		while (mapIter.hasNext()) {
			Entry<Integer, Integer> entry = mapIter.next();
			if (entry.getValue() > freq) {
				System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
			}
		}
		
		System.out.println("End!");
	}
}
