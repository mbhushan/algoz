
public class PowerSet {
	
	public static void main(String [] args) {
		int [] A = {1,2,3};
		powerSet(A);
	}
	
	/*
	Find the power set of a given set of number n.
	Suppose n = 3, S = {a,b,c}
	*/

	public static void powerSet(int [] numArray) {
	    int len = numArray.length;
	    int psSize = (int)Math.pow(2, len);
	    
	    for (int i=0; i<psSize; i++) {
	        int set = i;
	        int position = 0;
	        System.out.print("(");
	        while (set != 0) {
	            if ((set & 1) != 0) {
	                System.out.print(numArray[position] + ", ");
	            }
	            set = set >> 1;
	    		++position;
	        }
	        System.out.print(")");
	        System.out.println();
	    }
	}
}
