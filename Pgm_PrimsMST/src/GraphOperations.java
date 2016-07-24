import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GraphOperations {
	private static Graph G;
	
	
	public static void main(String [] args) {
		readInput();
		G.printGraph();
		G.printWeights();
		G.doPrimMST();
	}
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int v = Integer.parseInt(br.readLine());
			G = new Graph(v);
			while  (v > 0) {
				String [] str = br.readLine().split(" ");
				int [] A = new int[str.length];
				for  (int i=0; i < A.length; i++) {
					A[i] = Integer.parseInt(str[i]);
				}
				G.buildGraph(A);
				--v;
			}
			v  = Integer.parseInt(br.readLine());
			while  (v > 0) {
				String [] str = br.readLine().split(" ");
				int [] W = new int[str.length];
				for  (int i=0; i < W.length; i++) {
					W[i] = Integer.parseInt(str[i]);
				}
				G.assignWeights(W);
				--v;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
