
public class StringSearch {
	public static void main(String[] args) {
		String [] str = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		
		System.out.println("Input String array: ");
		printArray(str);
		String key = "ball";
		System.out.println("Searching for key: " + key);
		int result = search(str, key);
		System.out.println(key + " is present at index: " + result);
		
		key = "ballcar";
		System.out.println("Searching for key: " + key);
		result = search(str, key);
		System.out.println(key + " is present at: " + result);
	}
	
	public static void printArray(String [] str) {
		if (null == str) { return ; }
		int len = str.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(str[i] + " => ");
		}
		System.out.println();
	}
	
	public static int search(String [] str, String key) {
		if (null == str || null == key) { return -1; }
		if (key == "") {
			for (int i=0; i<str.length; i++) {
				if (str[i] == "") { return i; }
			}
		}
		return searchWord(str, key, 0, str.length-1);
	}
	
	public static int searchWord(String [] str, String key, int low, int high) {
		
		while (low <= high) {
			//lets make sure there is some string at the end.
			while (low <= high && str[high] == "") {
				--high;
			}
			if (high < low) { return -1; }
			
			int mid = (low+high)/2;
			//increase the mid index till we find some index.
			while (str[mid] == "") {
				++mid;
			}
			
			int result = str[mid].compareTo(key);
			if (result == 0) {
				return mid;
			} else if (result < 0) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return -1;
	}
} 
