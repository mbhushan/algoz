
public class MinDistance {
	
	public static void main(String[] args) {
//		int [] A = {1, 5, 3, 7, 2, 8, 3, 4, 5, 9, 2, 9};
		int [] A = {1, 5, 3, 7, 2, 8, 3, 4, 5, 9, 9, 3, 1, 3, 2, 9};
		int minDist = -1;
		minDist = minDistance(A, 9, 3);
		System.out.println("Min Distance (9, 3): " + minDist);
		
		minDist = minDistance(A, 3, 9);
		System.out.println("Min Distance (3, 9): " + minDist);
		
		minDist = minDistance(A, 4, 7);
		System.out.println("Min Distance (4, 7): " + minDist);
		
		minDist = minDistance(A, 9, 9);
		System.out.println("Min Distance (9, 9): " + minDist);
		
		minDist = minDistance(A, 3, 3);
		System.out.println("Min Distance (3, 3): " + minDist);
		
		minDist = calcMinDistance(A, 5, 8);
		System.out.println("Min Distance (5, 8): " + (minDist-1));
		
		minDist = calcMinDistance(A, 5, 9);
		System.out.println("Min Distance (5, 9): " + (minDist-1));
	}
	
	//use this method when a != b
	public static int calcMinDistance(int [] A, int a, int b) {
		int len = A.length;
		int minDist = len+1;
		
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		for (int i=0; i<len; i++) {
			if (A[i] == a) { x = i;}
			if (A[i] == b) { y = i; }
			if ((x < Integer.MAX_VALUE) && (y < Integer.MAX_VALUE)) {
				minDist = Math.min(minDist, Math.abs(y-x));
			}
		}
		
		return minDist;
	}
	
	//this method even works when numbers are equal ie a == b.
	public static int minDistance(int [] A, int a, int b) {
		int len = A.length;
		int distance = len+1;
		
		int j = 0;
		int k = 0;
		int z = 0;
		for (int i=0; i<len; i++) {
			if (A[i] == a) {
				j=i+1;
				z = i;
				while (j < len) {
					if (A[j] == b) {
						k = j;
						if ((j-i-1) < distance) {
							distance = j-i-1;
						}
						i=k+1;
						break;
					}
					++j;
				}
				for (int x=z+1; x<k; x++) {
					if (A[x] == a) {
						if ((k-x-1) < distance ) {
							distance = k-x-1;
						}
					}
				}
			}
			
			if (i >= len) {
				break;
			}
			if (A[i] == b) {
				j=i+1;
				z = i;
				while (j < len) {
					if (A[j] == a) {
						k = j;
						if ((j-i-1) < distance) {
							distance = j-i-1;
						}
						i=k;
						break;
					}
					++j;
				}
				for (int x=z+1; x<k; x++) {
					if (A[x] == b) {
						if ((k-x-1) < distance ) {
							distance = k-x-1;
						}
					}
				}
			}
		}
		
		return distance;
	}
}
