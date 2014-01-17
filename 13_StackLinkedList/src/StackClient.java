import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class StackClient {

	public static void main(String [] args) {
		String input = readInput();
		String [] sArr = input.split(" ");
		Stack<String> fcs = new Stack<String>();
		
		int len = sArr.length;
		
		for (int i=0; i<len; i++) {
			if (!sArr[i].equals("-")) {
				fcs.push(sArr[i]);
				System.out.println("push: " + sArr[i]);
			} else {
				System.out.println("POP: " + fcs.pop());
			}
		}
		System.out.println("Items left on stack: " + fcs.size());
		
		for (String str: fcs) {
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
/*
push: to
push: be
push: or
push: not
push: to
POP: to
push: be
POP: be
POP: not
push: that
POP: that
POP: or
POP: be
push: is
Items left on stack: 2
*/