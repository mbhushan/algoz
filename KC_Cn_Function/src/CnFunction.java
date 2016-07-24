
public class CnFunction {
	
	public static void main(String [] args) {
		int [] A = {4,5,6,7};
		
		for (int i=0; i<A.length; i++) {
			getCnFuncValue(A[i]);
		}
	}
	
	public static int getCnFuncValue(int n) {
		if (n == 0 || n == 1) { return 1; }
		if (n == 2) { return 2; }
		
		int [] cnArr = {1,1,2};
		
		int i = 3;
		while (i <= n) {
			int cn2 = cnArr[2];
			cnArr[2] = cnArr[0] + cnArr[1] + cnArr[2];
			cnArr[0] = cnArr[1];
			cnArr[1] = cn2;
			++i;
		}
		
		System.out.println("n: " + n);
		System.out.println("C(n): " + cnArr[2]);
		
		return cnArr[2];
		
	}

}
