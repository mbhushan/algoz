import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;


public class Graph {
	
	class Node {
		int data;
		int key;
		Node next;
		Node(int data) {
			this.data = data;
			key = Integer.MAX_VALUE;
		}
	}
	
	Node [] vertices;
	int [] parent ;
	int [] distance;
	int [][] weight;
	
	public Graph(int N) {
		vertices = new Node[N];
		parent = new int[N];
		distance = new int[N];
		weight = new int[N][N];
	}
	
	public void calcDijkstraShortestPath() {
		vertices[0].key = 0;
		Set<Node> vertexSet = new HashSet<Node>();
		PriorityQueue<Node> pq = new PriorityQueue<Node>(10,new KeyComparator());
		
		for (int i=1; i<parent.length; i++) {
			parent[i] = -1;
			distance[i] = Integer.MAX_VALUE;
			pq.add(vertices[i]);
		}
		distance[0] = 0;
		vertices[0].key = 0;
		parent[0] = -1;
		pq.add(vertices[0]);
		
		
		while (!pq.isEmpty()) {
			Node u = pq.poll();
			System.out.println("U: " + u.key);
			vertexSet.add(u);
			for (Node v=u.next; v!=null; v=v.next) {
				if (distance[v.data] > (distance[u.data] + weight[u.data][v.data]))  {
					//vertices[v.data].key = u.key + weight[u.data][v.data];
					parent[v.data] = u.data;
					distance[v.data] = distance[u.data] + weight[u.data][v.data];
					vertices[v.data].key = distance[v.data];
				}
			}
		}
		System.out.println("Shortest distance to vertices are: ");
		Iterator<Node> it = vertexSet.iterator();
		while (it.hasNext()) {
			Node node = it.next();
			System.out.println(node.data + " : " + distance[node.data]);
		}
	}
	
	class KeyComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			if (o1.key < o2.key) {
				return -1;
			} else if (o1.key > o2.key) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public void printGraph() {
		System.out.println("printing the graph: ");
		for (int i=0; i<vertices.length; i++) {
			for (Node node=vertices[i]; node != null; node=node.next) {
				System.out.print(node.data + " -> ");
			}
			System.out.println("null");
		}
		System.out.println("Printing weights of the graph: ");
		for (int i=0; i<weight.length; i++) {
			for (int j=0; j<weight[i].length; j++) {
				System.out.print(weight[i][j]  + " ");
			}
			System.out.println();
		}
	}
	public void populateWeight(int [] W) {
		int r = W[0];
		
		for (int j=1; j<W.length; j=j+2) {
			weight[r][W[j]] = W[j+1]; 
		}
	}
	
	public void buildGraph(int [] A){
		vertices[A[0]] = new Node(A[0]);
		int len = A.length;
		Node node =  vertices[A[0]];
		for (int i=1; i<len; i++) {
			node.next  = new Node(A[i]);
			node = node.next;
		}
	}
}
