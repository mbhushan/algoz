import java.util.HashMap;
import java.util.Random;


public class RandGenerator {
	
	public static void main(String [] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0; i<7000; i++) {
			int n = genRand7();
			int val = 0;
			if (map.containsKey(n)) {
				val = map.get(n);
			}
			map.put(n, ++val);
		}
		
		for (int i=1; i<=7; i++) {
			System.out.println(i +":" + map.get(i));
		}
	}
	
	
	public static int genRand7() {
	    int [][] M5 = {{1,2,3,4,5},
	                    {6,7,1,2,3},
	                    {4,5,6,7,1},
	                    {2,3,4,5,6},
	                    {7,0,0,0,0}};
	   int result = 0;  
	   
	   while (result == 0) {
	       int row = rand5();
	       int col = rand5();
	       result = M5[row-1][col-1];
	   }
	   
	   return result;
	}
	
	public static int getRand7_Alt() {
		int num;
		do {
			num = 5 * (rand5()-1) + rand5();
		} while (num > 21);
		
		return num%7+1;
	}
	
	public static int rand5() {
		Random rand = new Random();
		return rand.nextInt(5) + 1;
	}

}
