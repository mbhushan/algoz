import java.util.Comparator;
import java.util.PriorityQueue;


public class Graph {
	
	class Node {
		int data;
		Node next;
		int key;
		
		Node (int data) {
			this.data = data;
			next = null;
		}
	}
	
	Node [] vertices;
	int [][] weights;
	int [] parent;
	int [] key;
	int [] visited;
	
	public Graph(int N) {
		vertices = new Node[N];
		weights = new int[N][N];
		parent = new int[N];
		key = new int[N];
		visited = new int[N];
		
	}
	
	public void doPrimMST() {
		for (int i=0; i<parent.length; i++) {
			parent[i] = -1;
			key[i] = Integer.MAX_VALUE;
			vertices[i].key = Integer.MAX_VALUE;
			visited[i] = 0;
		}
		vertices[0].key = 0;
		
		Comparator<Node> comparator = new KeyComparator();
		PriorityQueue<Node> pq = new PriorityQueue<Node>(10, comparator);
		
		for (int i=0; i<key.length; i++) {			
			pq.add(vertices[i]);
		}
		
		while (!pq.isEmpty()) {
			Node K = pq.remove();
			int u = K.data;
			System.out.println("U: " + u);
			
			for (Node node=vertices[u].next; node != null; node=node.next) {
				int v = node.data;
				if (v ==  7) {
					System.out.println("V: " + v);
					System.out.println(pq.contains(vertices[v]));
					boolean wc = (weights[u][v]  < key[v]);
					System.out.println("weight comparison: " + wc );
				}
				if  (pq.contains(vertices[v]) && (weights[u][v]  < key[v])) {
					parent[v] = u;
					key[v]  = weights[u][v];
					vertices[v].key = key[v];
				}
			}
		}
		
		System.out.println("prim mst is: ");
		
		for (int i=1; i<parent.length; i++) {
			System.out.println(i + " - " + parent[i] + " - W: " + key[i]);
		}
		System.out.println("DONE");
	}
	class KeyComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			if (o1.key <  o2.key) {
				return -1;
			} else if (o1.key >  o2.key) {
				return 1;
			} else {
				return 0;
			}
		}
		
	}
	public void buildGraph(int [] A) {
		vertices[A[0]] = new Node(A[0]);
		Node node = vertices[A[0]];
		for (int i=1;  i<A.length; i++) {
			node.next =  new Node(A[i]);
			node = node.next;
		}
	}
	
	public void assignWeights(int [] W) {
		int i = W[0];
		
		for (int j=1; j<W.length;  j=j+2) {
			weights[i][W[j]] = W[j+1];
		}
	}
	
	public void printGraph() {
		System.out.println("printing graph: ");
		for (int i=0; i<vertices.length; i++) {
			for (Node node=vertices[i]; node != null; node=node.next) {
				System.out.print(node.data + " -> ");
			}
			System.out.println("null");
		}
	}
	
	public void printWeights() {
		
		int n = vertices.length;
		System.out.println("printing weights: ");
		for  (int i=0; i<n;  i++) {
			for  (int j=0; j<n; j++) {
				System.out.print(weights[i][j] + " ");
			}
			System.out.println();
		}
	}
}
