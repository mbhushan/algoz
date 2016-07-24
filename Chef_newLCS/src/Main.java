import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


class Vertex {
	public int x;
	public int y;
	
	public Set<Vertex> link = new HashSet<Vertex>();
	public char ch;
	public int max =0;
	public String parent ;
	public int color = 0;
	public int time = 0;
	public boolean hasIndegree = false;
	//public List<Integer> degree = new LinkedList<Integer>();
	//public Set<String> lcs = new HashSet<String>();
}

public class Main {
	public static String X;
	public static String Y;
	public static int[][] C ;
	public static int lcsCount = 0;
	public static int lcsLength = 0;
	public static String string ;
	public static char []x;
	public static char []y;
	
	public static Set<String> set =new HashSet<String>();;
	
	public static List<Vertex> list = new LinkedList<Vertex>();
	public static Map<String,Vertex> vertexMap = new HashMap<String, Vertex>();
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		readInput();
		
	}
	
	public static void allLCS(int r, int c) {
		Vertex v = new Vertex();
		v.x = r;
		v.y = c;
		v.ch = X.charAt(r-1);
		v.parent = X.charAt(r-1) + "";
		v.max = 1;
		
		
		int col = 1;
		int row = 1;
		for (int i=r-1; i >= row; i--) {
			for (int j=c-1; j >= col; j--) {

				if (X.charAt(i-1) == Y.charAt(j-1)) {
					Vertex tmp  = (Vertex)vertexMap.get(i+""+j);
					v.link.add(tmp);
					tmp.hasIndegree = true;
					vertexMap.put(i+""+j, tmp);
					list.remove(tmp);
					col = tmp.y+1;
				}
			}
		}
		list.add(v);
		vertexMap.put(r+""+c, v);
	}
	
	public static void plotGraph() {
		Iterator<Vertex> it = list.iterator();
		
		while (it.hasNext()) {
			Vertex v = it.next();
			
			System.out.print(v.hasIndegree + " " + v.ch + " - ");
			Iterator<Vertex> st = v.link.iterator();
			while (st.hasNext()) {
				System.out.print(st.next().ch + " - ");
			}
			System.out.println("null");
		}
	}
	public static void dfsVisit(Vertex u) {
		u.color = 1;
		u.time = 1;
		Iterator<Vertex> st = u.link.iterator();
		while (st.hasNext()) {
			Vertex v = st.next();
			if (v.color == 0) {
				v.parent += u.parent;
				dfsVisit(v);
			}
		}
		u.color = 2;
		//System.out.println(u.parent);
		if (u.parent.length() == lcsLength) {
			set.add(u.parent);
		}
	}
	public static void doDFS () {
		Iterator<Vertex> it = list.iterator();
		
		while (it.hasNext()) {
			Vertex u = it.next();
			if (u.color == 0) {
				dfsVisit(u);
			}
		}
		System.out.println("SET SIZE: " + set.size());
		Iterator setIt = set.iterator();
		while (setIt.hasNext()) {
			System.out.println(setIt.next());
		}
	}
	public static void LCSLength() {
		int m = X.length();
		int n = Y.length();
		C = new int[m+1][n+1];
		x = new char[m+1];
		y = new char[n+1];
		for (int i=1; i<=m; i++) {
			x[i] = X.charAt(i-1);
		}
		for (int i=1; i<=n; i++) {
			y[i] = Y.charAt(i-1);
		}
		
		for (int i=1; i <= m; i++) {
			C[i][0] = 0;
		}
		
		for (int j=0; j <= n ; j++) {
			C[0][j] = 0;
		}
		
		for (int i=1; i<=m ;i++) {
			for (int j=1; j<=n; j++) {
				if (x[i] == y[j]) {
					C[i][j] = C[i-1][j-1] + 1;
				} else if (C[i-1][j] >= C[i][j-1]) {
					C[i][j] = C[i-1][j];
				} else {
					C[i][j] = C[i][j-1];
				}
			}
		}
		lcsLength = C[m][n];
		//C = new int[0][0];

		System.out.println("LCS-LENGTH: " + lcsLength);
		uniqueLCS(m-1,n);
		System.out.println("DONE");
//		for (int i=1; i<=m ;i++) {
//			for (int j=1; j<=n; j++) {
//				if (X.charAt(i-1) == Y.charAt(j-1)) {
//					allLCS(i, j);
//				} 
//			}
//		}
//		plotGraph();
//		doDFS();
	}
	
	public static void uniqueLCS (int i, int j) {
		if (i== 0 || j==0) {
			System.out.print(string + " ");
			string = "";
			return;
		} else if ((x[i] == y[j])) {
			    //System.out.print(X.charAt(i-1));
				string = x[i] + string;  
				uniqueLCS(i-1, j-1);
				
				string = x[i] + string;
				uniqueLCS(i, j-1);
				
		} else {
			if (C[i-1][j] > C[i][j-1]) {
				uniqueLCS(i-1, j);
			}   
			else { //(C[i][j-1] >= C[i-1][j])  {
				uniqueLCS(i, j-1);
			} 
		}
	}
	
	
	
	public static void readInput() throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int numOfTestCases = Integer.parseInt(st.nextToken());
		while (numOfTestCases > 0) {
			--numOfTestCases;
			
			X = in.readLine();
			Y = in.readLine();
			
			in.readLine();
			
			long stime = System.currentTimeMillis();
			LCSLength();
			System.out.println("Time: " + (System.currentTimeMillis()-stime));
		}
	}
}
