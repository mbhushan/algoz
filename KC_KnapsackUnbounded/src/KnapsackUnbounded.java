
public class KnapsackUnbounded {
	
	public static void main(String[] args) {
		int [] W = {6, 3, 4, 2};
		int [] V = {30, 14, 16, 9};
		int M = 10;
		int optimalValue = unboundedKnapsack(W, V, M);
		System.out.println("Optimal value for unbounded knapsack: " + optimalValue);
	}
	
	public static int unboundedKnapsack(int [] W, int [] V, int M) {
		//ssshhhh... there is an undelying DAG :)
		int wLen = W.length;
		int [] K = new int[M+1];
		K[0] = 0;
		int best = 0;
		for (int w=1; w <= M; w++) {
			
			for (int i=0; i <wLen; i++) {
				if (w >= W[i]) {
					best = Math.max(K[w-W[i]] + V[i], best);
				}
			}
			K[w] = best;
		}
		
		System.out.println("Printing knapsack for different Ws:");
		for (int i=0; i<=M; i++) {
			System.out.print(K[i] + " ");
		}
		System.out.println();
		
		return K[M];
	}
}
