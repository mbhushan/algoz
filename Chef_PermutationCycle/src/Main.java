import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int lenPerm = Integer.parseInt(br.readLine());
		
		String [] str = br.readLine().split(" ");
		int [] perms = new int[lenPerm+1];
		int [] nums = new int[lenPerm+1];
		
		for (int i=1; i<=lenPerm; i++) {
			perms[i] = Integer.parseInt(str[i-1]);
		}
		
		int numCycles = 0;
		int start = 1;
		int current = 1;
		//int ptr = 1;
		int next  = 0;
		
		while ((start = getNextCyle(nums)) != -1) {
			//System.out.print(start + " ");
			sb.append(start + " ");
			current = start;
			while (true) {
				nums[current] = 1;
				next = perms[current];
				//System.out.print(next + " ");
				sb.append(next + " ");
				if (next == start) {
					break;
				}
				current = next;

			}
			++numCycles;
			sb.append("\n");
		}
		//System.out.println();
		System.out.println(numCycles);
		System.out.println(sb.toString());
	}
	
	public static int getNextCyle(int [] N) {
		int len = N.length;
		
		for (int i=1; i<len; i++) {
			if (N[i] == 0) {
				return i;
			}
		}
		
		return -1;
	}
}
