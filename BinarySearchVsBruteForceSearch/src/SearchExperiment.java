import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
Binary search versus brute-force search. Write a program BruteForceSearch
that uses the brute-force search method given on page 48 and compare its running time
on your computer with that of BinarySearch for largeW.txt and largeT.txt.
*/

public class SearchExperiment {
	private static int [] A;
	
	public static void main(String [] args) {
		readInputFile();
		Arrays.sort(A);
		int [] keys = {403161, 467242, 795021, 432329, 618486, 568962, 970523,	192618,	
				528476, 387221,	831753,	478292,	563352, 494315,
				935085,403161, 141720,	150243, 587173, 278584};
		
		int len = keys.length;
		long start = System.currentTimeMillis();
		for (int i=0; i<len; i++) {
			int index = bruteForceSearch(keys[i]);
			System.out.print(index + " ");
		}
		System.out.println();
		long finish = System.currentTimeMillis();
		
		System.out.println("Total time bruteforce: " + (finish-start));
		
		start = System.currentTimeMillis();
		for (int i=0; i<len; i++) {
			int index = binarySearch(A, keys[i]);
			System.out.print(index + " ");
		}
		System.out.println();
		finish = System.currentTimeMillis();
		
		System.out.println("Total time binarySearch: " + (finish-start));
	}
	
	public static void readInputFile() {
		try {
			//http://algs4.cs.princeton.edu/11model/largeW.txt
			//http://algs4.cs.princeton.edu/11model/largeT.txt
			BufferedReader br = new BufferedReader(new FileReader("data/largeT.txt"));
			String str;
			A = new int[10000000];
			int i=0;
			while ((str = br.readLine()) != null) {
				A[i] = Integer.parseInt(str.trim());
				++i;
				//System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int binarySearch(int [] A, int key) {
		if (null == A) { return -1; }
		int len = A.length;
		return binarySearch(A, key, 0, len-1);
	}
	
	private static int binarySearch(int [] A, int key, int low, int high) {
		if (null == A) { return -1; }
		
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
	
	public static int bruteForceSearch(int key) {
		if (null == A) { return -1; }
		int len = A.length;
		//System.out.println("A len: " + len);
		for (int i=0; i<len; i++) {
			if (A[i] == key) {
				return i;
			}
		}
		return -1;
	}
}
/*
//below times are in milliseconds.
 
//with largeW.txt
402559 466658 794522 431864 617867 568317 970297 192720 528048 386733 831391 477879 562760 493876 934819 402559 141742 150369 586632 278573 
Total time bruteforce: 17
402559 466658 794522 431865 617867 568317 970298 192720 528048 386733 831391 477879 562761 493876 934819 402559 141742 150369 586632 278573 
Total time binarySearch: 1

======================================
//with largeT.txt
3882337 4500219 7659178 4163618 5958444 5480697 9347192 1857893 5092281 3728839 8011417 4606679 5426827 4760821 9006998 3882337 1365420 1449556 5657435 2684122 
Total time bruteforce: 115
3882348 4500233 7659185 4163625 5958449 5480706 9347196 1857908 5092294 3728844 8011423 4606683 5426842 4760826 9007003 3882348 1365430 1449562 5657441 2684132 
Total time binarySearch: 1

 */
*/