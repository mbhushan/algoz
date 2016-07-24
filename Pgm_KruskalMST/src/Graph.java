import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
	
	class Node {
		int data;
		Node next;
		
		Node (int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	class Edge {
		Node u;
		Node v;
		int weight;
		public Edge(Node u, Node v, int weight) {
			this.u = u;
			this.v =v;
			this.weight = weight;
		}
	}
	
	public Graph(int N) {
		vertices =  new Node[N];
		parent = new int[N];
		
		
		for (int i=0; i<N; i++)  {
			vertices[i] = new Node(i);
			parent[i] = -1;
		}
	}
	
	public void setNumberOfEdges(int n) {
		edges = new Edge[n];
	}
	
	Node [] vertices;
	int [] parent;
	Edge [] edges;
	
	private static int edgeCount = 0;
	
	Comparator<Edge> comparator = new EdgeWeight();
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>(20, comparator);
	List<Edge> edgeList = new ArrayList<Edge>();
	Set<Edge> edgeSet = new HashSet<Edge>();
	
	public void doKruskalMST() {
		for (int i=0; i<edges.length; i++) {
			int u = edges[i].u.data;
			int v = edges[i].v.data;
			if (findSet(u) != findSet(v)) {
				int k = findSet(v);
				parent[k] = u;
				edgeSet.add(edges[i]);
			}
		}
		
		System.out.println("The kruskal edges are: ");
		Iterator<Edge> iter = edgeSet.iterator();
		while  (iter.hasNext()) {
			Edge e = iter.next();
			System.out.println(e.u.data  + " -> "  + e.v.data + " : W " + e.weight);
		}
	}
	
	public int findSet(int u) {
		int i = parent[u];
		while (i  != -1) {
			u = i;
			i = parent[i];
		}
		
		return u;
	}
	
	public void buildEdges(int u, int v, int w) {
		Edge edge = new Edge(vertices[u], vertices[v], w);
		pq.add(edge);
		edgeList.add(edge);		
		edges[edgeCount] = edge;
		++edgeCount;
	}
	
	public void sortEdgesByWeight() {
		Arrays.sort(edges, new EdgeWeight());
	}
	
	public void sortEdgesCollectionByWeight() {
		Collections.sort(edgeList, new EdgeWeight());
	}
	public void printEdgeArray()  {
		System.out.println("printing the edges: ");
		
		for (int i=0; i<edges.length;i++) {
			System.out.println(edges[i].u.data  + " -> "  + edges[i].v.data + " : W " + edges[i].weight);
		}
	}
	public void printSortedEdges () {
		System.out.println("printing the edges: ");
		Iterator<Edge> it = edgeList.iterator();
		while (it.hasNext()) {
			Edge e = it.next();
			System.out.println(e.u.data  + " -> "  + e.v.data + " : W " + e.weight);
		}
	}
	
	public void printEdges() {
		System.out.println("printing the edges: ");
		Iterator<Edge> it = pq.iterator();
		while  (it.hasNext()) {
			Edge e = it.next();
			System.out.println(e.u.data  + " -> "  + e.v.data + " : W " + e.weight);
		}
	}
	
	class EdgeWeight implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			if (o1.weight < o2.weight) {
				return -1;
			} else if (o1.weight > o2.weight) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
