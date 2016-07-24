import java.util.LinkedList;
import java.util.Queue;


public class DirectedGraph {
	
	private int V ;
	class Node {
		Node next;
		int data;
		
		Node (int data) {	this.data = data;	}
	}
	
	Node [] vertex;
	int [] visited;
	
	public DirectedGraph() {
		vertex = null;
		V = 0;
	}
	
	public void setNumOfNodes(int v) { 
		this.V = v;
		vertex  = new Node[v+1];
		visited = new int[v+1];
	}
	
	public void buildGraph(int [] A) {
		int n = A[0];
		vertex[n] = new Node(A[0]);
		Node node =  vertex[n];
		
		for(int i=1; i<=A.length-1; i++) {
			node.next = new Node(A[i]);
			node = node.next;
		}
	}
	
	public void printGraph() {
		for (int i=1; i<vertex.length; i++) {
			for (Node node = vertex[i]; node != null; node=node.next) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
	
	public void doBFS() {
		Queue<Node> qe = new LinkedList<Node>();
		qe.add(vertex[1]);
		
		while (!qe.isEmpty()) {
			Node node = qe.poll();
			Node temp = node.next;
			while (temp != null) {
				//System.out.println("q add: " + temp.data);
				qe.add(temp);
				temp = temp.next;
			}
			int value = node.data;
			if (visited[value] == 0) {
				System.out.print(value + " ");
				visited[value] = 1;
			}			
		}
	}
}
