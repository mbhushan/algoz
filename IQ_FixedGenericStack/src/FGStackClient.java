import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FGStackClient {
	
	private static String [] input;
	
	public static void main(String [] args) {
		readInput();
		FixedGenericStack<String> stack = new FixedGenericStack<String>(30);
		
		for (int i=0; i<input.length; i++) {
			if (!input[i].equals("-")){
				stack.push(input[i]);
				System.out.println("pushed: " + input[i]);
			} else if (!stack.isEmpty()){
				String pop = stack.pop();
				System.out.println("pop: " + pop);
			}
		}
		System.out.println("(" + stack.size() + ") items left on the stack!");
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
/**
to be or not to - be - - that - - - is
pushed: to
pushed: be
pushed: or
pushed: not
pushed: to
pop: to
pushed: be
pop: be
pop: not
pushed: that
pop: that
pop: or
pop: be
pushed: is
(2) items left on the stack!
*/