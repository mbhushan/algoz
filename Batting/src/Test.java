import org.omg.CosNaming.IstringHelper;


public class Test {
	
	public static void main(String[] args) {
		System.out.println("ans: " + plusOut("12xy34", "xy") );
	}
	
	public static String plusOut(String str, String word) {
		if (word.length() > str.length()) {
			if (str.length() < 1) { return ""; }
			else {
				String result = "";
				for (int i=0; i < str.length(); i++) {
					result += "+";
				}
				return result;
			}
		} else {
			int i = 0;
			int in = 0;
			String result = "";
			String st = "";
			st = str;
			while (i < st.length()) {
				in  = st.indexOf(word);
				
				if (in != -1) {
					for (int j=0; j < in; j++) {
						result += "+";
					}
					result += word;
					
					if ((in+word.length()) < st.length()) {
						st = st.substring(in+word.length());
						i = 0;
					} else {
						i = in+word.length();
					}
				} else {
					for (int k = 0; k < st.length(); k++) {
						result += "+";
					}
					break;
				}
			}
			return result;
		}
	}
}
