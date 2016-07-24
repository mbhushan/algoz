
public class KSubSet {
	
	public static void main(String [] args) {
		int [] A = {1,2,3,4,5};
		int k = 3;
		int len  = A.length;
		int result = 0;
		
		StringBuffer sb = new StringBuffer();
		int diff = len-k;
		
		for (int i=1; i<=diff; i++) { sb.append('0'); }
		for (int i=1; i<=k; i++) { sb.append('1'); }
		
		String binStr = sb.toString();
		String finalBinStr = sb.reverse().toString();
		int last = Integer.parseInt(finalBinStr,2);
		//System.out.println("LAST:" + last);
		System.out.println("Subsets of size " + k + " are: ");
		printSubSet(A, binStr);
		result = Integer.parseInt(binStr,2);		
		while (result < last) {
			binStr = findNext(result, len);
			printSubSet(A, binStr);
			result = Integer.parseInt(binStr,2);
		}
	}
	
	public static void printSubSet(int [] A, String binaryString) {
		int len = binaryString.length();
		for (int i=0; i<len; i++) {
			if (binaryString.charAt(i) == '1') {
				System.out.print(A[i] + " ");
			}
		}
		System.out.println();
	}
	
	//finds the next smallest number with same number of k bits set.
	public static String  findNext(int n, int k) {
		StringBuffer sbuff = new StringBuffer();
		
		int l = Integer.toBinaryString(n).length();
		if (l < k) {
			for (int i=1; i<= (k-l); i++) {
				sbuff.append('0');
			}
		}
		char [] ch = (sbuff.toString() + Integer.toBinaryString(n)).toCharArray();
		int len = ch.length;
		boolean switched = false;
		int index = 0;
		for (int i=len-1; i>=0; i--) {
			if (ch[i] == '1') {
				for (int j=i-1; j>=0; j--) {
					if (ch[j] == '0') {
						ch[j] = '1';
						ch[j+1] = '0';
						index = j+1;
						//System.out.println("J:" + j + " J+1:" + (j+1));
						switched = true;
						break;
					}
				}
				if (switched) {
					break;
				}
			}
		}
		int i=index+1;
		int j = len-1;
		
		while (i<j) {
			if (ch[i] == '1' && ch[j] == '0') {
				ch[i] = '0'; ch[j] = '1';
				++i; --j;
			}
			++i;
		}
		StringBuffer sb = new StringBuffer();
		for (i=0; i<len; i++) {
			sb.append(ch[i]);
		}
		
		return sb.toString();
	}

}
