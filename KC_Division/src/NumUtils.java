
public class NumUtils {
	public static void main(String[] args) {
		divide(29,4);
	}
	
	
	public static int divide(int n, int d) {
		if (n == 0 && d == 0) { return -1; }
		if (n == 0 && d != 0) { return 0; }
		if (n != 0 && d == 0) { return -1; }
		
		int count = 0;
		
		while (n >= d) {
			n = n - d;
			++count;
		}
		System.out.println("quotiend: " + count);
		System.out.println("remainder: " + n);
		
		return count;
	}
}
