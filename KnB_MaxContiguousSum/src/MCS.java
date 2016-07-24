
public class MCS {
	
	public static void main(String[] args) {
		int [] A = {5,7,-3,1,-11,8,12};
		int [] B = {3,-2,4,-2,-3,5,-6,7,-3,-2,-1,-8};
		MCS(A);
		MCS(B);
	}
	
	public static void MCS(int [] A) {
		
		int len = A.length;
		
		int max = 0;
		int sum = 0;
		int start = 0;
		int end = 0;
		int j=0;
		for (int i=0; i<len; i++) {
			sum += A[i];
			
			if (sum > max) {
				max = sum;
				start = j;
				end = i;
			} else if (sum < 0) {
				sum = 0;
				j = i+1;
			}
		}
		
		System.out.println("Max Sum: " + max);
		System.out.println("Indices: " + start + ":" + end);
	}
}
