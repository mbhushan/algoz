
public class SmallestWindow {
	public static void main(String[] args) {
		int [] A = {1, 10, 100};
		int [] B = {99, 101, 150};
		int [] C = {5, 11, 98};
		
		findMinimizingIndices(A, B, C);
	}
	
	public static void findMinimizingIndices(int []A, int [] B, int []C) {
		int i=0, j=0, k=0;
		int min = Integer.MAX_VALUE;
		boolean isDone = false;
		int currMin = 0;
		int [] minIndices = null;
		while (!isDone) {
			currMin = Math.max(Math.abs(A[i]-B[j]), 
					  Math.max(Math.abs(B[j]-C[k]), Math.abs(C[k]-A[i])));
			if (currMin < min) {
				min = currMin;
				minIndices = new int[]{i, j, k};
			}
			boolean canInci = (i != A.length-1) ;
			boolean canIncj = (j != B.length-1) ;
			boolean canInck = (k != C.length-1) ;
			boolean isDelta = false;
			if (!canInci && !canIncj && !canInck) {				
				isDone = true;
			} else if (canInci && ((A[i] <= B[j]) && (A[i] <= C[k]))){				
				++i;
				isDelta = true;
			} else if (canIncj && ((B[j] <= A[i]) && (B[j] <= C[k]))){
				++j;
				isDelta = true;
			} else if (canInck && ((C[k] <= A[i]) && (C[k] <= B[j]))){
				++k;
				isDelta = true;
			}
			if (!isDelta) {
				break;
			}
		}
		
		System.out.println("i:"+minIndices[0] + ", " + "j:"+minIndices[1] + ", k:" + minIndices[2]);
	}
}
