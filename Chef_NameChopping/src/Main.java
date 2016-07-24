import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static String [] names;
	public static int maxLen = 0;

	public static void main(String[] args) {
		//testMethod();
		takeInput();
		//printResult();
		calculateResult();		
		
	}
	
	public static void testMethod () {
		String s = "TESTING";
		String t = "TESKIN";
		
		String [] test = {"moni", "boni", "zoom","sbni", "kani", "llni"};
		
		Arrays.sort(test);
		
		for (String i : test) {
			System.out.println(i);
		}		
	}
	
	public static void takeInput() {
		Scanner sc = new Scanner(System.in);
		
		int noOfNames = sc.nextInt();
		names = new String [noOfNames];
        for (int i=0; i< noOfNames; i++) {
        	names[i] = sc.next().toLowerCase();
        }
        Arrays.sort(names);
	}
	
	public static void calculateResult() {
		for (int i=0; i<names.length-1; i++) {
			int min = names[i].length() <= names[i+1].length() ? names[i].length() : names[i+1].length();
			
			if (names[i].equals(names[i+1])) {
				if (names[i].length() > maxLen)
					maxLen = names[i].length();
			} else {
				for (int j=0; j < min; j++) {				
					if (names[i].charAt(j) != names[i+1].charAt(j)) {
						if (j > maxLen) {
							maxLen = j;							
						}
						break;
					}
				}
			}
		}
		System.out.println(maxLen);
	}
	
	public static void printResult() {
		for (String s : names) {
			System.out.println(s);
		}
	}

}
