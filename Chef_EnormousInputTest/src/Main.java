import java.util.Scanner;


public class Main {
	
	static long [] t;
	static int k = 0;
	static int n = 0;
	
	public static void main( String [] args) {
		Main obj =  new Main();
		
		Scanner sc = new Scanner(System.in);
	    n = sc.nextInt();
	    k = sc.nextInt();
	    
	    t = new long [n];
	    int count = 0;
	    int i = 0;
	    while (i < n) {
	    	t[i] = sc.nextLong();
	    	
	    	if  ((t[i] % k) == 0) { ++count; }	    	
	    	++i;
	    }
	    System.out.println(count);
	}
}
