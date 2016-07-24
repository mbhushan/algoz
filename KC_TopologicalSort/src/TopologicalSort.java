import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * 
 * @author mbhushan

8
1 4 5
2 4
3 5 8
4 6 7 8
5 7
6 7
7
8 7

5
1 2
2 4
3
4 3
5 3 4

*/

public class TopologicalSort {
	private static Node [] graph;
	private static int [] color;
	private static int [] ftArr;
	private static int TIME = 0;
	private static boolean IS_POSSIBLE = true;
	public static void main(String [] args) {
		readInput();
		printGraph(graph);
		topologicalSort(graph);
	}
	
	public static void topologicalSort(Node [] nodes) {
		if (null == nodes) { return ; }
		int len = nodes.length;
		for (int i=1; i<len; i++) {
			if (0 == color[i]) {
				dfs(nodes, i);
			}
		}
		System.out.println("Topological sorting of vertices gives: ");
		if (!IS_POSSIBLE) {
			System.out.println("Graph has CYCLE! No Topo Sort possible!");
			return;
		}
		for (int i=len-1; i>= 1; i--) {
			System.out.print(ftArr[i] + " ");
		}
		System.out.println();
	}
	
	private static void dfs(Node [] nodes, int u) {
		color[u] = 1;
		Vector<Node> vect = nodes[u].edges;
		int size = vect.size();
		for (int i=0; i<size; i++) {
			int v = vect.get(i).vertex;
			if (color[v] == 1) {
				IS_POSSIBLE = false;
				return;
			}
			if (color[v] == 0) {
				dfs(nodes, v);
			}
		}
		++TIME;
		ftArr[TIME] = u;
		color[u] = 2;
	}
	
	public static void printGraph(Node [] nodes) {
		if (null == nodes) { return ; }
		int len = nodes.length;
		for (int i=1; i<len; i++) {
			System.out.print(nodes[i].vertex + " ");
			Vector<Node> vect = nodes[i].edges;
			int size = vect.size();
			for (int j=0; j<size; j++) {
				System.out.print(vect.get(j).vertex + " ");
			}
			System.out.println();
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			initNodes(n);
			while (n > 0) {
				String [] str = br.readLine().trim().split(" ");
				int u = Integer.parseInt(str[0]);
				int len = str.length;
				for (int i=1; i<len; i++) {
					int v = Integer.parseInt(str[i]);
					graph[u].edges.add(graph[v]);
				}
				--n;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void initNodes(int n) {
		graph = new Node[n+1];
		color = new int[n+1];
		ftArr = new int[n+1];
		for (int i=1; i<=n; i++) {
			graph[i] = new Node(i);
			color[i] = 0;
			ftArr[i] = 0;
		}
	}
}

class Node {
	Integer vertex;
	Vector<Node> edges;
	
	public Node(int v) {
		this.vertex = v;
		edges = new Vector<Node>();
	}
}
