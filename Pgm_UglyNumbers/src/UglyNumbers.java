import java.util.Comparator;
import java.util.PriorityQueue;


public class UglyNumbers {
	
	public static void main(String [] args) {
		UglyNumbers un = new UglyNumbers();
		un.calculateUglyNumbers();
	}
	
	public void calculateUglyNumbers() {
		Comparator<Integer> comparator = new IntegerComparator();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1500, comparator);
		int count = 1;
		int N = 15;
		pq.add(1);
		
		System.out.println("ugly numbers are: ");
		while (count <= N) {
			int i = pq.remove();
			
			if (!pq.contains(i*2))  {pq.add(i*2); }
			if (!pq.contains(i*3))  {pq.add(i*3); }
			if (!pq.contains(i*5))  {pq.add(i*5); }
			count += 1;
			
			System.out.print(i  + " ");
			//if ((pq.size() + count) == N)  { break; }
		}
//		while (!pq.isEmpty()) {
//			System.out.print(pq.remove() + " ");
//		}
		System.out.println();
	}
	
	public class IntegerComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 < o2) {
				return -1;
			}
			if (o1 > o2) {
				return 1;
			}
			return 0;
		}
	}
}
