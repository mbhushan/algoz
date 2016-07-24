import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String [] args) {
		readInput();
	}
	
	public static void readInput() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] inputs = in.readLine().split(" ");
			int cashNeeded = Integer.valueOf(inputs[0]);
			double accBalance = Double.valueOf(inputs[1]);
			
			doTransaction(cashNeeded, accBalance);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void doTransaction(int amount, double balance) {
		if ((0 != (amount % 5)) || (amount > (balance-0.5))) {
			System.out.println(balance);
			return;
		}
		double transacBal = balance - (amount + 0.5);
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
		System.out.println(df.format(transacBal));
	}

}
