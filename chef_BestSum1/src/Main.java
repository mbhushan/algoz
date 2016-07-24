import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static int N = 0;
	public static int K = 0;
	public static int P = 0;
	
	public static int [] A ;
	
	public static void main(String[] args) throws IOException {
		Main.readInput();
	}
	
	public static void readInput() throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		 
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		
		for (int i=0; i < N; i++) {
			A[i] =  (Integer.valueOf(in.readLine())) % P;
		}
		long stime = System.currentTimeMillis();
		Main.computeBestSum();
		System.out.println("Time: " + (System.currentTimeMillis() - stime));
	}
	
	public static void computeBestSum () {
		int ans = 0;
		int max = N;
		
//		for (int i=1; i <= N; i++ ) {
//			R[i] = A[i-1] % P;
//			C[i] = R[i];
//		}
		boolean dobreak = false;
		for (int i=1; !dobreak  && (i <= N) ; i++) {
			int t = A[i-1];
			for (int j=i; j <= N; j++) {
				if (i != j) {
					t = (t + A[i-1]) % P;
				}
				if ((t < max) && (t >= K)) {
					max = t;
					ans = t;
				}
				if (ans == K) {
					dobreak = true;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
