
public class ArraySubset {
	
	public static void main(String [] args) {
		int [] A = {1,2,3,4,5};
		findSubsets(A, 3);
	}
	
	private static void findSubsets(int []A, int setSize) {
		int len = A.length;
		int n = (int)Math.pow(2, len);
		
		if (setSize > len) {
			return ;
		}
		for (int i=0; i<n; i++) {
			int set = i;
			int count = 0;
			String str = "";
			while (set != 0) {
				if ((set & 1) != 0) {
					str += A[count];
				}
				set = set >> 1;
				++count;
			}
			if (str.length() == setSize) {
				System.out.println(str);
			}
		}
	}
}
