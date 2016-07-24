import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class LCM {
	
	private static int [] numbers;
	public static void main(String [] args) {
		readInput();
		printInput();
		System.out.println("LCM is: " + calcLCM(numbers));
		
	}
	
	public static long calcLCM(int[] numArray) {
		if (null == numArray) {
			return -1;
		}
		int len = numArray.length;

		if (len < 2) {
			return -1;
		}
		int maxInArray = findMaxInArray(numArray);

		int countOnes = 0;
		boolean iFactor = true;
		long lcmOfNumbers = 1;

		for (int i = 2; i <= maxInArray; i++) {
			countOnes = 0;
			iFactor = true;
			while (iFactor) {
				iFactor = false;
				for (int j = 0; j < len; j++) {
					if ((numArray[j] > 1) && (numArray[j] % i == 0)) {
						numArray[j] = numArray[j] / i;
						iFactor = true;
					}
					if (numArray[j] == 1) {
						countOnes += 1;
					}
				}
				if (iFactor) {
					lcmOfNumbers *= i;
				}
			}
			if (countOnes == len) {
				break;
			}
		}

		return lcmOfNumbers;
	}
	
	public static int findMaxInArray(int [] numArray) {
		Arrays.sort(numArray);
		
		return numArray[numArray.length-1];
	}
	
	public static void printInput() {
		int len = numbers.length;
		System.out.println("Printing input numbers:");
		for (int i=0; i<len; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		try {
			String input = br.readLine();
			String [] str = input.split(" ");
			int strLen = str.length;
			
			numbers = new int[strLen];
			
			for (int i=0; i<strLen; i++) {
				numbers[i] = Integer.parseInt(str[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
