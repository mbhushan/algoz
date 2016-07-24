
public class ReplaceSpace {
	public static String url = "This is the best string.";
	
	public static void main(String[] args) {
		System.out.println("url: " + url);
		System.out.println("replaced: " + replaceSpace());
	}
	
	public static String replaceSpace()  {
		String sb = new String();
		sb  = url.replaceAll(" ", "%20");
		
		return sb;
	}
}
