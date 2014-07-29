import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FCStackClient {

	private static String [] input;
	public static void main(String [] args) {
		FixedCapacityStack stack = new FixedCapacityStack(100);
		readInput();
		
		int len = input.length;
		
		for (int i=0; i<len; i++) {
			if (!input[i].equals("-")) {
				stack.push(input[i]);
				System.out.println("pushed: " + input[i]);
			} else if (!stack.isEmpty()) {
				System.out.println("popped: " + stack.pop());
			}
		}
		System.out.println("(" + stack.size() + ") items left on stack!");
		
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
