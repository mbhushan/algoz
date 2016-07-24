import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static int musicPref[][];
	public static int row;
	public static int col;
	public static int [] boredom;
	public static void main(String[] args) throws IOException {
		takeInput();
		printInput();
		
	}
	
	public static void calcResult() {
		
	}
	
	public static void takeInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		boredom = new int[row];
		musicPref = new int[row][col];
		
		st = new StringTokenizer(in.readLine());
		
		for (int i=0; i < boredom.length; i++) {
			boredom[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<row; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j=0; j< col; j++) {
				musicPref[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void printInput() {
		System.out.println(row + " " + col);
		
		for (int i=0; i < boredom.length; i++) {
			System.out.print(boredom[i] + " "); 
		}
		System.out.println();
		
		for (int i=0; i<row; i++) {
			for (int j=0; j< col; j++) {
				System.out.print(musicPref[i][j] + " "); 
			}
			System.out.println();
		}
	}
}
