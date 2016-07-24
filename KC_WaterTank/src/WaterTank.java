
public class WaterTank {
	public static void main(String[] args) {
		int [] container = {1, 3, 5, 6, 25};
		
		fillTheTank(container, 80);
		fillTheTank(container, 71);
	}
	
	public static void fillTheTank(int [] C, int V) {
		int len = C.length;
		int [] solution = new int[V+1];
		int [] D = new int[V+1];
		
		for (int i=1; i<=V; i++) {
			D[i] = Integer.MAX_VALUE;
			for (int k=0; k<len; k++) {
				if (i >= C[k]) {
					//D[i] = D[i] > 1+D[i-C[k]] ? 1+D[i-C[k]] : D[i];
					if (D[i] > (1 + D[i-C[k]])) {
						D[i] = 1 + D[i-C[k]];
						solution[i] = C[k];
					}
				}
			}
		}
		
		System.out.println("Number of containers for " + V + ": " + D[V]);
		printSolution(solution, V);
		System.out.println();
	}
	
	private static void printSolution(int [] S, int V) {
		if (V > 0) {
			printSolution(S, V - S[V]);
			System.out.print(S[V] + " ");
		}
	}
}
