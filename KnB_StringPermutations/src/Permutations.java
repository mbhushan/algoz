import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Permutations {
	
	public static void main(String [] args) {
		//permuteRecursive("abc".toCharArray(), 0);
		calcPermutation("abc");
		
	}
	
	public static void permuteRecursive(char [] S, int n) {
		if (n == S.length) {
			for (int i=0; i<n; i++) {
				System.out.print(S[i]);
			}
			System.out.println();
		} else {
			int len = S.length;
			for (int i=n; i<len; i++) {
				char t = S[i]; S[i] = S[n]; S[n] = t;
				permuteRecursive(S, n+1);
				t = S[i]; S[i] = S[n]; S[n] = t;
			}
		}
	}
	
	public static void calcPermutation(String string) {
			List<String> permutations = permute(string);
			Iterator<String> iter = permutations.iterator();
			System.out.println("Printing permutations: ");
			while (iter.hasNext()) {
				System.out.println(iter.next());
			}
			System.out.println("done!!");
	}
	
	public static List<String> permute(String string) {
	    List<String> result = new ArrayList<String>();
	    
	    if (string == null || string.length() <= 1) { 
	        result.add(string);
	        return result;
	    }
	    
	    char first = string.charAt(0);
	    String rest = string.substring(1);
	    
	    List<String> simpler = (List<String>)permute(rest);
	    
	    Iterator<String> iter = simpler.iterator();
	    
	    while (iter.hasNext()) {
	        List<String> additions = insertAtAllPositions((String)iter.next(), first);
	        result.addAll(additions);
	    }
	    
	    return result;    
	}

	public static List<String> insertAtAllPositions(String string, char first) {
	    List<String> result = new ArrayList<String>();
	    int len = string.length();
	    for (int i=0; i<=len; i++) {
	        String inserted = string.substring(0,i) + first + string.substring(i);
	        result.add(inserted);
	    }
	    return result;
	}

}
