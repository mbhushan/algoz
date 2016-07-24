import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int [] dr = {1,-1,2,-2};
		int [] dc = {2,2,1,1};
		
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			int boardSize = Integer.parseInt(br.readLine());
			int [][] dp = new int[boardSize+1][boardSize+1];
			
			char [][] board = new char[boardSize][boardSize];
			int kr = 0; int kc = 0;
			
			for (int i=0; i< boardSize; i++) {
				String str = br.readLine();
				for (int j=0; j<boardSize; j++) {
					board[i][j] = str.charAt(j); 
					if (board[i][j] == 'K') {
						kr = i; kc = j;
					}
				}
			}
			
			for (int c=boardSize-1; c>=0; c--) {
				for (int r=0; r<boardSize; r++) {
					if (board[r][c] == 'P') {
						dp[r][c] = 1;
					}
					int pawnKilled = 0;
					for (int i=0; i<4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (nr >= boardSize || nr < 0 || nc >= boardSize || nc < 0) {
							continue;
						}
						pawnKilled = Math.max(pawnKilled, dp[nr][nc]);
					}
					dp[r][c] += pawnKilled;
					
				}
			}
			sb.append(dp[kr][kc] + "\n");
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
}
