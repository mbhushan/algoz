import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DateClient {

	private static SmartDate sd;
	public static void main(String [] args) {
			readInput();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] strs = br.readLine().trim().split(" ");
			int month = Integer.parseInt(strs[0]);
			int day = Integer.parseInt(strs[1]);
			int year = Integer.parseInt(strs[2]);
			sd = new SmartDate(month, day, year);
			if (sd != null) {
				System.out.println("Valid DATE!");
			} else {
				System.out.println("Invalid DATE!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
