
public class reverse {
	public static String a = "I am here";
	static char[] arr =  a.toCharArray() ;
	
public static void main(String args[]){
	
	
	System.out.print("Array: ");
	
	for (int i=0;i<arr.length;i++) {
		System.out.print(arr[i]);
	}

	System.out.println();
	retRev(0,arr.length-1);
	
	printString(arr);
	
	int start = 0;
	int end = 0;
	for (int i=0; i< arr.length; i++) {
		if (arr[i] == ' ') {
			retRev(start, end-1);
			start = i+1;
		}
		end++;
	}
	
	printString(arr);
	
//	for(int i=0;i<arr.length;i++){
//		System.out.print(arr[i]);
//	}
	System.out.println();
	
}
	public static  void retRev(int i, int j) {
		
		while  (i < j) {
			char c = arr[i];
			arr[i] = arr[j];
			arr[j] = c;
			i++;
			j--;
		}
	}
	
	public static void printString(char [] S) {
		for (int i=0; i< S.length; i++) {
			System.out.print(S[i]);
		}
		System.out.println();
	}
}
