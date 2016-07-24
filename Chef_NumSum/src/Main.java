import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	//static StringBuilder stringBuilder = new StringBuilder();
	static BigInteger two = new BigInteger("2");
	static String [] bigNum = new String[100];
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		takeInput();
	}
	
	public static void takeInput() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numOfTestCases =  Integer.valueOf(in.readLine());
		long stime  = 0;
		while(numOfTestCases > 0) {
			--numOfTestCases;
			
			bigNum[count] = String.valueOf(in.readLine());
			++count;
			//BigInteger n = new BigInteger(String.valueOf(in.readLine()));
			
//			stime = System.currentTimeMillis();
//			stringBuilder.append(n.multiply((n.add(n.ONE))).divide(two));
//			stringBuilder.append('\n');		
			
		}
		StringBuilder stringBuilder = new StringBuilder();
		stime = System.currentTimeMillis();
		for (int i=0; i < count; i++) {			
			BigInteger n = new BigInteger(bigNum[i]);
			stringBuilder.append(n.multiply((n.add(n.ONE))).divide(two));
			stringBuilder.append('\n');				
		}
		System.out.println(stringBuilder);			
		System.out.println("Time:" + (System.currentTimeMillis() - stime));
	}
	
}
