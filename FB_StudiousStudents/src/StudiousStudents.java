import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class StudiousStudents {
	
	public static void main(String [] args) {
//		String [] s = {"1", "mani", "archana", "book","doggie"};
//		Arrays.sort(s);
//		for(int i=0; i<s.length; i++) {
//			System.out.println(s[i]);
//		}
		readInput();
	}
	
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			StringBuffer sb = new StringBuffer();
			while (n > 0) {
				String [] str = br.readLine().split(" ");
				Arrays.sort(str);
				int len = str.length;
				
				for (int i=1; i<len;i++) {
					sb.append(str[i]);
				}
				sb.append('\n');
				//System.out.println(sb.toString());
				--n;
			}
			System.out.println(sb.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
