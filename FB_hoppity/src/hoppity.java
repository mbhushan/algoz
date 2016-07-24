import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class hoppity {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		String fileName = args[0];
		int num = readInput(fileName);
		doHoppity(num);
	}
	
	public static void doHoppity(int num) {
		for (int i=1; i<= num; i++) {
			if (i%3 == 0 && i%5 == 0) {
				System.out.println("Hop");
			}
			else if (i%3 == 0) {
				System.out.println("Hoppity");
			}
			else if (i%5 == 0) {
				System.out.println("Hophop");
			}
		}
	}
	public static int readInput(String fileName) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		int num = Integer.parseInt(br.readLine());
		
		return num;
	}
}
