import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int tcNum = Integer.parseInt(br.readLine());
		
		while (tcNum > 0) {
			String [] str = br.readLine().split(" ");
			int strLen = str.length;
			int [] perm = new int[strLen];
			int [] inversePerm = new int[strLen];
			
			for (int i=0; i<strLen; i++) {
				int num = Integer.parseInt(str[i]);
				perm[i] = num;
				inversePerm[num-1] = i+1;
			}
			if (isAmbiguous(perm, inversePerm, strLen)) {
				sb.append("ambiguous" + "\n");
			} else {
				sb.append("not ambiguous" + "\n");
			}
			     
			tcNum = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());
	}
	
	public static boolean isAmbiguous(int [] A, int [] B, int len) {
		//printArr(A);
		//printArr(B);
		for (int i=0; i<len; i++) {
			if (0 != (A[i] ^ B[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void printArr(int [] A) {
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
