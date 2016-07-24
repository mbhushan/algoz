
public class IntegerKnapsack {
	public static void main(String[] args) {
		int [] W = {6, 3, 4, 2};
		int [] V = {30, 14, 16, 9};
		int C = 10;
		int optimalValue = integerKnapsack(W, V, C);
		System.out.println("Optimal value for integer knapsack: " + optimalValue);
	}
	
	public static int integerKnapsack(int [] W, int []V, int C) {
		int N = W.length;
		int [][] K = new int[C+1][N+1];
		
		//K(w,j) = Max { K(w - w[j], j-1) + v[j], K(w, j-1)}
		for (int i=1; i<=N; i++) {
			for (int w=1; w <=C; w++) {
				if (W[i-1] > w ) {
					K[w][i] = K[w][i-1];
				} else {
					K[w][i] = Math.max(K[w-W[i-1]][i-1] + V[i-1], K[w][i-1]);
				}
			}
		}
		//System.out.println(K[C][N]);
		return K[C][N];
	}
}
