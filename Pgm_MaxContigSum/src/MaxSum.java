
public class MaxSum {
	private int [] A = {-2,3,4,1,-15,15,-20,9,2};
	
	public static void main(String [] args) {
		MaxSum ms = new MaxSum();
		System.out.println("max sum: " + ms.maxSum());
	}
	
	public int maxSum() {
		
		int sum = 0;
		int len = A.length;
		int max = 0;
		for (int i=0; i<len; i++) {
			sum += A[i];
			if (sum > max) {
				max =  sum;
			}
			if (sum < 0) {
				sum=0;
			}
		}
		
		return max;
	}
}
