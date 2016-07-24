import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;


public class PriorityQTest {
	public static void main(String [] args) {
		Comparator<Integer> iq = new IntegerComparator();
		PriorityQueue<Integer> pq =  new PriorityQueue<Integer>(10, iq);
		
		for (int i=0; i<200; i++) {
			Random rand = new Random();
			pq.add(rand.nextInt(9900)+1);
		}
		
		//printing the data from the queue
		System.out.println("Printing the data of the queue: ");
		while (pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
		System.out.println();
	}
	
	static class IntegerComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer arg0, Integer arg1) {
			if (arg0 < arg1) {
				return -1; 
			}
			if (arg0 > arg1) {
				return 1;
			}
			return 0;
		}
		
	}
}
