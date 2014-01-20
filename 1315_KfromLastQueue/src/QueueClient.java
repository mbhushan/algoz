/*
1.3.15 Write a Queue client that takes a command-line argument k and prints the kth
from the last string found on standard input (assuming that standard input has k or
more strings).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class QueueClient {
	private static String [] strs;
	private static int K = 0;

	public static void main(String[] args) {

		readInput();

		Queue<String> Q = new Queue<String>();
		for (int i = 0; i < strs.length; i++) {
			Q.enqueue(strs[i]);
		}
		int size = Q.size();
		int j = size - K;
		
		for (String s : Q) {
			if (0 == j) {
				System.out.println("Kth data from end: " + s);
			}
			--j;
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		try {
			input = br.readLine().trim();
			strs = input.split(" ");
			input = br.readLine().trim();
			K = Integer.parseInt(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
A B C D E F G H I
9
Kth data from end: A
===============================================
A B C D E F G H I
5
Kth data from end: E
=================================================
A B C D E F G H I
1
Kth data from end: I
===============================================
*/
