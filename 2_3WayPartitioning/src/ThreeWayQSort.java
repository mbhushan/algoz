
public class ThreeWayQSort {

	private static Comparable [] A;
	
	public static Comparable [] sort(Comparable [] In) {
		if (In == null) { return In; }
		
		A = In;
		ThreeWaySort(0, A.length-1);
		return A;
	}
	
	private static void ThreeWaySort(int low, int high) {
		if (low >= high) { return ; }
		
		int i = low;
		int lt = low;
		int gt = high;
		Comparable K = A[low];
		
		while (i <= gt) {
			int cmp = A[i].compareTo(K);
			if (cmp < 0) {
				exchange(lt++, i++);
			} else if (cmp > 0) {
				exchange(gt--, i);
			} else {
				i++;
			}
		}
		
		ThreeWaySort(low, lt-1);
		ThreeWaySort(gt+1, high);
	}
	
	private static void exchange(int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
}
