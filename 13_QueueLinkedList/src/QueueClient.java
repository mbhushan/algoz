import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class QueueClient {

	public static void main(String [] args) {
		String input = readInput();
		String [] sArr = input.split(" ");
		Queue<String> Q = new Queue<String>();
		
		int len = sArr.length;
		
		for (int i=0; i<len; i++) {
			if (!sArr[i].equals("-")) {
				Q.enqueue(sArr[i]);
				System.out.println("Enqueue: " + sArr[i]);
			} else {
				System.out.println("Dequeue: " + Q.dequeue());
			}
		}
		System.out.println("Items left on stack: " + Q.size());
		for (String str: Q) {
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
