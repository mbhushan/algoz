import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;


public class Duplicates {
	public static int [] A;
	
	public static void main(String [] args) {
		readInput();
		removeDuplicates(A);
	}
	
	public static void removeDuplicates (int [] A) {
		if (null == A) {
			return ;
		}
		HashSet<Integer> hset = new HashSet<Integer>();
		int len = A.length;
		for (int i=0; i<len; i++) {
			hset.add(A[i]);
		}
		System.out.println("after removing duplicates: ");
		Iterator<Integer> iter = hset.iterator();
		
		while (iter.hasNext()) {
			int value = iter.next();
			System.out.print(value + " ");
		}
		System.out.println();
	}
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] strs = br.readLine().split(" ");
			int len = strs.length;
			A = new int[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(strs[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
 OUTPUT:
 5 4 3 2 1 5 3 4 2 1
after removing duplicates: 
1 2 3 4 5 
*/