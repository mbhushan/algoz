import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;


public class Main {
	
	public static void main(String [] args) throws IOException {
		readInput();
	}
	
	public static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().trim().split(" ");
		int N1 = Integer.parseInt(str[0]);
		int N2 = Integer.parseInt(str[1]);
		int N3 = Integer.parseInt(str[2]);
		
		//int n = N1 + N2 + N3;
		int [] A = new int[N1];
		int [] B = new int[N2];
		int [] C = new int[N3];
		
		BitSet bs = new BitSet();
		StringBuffer sb = new StringBuffer();
		Set<Integer> set = new HashSet<Integer>();
		
		int i=0;
		while (N1 > 0) {
			A[i] = Integer.parseInt(br.readLine());
			bs.set(A[i]);
			++i;
			--N1;
		}
		i=0;
		while (N2 > 0) {
			B[i] = Integer.parseInt(br.readLine());
			if (bs.get(B[i])) {
				//sb.append(B[i] + "\n");
				set.add(B[i]);
			} else {
				bs.set(B[i]);
			}
			--N2;
			++i;
		}
		i=0;
		while (N3 > 0) {
			C[i] = Integer.parseInt(br.readLine());
			if (bs.get(C[i])) {
				//sb.append(C[i] + "\n");
				set.add(C[i]);
			} else {
				bs.set(C[i]);
			}
			--N3;
			++i;
		}
		
		
		Integer [] s = set.toArray(new Integer[0]);
		Arrays.sort(s);
		int len = s.length;
		for (i=0; i<len; i++) {
			sb.append(s[i] + "\n");
		}
		//System.out.println(len);
		System.out.println(len + "\n" + sb.toString());
	}
}
