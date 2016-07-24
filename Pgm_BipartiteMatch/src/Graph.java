import java.util.LinkedList;
import java.util.Queue;


public class Graph {
	
	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	private Node [] vertices;
	private int N;
	private int [] color;
	private int [] visited;
	
	public Graph(int n) {
		this.N = n;
		this.vertices = new Node[N];
		this.color = new int[N];
		this.visited = new int[N];
	}
	
	public boolean isBipartite() {
		for (int i=0; i<N; i++) {
			this.color[i] = 0;
			this.visited[i] = 0;
		}
		this.color[0] = 1;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(vertices[0]);
		while (!queue.isEmpty()) {
			Node u = queue.poll();
			int ucol = color[u.data];
			for (Node v=vertices[u.data].next; v!= null; v=v.next) {
				if (color[v.data] == ucol) { return false; }
				if (visited[v.data] == 0) {					
						if (ucol == 1) {
							color[v.data] = 2;
						} else if (ucol == 2) {
							color[v.data] = 1;
						}
					queue.add(v);
				} 				
			}
			
			this.visited[u.data] = 1;
		}
		
		return true;
	}
	public void buildGraph(int [] A) {
		vertices[A[0]] = new Node(A[0]);
		Node node = vertices[A[0]];
		int aLen = A.length;
		for (int i=1; i<aLen; i++) {
			node.next = new Node(A[i]);
			node = node.next;
		}
	}
	
	public void printGraph()  {
		int len = vertices.length;
		
		System.out.println("printing the graph:");
		for (int i=0; i<len; i++) {
			for (Node node=vertices[i]; node != null; node=node.next) {
				System.out.print(node.data + " -> ");
			}
			System.out.println("null");
		}
	}
}
