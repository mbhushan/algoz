
public class LargestSum {
	
	public static void main(String[] args) {
		int [] A = { 6, -8, 3, 7, -2, 4 };
		
		System.out.println("Max sum is: " + maxSum(A));
	}
	
	public static int maxSum(int [] A) {
		int sum=0;
		int max=0;
		int i=0;
		
		for (int j=0;  j< A.length; j++){
			sum  += A[i];
			
			if (max < sum) {
				max = sum;
			} else if (sum < 0){
				sum = 0;
				i=j;
			}
			++i;
		}
		return max;		
	}
}
