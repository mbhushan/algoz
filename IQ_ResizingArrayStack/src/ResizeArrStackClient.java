import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ResizeArrStackClient {

	private static String [] A;
	
	public static void main(String [] args) {
		readInput();
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		
		for (int i=0; i<A.length; i++) {
			stack.push(A[i]);
		}
		
		System.out.println("iterating through stack with java's foreach ..");
		for (String s : stack) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			A = br.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
one two three four five six seven eight nine ten
iterating through stack with java's foreach ..
ten nine eight seven six five four three two one 

*/