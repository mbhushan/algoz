import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GraphOperations {
	public static Graph G;
	
	public static void main(String [] args) {
		readInput();
		G.printGraph();
		System.out.println("is the graph bipartite? " + G.isBipartite());
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			G = new Graph(n);
			
			while (n>0) {
				String [] str = br.readLine().split(" ");
				int [] A = new int[str.length];
				int len = A.length;
				for (int i=0; i<len; i++) {
					A[i] = Integer.parseInt(str[i]);
				}
				G.buildGraph(A);
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
