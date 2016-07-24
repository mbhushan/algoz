import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Vector;


public class MST {
	private static Node [] graph ;
	public static void main(String [] args) {
		readInput();
		//printGraph();
		prims();
	}
	
	public static void prims() {
		//init priority queue.
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(10, new NodeComparator());
		HashSet<Node> S = new HashSet<Node>();
		
		int n = graph.length;
		graph[1].cost = 0;
		for (int i=1; i<n; i++) {
			minHeap.add(graph[i]);
		}
		
		while (!minHeap.isEmpty()) {
			Node U = minHeap.remove();
			S.add(U);
			
			//decrease key operations on the nodes present on heap.
			Vector<Node> e = U.edges;
			Vector<Integer> ec = U.edgeCost;
			
		//	System.out.println("U: " + U.vertex + ":: U.cost: " + U.cost);
			int size = e.size();
			for (int j=0; j<size; j++) {
				Node V = e.get(j);
				if (S.contains(V)) {
					continue;
				}
				int ecost = ec.get(j);
				if (ecost < V.cost) {
					minHeap.remove(V);
					V.cost = ecost;
					minHeap.add(V);
				}
				//System.out.print(V.vertex + ":" + ec.get(j) + " ");
			}
		}
		
		long mstCost = 0;
		for (int i=1; i<n; i++) {
			mstCost += graph[i].cost;
		}
		System.out.println("MST Cost: " + mstCost);
		
	}
	
	public static void printGraph() {
		int len = graph.length;
		
		for (int i=1; i<len; i++) {
			Node U = graph[i];
			System.out.print(U.vertex + " ");
			Vector<Node> e = U.edges;
			Vector<Integer> ec = U.edgeCost;
			
			int n = e.size();
			for (int j=0; j<n; j++) {
				System.out.print(e.get(j).vertex + ":" + ec.get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().trim().split(" ");
			int vertices = Integer.parseInt(str[0]);
			int edges = Integer.parseInt(str[1]);
			
			graph = new Node[vertices+1];
			for (int i=1; i<=vertices; i++) {
				graph[i] = new Node(i, Integer.MAX_VALUE);
			}
			
			while (edges > 0) {
				str = br.readLine().trim().split(" ");
				int u = Integer.parseInt(str[0]);
				int v = Integer.parseInt(str[1]);
				int c = Integer.parseInt(str[2]);
				
				graph[u].edges.add(graph[v]);
				graph[u].edgeCost.add(c);
				
				graph[v].edges.add(graph[u]);
				graph[v].edgeCost.add(c);
				
				--edges;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Node {
	Integer vertex;
	Integer cost;
	
	Vector<Node> edges;
	Vector<Integer> edgeCost;
	
	public Node(int v, int c) {
		this.vertex = v;
		this.cost = c;
		
		edges = new Vector<Node> ();
		edgeCost = new Vector<Integer>();
	}
}

class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.cost < o2.cost) {
			return -1;
		} else if (o1.cost > o2.cost) {
			return 1;
		} else {
			return 0;
		}
	}
}