import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GOperations {
	
	private static DGraph dg;
	
	public static void main(String[] args) {
		dg = new DGraph();
		
		GOperations go = new GOperations();
		go.readInput();
		System.out.println("Printing the graph: ");
		dg.printGraph();
		dg.doDFS();
	}
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String s = br.readLine();
			int n = Integer.parseInt(s);
			dg.setNumOfVertices(n);
			
			while (n>0) {
				String [] str = br.readLine().split(" ");
				int [] A = new int[str.length];
				
				for (int i=0; i<str.length; i++) {
					A[i] = Integer.parseInt(str[i]);
				}
				dg.buildGraph(A);
				--n;
			}
			br.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
