
public class reverseString {
	public static void main(String arg[]){
		
		String str="Archana means programmer";
		char[] arr=str.toCharArray();
		arr=retRev(arr);
	System.out.print("Returned String :");
	printString(arr);
		}
	public static char[] retRev(char[] s){
		int i= 0;
		int j=s.length -1;
		while  (i < j) {
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
			i++;
			j--;
		}
		return s;
	}
	public static void printString(char[] s){
		for(int i=0;i<s.length;i++)
		System.out.print(s[i]);
	}

}
