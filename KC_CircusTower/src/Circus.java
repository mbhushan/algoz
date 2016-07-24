import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Circus {
	
	private static Person [] persons;
	
	public static void main(String [] args) {
		readInput();
		//printPersons(persons);
		calcPeopleTower(persons);
	}
	
	public static void calcPeopleTower(Person [] P) {
		if (null == P) { return ; }
		int len = P.length;
		Arrays.sort(P, new WeightComparator());
		//printPersons(P);
		
		int [] DP = new int[len];
		int [] prev = new int[len];
		DP[0] = 1;
		prev[0] = -1;
		for (int i=0; i<len; i++) {
			prev[i] = -1;
		}
		int maxLen = Integer.MIN_VALUE;
		int bestEnd = -1;
		for (int i=1; i<len; i++) {
			for (int j=i-1; j>=0; j--) {
				if (((DP[j]+1) > DP[i]) && (persons[j].height <= persons[i].height)) {
					DP[i] = DP[j]+1;
					prev[i] = j;
				}
			}
			if (DP[i] > maxLen) {
				maxLen = DP[i];
				bestEnd = i;
			}
		}
		System.out.println("MaxLen: " + maxLen);
		printPeopleTower(prev, bestEnd);
	}
	
	public static void printPeopleTower(int [] prev, int n) {
		if (n < 0) {
			return ;
		}
		System.out.println("H:" + persons[n].height + " :: W:" + persons[n].weight);
		printPeopleTower(prev, prev[n]);
	}
	
	public static void printPersons(Person [] persons) {
		if (null == persons) {
			return ;
		}
		int len = persons.length;
		System.out.println("Printing persons height and weight: ");
		for (int i=0; i<len; i++) {
			System.out.println("H:" + persons[i].height + " :: W:" + persons[i].weight);
		}
	}
	public static void readInput() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			persons = new Person[n];
			int i=0;
			while (n>0) {
				String [] temp = br.readLine().split(" ");
				persons[i] = new Person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				--n;
				++i;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class WeightComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.weight < o2.weight) {
			return -1;
		} else if (o1.weight > o2.weight) {
			return 1;
		}
		return 0;
	}

}

class Person {
	Integer weight;
	Integer height;
	
	public Person(Integer height, Integer weight) {
		this.height = height;
		this.weight = weight;
	}
}
