
public class QuickFind {

	private static int [] A;
	private static int [] sizeArr;
	
	public static void main(String[] args) {
		init(10);
		//5-4 5-8 3-2 9-1 6-0 5-6 
//		union(5,4);
//		union(5,8);
//		union(3,2);
//		union(9,1);
//		union(6,0);
//		union(5,6);
		// 8-4 5-8 3-6 1-0 7-9 9-0 3-5 3-9 6-2 
		weightedUnion(8, 4);
		weightedUnion(5, 8);
		weightedUnion(3, 6);
		weightedUnion(1, 0);
		weightedUnion(7, 9);
		weightedUnion(9, 0);
		weightedUnion(3, 5);
		weightedUnion(3, 9);
		weightedUnion(6, 2);
		printArray(A);
		System.out.println("printing size Array:" );
		printArray(sizeArr);
	}
	
	public static void printArray(int [] A) {
		if (null == A) { return; }
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	private static int root(int p) {
		while (p != A[p]) {
			p = A[p];
		}
		return p;
	}
	
	public static void weightedUnion(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if (sizeArr[rootP] >= sizeArr[rootQ]) {
			A[rootQ] = rootP;
			sizeArr[rootP] = sizeArr[rootP] + sizeArr[rootQ];
		} else {
			A[rootP] = rootQ;
			sizeArr[rootQ] = sizeArr[rootQ] + sizeArr[rootP];
		}
	}
	
	public static void union(int p, int q) {
		int pid = A[p];
		int qid = A[q];
		
		int len = A.length;
		for (int i=0; i<len ;i++) {
			if (A[i] == pid) {
				A[i] = qid;
			}
		}
	}
	
	public static void init(int n) {
		A = new int[n];
		sizeArr = new int[n];
		for (int i=0; i<n; i++) {
			A[i] = i;
			sizeArr[i] = 1;
		}
	}
	
}
