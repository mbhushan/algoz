
public class Coins {
	
	public static void main(String [] args) {
		new Coins().denominations();
	}
	
	public void denominations() {
		int [] C = {1,2,5,10};
		int N = 6;
		int [] T = new int[N +1];
		
		
		T[0] = 1;
		
		for (int i=0; i<C.length; i++) {
			for (int j=0; j + C[i] <= N; j++) {
				T[j+C[i]] += T[j];
			}
		}
		System.out.println("printing T: ");
		for (int i=0; i<T.length; i++) {
			System.out.print(T[i] + " ");
		}
		System.out.println();
		System.out.println("Number of ways? " + T[N]);
	}
}
