import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class TwoSum {
	
	public static String FILE_NAME = "C:\\Users\\mbhushan\\Documents\\workplace\\KC_HashTwoSum\\HashInt.txt";
	private static HashSet<Integer> hset = new HashSet<Integer>();
	private static int X = 2500;
	private static int Y = 4000;
	
	public static void main(String [] args) {
		readInput();
		System.out.println("printing hashed set values: ");
		printHashSet();
		int result = twoSum(X, Y);
		System.out.println("Result of TwoSum: " + result);
		
	}
	
	public static int twoSum(int x, int y) {
		int counter = 0;
		for (int i=x; i<=y; i++) {
			Iterator<Integer> iter = hset.iterator();
			while (iter.hasNext()) {
				int t = (Integer)iter.next();
				int diff = i - t;
				if ((diff != t) && (hset.contains(diff))) {
					++counter;
					break;
				}
			}
		}
		
		return counter;
	}
	
	public static void printHashSet() {
		Iterator iter = hset.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
	}
	
	public static void readInput() {
		File file = new File(FILE_NAME);
		try {
			
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				Integer num = Integer.parseInt(line);
				if (num <= Y) {
					hset.add(num);
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
