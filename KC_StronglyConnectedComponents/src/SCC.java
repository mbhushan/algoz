import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;


public class SCC {
	//public static int SIZE = 16; //9; //875714;
	public static int SIZE = 875714;
	
	public static Node [] nodes;
	public static Node [] nodesRev;
	public static int [] ft;
	public static int [] ftRev;
	public static boolean [] isExplored;
	public static HashMap<Integer, Integer> sccMap = new HashMap<Integer, Integer>();
	public static int SCC_COUNT = 0;
	public static int TIME = 0;
//	public static PriorityQueue<Integer> minHeap;
	public static String FILE_NAME = "C:\\Users\\mbhushan\\Documents\\workplace\\KC_StronglyConnectedComponents\\SCC.txt";
	
	public static void main(String[] args) {
		init();
		readInput();
		
//		System.out.println("printing original graph: ");
//		printGraph(nodes);
//		System.out.println("printing reversed graph: ");
//		printGraph(nodesRev);
//		
		dfsLoop(nodes);
		//printFinishingTime(ft);
	//	System.out.println("printing finishing time to node mapping: ");
	//	printFinishingTime(ftRev);
		
		sccLoop(nodesRev);
	//	System.out.println("printing scc:");
	//	printMap(sccMap);
		calcTopSCC(sccMap, 5);
	}
	
	public static void init() {
		nodes = new Node[SIZE+1];
		nodesRev = new Node[SIZE+1];
		ft = new int[SIZE+1];
		ftRev = new int[SIZE+1];
		isExplored = new boolean[SIZE+1];
		
		for (int i=1; i<=SIZE; i++) {
			nodes[i] = new Node(i);
			nodesRev[i] = new Node(i);
			isExplored[i] = false;
		}
		
	}
	
	public static void dfsLoop(Node [] graph) {
		for (int i=SIZE; i>=1; i--) {
			if (!isExplored[i]) {
				dfs(graph, i);
				
			}
		}
	}
	public static void dfs(Node [] graph, int i) {
		isExplored[i] = true;
		Vector<Node> vect = graph[i].edges;
		int size = vect.size();
		for (int j=0; j<size; j++) {
			if (!isExplored[vect.get(j).vertex]) {
				dfs(graph, vect.get(j).vertex);				
			}
		}
		++TIME;
		ft[i] = TIME;
		ftRev[TIME] = i;
		
	}
	
	public static void sccLoop(Node [] graph) {
		for (int i=1; i<=SIZE; i++) {
			isExplored[i] = false;
		}
		for (int i=SIZE; i>=1; i--) {
			int u = ftRev[i];
			if (!isExplored[u]) {
				++SCC_COUNT;
				scc(graph, u);
			//	System.out.println("U:: " + u + "::: SCC:" + SCC_COUNT);
				sccMap.put(u, SCC_COUNT);
				SCC_COUNT = 0;
			}
		}
	}
	
	public static void scc(Node [] graph, int i) {
		isExplored[i] = true;
		Vector<Node> vect = graph[i].edges;
		int size = vect.size();
		for (int j=0; j<size; j++) {
			if (!isExplored[vect.get(j).vertex]) {
				++SCC_COUNT;
				scc(graph, vect.get(j).vertex);				
			}
		}
	}
	
	public static void printMap(HashMap<Integer, Integer> map) {
		if (null == map) { return ; }
		Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> pair = iter.next();
			System.out.println("Leader: " + pair.getKey() + "::: SCC: " + pair.getValue() );
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			File file = new File(FILE_NAME);
			Scanner scanner = new Scanner(file);
			int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
               // System.out.println(line);
                String [] strArr = line.trim().split(" ");
				
				int u = Integer.parseInt(strArr[0]);
				int v = Integer.parseInt(strArr[1]);
			//	System.out.println("U:"  + u + " :: V:" + v);
				//add the new edge to orig graph - nodes
				nodes[u].edges.add(nodes[v]);
				
				//add the new edge in reversed direction in Graph_Rev - nodesRev;
				nodesRev[v].edges.add(nodesRev[u]);
                ++counter;
            }
           // SIZE = counter;
            System.out.println("EDGE_COUNTER::" + counter);
            scanner.close();
            
//			int n = Integer.parseInt(br.readLine());
//			
//			while (n > 0) {
//				String [] strArr = br.readLine().trim().split(" ");
//				
//				int u = Integer.parseInt(strArr[0]);
//				int v = Integer.parseInt(strArr[1]);
//			//	System.out.println("U:"  + u + " :: V:" + v);
//				//add the new edge to orig graph - nodes
//				nodes[u].edges.add(nodes[v]);
//				
//				//add the new edge in reversed direction in Graph_Rev - nodesRev;
//				nodesRev[v].edges.add(nodesRev[u]);
//				
//				--n;
//			}
			System.out.println();
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void printFinishingTime(int [] A) {
		if (null == A) { return ; }
		int len = A.length;
		for (int i=1; i<len; i++) {
			System.out.println(i + "::" + A[i]);
		}
		System.out.println();
	}
	
	public static void printGraph(Node [] nodes) {
		if (null == nodes) { return; }
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
	
	
	
	public static void calcTopSCC(HashMap<Integer, Integer> map, int k) {
		if (sccMap == null || sccMap.size() < 1) {
			return ;
		}
		
	//	minHeap = new PriorityQueue<Integer>(k, new SCCComparator());
		Vector<Integer> vector = new Vector<Integer>();
		Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> pair = iter.next();
			int value = pair.getValue();
		//	minHeap.add(value);
			vector.add(value);
		}
		
//		while (!minHeap.isEmpty()) {
//			System.out.print(minHeap.remove() + " ");
//		}
		System.out.println();
		Collections.sort(vector);
		int len = vector.size();
		int num = len;
		System.out.println("LEN: " + len);
		if (len < k) {
			k = len;
		}
		int sumNode = 0;
		while (k > 0) {
			System.out.print(vector.get(--len) + " ");
			--k;
		}
		while (num > 0) {
			sumNode = sumNode + vector.get(--num);
		}
		System.out.println("Total Nodes: " + sumNode);
	}

}

class Node {
	Integer vertex;
	Vector<Node> edges;
	
	public Node(Integer value) {
		this.vertex = value;
		edges = new Vector<Node>();
	}
}

class SCCComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer arg0, Integer arg1) {
		if (arg0 < arg1) {
			return -1;
		} else if (arg0 > arg1) {
			return 1;
		} else {
			return 0;
		}
	}
	
}