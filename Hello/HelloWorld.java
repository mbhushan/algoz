import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloWorld {
	
	public static void main(String [] args)
	{
//		System.out.println("Hello world to Java !\n");
//		double dist = 123451236789.2355;
//		DecimalFormat format = new DecimalFormat("######.00");
//		System.out.println(format.format(dist));
			List<String> result = permuteOf("abc",'0');
			
			Iterator<String> it = result.iterator();
			
			while (it.hasNext()) {
				String s = (String)it.next();
				System.out.println(s);
			}
		
//		char [] s = {'a','b','c'};
//		//permut(s,0);
//		perm("xxy",0);
	}
	public static void permut(char [] s, int n) {
		if (n == s.length) {
			System.out.println(s);
		} else {
			for (int i=n; i < s.length; i++) {
				char t = s[i]; s[i] = s[n]; s[n] = t;
				permut(s,n+1);
				char p = s[i]; s[i] = s[n]; s[n] = p;
			}
		}
	}
	// repeated characters allowed. like (aabbc)
	public static void perm(String s, int n) {
		if (n == s.length()) {
			System.out.println(s);
		} else {
			char last = '0';
			
			for (int i=n; i < s.length(); i++) {
				if  (last == s.charAt(i)) {
					continue;
				} else {
					last = s.charAt(i);					
				}
				
				char c = s.charAt(i);
				char t = s.charAt(n);
				s = s.substring(0,i) + t + s.substring(i+1,s.length());
				s = s.substring(0,n) + c + s.substring(n+1,s.length()); 
				perm(s, n+1);
				c = s.charAt(i);
				t = s.charAt(n);
				s = s.substring(0,i) + t + s.substring(i+1,s.length());
				s = s.substring(0,n) + c + s.substring(n+1,s.length()); 
			}
		}
	}
	
	   private static void perm1(String prefix, String s) {
	        if (s.length() == 0) System.out.println(prefix);
	        else {
	            for (int i = 0; i < s.length(); i++)
	               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, s.length()));
	        }

	    }
	
	public static List<String> permuteOf(String s, char last) {
		List<String> result = new ArrayList<String>();
		if (s.length() == 1) {
			result.add(s);
			return result;
		} else {		
			char first = s.charAt(0);
			
				String rest = s.substring(1);
				List<String> simpler = new ArrayList<String>();
				if (first != last){
					simpler = permuteOf(rest, first); 
					for (String permutation : simpler) { // extra work 
						 System.out.println("calling !");
			             List<String> additions = insertAtAllPositions(first, permutation); 
			             result.addAll(additions);
			         }
					
				} 				
				
		         return result;				
		} 
	}
	private static List<String> insertAtAllPositions(char first, String s) {
		    ArrayList<String> result = new ArrayList<String>();
		     for (int i = 0; i <= s.length(); i++) {
		         String inserted = s.substring(0, i) + first + s.substring(i);
		         result.add(inserted); 
		    }
		     return result; 
		}
	
}