
public class PowerSet {
	
	public static void main(String [] args) {
		int[] a = {1, 2, 3};
		powerSet(a);
		
	}
	
	public static void powerSet(int [] A) {
		int len = A.length;
		int n = (int)Math.pow(2, len);
		System.out.println("Power sets are: ");
		for (int i=0; i<n; i++) {
			int v = i;
			int c = 0;
			System.out.print("{");
			while (v != 0) {
				if ((v & 1) != 0) {
					System.out.print(A[c] +  " ");
				}
				++c;
				v = v >> 1;
			}
			System.out.println("}");
			System.out.println();
		}
	}
}
