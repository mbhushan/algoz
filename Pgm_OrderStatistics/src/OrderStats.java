import java.util.Random;


public class OrderStats {
	private static int N = 11;
	private static int [] A;
	
	public static void main(String[] args) {
		A =  new int[N];
		populateArray();
		System.out.println("Nth biggest element is: " + NthBiggestInArray(0,N-1,3));
	}
	
	private static int NthBiggestInArray(int p, int q, int i) {
		if  (p == q) {
			return A[p];
		}
		int r = randPartition(p,q);
		int key = r-p+1;
		
		if  (i == key) { return A[r]; }
		else if (i<key) {
			return NthBiggestInArray(p, r-1, i);
		} else {
			return NthBiggestInArray(r+1, q, i-key);
		}
	}
	
	private static int randPartition(int p, int q) {
		int i=p+1;
		int j=q;
		int key = A[p];
		while (i<j) {
			if (A[j] <= key) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i=i+1;
			} else {
				j=j-1;
			}
		}
		A[0] = A[j];
		A[j] = key;
		return j;
	}
	
	private static void populateArray() {
		Random rand = new Random();
		
		for(int i=0;i<N;i++) {
			int value = rand.nextInt(99)+1;
			A[i] = value;
		}
		
		System.out.println("Array is:");
		for(int i=0; i<N; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
