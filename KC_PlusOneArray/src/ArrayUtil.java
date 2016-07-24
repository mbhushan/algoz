import java.util.ArrayList;
import java.util.Iterator;


//6:50
public class ArrayUtil {
	
	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(8);
		list.add(9);
		
		System.out.println("initial array: ");
		printList(list);
		
		list = plusOneArray(list);
		System.out.println("after plus one array: ");
		printList(list);
		
		list = new ArrayList<Integer>();
		list.add(9);
		list.add(9);
		list.add(9);
		System.out.println("initial array: ");
		printList(list);
		
		list = plusOneArray(list);
		System.out.println("after plus one array: ");
		printList(list);
		
		
	}
	
	public static void printList(ArrayList<Integer> list) {
		if (null == list) { return ; }
		Iterator<Integer> iter = list.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
	
	public static ArrayList<Integer>  plusOneArray(ArrayList<Integer> list) {
		if (null == list) { return list; }
		
		int len = list.size();
		
		int num = 1;
		int i = len-1;
		int carry = 0;
		while (i>=0) {
			//System.out.println(list.get(i));
			int sum = (list.get(i) + num)%10;
			carry = (list.get(i) + num)/10;
			
			//update the index in list.
			list.set(i, sum);
			num = carry;
			--i;
		}
		if (carry > 0) {
			list.add(0);
			for (i=len; i>0; i--) {
				list.set(i, list.get(i-1));
			}
			list.set(0, carry);
		}
		
		return list;
	}

}
