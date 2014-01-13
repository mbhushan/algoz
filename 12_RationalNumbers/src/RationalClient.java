import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RationalClient {

	private static Rational R1 = null;
	private static Rational R2 = null;
	public static void main(String [] args) {
		inputRationalNums();
		plusTest();
		minusTest();
		timesTest();
		dividesTest();
		equalityTest();
		printRationalNums();
	}
	
	
	public static void printRationalNums() {
		System.out.println("invoking toString on Rational obj:");
		System.out.println("R1: " + R1.toString());
		System.out.println("R2: " + R2.toString());
	}
	
	public static void equalityTest() {
		boolean flag = R1.equals(R2);
		
		if (flag) { 
			System.out.println("R1 and R2 are SAME!");
		} else {
			System.out.println("R1 and R2 are NOT same!");
		}
		
		flag = R1.equals(R1);
		if (flag) {
			System.out.println("R1 and R1 are SAME!");
		} else {
			System.out.println("R1 and R1 are NOT SAME!");
		}
	}
	
	
	public static void dividesTest() {
		Rational S = R1.divides(R2);
		
		if (S.N() == S.D() || S.N() == 0) {
			System.out.println("R1 / R2: " + S.N());
		}else { 
			System.out.println("R1 / R2: " + S.N() + "/" + S.D());
		} 
	}
	
	public static void timesTest() {
		Rational S = R1.times(R2);
		
		if (S.N() == S.D() || S.N() == 0) {
			System.out.println("R1 * R2: " + S.N());
		}else { 
			System.out.println("R1 * R2: " + S.N() + "/" + S.D());
		} 
	}

	public static void minusTest() {
		
		Rational S = R1.minus(R2);
		if (S.N() == S.D() || S.N() == 0) {
			System.out.println("R1 - R2: " + S.N());
		}else { 
			System.out.println("R1 - R2: " + S.N() + "/" + S.D());
		} 
	}
	
	public static void plusTest() {
		Rational S = R1.plus(R2);
		
		if (S.N() == S.D() || S.N() == 0) {
			System.out.println("R1 + R2: " + S.N());
		}else { 
			System.out.println("R1 + R2: " + S.N() + "/" + S.D());
		} 
	}
	
	public static void inputRationalNums() {
		int [] A = readInput();
		try {
			R1 = new Rational(A[0], A[1]);
		} catch (DivideByZeroException e) {
			e.printStackTrace();
		}
		System.out.println("R1: " + R1.N() + "/" + R1.D());
		
		A = readInput();
		try {
			R2 = new Rational(A[0], A[1]);
		} catch (DivideByZeroException e) {
			e.printStackTrace();
		}
		System.out.println("R2: " + R2.N() + "/" + R2.D());
	}
	
	public static int [] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] A = new int[2];
		try {
			String [] strs = br.readLine().split(" ");
			
			for (int i=0; i<strs.length; i++) {
				A[i] = Integer.parseInt(strs[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return A;
	}
}
