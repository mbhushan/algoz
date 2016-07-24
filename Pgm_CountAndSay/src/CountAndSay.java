
public class CountAndSay {
	
	public static void main(String [] args) {
		new CountAndSay().countAndSay(5);
	}
	
	
	public void countAndSay(int n) {
		String current = "0 1";
		String previous = "";
		int count=0;
		
		do {
			System.out.println(current);
			previous = current;
			++count;
			StringBuilder sb = new StringBuilder();
			String [] str = previous.split(" ");
			int [] A = new int[str.length];
			for (int i=0; i<A.length; i++) {
				A[i] = Integer.parseInt(str[i]);
			}
			sb.append(count + " ");
			int i = 1;
			while (i<A.length) {
				int c = A[i];
				int cnt = 0;
				while ((i < A.length) && A[i] == c) {
					++cnt;
					i=i+1;
				}				
				sb.append(cnt + " ");
				sb.append(c + " ");
			}
			current = sb.toString();
		}while (n-- > 0);
	}
}
