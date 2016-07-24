
public class Reverse {
	
	public static void main(String[] args) {
		int n = 37;
		
		String s = Integer.toBinaryString(n);
		System.out.println("input bits: " + s);
		
		int r = 0;
		int i = 0;
		while (n > 0) {
			r <<= 1;
			++i;
			//System.out.println(i + ": " + Integer.toBinaryString(r));
			r |= (n&1);
			System.out.println(i + ": " + Integer.toBinaryString(r));
			n >>= 1;
		}
		System.out.println("reversed bits: " + Integer.toBinaryString(r)); 
	}
}
