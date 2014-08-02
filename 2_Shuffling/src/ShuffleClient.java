import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ShuffleClient {

	private static Integer [] A;
	
	public static void main(String [] args) {
		readInput();
		
		A = (Integer [])Shuffle.shuffle(A);
		System.out.println("showing shuffled data ...");
		Shuffle.showData(A);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] S = br.readLine().trim().split(" ");
			int len = S.length;
			A = new Integer[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(S[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
1 2 3 4 5 6 7 8 9
showing shuffled data ...
5 6 2 1 9 3 8 7 4 
*/
