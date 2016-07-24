import java.util.Arrays;


public class Triplets {
	public static void main(String[] args) {
		int [] A = {-12, -7, -4, 2, 3, 5, 9, 10, 15, 16};
		int [] B = {-29, -9, -4, 2, 3, 49, 9, 10, 15, 16};
		findTripletClosestToZero(A);
		System.out.println();
		findTripletClosestToZero(B);
	}
	
	public static void findTripletClosestToZero(int [] A) {
		Arrays.sort(A);
		System.out.println("Array values are: ");
		printArray(A);
		int len  = A.length;
		int fa=0, fb=0, fc = 0;
		int a=0, b=0, c = 0;
		int j=0, k = 0;
		int min = Integer.MAX_VALUE;
		boolean isFound = false;
		for (int i=0; i<len-2; i++) {
			a = A[i];
			j = i+1;
			k = len-1;
			while (j < k) {
				b = A[j];
				c = A[k];
				if ((a+b+c) == 0) {
					fa = a; fb = b; fc = c;
					isFound = true;
					break;					
				} else if ((a+b+c) < 0) {
					++j;
				} else {
					--k;
				}
				if ((Math.abs(a+b+c) < min)) {
					fa = a; fb = b; fc = c;
					min = Math.abs(a+b+c);
				}
			}
			if (isFound) {
				break;
			}
		}
		if (isFound) {
			System.out.println("We found a triplet that sums to zero!!");
		} else {
			System.out.println("Triplet whose sum is closest to zero by: " + min);
		}
		System.out.println("Triplet is: ");
		System.out.println(fa + ", " + fb + ", " + fc);
	}
	
	public static void printArray(int [] A) {
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
