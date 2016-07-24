import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Permute {
	
	
	public static void main(String [] args) {
		Permute perm = new Permute();
		List<String> permuations =  perm.permute("abc");
		
		Iterator<String> iter = permuations.iterator();
		
		System.out.println("Permutations of the string are: ");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	
	public List<String> permute(String s) {
		List<String> result = new ArrayList<String>();
		if (s.length() == 1) {
			result.add(s);
			return result;
		} else {
			char first = s.charAt(0);
			String rest = s.substring(1);
			List<String> simpler = (ArrayList<String>)permute(rest);
			
			Iterator<String> it = simpler.iterator();
			
			while (it.hasNext()) {
				String perm = (String)it.next();
				List<String> additions = insertAtAllPositions(perm,first);
				result.addAll(additions);
			}
			return result;
		}
	}
	
	private List<String> insertAtAllPositions(String perm, char c) {
		List<String> result = new ArrayList<String>();
		for (int i=0; i<=perm.length(); i++) {
			String temp = perm.substring(0, i) + c + perm.substring(i);
			result.add(temp);
		}
		
		return result;
	}
}
