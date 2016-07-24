
public class PetrolBunks {
	public static void main(String[] args) {
		//int [] D = {1, 3, 2, 1, 3, 5};
		//int [] P = {1, 2, 4, 3, 3, 2};
		
//		int [] D =  {4, 8, 5, 4, 1, 6, 2, 2};
//		int [] P =  {3, 8, 7, 3, 5, 3, 2, 2};
		
		int [] D =  {4, 7, 4, 8, 4, 1};
		int [] P =  {3, 5, 3, 8, 3, 6};
		
		System.out.println("Start index: " + findStartingNode(D, P));
	}
	
	public static int findStartingNode(int [] D, int [] P) {
		int Dlen = D.length;
		int Plen = P.length;
		
		int Dsum = 0;
		int Psum = 0;
		for (int i=0; i<Dlen; i++) {
			Dsum += D[i];
		}
		
		for (int i=0; i<Plen; i++) {
			Psum += P[i];
		}
		System.out.println("Distance Sum: " + Dsum);
		System.out.println("Petrol Sum: " + Psum);
		
		if (Psum < Dsum) {
			return -1;
		}
		
		int start = 0;
		while (start < Dlen) {
			int i=start;
			int d = D[i];
			int p = P[i];
			
			while (d <= p) {
				int carry = p-d;
				if (i == (Dlen-1)) {
					i = 0;
				} else {
					++i;
				}
				if (i == start) {
					return start;					
				}
				
				d = D[i];
				p = P[i] + carry;
			}
			if (i == (Dlen-1)) {
				start = 0;
			} else {
				start = i+1;
			}
		}
		return -1;
	}
}
