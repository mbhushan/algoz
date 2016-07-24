import java.util.BitSet;
import java.util.Random;


public class BloomFilter {
	private static final int M = 100;
	private static final int K = 3;
	private static BitSet bfilter = new BitSet(M);
	
	public static void main(String[] args) {
		String [] S = {"apple",
					   "beetroot",
					   "carrot",
					   "mango",
					   "orange",
					   "banana",
					   "guava",
					   "cucumber",
					   "pineapple",
					   "lemon",
					   "grapes",
					   "watermelon",
					   "papaya",
					   "jackfruit"
					  };
		
		initFilter(S);
		String str = "grape";
		String str1 = "apples";

		System.out.println("\"" + S[0] + "\" is present in bloomfilter? " + isKeyPresent(S[0]));
		System.out.println("\"" + str1 + "\" is present in bloomfilter? " + isKeyPresent(str1));
		System.out.println("\"" + S[5] + "\" is present in bloomfilter? " + isKeyPresent(S[5]));
		System.out.println("\"" + S[10] + "\" is present in bloomfilter? " + isKeyPresent(S[10]));
		System.out.println("\"" + str + "\" is present in bloomfilter? " + isKeyPresent(str));

	}
	
	public static boolean isKeyPresent(String str) {
		
		for (int i=0; i<K; i++) {
			int hcode = str.hashCode();
			hcode = Math.abs(hcode);
			int R = hcode % M;
			
			boolean flag = bfilter.get(R);
			if (!flag) { return false; }
			
			str = rotateClockwiseString(str);
		}
		return true;
	}
	
	public static void initFilter(String [] S) {
		int len = S.length;

		for (int i=0; i<len; i++) {
			String key = S[i];
			for (int j=0; j<K; j++) {
				int hcode = key.hashCode();
				hcode = Math.abs(hcode);
				int R = hcode % M;
				bfilter.set(R);
				key = rotateClockwiseString(key);
			}
		}
	}
	
	public static String rotateClockwiseString(String str) {
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		sb.append(str.charAt(len-1));
		
		for (int i=0; i<len-1; i++) {
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
	}
}
