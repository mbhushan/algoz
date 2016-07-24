
public class GrayCodes {
	public static void main(String [] args) {
		String [] binArr = { "000", "001", "010", "011", "100", "101", "110", "111" };
		int len = binArr.length;
		System.out.println("Binary => Gray");
		for (int i=0; i<len; i++) {
			System.out.println(binArr[i] + " => " + binaryToGray(binArr[i], 0, new StringBuffer()));
			//System.out.print( binaryToGray(binArr[i], 0, new StringBuffer()) + " " );
		}
		System.out.println();
		System.out.println("Gray => Binary");
		String [] grays = { "000", "001", "011", "010", "110", "111", "101", "100" };
		len = grays.length;
		for (int i=0; i<len; i++) {
			System.out.println(grays[i] + " => " + grayToBinary(grays[i], 0, new StringBuffer()));
			//System.out.print(grayToBinary(grays[i], 0, new StringBuffer()) + " ");
		}
		
	}
	
	public static String binaryToGray(String binary, int bit, StringBuffer sb) {
		if (binary.length() == 0) {
			return sb.toString();
		}
		int c = Integer.parseInt(binary.substring(0,1));
		sb.append(bit ^ c);
		binaryToGray(binary.substring(1), c, sb);
		return sb.toString();
	}
	
	public static String grayToBinary(String gray, int bit, StringBuffer sb) {
		if (gray.length() == 0) {
			return sb.toString();
		}
		int c = Integer.parseInt(gray.substring(0,1));
		c = bit ^ c;
		sb.append(c);
		grayToBinary(gray.substring(1), c, sb);
		return sb.toString();
	}
}
