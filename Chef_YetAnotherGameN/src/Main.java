import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	private static int [] numArray;
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		takeInput();
		printArray();
	}
	
	public static void playGame(int N) {
		
	}
	public static void takeInput() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numOfTestCases =  Integer.valueOf(in.readLine());
		numArray = new int[numOfTestCases];
		
		int i=0;
		while (numOfTestCases > 0) {
			numArray[i] = Integer.valueOf(in.readLine());
			--numOfTestCases;
			i++;
		}
	}
	
	public static void printArray() {
		for (int i=0; i<numArray.length; i++) {
			System.out.print(numArray[i]  + " ");
		}
		System.out.println();
	}
}
