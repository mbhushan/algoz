import java.util.Scanner;


public class Main {
	
	public static int N = 0;
	public static int K = 0;
	public static int P = 0;
	
	public static int [] A ;
	
	public static void main(String[] args) {
		Main.readInput();
		//Main.print();
	}
	
	public static void readInput() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		P = sc.nextInt();
		
		A = new int[N];
		
		for (int i=0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		System.out.println("K: " + K);
		System.out.println("P: " +  P);
		Main.computeBestSum();
	}
	
	public static void computeBestSum () {
		int [][] matrix = new int[N+1][N+1];
		int ans = 0;
		int min = K;
		int max = N;
		
		for (int i=1; i <= N; i++ ) {
			matrix[0][i] = A[i-1] % P;
		}
		
		for (int i=1; i <= N; i++ ) {
			matrix[i][0] = matrix[0][i];
		}
		
		for (int i=0; i <= N; i++) {
			for (int j=0 ; j<= N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i=1; i <= N; i++) {
			for (int j=i; j <= N; j++) {
				if (i != j) {
					matrix[i][j] = (matrix[i][j-1] + matrix[0][j]) % P;
				} else {
					matrix[i][j] = matrix[0][j];
				}
				int t = matrix[i][j];
				
				if ((t < max) && (t >= min)) {
					max = t;
					ans = t;
				}
			}
		}
		for (int i=0; i <= N; i++) {
			for (int j=0 ; j<= N; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("Answer: " + ans);
	}
	public static void print() {
		for (int i=0; i < N; i++) {
			System.out.print(A[i] + "\t");
		}
		System.out.println();
	}
}
