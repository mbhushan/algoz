import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;


public class TwoSum {
	public static String FILE_NAME = "C:\\Users\\mbhushan\\Documents\\workplace\\KC_HashInt\\HashInt.txt";
	public static HashMap<Integer, Integer> numMap;
	public static Vector<Integer> vect ;
	public static void main(String [] args) {
		readInput();
		//int [] A = {62, 20, 10, 14, 32, 95, 4, 1, 120};
		int [] A = {231552,234756,596873,648219,726312,981237,988331,1277361,1283379};
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<A.length; i++) {
			if (twoSum(A[i])) {
				sb.append("1");
			} else {
				sb.append("0");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static boolean twoSum(int target) {
		int size = vect.size();
		
		for (int i=0; i<size; i++) {
			int n = vect.get(i);
			int diff = target - n;
			if (numMap.containsKey(diff)) {
				
				int value = numMap.get(diff);
				System.out.println("target: " + target + ":: diff: " + diff + " ::::n : " + n + " :::Value: " + value);
				if (n == diff) {
					return (value == 2);
				} 
				return true;
			}
		}
		return false;
	}
	
	public static void readInput() {
		File file = new File(FILE_NAME);
		try {
			numMap = new HashMap<Integer, Integer>();
			vect = new Vector<Integer>();
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				String line = sc.next();
				//System.out.print(line + " ");
				Integer key = Integer.parseInt(line);
				int count = 0;
				if (numMap.containsKey(key)) {
					count = numMap.get(key);
				}
				numMap.put(key, ++count);
				vect.add(key);
				
			}
			//System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
