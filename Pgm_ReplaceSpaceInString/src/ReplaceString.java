import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReplaceString {
	
	private static String text;
	private static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		readInput();
		replaceSpace();
	}
	
	public static void replaceSpace() {
		StringBuilder sb = new StringBuilder();
		String replace = "%20";
		
		for (int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			if (c == ' ') {
				sb.append(replace);
			} else {
				sb.append(c);
			}
		}
		
		System.out.println("Repalced String is:");
		System.out.println(sb.toString());
	}
	
	public static void  readInput() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		text = br.readLine();		
	}
}
