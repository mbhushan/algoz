
public class StringProblems {
	private static String sampleStr = "here is a test method";
	
	public static void main(String [] args) {
		System.out.println("String before replaceSpace call: " + sampleStr);
		System.out.println("Result after replaceSpace call: " + replaceSpace(sampleStr, "%20"));
	}
	
	private static String replaceSpace(String sourceStr,String replaceStr) {
		StringBuffer strBuff = new StringBuffer();
		
		for (int i=0;i<sourceStr.length();i++) {
			if (sourceStr.charAt(i) == ' ') {
				strBuff.append(replaceStr);
				continue;
			}
			strBuff.append(sourceStr.charAt(i));
		}
		return strBuff.toString();
	}
}
