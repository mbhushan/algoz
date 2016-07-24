
public class StringUtils {
	public static void main(String[] args) {
		System.out.println(isRotation("apple", "pleap"));
		System.out.println(isRotation("apple", "ppale"));
	}
	
	public static boolean isRotation(String s1, String s2) {
		
		if (null == s1 || null == s2) {
			return false; 
		}
		
		boolean flag = false;
		int s1Len = s1.length();
		int s2Len = s2.length();
		
		if (s1Len == s2Len) {
			String s3 = s1 + s1;
			if (s3.indexOf(s2, 0) >= 0) {
				flag = true;
			}
		}
		
		return flag;
	}
}
