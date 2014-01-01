import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/*
Empirical shuffle check. Run computational experiments to check that our
shuffling code on page 32 works as advertised. Write a program ShuffleTest that takes
command-line arguments M and N, does N shuffles of an array of size M that is initial-
ized with a[i] = i before each shuffle, and prints an M-by-M table such that row i
gives the number of times i wound up in position j for all j. All entries in the array
should be close to N/M.
 */
public class Shuffling {
	
	private static int M ;
	private static int N;
	private static int [][] S;
	private static int [] A;
	
	public static void main(String[] args) {
		readInput();
		experiment();
		printMatrix(S);
	}
	
	public static void experiment() {
		for (int i=0; i<N; i++) {
			init();
			int [] R = shuffling(A);
			//printArray(R);
			//System.out.println();
			for (int j=0; j<M; j++) {
				++S[R[j]][j];
			}
		}
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
	
	private static void init() {
		for (int i=0; i<M; i++) {
			A[i] = i;
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] strs = br.readLine().split(" ");
			M = Integer.parseInt(strs[0]);
			N = Integer.parseInt(strs[1]);
			S = new int[M][M];
			A = new int[M];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int [] shuffling(int [] A) {
		if (null == A) {
			return A;
		}
		int len = A.length;
		Random rand = new Random();
		
		for (int i=0; i<len; i++) {
			// Exchange A[i] with random element in A[i..len-1]
			int r = i + rand.nextInt(len-i);
			int temp = A[i];
			A[i] = A[r];
			A[r] = temp;
		}
		return A;
	}
}
/*
10 10000000
1002018 999324 1000069 998878 1000484 999376 998337 1000663 1001166 999685 
1000009 998176 999840 998472 999775 1000643 1001661 1000653 1000618 1000153 
1000888 999931 998735 1000618 999445 999303 999831 999547 999839 1001863 
999810 998315 1000183 998796 1000335 1001373 999493 1002049 1000295 999351 
1000483 1001736 999455 999732 997556 998862 1001207 1000519 998936 1001514 
999479 1002280 1002249 998579 999046 999429 999578 998684 999732 1000944 
999624 998275 1000662 1002096 1001167 999962 1000194 998041 1000306 999673 
1001248 1000207 998738 999099 1004313 999611 999260 999854 999184 998486 
998388 999886 1001194 1000357 1000832 1001257 999550 1002761 998996 996779 
998053 1001870 998875 1003373 997047 1000184 1000889 997229 1000928 1001552 
*/