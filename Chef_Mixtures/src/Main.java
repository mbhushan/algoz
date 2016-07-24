import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public LinkedList<Integer> colorList = new LinkedList<Integer>();
	public int smokeValue = 0;	
	
	public void computeMinSmoke() {
		int min = 99999;
		int minIndex = 0;
		
		int [] colorArray ;
		Object [] ia = null;
		
		while (1 != colorList.size()) {
			colorArray =  new int[colorList.size()];
			ia = colorList.toArray();
			for (int j=0; j < ia.length; j++) {
				colorArray[j] = ((Integer)ia[j]).intValue();
			}			
			
			for (int i=0; i < colorArray.length - 1; i++) {
				int pairVal = (colorArray[i]+ colorArray[i+1]) % 100;
				if ( pairVal < min) {
					min = pairVal;
					minIndex = i;
				}
			}
			
			smokeValue = smokeValue +  (colorArray[minIndex] * colorArray[minIndex + 1]);			
			
			colorList.set(minIndex + 1, min);
			colorList.remove(minIndex);		
			min = 9999;
		}
		
		System.out.println(smokeValue);
		this.smokeValue = 0;
		this.colorList.clear();		
	}
	
	public static void main(String [] args) {
		Main obj = new Main();
		
		Scanner sc = new Scanner(System.in);	
		
		do {
			int count = sc.nextInt();
			
			if (1 == count) {
				sc.nextInt();
				System.out.println(0);
			} else {
				while (count > 0) {
					obj.colorList.add(sc.nextInt());
					count = count - 1;
				}
				obj.computeMinSmoke();
			}			
		}while (sc.hasNextInt());		
	}
}
