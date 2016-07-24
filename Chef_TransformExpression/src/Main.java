import java.util.Scanner;
import java.util.Stack;


public class Main {
	
	public static void main(String [] args) {
		String [] in = new String[3];
		
		for (int i =0; i<in.length; i++) in[i] = new String();
		
		Scanner sc = new Scanner(System.in);
		Stack lifo = new Stack();
		int numOfTestCases = sc.nextInt();
		
		while (numOfTestCases > 0) {
	    	numOfTestCases = numOfTestCases - 1;
	    	String x = sc.next();
	    	int j = 0;

	    	for(int i=0; i<x.length();i++){
	    		if (x.charAt(i) != ')') {
	    			lifo.push(new String("" + x.charAt(i)));
	    		} else {
	    			while (!lifo.peek().toString().equals("(")) {
	    				in[j]= lifo.pop().toString();
	    				j = j+1;
	    			}
	    			lifo.pop();
	    			lifo.push(in[2] + in[0] + in[1]);
	    			j = 0;
	    		}	    		
	    	}
            System.out.println ( lifo.pop() );
		}
	}
}
