import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;


public class HeapDS {
	private static final int N = 7;
	private static Comparator<Integer> comparator = new NumericComaprator();
	private static Comparator<Integer> maxComparator = new MaxNumericComparator();
	private static PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(N, comparator);
	private static PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(N, maxComparator);
	
	public static void main(String[] args) {
		int [] A = {14, 17, 12, 19, 13, 15, 20};
		
		addToHeap(A);
		
		Random rand = new Random();
		int len = A.length;
		for (int i=0; i<len; i++) {
			//System.out.print(minheap.remove() + " ");
			int value = rand.nextInt(100) + 1;
			minheap.add(value);
			maxheap.add(value);
		}
		System.out.println("Printing min heap data: ");
		while (minheap.size() > 0) {
			System.out.print(minheap.remove() + " ");
		}
		System.out.println();
		System.out.println("Printing max heap data");
		while (maxheap.size() > 0) {
			System.out.print(maxheap.remove() + " ");
		}
		System.out.println();
	}
	
	public static void addToHeap(int [] A) {
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			minheap.add(A[i]);
			maxheap.add(A[i]);
		}
	}
}

class MaxNumericComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 < o2) {
			return 1;
		} else if (o1 > o2) {
			return -1;
		}
		return 0;
	}
	
}

class NumericComaprator implements Comparator<Integer> {

	@Override
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
