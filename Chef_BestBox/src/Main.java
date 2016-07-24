import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;



public class Main {
	
	public static int P = 0;
	public static int S = 0;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		readInput();
	}
	
	public static void readInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int numOfTestCases = Integer.parseInt(st.nextToken());
		
		while (numOfTestCases > 0) {
			--numOfTestCases;
			
			st = new StringTokenizer(in.readLine());
			
			P = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			calcVolume();			
		}
		System.out.println(sb);
	}
	
	public static void calcVolume () {
		double A = P/4;
		double B = S/2;
		//System.out.println("A:" + A + "B:" + B);
		double z1 = (A + Math.sqrt((A*A) - (3.0*B)))/3.0;
		double z2 = (A - Math.sqrt((A*A) - (3.0*B)))/3.0;
		//System.out.println("Z1: " + z1 + " Z2: " + z2);
		double a = A - z1;
		double b = B - (z1*A) + (z1*z1);
		
		double x1 = (a + Math.sqrt((a*a) - (4.0*b)))/2.0;
		double y1 = (a - Math.sqrt((a*a) - (4.0*b)))/2.0;
		
		//System.out.println("x1:" + x1 + "y1:" + y1);
		double vol1 = x1 * y1 * z1;
		//System.out.println("Vol1:" + vol1);
		a = A - z2;
		b = B - (z2*A) + (z2*z2);
		
		x1 = (a + Math.sqrt((a*a) - (4.0*b)))/2.0;
		y1 = (a - Math.sqrt((a*a) - (4.0*b)))/2.0;
		//System.out.println("x1:" + x1 + "y1:" + y1);
		double vol2 = x1 * y1 * z2;
		//System.out.println("Vol1:" + vol2);
		DecimalFormat format = new DecimalFormat("######0.00");
		
			
		if (vol1 > vol2) {
			sb.append(format.format(vol1) + '\n');
		} else {
			sb.append(format.format(vol2) + '\n');
		}		 
	}
}
