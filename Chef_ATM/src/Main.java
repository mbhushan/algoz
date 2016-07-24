import java.text.DecimalFormat;
import java.util.Scanner;



public class Main {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long X = 0;
		Double Y = 0.0;
		
		X = sc.nextLong();
		Y = sc.nextDouble();
		
		DecimalFormat format = new DecimalFormat("######.00");
		
		if ((X+0.5 > Y) || ((X%5) != 0)) {
			System.out.println(format.format(Y));
		} else {
			Y = Y - X - 0.5;
			System.out.println(format.format(Y));
		}
	}
}
