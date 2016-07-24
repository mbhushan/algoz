import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Graphs {
	private static String [][] adjList;
	private static Map<String, Integer> nodeMap = new HashMap<String, Integer>();
	private static int [] indegree ;
	public static void main(String[] args) {
		readInput();
		System.out.println("printing adjacency list: ");
		printAdjList();
		System.out.println("printing indegree of nodes: ");
		printIndegree();
		System.out.println("Does Graph has cycle ? " + graphHasCycle());
		
	}
	
	public static boolean graphHasCycle() {
		
		int zeroIndegreeIndex = getZeroIndegree();
		while (zeroIndegreeIndex >=0) {
			int len = adjList[zeroIndegreeIndex].length;
			for (int i=1; i<len; i++) {
				--indegree[nodeMap.get(adjList[zeroIndegreeIndex][i])];
			}
			zeroIndegreeIndex = getZeroIndegree();
		}
		
		return checkNonZeroIndegree();
	}
	
	private static boolean checkNonZeroIndegree() {
		int len = indegree.length;
		for (int i=0; i<len; i++) {
			if (indegree[i] > 0) {
				return true;
			}
		}
		return false;
	}
	private static int getZeroIndegree() {
		int len = indegree.length;
		for (int i=0; i<len; i++) {
			if (indegree[i] == 0) {
				indegree[i] = -1;
				return i;
			}
		}
		return -1;
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
	
	private static void printIndegree() {
		Iterator<Entry<String, Integer>> iter = nodeMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>)iter.next();
			System.out.println(pair.getKey() + ":" + indegree[pair.getValue()]);
		}
	}
	
	private static void doNodeMapping(String [] nodes) {
		if (nodes == null) { return ; }
		int nlen = nodes.length;
		for (int i=0; i<nlen; i++) {
			nodeMap.put(nodes[i], i);
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] nodes = br.readLine().split(" ");
			int nLen = nodes.length;
			adjList = new String[nLen][];
			indegree = new int[nLen];
			doNodeMapping(nodes);
			int i=0;
			while (i <nLen) {
				String [] temp = br.readLine().split(" ");
				int tLen = temp.length;
				adjList[i] = new String[tLen];
				for (int j=0; j<tLen; j++) {
					adjList[i][j] = temp[j];
					if (j == 0) { continue; }
					++indegree[nodeMap.get(temp[j])];
				}
				++i;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
