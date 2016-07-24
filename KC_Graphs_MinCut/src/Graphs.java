import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Graphs {
	private static Node [] gnodes;
	private static int [] vertices;
	private static int currentLen;
	private static int minCut = Integer.MAX_VALUE;
	public static void main(String [] args) {
		readInput();
	//	printAdjacencyList();
		//int [] A = {3,1,4,5,6,2};
	//	int [] A = {1, 5, 6, 8, 2, 4, 7, 3};
		//vertices = A;
		int len = vertices.length;
		len = 2;
//		for (int i=0; i<(len*len); i++) {
//			shuffleVertices();
//			printVertices();
//			minCut(gnodes);
//			System.out.println("Min Cut for the graph::" + minCut);
//		}
//		System.out.println("Min Cut for the graph::" + minCut);
	}
	
	public static void minCut(Node [] nodes) {
		int len = vertices.length;
		for (int i=0; i<len-2; i++) {
			int u = vertices[i];
			int v = -1;
			int nLen = nodes[u].neighbors.length;
			int j=0;
			while (j < nLen) {
			//	System.out.println("inside while J");
				if (nodes[u].neighbors[j] != null) {
					v = nodes[u].neighbors[j].data;
					break;
				}
				++j;
			}
			//System.out.println("U: " + u + "::V: " + v);
			int m = nodes[v].neighbors.length;
			
			Node [] temp = new Node[nLen + m];
			for (j=0; j<nodes[v].neighbors.length; j++) {
				temp[j] = nodes[v].neighbors[j];
			}
			nodes[v].neighbors = temp;
			
			Node [] adj = nodes[u].neighbors;
			int adjLen = adj.length;
			for (int n=0; n<adjLen; n++) {
				if (adj[n] == null) {
					continue;
				}
				int w = adj[n].data;
				if (w == v) {
					for (int k=0; k<nodes[v].neighbors.length; k++) {
						if ((nodes[v].neighbors[k] != null) && (nodes[v].neighbors[k].data == u)) {
							nodes[v].neighbors[k] = null;
						}
					}
				} else {
					for (int k=0; k<nodes[w].neighbors.length; k++) {
						if ((nodes[w].neighbors[k] != null) && (nodes[w].neighbors[k].data == u)) {
							nodes[w].neighbors[k] = nodes[v];
							nodes[v].neighbors[m++] = nodes[w];
						}
					}
				}
			}
			nodes[u].neighbors = null;
			//System.out.println("ADJ______________:::" + i );
			//printAdjacencyList();
		}
	//	System.out.println("FINAL ADJ LIST::::" );
		//printAdjacencyList();
		int u = nodes[vertices[len-1]].data;
		int ulen = nodes[u].neighbors.length;
		int count = 0;
		for (int i=0; i<ulen; i++) {
			if (nodes[u].neighbors[i] != null) {
				++count;
			}
		}
		if (count < minCut) {
			minCut = count;
		}
	}
	
	public static void shuffleVertices() {
		int len = vertices.length;
		//init the vertices array;
		for (int i=0; i<len; i++) {
			vertices[i] = i+1;
		}
		//shuffle the vertices;
		Random rand = new Random();
		for (int i=len-1; i>=0; i--) {
			int r = rand.nextInt(i+1);
			//swap i and r
			int temp = vertices[r]; 
			vertices[r] = vertices[i];
			vertices[i] = temp;
		}
	}
	
	public static void printVertices() {
		int len = vertices.length;
		System.out.println("shuffled vertices: ");
		for (int i=0; i<len; i++) {
			System.out.print(vertices[i] + " ");
		}
		System.out.println();
	}
	public static void printAdjacencyList() {
		System.out.println("printing adjacency list: ");
		for (int i = 1; i <= currentLen; i++) {
			System.out.print(gnodes[i].data + " ");
			if (gnodes[i].neighbors != null) {
				int len = gnodes[i].neighbors.length;
				for (int j = 0; j < len; j++) {
					if (gnodes[i].neighbors[j] != null) {
						System.out.print(gnodes[i].neighbors[j].data + " ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void readInput() {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine().trim());
			gnodes = new Node[n+1];
			vertices = new int[n];
			currentLen = n;
			for (int i=1; i<=n; i++) {
				gnodes[i] = new Node(i);
			}
			
			while (n > 0) {
				String [] strArr = br.readLine().trim().split(" ");
				int len = strArr.length;
				int u = Integer.parseInt(strArr[0]);
				gnodes[u].neighbors = new Node[len-1];
				
				for (int i=1; i<len; i++) {
					int v = Integer.parseInt(strArr[i]);
					gnodes[u].neighbors[i-1] = gnodes[v]; 
				}
				--n;
			}
			for (int i=0; i<10; i++) {
				shuffleVertices();
				//printVertices();
				Node [] nodes = copyGraph();
				minCut(nodes);
				//System.out.println("Min Cut for the graph::" + minCut);
			}
			System.out.println("Min Cut for the graph::" + minCut);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Node [] copyGraph() {
		int len = gnodes.length;
		Node [] nodes = new Node[len];
		
		for (int i=1; i<len; i++) {
			int value = gnodes[i].data;
			int n = gnodes[i].neighbors.length;
			nodes[i] = new Node(value);
			nodes[i].setNeighbors(n);
		}
		
		for (int i=1; i<len; i++) {
			Node [] neighbors = gnodes[i].neighbors;
			int nLen = neighbors.length;
			for (int j=0; j<nLen; j++) {
				nodes[i].neighbors[j] = nodes[neighbors[j].data];
			}
			//shuffle neighbors.
			for (int k=nLen-1; k>=0; k--) {
				Random rand = new Random();
				int r = rand.nextInt(k+1);
				Node temp = nodes[i].neighbors[r];
				nodes[i].neighbors[r] = nodes[i].neighbors[k];
				nodes[i].neighbors[k] = temp;
			}
		}
		
		
		return nodes;
	}

}

class Node {
	Integer data;
	Node [] neighbors;
	
	public Node(Integer data) {
		this.data = data;
	}
	
	public void setNeighbors(int n) {
		this.neighbors = new Node[n];
	}
}
