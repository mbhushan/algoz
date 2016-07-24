import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;


public class TripletSum {
	private static HashSet<Triplet> triplets = new HashSet<Triplet>();
	public static void main(String[] args) {
		int [] A = {5, 9, 2, 11, 3, 8, 15, 7, 4, 12, 1, 6};
		int sum = 12;
		calcTripletSet(A, sum);
		System.out.println("triplets that sum to " + sum + ":");
		printTriplets();
	}
	
	public static void calcTripletSet(int [] A, int sum) {
		Arrays.sort(A);
		printArray(A);
		int len = A.length;	
		int a=0, b=0, c=0;
		int j=0, k=len-1;
		for (int i=0; i<len; i++) {
			a = A[i];
			j = i+1;
			k = len-1;
			while (j<k) {
				b = A[j]; c = A[k];
				if (a+b+c == sum) {				
					triplets.add(new Triplet(a,b,c));
					--k;
				} else if (a+b+c < sum) {
					++j;
				} else {
					--k;
				}
			}		
		}
	}
	
	public static void printArray(int [] A) {
		int len = A.length;
		for (int i=0; i<len ;i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	public static void printTriplets() {
		Iterator<Triplet> iter = triplets.iterator();
		
		while (iter.hasNext()) {
			Triplet tempTriplet = (Triplet)iter.next();
			System.out.println(tempTriplet.x + ":" + tempTriplet.y + ":" + tempTriplet.z);
		}
	}
}

class Triplet {
	int x; int y; int z;
	Triplet(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
