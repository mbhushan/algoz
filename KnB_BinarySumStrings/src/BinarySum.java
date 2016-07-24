
public class BinarySum {
	
	public static void main(String [] args) {
		
		String binarySum = addBinaryString("0110", "0101");
		
		System.out.println("Sum is: " + binarySum);
	}
	
	public static String addBinaryString(String first, String second) {
		
		int lenFirst = first.length();
		int lenSec = second.length();
		StringBuffer firstSB = new StringBuffer(first).reverse();
		StringBuffer secondSB = new StringBuffer(second).reverse();
		
		if (lenFirst > lenSec) {
			int delta = lenFirst-lenSec;
			for (int i=1; i<= delta; i++ ) {
				secondSB.append('0');
			}
		} else if (lenSec > lenFirst) {
			int delta = lenSec - lenFirst;
			for (int i=1; i<=delta; i++) {
				firstSB.append('0');
			}
		}
		System.out.println(firstSB.toString() + " : " + secondSB.toString());
		int len = firstSB.length();
		int carry = 0;
		StringBuffer binarySum = new StringBuffer();
		
		for (int i=0; i<len; i++) {
			String sum = bitSum(firstSB.charAt(i), secondSB.charAt(i), carry);
			binarySum.append(sum.charAt(0));
			carry = sum.charAt(1) == '1' ? 1 : 0;
		}
		
		if (carry == 1){
			binarySum.append('1');
		}
		
		return binarySum.reverse().toString();
	}
	
	private static String bitSum(char firstBit, char secBit, int carry) {
		int bitsum = 0;
		if ((firstBit == '1') && (secBit == '1')) {
			if (carry == 0) { bitsum = 0; carry = 1; }
			else {bitsum = 1; carry = 1;}
		} else if ((firstBit == '1') && (secBit == '0')) {
			if (carry == 0) { bitsum = 1; carry = 0; }
			else {bitsum = 0; carry = 1;}
		} else if ((firstBit == '0') && (secBit == '1')) {
			if (carry == 0) { bitsum = 1; carry = 0; }
			else {bitsum = 0; carry = 1;}
		} else if ((firstBit == '0') && (secBit == '0')) {
			if (carry == 0) { bitsum = 0; carry = 0; }
			else {bitsum = 1; carry = 0;}
		} 
		System.out.println(bitsum + " : " + carry);
		return (Integer.toString(bitsum) + Integer.toString(carry));
	}
}
