import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 * Dijkstra single source shortest path.
 * @author mbhushan
 *
 */
public class DijkstraSSSP {
	private static Node [] graph;
	private static int [] parent;
	private static PriorityQueue<Node> heap;
	public static void main(String [] args) {
		readInput();
	//	printGraph(graph);
		dijkstra();
	}
	
	public static void dijkstra() {
		//graph[1].weight = 0; //starting vertex
		System.out.println("Starting dijkstra: ");
		while (!heap.isEmpty()) {
			Node u = heap.remove();
		//	System.out.println("EXTRACT_MIN:: " + u.vertex + "::" + u.weight);
			Vector<Node> edges = u.edges;
			Vector<Integer> weights = u.edgeWeights;
			int size = edges.size();
			for (int i=0; i<size; i++) {
				int v = edges.get(i).vertex;
				int w = weights.get(i);
				if (graph[v].weight > (u.weight + w)) {
					heap.remove(graph[v]);
			//		System.out.println("RELAXING:: " + "V: " + v + " :: v_w:" + graph[v].weight + "::_uw: " + u.weight + " :: w: " + w);
					graph[v].weight = u.weight + w;
					parent[v] = u.vertex;
					heap.add(graph[v]);
				}
				//System.out.println("AFTER_RELAXING::: V: " + v + "::: vw:" + graph[v].weight);
			}
			
		}
		int [] A = {7,37,59,82,99,115,133,165,188,197};
		int len = A.length;
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<len; i++) {
			System.out.println("V: " + graph[A[i]].vertex + ":: dist: " + graph[A[i]].weight);
			sb.append(graph[A[i]].weight + ",");
		}
		System.out.println(sb.toString());
		
	}
	
	public static void printGraph(Node [] nodes) {
		if (null == nodes) { return ; }
		int len = nodes.length;
		for (int i=1; i<len; i++) {
			System.out.print(nodes[i].vertex + " ");
			int size = nodes[i].edges.size();
			for (int j=0; j<size; j++) {
				int u = nodes[i].edges.get(j).vertex;
				int w = nodes[i].edgeWeights.get(j);
				System.out.print(u + "," + w + " ");
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
					String [] vw = str[i].split(",");
					int v = Integer.parseInt(vw[0]);
					int w = Integer.parseInt(vw[1]);
					graph[u].edges.add(graph[v]);
					graph[u].edgeWeights.add(w);
				}
				--n;
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initNodes(int n) {
		graph = new Node[n+1];
		parent = new int[n+1];
		heap = new PriorityQueue<Node>(n, new NodeComparator());
		
		for (int i=1; i<=n; i++) {
			graph[i] = new Node(i, Integer.MAX_VALUE);
			parent[i] = -1;
			heap.add(graph[i]);
		}
		graph[1].weight = 0;
		for (int i=1; i<=n; i++) {
			heap.add(graph[i]);
		}
		
	}
}

class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.weight < o2.weight) {
			return -1;
		} else if (o1.weight > o2.weight) {
			return 1;
		} else {
			return 0;
		}
	}
}

class Node {
	Integer vertex;
	Integer weight;
	Vector<Node> edges;
	Vector<Integer> edgeWeights;
	public Node (Integer v, Integer w) {
		this.vertex = v;
		this.weight = w;
		this.edges = new Vector<Node>();
		this.edgeWeights = new Vector<Integer>();
	}
}
