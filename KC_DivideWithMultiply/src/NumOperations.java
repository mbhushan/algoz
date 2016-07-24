
public class NumOperations {

	public static void main(String [] args) {
		System.out.println(divideOp(10, 3));
		System.out.println(divideOp(10, 5));
		System.out.println(divideOp(66, 6));
	}
	public static int divideOp(int value, int num) {
	    
	    int result = 0;
	    int x = num;
	    while (x < value) {
	    	++result;
	        x = num * result;
	    }
	    if (x > value) {
	    	--result;
	    }
	    
	    return result;
	}
}
