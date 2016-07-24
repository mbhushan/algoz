import java.util.HashMap;
import java.util.HashSet;


public class PairSum {
	
	private static HashMap<Integer, Integer> cacheMap = new HashMap<Integer, Integer> ();
	private static HashSet<Integer> visited = new HashSet<Integer>();
	
	public static void main(String[] args) {
		int [] A = {5, 9, 2, 11, 3, 8, 15, 7, 4, 12, 1};
		
		initCacheMap(A);
		printPairs(A, 12);
	}
	
	public static void printPairs(int [] A, int sum) {
		int len = A.length;
		System.out.println("Pairs that sum up to " + sum);
		for (int i=0; i<len; i++) {
			int x = sum - A[i];
			if (!visited.contains(x) && cacheMap.containsKey(x)) {
				System.out.println(A[i] + ":" + x);
			}
			visited.add(x);
			visited.add(A[i]);
		}
		
	}
	
	private static void initCacheMap(int [] A) {
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			if (!cacheMap.containsKey(A[i])) {
				cacheMap.put(A[i], 1);
			}
		}
	}
}

