
public class ReverseWords {
	
	public static void main(String[] args) {
		String S = "this is my man mister school boy";
		StringBuilder sb = new StringBuilder();
		
		String [] A = S.split(" ");
		
		for (int i=A.length-1; i>=1; i--) {
			sb.append(A[i] + " ");
		}
		sb.append(A[0]  + ".");
		
		System.out.println(sb.toString());
	}
}
