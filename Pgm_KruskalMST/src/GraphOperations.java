import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GraphOperations {

	private static Graph G;
	
	public static void main(String [] args) {
		readInput();
		//G.printEdges();
		G.sortEdgesCollectionByWeight();
		G.printSortedEdges();
		G.doKruskalMST();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			G =  new Graph(n);
			n = Integer.parseInt(br.readLine());
			G.setNumberOfEdges(n);
			while (n > 0) {
				String [] str = br.readLine().split(" ");
				int u = Integer.parseInt(str[0]);
				int v = Integer.parseInt(str[1]);
				int w = Integer.parseInt(str[2]);
				G.buildEdges(u, v, w);
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
