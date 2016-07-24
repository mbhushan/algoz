import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PowerSet {
	private int [] S = {1,2};
	private List<String> subsets = new ArrayList<String>();
	
	public static void main(String [] args) {
		PowerSet ps = new PowerSet();
		ps.findPowerSet();
		ps.printSubsets();
	}
	public void printSubsets() {
		Iterator<String> iter = subsets.iterator();
		System.out.println("printing the subsets: ");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public void findPowerSet() {
		int k = S.length;
		int n = (int) Math.pow(2, k);
		
		
		
		for (int i=0; i<n; i++) {
			String str = "";
			for (int j=0; j<k;  j++) {
				if ((i & 1<<j) != 0) {
					str += S[j] + " ";
				}
			}
			if (str.length() == 0) { subsets.add("null"); }
			else {subsets.add(str);}
		}
	}
}
