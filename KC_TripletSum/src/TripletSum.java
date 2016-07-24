import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class TripletSum {
	public static void main(String[] args) {
		int [] A = {1, 2, -5, 4, -2, 3, -19, 10, 5, 8, -25, 19, 6, 20, -10, -7, -3};
		findTriplets(A);
	}
	
	public static void findTriplets(int [] A) {
		Arrays.sort(A);
		printArray(A);
		int len = A.length;
		Map<Integer, ArrayList<Integer>> tripletMap = new HashMap<Integer, ArrayList<Integer>>();
		int count = 0;
		for (int i=0; i<len-2; i++) {
			int a = A[i];
			int k = i+1;
			int l = len-1;
			int b, c = 0;
			while (k < l) {
				b = A[k];
				c = A[l];
				if ((a+b+c) == 0) {
					ArrayList<Integer> numList = new ArrayList<Integer>();
					numList.add(a);numList.add(b);numList.add(c);
					tripletMap.put(++count, numList);
					++k;
				} else if ((a+b+c) > 0) {
					l = l - 1;
				} else {
					k = k + 1;
				}
			}
		}
		
		System.out.println("Number of triplets that sum to zero:" + count);
		Iterator iter = tripletMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, ArrayList<Integer>> pair = (Map.Entry<Integer, ArrayList<Integer>>)iter.next();
			ArrayList<Integer> triplets = pair.getValue();
			Iterator it = triplets.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void printArray(int [] A) {
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
