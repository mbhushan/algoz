import java.util.Random;


public class RandomizeArray {
	public static int [] A = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) {
		printArray(A);
		randomizeArray(A);
		printArray(A);
	}
	
	public static void randomizeArray(int []A) {
		Random rand = new Random();
		
		for (int i=0; i<A.length;  i++) {
			int r = rand.nextInt(A.length - i)+i;
			int t = A[r]; A[r] = A[i]; A[i] = t;
		}
	}
	
	public static void printArray(int [] A) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i]  + " ");
		}
		System.out.println();
	}
}
