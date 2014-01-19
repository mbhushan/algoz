import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1.3.10 Write a filter InfixToPostfix that converts an arithmetic expression from infix to postfix.
Infix: 
( ( ( ( 1 + 2 ) * 3 ) + 6 ) / ( 2 + 3 ) )
Postfix:
1 2 + 3 * 6 + 2 3 + /
*/

public class Infix {

	public static void main(String [] args) {
		String infix = readInput();
		String postfix = getPostfix(infix);
		System.out.println("postfix: " + postfix);
	}
	
	public static String getPostfix(String infix) {
		if (null == infix) { return null; }
		
		String [] sArr = infix.split(" ");
		int len = sArr.length;
		Stack<String> stack = new Stack<String>();
		Stack<String> op = new Stack<String>();
		
		for (int i=0; i<len; i++) {
			String st = sArr[i].trim();
			if (st.equals("(")) {
				//do nothing.
			} else if (st.equals(")")) {
				if (stack.isEmpty() || op.isEmpty() || stack.size() < 2) { return null; }
				
				String oprnd1 = stack.pop();
				String oprnd2 = stack.pop();
				String opr = op.pop();
				
				String post = oprnd2 + " " + oprnd1 + " " + opr;
				stack.push(post);
				
			} else if (isOperator(st)) {
				op.push(st);
			} else {
				stack.push(st);
			}
		}
		return stack.pop();
	}
	
	public static boolean isOperator(String st) {
		if (st.equals("+") || st.equals("-") || st.equals("*") || st.equals("/")) {
			return true;
		}
		return false;
	}
	public static String readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expr = null;
		try {
			expr = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return expr;
	}
}
/*
( ( ( ( 1 + 2 ) * 3 ) + 6 ) / ( 2 + 3 ) )
postfix: 1 2 + 3 * 6 + 2 3 + /
*/
