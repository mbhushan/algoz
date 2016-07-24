import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

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
			if (A[j] <= x) {
				i = i + 1;
				int t = A[i]; A[i] = A[j]; A[j] = t;
			}
		}
		int t = A[i+1]; A[i+1] = A[r]; A[r] = t;
		return i+1;
	}

	public static void main(String[] args) throws Exception{
		
		long startTime = System.currentTimeMillis();
		readFromConsole();
		System.out.println(System.currentTimeMillis()-startTime);
		
		sort();
	}
	

	public static void readFromConsole() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			t -= 1;
//			A[index++] = Integer.parseInt(br.readLine());
			//index += 1;
		}
	}
	public static void sort(){
		long sTime = System.currentTimeMillis();			
		randomizedQuickSort(0, index-1);
		System.out.println("Time " + (System.currentTimeMillis()-sTime) );
//		for (int i=0; i<index; i++)  {
//			System.out.println(A[i]);
//		}
	}
}