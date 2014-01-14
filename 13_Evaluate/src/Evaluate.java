/*
this code assumes that the expression is fully parenthesized, with numbers and characters
separated by whitespace.
( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Stack;


public class Evaluate {

	public static void main(String [] args) {
		String expr = readInputExpr();
		double result = evalExpr(expr);
		
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("result: " + df.format(result));
	}
	
	public static Double evalExpr(String str) {
		if (null == str) {return null; }
		
		Stack<Double> operand = new Stack<Double>();
		Stack<String> operator = new Stack<String>();
		
		String [] strArr = str.split(" ");
		int len = strArr.length;
		
		for (int i=0; i<len; i++) {
			String s = strArr[i].trim();
			if (isOperator(s)) {
				operator.push(s);
			} else if (s.equals("(")) {
				//continue;
			} else if (s.equals(")")) {
				String op = operator.pop();
				double v1 = operand.pop();
				if (!op.equals("sqrt")) {
					double v2 = operand.pop();
					double val = calc(v1, v2, op);
					operand.push(val);
				} else {
					operand.push(Math.sqrt(v1));
				}
			} else {
				//System.out.println("S: " + s);
				operand.push(Double.parseDouble(s));
			}
		}
		return operand.pop();
	}
	
	public static Double calc(double v1, double v2, String operator) {
		if (operator.equals("+")) {
			return (v1+v2);
		} else if (operator.equals("-")) {
			return (v2 - v1);
		} else if (operator.equals("*")) {
			return (v1 * v2);
		} else if (operator.equals("/")) {
			if (0 == v1) {
				System.out.println("divide by zero!");
				System.out.println("evaluating with denom as 1");
			}
			return (v2/v1);
		} 
		return null;
	}
	
	public static boolean isOperator(String st) {
		if (st == null) { return false; }
		
		if (st.equals("+") || st.equals("-") || st.equals("*") || st.equals("/") || st.equals("sqrt")) {
			return true;
		}
		return false;
	}
	
	public static String readInputExpr() {
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
( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
result: 101.0
=====================================
( ( 1 + sqrt ( 5.0 ) ) / 2.0 )
result: 1.62
*/