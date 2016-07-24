import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GraphOperations {
	
	private static DirectedGraph dg;
	private static BufferedReader br;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		dg = new DirectedGraph();	
		GraphOperations obj = new GraphOperations();
		obj.readInput();
		obj.graphOperations();
	}
	
	public void graphOperations() {
		System.out.println("Printing the graph: ");
		dg.printGraph();
		System.out.println("DFS traversal of the graph: ");
		dg.doBFS();
	}
	
	public  void readInput() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		N =  Integer.parseInt(s);
		dg.setNumOfNodes(N);
		
		int n = N;
		while (n>0) {
			String [] str = br.readLine().split(" ");
			int [] A = new int[str.length];
			
			for (int i=0; i<str.length; i++)  {
				A[i] = Integer.parseInt(str[i]);
			}
			dg.buildGraph(A);
			--n;
		}
	}
}
