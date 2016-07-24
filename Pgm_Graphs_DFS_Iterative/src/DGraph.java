import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class DGraph {

	private int N;
	
	class Node {
		int data;
		Node next;
		boolean visited;
		
		public Node(int data) {
			this.data = data;
			visited = false;
		}
	}
	
	private Node vertices[];
	
	public DGraph() {
		vertices = null;
	}
	
	public void setNumOfVertices(int n) {
		this.N = n;
		vertices = new Node[N+1];
	}
	
	public void buildGraph(int [] A) {
		int n = A[0];
		vertices[n] = new Node(n);
		
		Node node = vertices[n];
		
		for (int i=1; i<A.length; i++)  {
			node.next = new Node(A[i]);
			node = node.next;
		}
	}
	
	public void doDFS() {
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> st = new Stack<Node>();
		vertices[1].visited = true;
		
		stack.push(vertices[1]);
		
		while (!stack.isEmpty()) {
			Node vertex = (Node)stack.peek();
			if (allVisited(vertex)) {
				st.push(stack.pop());
			} else {
				Node node = findUnvisited(vertex);
				if (null != node) {
					node.visited = true;
					stack.push(node);
				}
			}
		}
		
		System.out.println("DFS traversal of the graph gives: ");
		while (!st.isEmpty()) {
			Node node = (Node)st.pop();
			System.out.print(node.data + " ");
		}
		System.out.println();
	}
	
	private Node findUnvisited(Node node) {
		for (Node temp=node;temp!=null; temp=temp.next) {
			if (!temp.visited) {
				return temp;
			}
		}
		return null;
	}
	
	private boolean allVisited(Node node) {
		for (Node temp=node; temp!=null; temp=temp.next) {
			if (!temp.visited) {				
				return false;
			}
		}
		return true;
	}
	
	public void printGraph() {
		for (int i=1; i<vertices.length; i++) {
			for (Node node=vertices[i]; node != null; node=node.next) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
}
