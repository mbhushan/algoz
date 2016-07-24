

public class CoinChange {
	
	public static void main(String[] args) {
		int [] D = {50, 25, 10, 1};
		
//		makeCoinChange(D, 30);
//		
//		System.out.println();
//		int [] D1 = {1, 4, 6};
//		coinChangeVersion2(D1, 8);
		
		int [] limit = {2, 1, 2, 5};		
		makeChangeLimitedCoins(D, limit, 30);
	}
	
	public static void makeChangeLimitedCoins(int [] D, int [] S, int N) {
		int [] C = new int [N+1];
		C[0] = 0;
		
		int len = D.length;
		int [][] track = new int[N+1][len];
		for (int i=0; i<len; i++) {
			track[0][i] = S[i];
		}
		int [] denom = new int[N+1];
		for (int j=1; j<=N; j++) {
			C[j] = Integer.MAX_VALUE;
			for (int k=0; k<len ; k++) {
				if (j >= D[k] && (C[j-D[k]] < Integer.MAX_VALUE) && (track[j-D[k]][k] > 0)) {
					if ((C[j] > 1+C[j-D[k]])) {
						C[j] =  1 + C[j-D[k]];
						denom[j] = D[k];
						track[j][k] = track[j-D[k]][k] - 1;
					} else {
						track[j][k] = track[j-D[k]][k];
					}
				} else if (j < D[k] ){
					track[j][k] = track[0][k];
				}
			}
		}
		System.out.println("Printing Coin Value and Change:");
		for (int i=1; i<=N; i++) {
			if (C[i] == Integer.MAX_VALUE) {
				System.out.println(i + ":" + " Not Possible");
			} else {
				System.out.println(i + ":" + C[i]);
			}
		}
		System.out.println();
		
		for (int i=0; i<=N ;i++) {
			System.out.print(i + ": ");
			for (int j=0; j<len; j++) {				
				System.out.print(track[i][j] + " ");
			}
			System.out.println();
		}
		
		//System.out.println("Printing change for: " + (N));
		//printCoins(denom, N);		
	}
	
	public static void coinChangeVersion2(int [] D, int N) {
		int Dlen = D.length;
		int [][] C = new int[Dlen+1][N+1];
		
		for (int j=1; j <= N ;j++) {
			C[0][j] = j;
		}
		
		System.out.println("Tracing ...");
		for (int i=1; i < Dlen; i++) {
			for (int j=1 ; j<= N; j++) {
				if (j < D[i-1]) {
					C[i][j] = C[i-1][j];
				} else {
					C[i][j] = Math.min(C[i-1][j], 1 + C[i][j-D[i-1]]);
				}
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Coin change version2 - change for: " + N);
		for (int i=0; i<Dlen; i++) {
			System.out.print(D[i] + " ");
			for (int j=1; j <= N; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void makeCoinChange(int [] D, int N) {
		int [] C = new int [N+1];
		C[0] = 0;
		
		int len = D.length;
		int [] denom = new int[N+1];
		for (int j=1; j<=N; j++) {
			C[j] = Integer.MAX_VALUE;
			for (int k=0; k<len; k++) {
				if (j >= D[k]) {
					//C[j] = C[j] > 1+C[j-D[k]] ? 1+C[j-D[k]] : C[j];
					if (C[j] > 1+C[j-D[k]]) {
						C[j] =  1 + C[j-D[k]];
						denom[j] = D[k];
					}
				}
			}
		}
		for (int i=1; i<=N; i++) {
			System.out.println(i + ":" + C[i]);
		}
		System.out.println();
		System.out.println("Printing change for: " + (N));
		printCoins(denom, N);		
	}
	
	public static void printCoins(int [] denom, int n) {
		if (n > 0) {
			printCoins(denom, n - denom[n]);
			System.out.print(denom[n] + " ");
		}
	}
}
