import java.util.Random;


public class TicTacToe {
	
	private static int [][] board = new int[3][3];
	private static int numMoves = 0;
	private static final int N = 3;
	
	public static void main(String[] args) {
		Random rand = new Random();
		int move = 1;
		int result = 0;
		while (true) {
			int x = rand.nextInt(3);
			int y = rand.nextInt(3);
			result = makeMove(x, y, move);
			if (result == -1) { continue; }
			printBoard();
			if (result == move || result == N) {
				break;
			}
			move = (move == 1) ? 2: 1;
		
		}
		if (result == N) {
			System.out.println("Game DRAW!");
		} else if (result == move) {
			System.out.println(move + " WINS!");
		}
		
	}
	
	private static void printBoard() {
		int r = board.length;
		int c = board[0].length;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int makeMove(int x, int y, int move) {
		if (board[x][y] == 0) {
			board[x][y] = move;
		} else {
			return -1;
		}
		++numMoves;
		
		//check the end conditions.
		//check col.
		for (int i=0; i<N; i++) {
			if (board[x][i] != move) {
				break;
			}
			if (i == N-1) {
				return move;
			}
		}
		
		//check row.
		for (int i=0; i<N; i++) {
			if (board[i][y] != move) {
				break;
			}
			if (i == N-1) {
				return move;
			}
		}
		
		//check diagonal.
		if (x == y) {
			for (int i=0; i<N; i++) {
				if (board[i][i] != move) {
					break;
				}
				if (i == N-1) {
					return move;
				}
			}
		}
		
		
		//check anti diagonal.
		for (int i=0; i<N; i++) {
			if (board[i][N-1-i] != move) {
				break;
			}
			if (i == N-1) {
				return move;
			}
		}
		
		if (numMoves == (int)Math.pow(2, N)) {
			return N;
		}
		
		return 0;
	}
}
