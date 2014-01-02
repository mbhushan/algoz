import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class BadShuffle {
	private static int M ;
	private static int N;
	private static int [][]S;
	private static int [] I;
	
	public static void main(String [] args) {
		readInput();
		experiment();
		printMatrix(S);
	}
	
	public static void experiment() {
		for (int i=0; i<N; i++) {
			initArr();
			int [] R = shuffle(I);
			//printArray(R);
			for (int j=0; j<M; j++) {
				++S[R[j]][j];
			}
		}
		//System.out.println();
	}
	
	public static void printArray(int [] arr) {
		if (null == arr) {
			return;
		}
		int len = arr.length;
		for (int i=0; i<len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void printMatrix(int [][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void initArr() {
		if (null == I) {
			return;
		}
		for (int i=0; i<I.length; i++) {
			I[i] = i;
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		try {
			String [] strs = br.readLine().split(" ");
			M = Integer.parseInt(strs[0]);
			N = Integer.parseInt(strs[1]);
			S = new int[M][M];
			I = new int[M];
			//initArr();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int [] shuffle(int [] A) {
		if (null == A) { return A; }
		int len = A.length;
		
		Random rand = new Random();
		for (int i=0; i<len; i++) {
			int r = rand.nextInt(len);
			int temp = A[i];
			A[i] = A[r];
			A[r] = temp;
		}
		return A;
	}
}
/*
10 10000000
1000824 996904 1000637 999692 999554 1000871 1001247 1000473 1000591 999207 
1287394 945080 947122 953411 959216 964167 973745 980633 989119 1000113 
1198435 1240421 902448 911860 922437 934396 947079 963083 979549 1000292 
1116844 1159440 1208779 871588 888668 906994 925529 948125 973228 1000805 
1043793 1083719 1135148 1189746 859955 881891 907392 933862 963798 1000696 
976006 1020166 1067542 1122329 1186224 859352 887674 923645 957119 999943 
918567 961665 1007788 1064265 1121851 1187768 875216 911543 952587 998750 
865350 909773 953210 1011028 1070471 1134883 1208921 900532 948554 997278 
817353 859214 908603 962475 1022206 1086748 1157432 1244442 942983 998544 
775434 823618 868723 913606 969418 1042930 1115765 1193662 1292472 1004372 
*/