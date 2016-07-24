import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringBuffer sb = new StringBuffer();
		int numbers = 0;
		do {
			numbers = Integer.parseInt(br.readLine());
			if (numbers > 0) {
				String [] str = br.readLine().split(" ");
				int [] numArr = new int [numbers];
				for (int i=0; i<numbers; i++) {
					numArr[i] = Integer.parseInt(str[i]);
				}
				Arrays.sort(numArr);
				//printArray(numArr);
				int result = notTriangleTriplets(numArr);
				sb.append(result + "\n");
			}
		}while (numbers > 0);
		
		System.out.println(sb.toString());
	}
	
	private static int notTriangleTriplets(int [] numArr) {
		//printArray(numArr);
		//System.out.println();
		int result = 0;
		int len = numArr.length;
		for (int i=2; i<len; i++) {
			int j = 0;
			int k = i-1;
			
			while (j<k) {
				if ((numArr[j] + numArr[k]) < numArr[i]) {
					result += (k-j);
					j++;
				} else {
					k--;
				}
			}
		}
		
		return result;
	}
	private static void printArray(int [] A) {
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
