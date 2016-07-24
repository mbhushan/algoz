import java.util.Stack;


public class OrderedSeq {
	
	public static void main(String [] args) {
		int [] A = {1, 2, 3, 8, 10, 5, 6, 7, 12, 9, 4, 0};
		int ans = longestOrdered(A);
		System.out.println("Numbers of items to be removed? " + ans);
	}
	

	public static int longestOrdered(int [] A) {
	    Stack<Integer> stack = new Stack<Integer>();
	    
	    int len = A.length;
	    
	    int maxLen = 0;
	    int stackPtr = 0;
	    int index = 0;
	    stack.push(A[index]);
	    ++index;
	    ++stackPtr;
	    ++maxLen;
	    
	    while (index < len) {
	        while (!stack.isEmpty() && (A[index] >= stack.peek())) {
	            stack.push(A[index]);
	            ++index;
	            ++stackPtr;
	        }
	        if (stackPtr > maxLen) { maxLen = stackPtr; } 
	        while (!stack.isEmpty() && (A[index] < stack.peek())) {
	            stack.pop();
	            --stackPtr;
	        }       
	    }
	    
	    return (len-maxLen);
	}
}
