
public class PrintNumbers {
	
	public static void main(String[] args) {
		printIncreasingOrder2_5(20);
	}
	
	public static void printIncreasingOrder2_5(int n) {
		int [] A = new int [n];
		A[0] = 1;
		int two = 0;
		int five = 0;
		int i = 1;
		System.out.print(A[0] + " ");
		while (i < n) {
			if ((2 * A[two]) == (5 * A[five])) {
				A[i] = 2 * A[two];
				++two;
				++five;
			} else if ((2 * A[two]) < (5 * A[five])) {
				A[i] = 2 * A[two];
				++two;
			} else {
				A[i] = 5 * A[five];
				++five;
			}
			System.out.print(A[i] + " ");
			++i;
		}
		
		System.out.println();
	}
}
