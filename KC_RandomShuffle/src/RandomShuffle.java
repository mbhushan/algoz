import java.util.Random;


public class RandomShuffle {
	public static void main(String[] args) {
		int [] A = {1,2,3,4,5,6,7};
		System.out.println("printing original array: ");
		printArray(A);
		A = shuffle(A);
		System.out.println("printing shuffled array: ");
		printArray(A);
	}
	
	public static int [] shuffle(int [] A) {
		if (A == null) { return A; }
		
		int len = A.length;
		Random rand = new Random();
		for (int i=len-1; i>=0; i--) {
			int k = rand.nextInt(i+1);
			//System.out.println("k: " + k);
			int temp = A[i]; A[i]=A[k]; A[k]=temp;
		}
		
		return A;
	}
	
	public static void printArray(int [] A) {
		if (A == null) { return ; }
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
