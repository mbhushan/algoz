
public class NetworkIP {
	
	public static final String ip = "125.25.100.201";
	
	public static void main(String[] args) {
		System.out.println("IP: " + ip);
		System.out.println("Integer Value: " + parseIPToInteger());
	}
	
	public static int parseIPToInteger() {
		int result = 0;
		int [] ipArray = new int[4];
		int len = ip.length();
		String temp = "";
		int j = 0;
		int n = 24;
		
		for (int i=0; i <len; i++) {
			char c = ip.charAt(i);
			
			if (c == '.') {
				ipArray[j] = Integer.parseInt(temp);
				temp = "";
				continue; 
			} else {
				temp += c;
			}
		}
		for (int i=0 ; i < ipArray.length; i++) {
			ipArray[i] = Integer.rotateLeft(ipArray[i],n);
			n = n-8;
			result += ipArray[i];
		}
		
		return result;
	}
}
