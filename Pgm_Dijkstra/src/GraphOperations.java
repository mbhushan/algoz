import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GraphOperations {
	public static Graph G;
	
	public static void main(String [] args) {
		readInput();
		G.printGraph();
		G.calcDijkstraShortestPath();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int k = n;
			G = new Graph(n);
			while (n>0) {
				String [] str = br.readLine().split(" ");
				int [] A =  new int[str.length];
				for (int i=0; i<A.length; i++) {
					A[i] = Integer.parseInt(str[i]);
				}
				G.buildGraph(A);
				--n;
			}
			
			while (k>0) {
				String [] str = br.readLine().split(" ");
				int [] A =  new int[str.length];
				for (int i=0; i<A.length; i++) {
					A[i] = Integer.parseInt(str[i]);
				}
				G.populateWeight(A);
				--k;
			}
		
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
