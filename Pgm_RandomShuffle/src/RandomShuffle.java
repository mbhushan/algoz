import java.util.Random;


public class RandomShuffle {
	
	public static void main(String[] args) {
		int [] A = {1,2,3,4,5,6,7,8,9,10,11};
		
		randomShuffle(A);
		printArray(A);
	}
	
	private static void printArray(int [] A) {
		for (int i=0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	private static void randomShuffle(int [] A) {
		
		for (int i=A.length; i>1; i--) {
			Random rand = new Random();
			int r = rand.nextInt(i);			
			System.out.println("Random: " + r + " ArraySize: " + A.length);
			int temp = A[i-1]; A[i-1] = A[r]; A[r] = temp;
		}
	}
}
