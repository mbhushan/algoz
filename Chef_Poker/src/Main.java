import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCases = Integer.parseInt(br.readLine());
		
		while (testCases > 0) {
			String [] str = br.readLine().split(" ");
			int len = str.length;
			
			int [] ranks = new int[14];
			int [] suits = new int [5];
			boolean fourRankFound = false;
			for (int i=0; i<len; i++) {
				char first = str[i].charAt(0);
				char second = str[i].charAt(1);
				
				switch (first) {
				case 'A': ++ranks[1];   if (ranks[1] == 4){fourRankFound = true;} break;
				case 'T': ++ranks[10];	if (ranks[10] == 4){fourRankFound = true;}break;
				case 'J': ++ranks[11];	if (ranks[11] == 4){fourRankFound = true;}break;
				case 'Q': ++ranks[12];	if (ranks[12] == 4){fourRankFound = true;}break;
				case 'K': ++ranks[13];	if (ranks[13] == 4){fourRankFound = true;}break;
				default:
					int r = Integer.parseInt(first + "");
					++ranks[r];
					if (ranks[r] == 4){fourRankFound = true;}
					break;
				}
				
				switch (second) {
				case 'S': ++suits[1]; break;
				case 'H': ++suits[2]; break;
				case 'D': ++suits[3]; break;
				case 'C': ++suits[4]; break;
				}
			}
			boolean [] threeTwo = checkThreeTwo(ranks);
			if ((1==ranks[1]) && (1==ranks[10]) && (1==ranks[11]) && (1==ranks[12]) && (1==ranks[13]) && areAllSameSuit(suits)) {
				sb.append("royal flush" + "\n");
			 }else if (areConsecutive(ranks) && areAllSameSuit(suits)) {
				 sb.append("straight flush" + "\n");
			 } else if (fourRankFound) {
				sb.append("four of a kind" + "\n"); 
			 } else if (threeTwo[0] && threeTwo[1]) {
				 sb.append("full house" + "\n");
			 } else if (areAllSameSuit(suits)) {
				 sb.append("flush" + "\n");
			 } else if (areConsecutive(ranks)) {
				 sb.append("straight" + "\n");
			 } else if (threeTwo[0]) {
				 sb.append("three of a kind" + "\n");
			 } else if (threeTwo[1] && threeTwo[2]) {
				 sb.append("two pairs" + "\n");
			 } else if (threeTwo[1]) {
				 sb.append("pair" + "\n");
			 } else {
				sb.append("high card" + "\n");
			}
			
			--testCases;
		}
		System.out.println(sb.toString());
	}
	
	private static boolean [] checkThreeTwo(int [] ranks) {
		int len = ranks.length;
		boolean [] result = new boolean[3];
		int index = 1;
		for (int i=1; i<len; i++) {
			if (ranks[i] == 3) { result[0] = true; }
			if (ranks[i] == 2) { result[index] = true; ++index; }
		}
		
		return result;
	}
	
	private static boolean areConsecutive(int [] suits) {
		int len = suits.length;
		int count = 0;
		
		if ((1==suits[10]) && (1==suits[11]) && (1==suits[12]) && (1==suits[13]) && (1==suits[1])) {
			return true;
		}
		
		boolean found = false;
		for (int i=1; i<len; i++) {
			if (suits[i] == 1) {
				count = 1;
				int j = i+1;
				while ((j < len) && (suits[j] == 1)) {
					++count;
					++j;
				}
				if (count >= 5) {
					found = true;
					break;
				}
			}
		}
		
		return found;
	}
	
	private static boolean areAllSameSuit(int [] suits) {
		int len = suits.length;
		
		for (int i=1; i<len; i++) {
			if (suits[i] == 5) {
				return true;
			}
		}
		return false;
	}

}
