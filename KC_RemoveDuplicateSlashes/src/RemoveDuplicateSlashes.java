
public class RemoveDuplicateSlashes {
	
	public static void main(String[] args) {
		String str = "/root////foo///bar//";
		
		str = removeExtraSlashes(str);
		
		System.out.println(str);
		
		removeExtraSlashesInPlace(str.toCharArray());
	}
	
	public static int removeExtraSlashesInPlace(char [] A) {
		if (null == A) { return -1; }
		int len = A.length;
		
		if (len == 1) { return 1; }
		
		char prevChar = A[0];
		int index = 1;
		//char nextChar = A[0];
		for (int i=1; i<len; i++) {
			if (A[i] == '/' && prevChar == '/') {
				prevChar = A[i];
			} else {
				A[index] = A[i];
				prevChar = A[i];
				++index;
			}
		}
		
		for (int i=0; i<index; i++) {
			System.out.print(A[i]);
		}
		System.out.println();
		return index;
	}
	
	public static String removeExtraSlashes(String str) {
		if (null == str) {
			return null;
		}
		if (str.length() == 1) {
			return str;
		}
		
		StringBuffer sb = new StringBuffer();
		
		int len  = str.length();
		char lastChar = str.charAt(0);
		sb.append(lastChar);
		for (int i=1; i<len; i++) {
			char ch = str.charAt(i);
			if (ch == '/' && lastChar == '/') {
				continue;
			}
			sb.append(ch);
			lastChar = ch;
		}
		
		return sb.toString();
	}
}
