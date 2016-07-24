import java.util.HashMap;
import java.util.Map;


public class Numbers {
	
	private static Map<String, Integer> cacheMap = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		int result = calcWaysToChooseK(n, k);
		
		System.out.println("n: " + n);
		System.out.println("k: " + k);
		System.out.println("result: " + result);
	}
	
	public static int calcWaysToChooseK(int n, int k) {
		if (n == 0 || k ==0) {
			return 0;
		}
		if (k == 1) {
			return n;
		}
		if (k == n) {
			return 1;
		}
		if (k > n) {
			return 0;
		}
		
		
		return func(n, k);
	}
	
	public static int func (int n, int k) {
		if (k > n) { return 0; }
		if (k == 1) { return n; }
		
		String cacheKey = n + "_" + k;
		Integer cacheVal = cacheMap.get(cacheKey);
		
		if (cacheVal != null) {
			return cacheVal;
		}
		
		int val = 0;
		for (int i=1; i<=n; i++) {
			val += func(n-i-1, k-1);
		}
		cacheMap.put(cacheKey, val);
		
		return val;
	}
}
