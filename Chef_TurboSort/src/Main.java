import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static int [] A = new int[1000000];
	static int index = 0;
	static boolean isSorted = true;
	static boolean isReverseSorted = true;
	
	public static void randomizedQuickSort(int p,int r) {
		if (p < r) {
			int q = randomizedPartition(p, r);
			randomizedQuickSort(p, q-1);
			randomizedQuickSort(q+1, r);
		}
	}
	public static int randomizedPartition(int p, int r) {
		Random generator = new Random();
		int i = generator.nextInt(r-p) + p;
		int temp = A[r]; A[r] = A[i]; A[i] = temp;
		
		return partition(p,r);
	}
	
	public static int partition(int p, int r) {
		int x = A[r];
		int i = p-1;
		
		for (int j =p; j <= r-1; j++) {
			if (A[j] < x) {
				i = i + 1;
				int t = A[i]; A[i] = A[j]; A[j] = t;
			}
		}
		int t = A[i+1]; A[i+1] = A[r]; A[r] = t;
		return i+1;
	}
	
//	public static void main(String [] args) throws Exception {
//		
//		readFromConsole();
//		
//		sort();
//		
//		//Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1000000);
//		//br.readLine();
//		
//		//testMethod();
//		
//	//	int t = sc.nextInt();
//		//long startTime = System.currentTimeMillis();
////		while (t > 0) {
////			t -= 1;
////			A[index] = sc.nextInt();
////			if (index > 0 && isSorted && (A[index] < A[index-1])) { isSorted = false; }
////			if (index > 0 && isReverseSorted && (A[index] > A[index-1])) { isReverseSorted = false; }
////			index += 1;
////		}
//		//System.out.println("Time " + (System.currentTimeMillis()-startTime) );
//		//System.out.println(index);
//		
//		int t = Integer.parseInt(br.readLine());
//		long startTime = System.currentTimeMillis();
//		while (t > 0) {
//			t -= 1;
//			A[index] = Integer.parseInt(br.readLine());
//			//if (index > 0 && isSorted && (A[index] < A[index-1])) { isSorted = false; }
//			//if (index > 0 && isReverseSorted && (A[index] > A[index-1])) { isReverseSorted = false; }
//			index += 1;
//		}
//		System.out.println("Time " + (System.currentTimeMillis()-startTime) );
//		//System.out.println(index);
//		
//		 
//		
//    	//long startTime = System.currentTimeMillis();
//	 //	randomizedQuickSort(0,999999);
//		
////		System.out.println();
//	//	System.out.println("Time " + (System.currentTimeMillis()-startTime) );
//		if (isSorted) {
//			System.out.println("sorted...");
//			for (int i=0; i<index; i++)  {
//				System.out.println(A[i]);
//			}
//		} else if (isReverseSorted) {
//			System.out.println("Rev sorted...");
//			for (int i=index-1; i >= 0; i--)  {
//				System.out.println(A[i]);
//			}
//		} else {
//			System.out.println("Random...");
//			long sTime = System.currentTimeMillis();			
//			randomizedQuickSort(0, index-1);
//			System.out.println("Time " + (System.currentTimeMillis()-sTime) );
////			for (int i=0; i<index; i++)  {
////				System.out.println(A[i]);
////			}
//		}
//		
//	}
//	

	public static void main(String[] args) throws Exception{
		
		//readFromConsole();
		//readFromConsoleUsingScanner();
		testMethod();
		
		sort();
	}
	
	public static void readFromConsole() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1000000);
		index = Integer.parseInt(br.readLine());
		long startTime = -1;
//		while (t > 0) {
//			t -= 1;
//			A[index] = Integer.parseInt(br.readLine());
//			if(startTime==-1){
//				startTime = System.currentTimeMillis();
//			}
//			//if (index > 0 && isSorted && (A[index] < A[index-1])) { isSorted = false; }
//			//if (index > 0 && isReverseSorted && (A[index] > A[index-1])) { isReverseSorted = false; }
//			index += 1;
//		}
		
		for(int i=0;i<index;i++){
			if(startTime==-1){
				startTime = System.currentTimeMillis();
			}
			br.readLine();
			A[i] = Integer.parseInt("5");
		}
		
		System.out.println("Total Readtime " + (System.currentTimeMillis()-startTime));

	}
	
	
	public static void readFromConsoleUsingScanner() throws Exception{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long startTime = -1;
		while (t > 0) {
			t -= 1;
			A[index] = sc.nextInt();
			if(startTime==-1){
				startTime = System.currentTimeMillis();
			}
			if (index > 0 && isSorted && (A[index] < A[index-1])) { isSorted = false; }
			if (index > 0 && isReverseSorted && (A[index] > A[index-1])) { isReverseSorted = false; }
			index += 1;
		}
		
		System.out.println("Total Readtime " + (System.currentTimeMillis()-startTime));

	}

	
	public static void sort(){		
			long sTime = System.currentTimeMillis();			
			randomizedQuickSort(0, index-1);
			System.out.println("Sort Time " + (System.currentTimeMillis()-sTime) );
	}
	
	public static void testMethod() {
		Random generator = new Random();
		index = 1000000;
		for (int i=0; i<index; i++) {
			A[i] = generator.nextInt(1);
		}
		
	}
}
