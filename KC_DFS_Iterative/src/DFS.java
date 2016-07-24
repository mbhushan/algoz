import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class DFS {
	
	private static String [][] adjList;
	private static Map<String, Integer> nodeMap = new HashMap<String, Integer>();
	private static Map<String, Boolean> visitedMap = new HashMap<String, Boolean>();
	
	public static void main(String[] args) {
		readInput();
		System.out.println("printing adjacency list: ");
		printAdjList();
		System.out.println("printing DFS: ");
		doDFS();
	}
	
	public static void doDFS() {
		Stack<String> stack = new Stack<String>();
		Stack<String> opStack = new Stack<String>();
		String S = adjList[0][0];
		stack.push(S);
		visitedMap.put(S, true);
		while (!stack.isEmpty()) {
			String U = stack.peek();
			int uIndex = nodeMap.get(U);
			int len = adjList[uIndex].length;
			boolean allVisited = true;
			for (int i=1; i<len; i++) {
				String V = adjList[uIndex][i];
				if (visitedMap.containsKey(V)) { continue; }
				else {
					stack.push(V);
					visitedMap.put(V, true);
					allVisited = false;
					break;
				}
			}
			// if all the nodes adj to U are visited then pop U.
			if (allVisited) {
				opStack.push(stack.pop());
			}
		}
		while (!opStack.isEmpty()) {
			System.out.print(opStack.pop() + " ");
		}
		System.out.println();
	}
	
	public static void printAdjList() {
		int r = adjList.length;
		for (int i=0; i<r; i++) {
			int c = adjList[i].length;
			for (int j=0; j<c; j++) {
				System.out.print(adjList[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void doNodeMapping(String [] nodes) {
		if (null == nodes) { return ; }
		int len = nodes.length;
		
		for (int i=0; i<len; i++) {
			nodeMap.put(nodes[i], i);
		}
	}
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] nodes = br.readLine().split(" ");
			doNodeMapping(nodes);
			
			int len = nodes.length;
			adjList = new String[len][];
			
			int i=0;
			while (i<len) {
				String [] temp = br.readLine().split(" ");
				int tlen = temp.length;
				adjList[i] = new String[tlen];
				for (int j=0; j<tlen; j++) {
					adjList[i][j] = temp[j];
				}
				++i;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
