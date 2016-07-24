
public class Main {
	public static void main(String... args) throws Exception {
		int _buffLen = 8192, result = 0, i, read, divider = 0, number = 0;
		byte b;
		byte[] _buff = new byte[_buffLen];
		// SKIP LIMIT
		for (; (read = System.in.read()) != 32;)
			;

		// DIVIDER
		for (; (read = System.in.read()) != 10;)
			divider = divider * 10 + read - 48;
		// THE REST
		while ((read = System.in.read(_buff, 0, _buffLen)) > -1) {
			
			for (i = 0; i < read; i++) {
				b = _buff[i];

				if (b == 10) {
					if (number % divider == 0)
						result++;
					number = 0;
					continue;
				}
				number = number * 10 + b - 48;
			}
			//System.out.println(result);
		}
		System.out.println(result);
	}
}

/**

//Using Arrays.sort to sort the array "result[][]", based on the attribute 'd' 
double result[][] = new double[m][n]; // 'm' rows, 'n' attributes
int d=0; // 0 <= d <= n-1
java.util.Arrays.sort(result, new java.util.Comparator() {
   public int compare(double[] o1, double[] o2) {
     if(o1[d]>o2[d]) return 1; // -1 for descending order
     else if(o1[d]<o2[d]) return -1; // 1 for descending order
     else return 0;
   }
});
**/