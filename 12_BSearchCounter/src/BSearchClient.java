import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 1.2.9 Instrument BinarySearch (page 47) to use a Counter to count the total number
of keys examined during all searches and then print the total after all searches are com-
plete. Hint : Create a Counter in main() and pass it as an argument to rank().
 */
public class BSearchClient {
	
	private static Counter cnt;
	private static int [] A;
	private static int key;
	public static void main(String [] args) {
		cnt = new Counter("search");
		
		readInput();
		
		int index = BinarySearch.rank(A, key, cnt);
		if (index >= 0) {
			System.out.println("Key FOUND at: " + index);
			System.out.println(cnt.toString());
		} else {
			System.out.println("KEY NOT FOUND!");
		}
		
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] strs = br.readLine().trim().split(" ");
			int len = strs.length;
			if (len > 0) {
				A = new int[len];
				for (int i=0; i<len; i++) {
					A[i] = Integer.parseInt(strs[i].trim());
				}
			}
			key = Integer.parseInt(br.readLine().trim());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
1 3 5 7 9 10 12 14 16 18 20 22
20
Key FOUND at: 10
search 3
========================================
1 3 5 7 9 10 12 14 16 18 20 22
2
KEY NOT FOUND!
========================================
1 3 5 7 9 10 12 14 16 18 20 22
1
Key FOUND at: 0
search 3
*/