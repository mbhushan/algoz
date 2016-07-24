
public class ReverseStrings {
	
	public static void main(String [] args) {
		String string = "who are you";
		String revStr = reverseString(string);
		
		System.out.println(string + " -> " + revStr);
	}
	
	public static String reverseString(String string) {
	    if ((string == null) || (string.length() <= 1)) {return string; }
	    
	    int len = string.length();
	    
	    string = reverseWord(string);
	    
	    int startIndex = 0;
	    StringBuffer sb = new StringBuffer();
	    for (int i=0; i<len; i++) {
	        if (string.charAt(i) == ' ') {
	            sb.append(reverseWord(string.substring(startIndex,i)));
	            sb.append(' ');
	            startIndex = i+1;
	        }
	    }
	    sb.append(reverseWord(string.substring(startIndex,len)));
	    
	    return sb.toString();
	}

	public static String reverseWord(String word) {
	    if ((word == null) || (word.length() <= 1)) { return word; }
	    
	    int len = word.length();
	    char [] arr = word.toCharArray();
	    
	    for (int i=0, j=len-1; i<j; i++,j--) {
	        char ch = arr[i]; 
	        arr[i] = arr[j];
	        arr[j] = ch;        
	    }
	    
	    StringBuffer sb = new StringBuffer(new String(arr));
	    
	    return sb.toString();    
	}
}
