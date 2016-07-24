import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Bipartite {
	private static String [][] adjList;
	private static Map<String, Integer> colorMap = new HashMap<String, Integer>();
	private static Map<String, Boolean> visitedMap = new HashMap<String, Boolean>();
	private static Map<String, Integer> nodeMap = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		readInput();
		//printAdjList();
		boolean isBipartite = checkBipartite();
		System.out.println("Is Bipartite: " + isBipartite);
	}
	
	public static boolean checkBipartite() {
		int r=0; int c=0;
		Queue<String> queue = new LinkedList<String>();
		String s = adjList[r][c];
		queue.add(s);
		colorMap.put(s, 1);
		while (!queue.isEmpty()) {
			String u = queue.remove();
			int index = nodeMap.get(u);
			int len = adjList[index].length;
			int srcColor = colorMap.get(u);
			int color = srcColor == 1 ? 2: 1;
			for (int i=1; i<len; i++) {
				String v = adjList[index][i];
				Integer destColor = colorMap.get(v);
				if ((destColor != null) && (srcColor == destColor)) {
					return false;
				}
				if (!visitedMap.containsKey(v)) {
					colorMap.put(v, color);
					queue.add(v);
				}
			}
			visitedMap.put(u, true);
		}
		return true;
	}
	
	public static void printAdjList() {
		if (adjList == null) { return ; }
		
		int r = adjList.length;
		for (int i=0; i<r; i++) {
			int c = adjList[i].length;
			for (int j=0; j<c; j++) {
				System.out.print(adjList[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void makeNodeMappings(String [] nodes) {
		if (nodes == null) { return ; }
		int len = nodes.length;
		for (int i=0; i<len; i++) {
			nodeMap.put(nodes[i], i);
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] nodes = br.readLine().split(" ");
			int len = nodes.length;
			adjList = new String[len][];
			makeNodeMappings(nodes);
			int i=0;
			while (i < len) {
				String [] temp = br.readLine().split(" ");
				int tLen = temp.length;
				adjList[i] = new String[tLen];
				for (int j=0; j<tLen; j++) {
					adjList[i][j] = temp[j];
				}
				++i;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
