/*
Random matches. Write a BinarySearch client that takes an int value T as
command-line argument and runs T trials of the following experiment for N = 103, 104,
105, and 106: generate two arrays of N randomly generated positive six-digit int values,
and find the number of values that appear in both arrays. Print a table giving the average
value of this quantity over the T trials for each value of N.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;


public class RandomMatch {
	public static int T ;
	public static void main(String [] args) {
		readInput();
		experiment();
	}
	
	public static void experiment () {
		int [] N = {1000, 10000, 100000, 1000000};
		int lenN = N.length;
		
		for (int i=0; i<lenN; i++) {
			int count = 0;
			for (int j=0; j<T; j++) {
				count += getMatch(N[i]);
			}
			double avg = (double)count/T;
			System.out.println(N[i] + "::" + avg);
		}
	}
	public static int getMatch(int m) {
		int K = 100000;
		Random rand = new Random();
		
		int[] A = new int[m];
		int[] B = new int[m];

		int match = 0;
		for (int j = 0; j < m; j++) {
			int r1 = K + rand.nextInt(900000);
			A[j] = r1;
			int r2 = K + rand.nextInt(900000);
			B[j] = r2;
		}

		Arrays.sort(A);
		int index = -1;
		for (int j = 0; j < m; j++) {
			index = binarySearch(A, B[j]);
			if (index >= 0) {
				++match;
			}
		}
		return match;
	}
	
	public static int binarySearch(int [] A, int key) {
		if (null == A) { return -1; }
		return binarySearch(A, key, 0, A.length-1);
	}
	
	private static int binarySearch(int [] A, int key, int low, int high) {
		while (low <= high) {
			int mid = low + (high-low)/2;
			if (A[mid] == key) { return mid; }
			else if (key < A[mid]) { 
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return -1;
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		try {
			T = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
100
1000::1.11
10000::111.52
100000::10503.36
1000000::670817.77
*/