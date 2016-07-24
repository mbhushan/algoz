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
		
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			String [] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int A = Integer.parseInt(str[1]);
			int B = Integer.parseInt(str[2]);
			
			sb.append(findMaxXor(N, A, B) + "\n");
			
			--numTestCases;
		}
		
		System.out.println(sb.toString());
	}
	
	private static int findMaxXor(int n, int a, int b) {
		int max = 0;
		
		int na = calcSetBits(a);
		int nb = calcSetBits(b);
		int n1 = 0;
		int n0 = 0;
		
		if (na+nb <= n) {
			n1 = na + nb;
			n0 = n - n1;
		} else {
			n1 = 2*n - na - nb;
			n0 = n - n1;
		}
		
		max = 1 << n1;
		max = max - 1;
		max = max << n0;
		
		return max;
	}
	
	private static int findMax(int N, int A, int B) {
		int max = 0;
		int n = (int)Math.pow(2,N);
		
		int aSetBits = setBits(A);
		int bSetBits = setBits(B);
		
		StringBuffer sbA = new StringBuffer();
		StringBuffer sbB = new StringBuffer();
		
		for (int i=0; i<n; i++) {
			if (setBits(i) == aSetBits) {
				sbA.append(i + " ");
			}
			if (setBits(i) == bSetBits) {
				sbB.append(i + " ");
			}
		}
		String [] aStr = sbA.toString().split(" ");
		String [] bStr = sbB.toString().split(" ");
		
		//printArr(aCh);
		//printArr(bCh);
		int aLen = aStr.length;
		int bLen = bStr.length;
		for (int i=0; i<aLen; i++) {
			for (int j=0; j<bLen; j++) {
				int temp = Integer.parseInt(aStr[i]) ^ Integer.parseInt(bStr[j]);
				if (temp > max) {
					max = temp;
				}
					
			}
		}
		
		
		return max;
	}
	
	private static int calcSetBits(int n) {
		int count = 0;
		
		while (n > 0) {
			n = n & (n-1);
			++count;
		}
		return count;
	}
	
	private static int setBits(int n) {
		char [] ch = Integer.toBinaryString(n).toCharArray();
		
		int len = ch.length;
		int setBits = 0;
		for (int i=0; i<len; i++) {
			if (ch[i] == '1') {
				++setBits;
			}
		}
		return setBits;
	}
	
	private static void printArr(String [] ch) {
		System.out.print("PRINT:: ");
		for (int i=0; i<ch.length; i++) {
			System.out.print(ch[i] + " ");
		}
		System.out.println();
	}
}
