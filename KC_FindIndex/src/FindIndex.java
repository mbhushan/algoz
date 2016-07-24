
public class FindIndex {
	private static String [] A = { "apple",	"boy", "chair",	"dear",	"dog", "eating", "feature",	"great", "heat",
			"hunter", "intelligent","jealous","joker","kites",	"least","light","meaning","money","name",
			"neat",	"operation","peace","polite","quite","relentless","string",	"temperature","tools",	"universe",	"volvo",
			"wax",	"xeon",	"year",	"zebra" };
	
	public static void main(String[] args) {
		System.out.println("Length of Array: " + A.length);
		String str = "money";
		System.out.println("Index of \"" + str + "\": " + findIndex(str));
		
		str = "zebra";
		System.out.println("Index of \"" + str + "\": " + findIndex(str));
		
		str = "boy";
		System.out.println("Index of \"" + str + "\": " + findIndex(str));
		
		str = "volvo";
		System.out.println("Index of \"" + str + "\": " + findIndex(str));
		
		str = "baby";
		System.out.println("Index of \"" + str + "\": " + findIndex(str));
	}
	
	public static int findIndex(String str) {
		int first = 0;
		int last = 1;
		if (getWordFromList(0) == null) {
			System.out.println("list is EMPTY!");
			return -1;
		}
		if (getWordFromList(0).equals(str)) { return 0; }
		
		while (getWordFromList(last) != null && getWordFromList(last).compareTo(str) <= 0) {
			first = last;
			last = last * 2;
		}
		while (first <= last) {
			int mid = (first+last) / 2;
			if (getWordFromList(mid) == null) {
				last = mid - 1;
			} else {
				if (getWordFromList(mid).compareTo(str) == 0) {
					return mid;
				} else if (getWordFromList(mid).compareTo(str) < 0) {
					first = mid + 1;
				} else {
					last = mid - 1;
				}
			}
		}
		
		return -1;
	}
	
	public static String getWordFromList(int i) {
		if (i < 0) {
			return null;
		}
		
		int len = A.length;
		
		if (i >= len) {
			return null;
		}
		
		return A[i];
	}

}
