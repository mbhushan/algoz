
public class GrayCode {

	public static void main(String [] args) {
		String gray = "1110";
		String binary = grayToBinary(gray);
		System.out.println("binary: " + binary);
	}
	//Convert gray code to binary code:

	//9:51 am
	public static String grayToBinary(String grayCode) {
	    if (null == grayCode || grayCode.length() < 1) { return grayCode; }
	    
	    StringBuffer sb = new StringBuffer();
	    
	    int len = grayCode.length();
	    
	    char ch = grayCode.charAt(0);
	    sb.append(ch);
	    
	    for (int i=1; i<len; i++) {
	        char ch2 = grayCode.charAt(i);
	        int n = Integer.valueOf(new String(ch + "")) ^ Integer.valueOf(new String(ch2 + ""));
	        sb.append(n);
	        ch = String.valueOf(n).charAt(0);
	    }
	    
	    return sb.toString();
	}
}
