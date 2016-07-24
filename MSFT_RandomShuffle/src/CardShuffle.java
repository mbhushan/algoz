import java.util.Random;



public class CardShuffle {
	public static final int N = 52;
	private static int [] cards  = new int[N];
	
	public static void main(String[] args) {
		
		for (int i=0; i < N; i++) {
			cards[i] = i+1;
		}
		shuffle();
		printCards();
	}
	
	public static void shuffle() {
		Random rand = new Random();
		
		for (int i=N-1; i>0 ; i--) {
			int k = rand.nextInt(i+1);
			int temp = cards[i];
			cards[i] = cards[k];
			cards[k] = temp;
		}
	}
	
	public static void printCards() {
		int len = cards.length;
		for (int i=0; i < len; i++) {
			System.out.print(cards[i] + " ");
		}
		System.out.println();
	}
}
