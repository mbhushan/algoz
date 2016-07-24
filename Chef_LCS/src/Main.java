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
	
	public static List<Vertex> list = new LinkedList<Vertex>();
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
//		uniqueLCS(m, n);
//		if (!set.contains(sb.reverse().toString())) {
//			set.add(sb.toString());
//		}
//		lcsCount = set.size();
//		System.out.println("sb: " + sb);
//		int remainder = lcsCount % 23102009;
	//	result.append(lcsLength + " " + remainder + '\n');
		System.out.println("LCS-LENGTH: " + lcsLength);
		for (int i=1; i<=m ;i++) {
			for (int j=1; j<=n; j++) {
				if (X.charAt(i-1) == Y.charAt(j-1)) {
					allLCS(i, j);
				} 
			}
		}
		System.out.println("Unique Strings: " + set.size());
		Iterator<Vertex> it = list.iterator();
		while (it.hasNext()) {
			Vertex v = (Vertex)it.next();
			System.out.println(v.ch + " " + v.lcs.size());
		}
		
//		Iterator<Vertex> it = list.iterator();
//		while (it.hasNext()) {
//			Vertex v = (Vertex)it.next();
//			System.out.println(v.ch + " " + v.x + " " + v.y + " " + v.hasIndegree + " " + v.link.size());
//		//	if (!v.hasIndegree) {
//			//	System.out.println("Inside");
//				List<String> tmp = v.lcs;
//				Iterator<String> t = tmp.iterator();
//				while (t.hasNext()) {
//				//	System.out.println("INSIDE");
//					System.out.print(t.next() + " ");
//				}
//				System.out.println();
//			//}
//		}
		
		//System.out.println("Length of LCS:" + C[m][n] + " - uniq: " + lcsCount);
	}
	
	public static void allLCS(int r, int c) {
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
					if (!tmp.lcs.isEmpty()) {
						Set<String> tmpList = tmp.lcs;
						Iterator<String> it = tmpList.iterator();
						while (it.hasNext()) {
							//StringBuilder sb = new StringBuilder();
							//sb.append(it.next()+v.ch);

							String result = it.next() + v.ch;

							if (result.length() > v.max) {
								v.max = result.length();
							}

							if (result.length() == lcsLength){
								set.add(result);
							} else {
								v.lcs.add(result);
							}
						}
					}
					Object [] string = v.lcs.toArray();
					for (Object s : string) {
						if (s.toString().length() < v.max) {
							v.lcs.remove(s);
						}
					}
					//Iterator<String> lcsIt = v.lcs.iterator();
//					while (lcsIt.hasNext()) {
//						String key = lcsIt.next();
//						if (key.length() < v.max) {
//							v.lcs.remove(key);
//						}
//					}
//					for (int k=0; k<v.lcs.size();k++) {
//						if (v.lcs. < v.max) {
//							v.lcs.remove(k);
//						}
//					}
					//tmp.hasIndegree = true;
					vertexMap.put(i+""+j, tmp);
					col = tmp.y+1;
					//row = tmp.x;
				}
			}
		}
		list.add(v);
		vertexMap.put(r+""+c, v);
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
