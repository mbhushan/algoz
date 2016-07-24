
public class PerfectSquares {
	public static void main(String [] args) {
		int [] A = {12, 51, 73, 89, 133};
		
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.println("nearest perfect square for " + A[i] + ": " + getNearestSquare(A[i]));
		}
	}
	
	public static Integer getNearestSquare(Integer num) {
		if (null == num) {
			return null;
		}
		Integer result = null;
		
		Integer sqrt = (int)Math.sqrt(num);
		
		Integer prev = sqrt;
		Integer next = sqrt+1;
		
		prev = prev*prev;
		next = next*next;
		
		result = (num-prev) < (next-num) ? prev : next;
		
		return result;
	}
	
}
