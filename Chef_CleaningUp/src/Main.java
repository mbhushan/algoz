import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			StringBuffer sbChef = new StringBuffer();
			StringBuffer sbAssis = new StringBuffer();
			
			String [] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			BitSet totalTasks = new BitSet();
			//System.out.println("N:" + n);
			//System.out.println("M:" + m);
			totalTasks.set(1, n+1);
			str = br.readLine().split(" ");
		//	System.out.println("F::" + totalTasks.toString());
			for (int i=0; i<m ; i++) {
				totalTasks.clear(Integer.parseInt(str[i]));
			}
		//	System.out.println("S::" + totalTasks.toString());
			int count = 1;
			for (int i=1; i<=n ;i++) {
				if (totalTasks.get(i) && (count%2 == 1)) {
					sbChef.append(i + " ");
					++count;
				} else if (totalTasks.get(i)) {
					sbAssis.append(i + " ");
					++count;
				}
			}
			sb.append(sbChef.toString() + "\n" + sbAssis.toString() + "\n");
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
}
