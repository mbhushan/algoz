import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class BagClient {
	public static void main(String [] args) {
		String input = readInput();
		String [] sArr = input.split(" ");
		BagLinkedList<String> bag = new BagLinkedList<String>();
		
		int len = sArr.length;
		
		for (int i=0; i<len; i++) {
			if (!sArr[i].equals("-")) {
				bag.add(sArr[i]);
				System.out.print(sArr[i] + " ");
			} 
		}
		System.out.println();
		System.out.println("Items in bag: " + bag.size());
		for (String str : bag) {
			System.out.print(str + " ");
		}
		System.out.println();
	}
	
	
	public static String readInput() {
		String in = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
			in = br.readLine().trim();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return in;
	}
}
