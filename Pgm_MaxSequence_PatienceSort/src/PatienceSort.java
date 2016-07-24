import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;


public class PatienceSort {
	
	private int [] A = {7,10,2,6,8,5,9};	
	private Stack [] stacks;
	private int numOfStacks;
	private Map<Integer, Integer> parent;
	
	public PatienceSort() {
		stacks = new Stack[A.length];
		parent = new HashMap<Integer, Integer>();
		int numOfStacks = 0;
	}
	
	public static void main(String [] args) {
		PatienceSort ps =  new PatienceSort();
		ps.doPatienceSort();
		ps.printStackArray();
		System.out.println("Length of the max subsequence is: " + ps.numOfStacks);
		ps.printSequence();
	}
	
	public void printStackArray() {
		System.out.println("printing stack array: ");
		for (int i=0; i<numOfStacks; i++) {
			Iterator<Integer> it = stacks[i].iterator();
			while  (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
	}
	
	public void printSequence() {
		for (Integer i : parent.keySet()) {
			Integer key = (Integer)parent.get(i);
			System.out.print(i + " ");
			if (key != null) {				
				do {
					System.out.print(key + " ");
				} while ((key = parent.get(key))  != null);
			}
			System.out.println();
		}
	}
	
	public void doPatienceSort() {
		int len = A.length;
		for (int i=0; i<len; i++) {
			boolean dataUpdated = false;
			for (int j=0; j<numOfStacks; j++) {
				if ((Integer)stacks[j].peek() > A[i]) {
					stacks[j].push(A[i]);
					dataUpdated = true;
					if (j != 0) {
						parent.put(A[i], (Integer)stacks[j-1].peek());
					}
					break;
				}
			}
			if (!dataUpdated) {
				stacks[numOfStacks] = new Stack<Integer>();
				stacks[numOfStacks].push(A[i]);
				if (numOfStacks != 0) {
					parent.put(A[i], (Integer)stacks[numOfStacks-1].peek());
				}
				++numOfStacks;
			}
			
		}
	}
	
}
