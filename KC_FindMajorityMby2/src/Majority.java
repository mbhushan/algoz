
public class Majority {
	
	public static void main(String[] args) {
		int [] A = {7,11,8,11,9,11,7,11,8,11,9,11};
		//int [] A = {3,5,7,5};
		findMajority(A);
	}
	
	public static void findMajority(int [] A) {
		int len = A.length;
		//System.out.println("Len: " + len);
		
		int [] bits = new int[32];
		for (int i=0; i<len; i++) {
			int n = A[i];
			for (int c=0; n > 0; n=n>>1) {
				if ((n & 1) > 0) {
					++bits[c];
				}
				++c;
			}
		}
		StringBuffer sb = new StringBuffer();
		int majority = len/2;
		for (int j=31; j>=0; j--) {
			System.out.print(bits[j] + " ");
			if (bits[j] > majority) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}
		System.out.println();
		System.out.println("Majority: " + Integer.parseInt(sb.toString(),2));		
	}
}
