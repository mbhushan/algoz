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
	
	//public Set<Vertex> link = new HashSet<Vertex>();
	public char ch;
	public int max =0;
	//public boolean hasIndegree = false;
	//public List<Integer> degree = new LinkedList<Integer>();
	public Set<String> lcs = new HashSet<String>();
}

public class Main {
	public static String X;
	public static String Y;
	public static int[][] C ;
	public static int lcsCount = 0;
	public static int lcsLength = 0;
	public static StringBuilder sb = new StringBuilder();
	public static Set<String> set =new HashSet<String>();;
	public static StringBuilder result = new StringBuilder();
	
	public static Set<String> list = new HashSet<String>();
	public static Map<String,Vertex> vertexMap = new HashMap<String, Vertex>();
	
	public static void main(String[] args) throws IOException {
		readInput();
		
	}
	
	public static void LCSLength() {
		int m = X.length();
		int n = Y.length();
		C = new int[m+1][n+1];
		
		for (int i=1; i <= m; i++) {
			C[i][0] = 0;
		}
		
		for (int j=0; j <= n ; j++) {
			C[0][j] = 0;
		}
		
		for (int i=1; i<=m ;i++) {
			for (int j=1; j<=n; j++) {
				if (X.charAt(i-1) == Y.charAt(j-1)) {
					C[i][j] = C[i-1][j-1] + 1;
				} else if (C[i-1][j] >= C[i][j-1]) {
					C[i][j] = C[i-1][j];
				} else {
					C[i][j] = C[i][j-1];
				}
			}
		}
		lcsLength = C[m][n];
		C = new int[0][0];
		System.out.println("LCS-LENGTH: " + lcsLength);
		for (int i=1; i<=m ;i++) {
			for (int j=1; j<=n; j++) {
				if (X.charAt(i-1) == Y.charAt(j-1)) {
					allLCS(i, j);
				}			
			}
			if ((X.length()-i) < lcsLength) {
				int diff = lcsLength - (X.length() - i);
				Iterator<String> it = list.iterator();
				while (it.hasNext()) {
					String str = it.next();
					Vertex v = vertexMap.get(str);
					Object [] string = v.lcs.toArray();
					for (Object s : string) {
						if (s.toString().length() < diff) {
							v.lcs.remove(s);
							}
						}
					vertexMap.put(str, v);
					}
				}
			}
		System.out.println("Unique Strings: " + set.size());
	//	Iterator<Vertex> it = list.iterator();
//		while (it.hasNext()) {
	//		Vertex v = (Vertex)it.next();
		//	System.out.println(v.ch + " " + v.lcs.size());
//			Iterator vlist = v.lcs.iterator();
//			while (vlist.hasNext()) {
//				String s = vlist.next().toString();
//				System.out.print(s + " " + s.length()+ "\t");
//			}
//			System.out.println();
   }
		
	
	
	public static void allLCS(int r, int c) {
		boolean hasLCS = false;
		Vertex v = new Vertex();
		v.x = r;
		v.y = c;
		v.ch = X.charAt(r-1);
		v.max = 1;
	//	v.degree.add(1);
		v.lcs.add(X.charAt(r-1) +"");
		
		int col = 1;
		int row = 1;
		for (int i=r-1; i >= row; i--) {
			for (int j=c-1; j >= col; j--) {

				if (X.charAt(i-1) == Y.charAt(j-1)) {
				//	System.out.println("i :" + i + " j:" +j );
					Vertex tmp  = (Vertex)vertexMap.get(i+""+j);
					//System.out.println("TMP: " + tmp.x + tmp.y);
					//	v.link.add(tmp);	
					if ((tmp != null) && (!tmp.lcs.isEmpty())) {
						Set<String> tmpList = tmp.lcs;
						Iterator<String> it = tmpList.iterator();
						while (it.hasNext()) {
							
							String result = it.next() + v.ch;

							if (result.length() > v.max) {
								v.max = result.length();
							}

							if (result.length() == lcsLength){
								set.add(result);
								hasLCS = true;
								//vertexMap.remove(i+""+j);
							} else {
								v.lcs.add(result);
							}
						}
						//col = tmp.y+1;
						//vertexMap.remove(i+""+j);
					}
					
					
					//vertexMap.put(i+""+j, tmp);
					col = tmp.y+1;
				}
			}
		}
		if (hasLCS) {
			vertexMap.remove(r+""+c);
		} else {
			Object [] string = v.lcs.toArray();
			for (Object s : string) {
				if (s.toString().length() < v.max) {
					v.lcs.remove(s);
				}
			}
			list.add(r+""+c);
			vertexMap.put(r+""+c, v);
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
		System.out.println(result);
	}
}
