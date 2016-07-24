import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;


public class Medians {
	public static int [] A;
	public static void main(String [] args) {
		readInput();
		rollingMedian(A);
	}
	
	public static void rollingMedian(int [] A) {
		if (null == A) { return ; }
		
		PriorityQueue<Integer> maxH = new PriorityQueue<Integer>(5000, new MaxHeapComparator());
		PriorityQueue<Integer> minH = new PriorityQueue<Integer>(5000, new MinHeapComparator());
		Vector<Integer> medians = new Vector<Integer>();
		
		int len = A.length;
		maxH.add(A[0]);
		medians.add(A[0]);
		for (int i=1; i<len; i++) {
			int n = A[i];
			if (n <= maxH.peek()) {
				maxH.add(n);
			} else {
				minH.add(n);
			}
			
			//make sure the size diff b/w the heaps is not more than 1.
			int maxS = maxH.size();
			int minS = minH.size();
			
			if ((maxS > minS) && (maxS-minS > 1)) {
				int key = maxH.remove();
				minH.add(key);
			} else if (minS - maxS > 1) {
				int key = minH.remove();
				maxH.add(key);
			}
			
			//find median
			maxS = maxH.size();
			minS = minH.size();
			int mid = (0 == (i+1) % 2) ? (i+1)/2 : (i+1+1)/2;
			if (mid == maxS) {
				medians.add(maxH.peek());
			} else {
				medians.add(minH.peek());
			}
//			for (int j=0; j<medians.size(); j++) {
//				System.out.print(medians.get(j) + " ");
//			}
//			System.out.println();
		}
		
		long sum = 0;
		for (int j=0; j<medians.size(); j++) {
			sum += medians.get(j);
		}
		System.out.println("SUM: " + sum + " :: len: " + len);
		System.out.println("result: " + (sum%len));
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			A = new int[n];
			int i=0;
			while (n > 0) {
				int x = Integer.parseInt(br.readLine());
				A[i] = x;
				++i;
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MaxHeapComparator implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		if (o1 < o2) {
			return 1;
		} else if (o1 > o2) {
			return -1;
		} else {
			return 0;
		}
	}
}

class MinHeapComparator implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		if (o1 < o2) {
			return -1;
		} else if (o1 > o2) {
			return 1;
		} else {
			return 0;
		}
	}
}