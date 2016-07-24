import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;


public class CircusTower {
	
	private static Person [] persons;
	public static void main(String[] args) {
		readInput();
		printArray(persons);
		//System.out.println("After sorting by height: ");
		//First we will sort the persons according to height - O(nlogn)
		// And then we will find the longest increasing subsequence according to weight - O(n2)
		//sortPersonsByHeight();
		circusTower();
	}
	
	public static void circusTower() {
		Arrays.sort(persons, new HeightComparator());
		LISWeight();
	}
	
	public static void LISWeight() {
		int len = persons.length;
		int [] dp = new int[len];
		int [] prev = new int[len];
		
		for (int i=0; i<len; i++) {
			dp[i] = 1;
			prev[i] = -1;
		}
		
		int bestEnd = -1;
		int maxSeq = Integer.MIN_VALUE;
		
		for (int i=1; i<len; i++) {
			for (int j=0; j<i; j++) {
				if ((persons[i].getWeight() > persons[j].getWeight()) &&
						(dp[i] < dp[j] + 1)) {
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
			}
			if (dp[i] > maxSeq) {
				maxSeq = dp[i];
				bestEnd = i;
			}
		}
		
		System.out.println("Length of max tower possible: " + maxSeq);
		printCircusTower(prev, bestEnd);
		
	}
	
	public static void printCircusTower(int [] prev, int index) {
		Stack<Person> stack = new Stack<Person>();
		
		while (index >= 0) {
			stack.push(persons[index]);
			index = prev[index];
		}
		
		while (!stack.isEmpty()) {
			Person p = stack.pop();
			System.out.println("W: " + p.getWeight() + ":: H: " + p.getHeight());
		}
		System.out.println();
	}
	
	public static void sortPersonsByHeight() {
		Arrays.sort(persons, new HeightComparator());
		printArray(persons);
	}
	
	public static void printArray(Person [] persons) {
		if (null == persons) {
			return;
		}
		int len = persons.length;
		
		for (int i=0; i<len; i++) {
			System.out.println("H: " + persons[i].getHeight() + " - W:" + persons[i].getWeight());
		}
	}
	
	public static void readInput() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(in.readLine());
			persons = new Person[n];
			int i=0;
			while (n > 0) {
				String [] strs = in.readLine().split(" ");
				persons[i] = new Person(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
				++i;
				--n;
			}
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class HeightComparator implements Comparator<Person> {
	@Override
	public int compare(Person arg0, Person arg1) {
		if (arg0.getHeight() < arg1.getHeight()) {
			return -1;
		} else if(arg0.getHeight() > arg1.getHeight()) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
class Person {
	private int height;
	private int weight;
	
	public Person (int height, int weight) {
		this.height = height;
		this.weight = weight; 
	}
	
	public int getHeight() { return this.height; }
	public int getWeight() { return this.weight; }
}

