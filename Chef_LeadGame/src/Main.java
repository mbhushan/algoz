import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =  new StringBuffer();
		
		int numRounds = Integer.parseInt(br.readLine());
		int winner = 0;
		int lead = 0;
		int maxLead = 0;
		int s1 = 0;
		int s2 = 0;
		while (numRounds > 0) {
			String [] str = br.readLine().split(" ");
			s1 += Integer.parseInt(str[0]);
			s2 += Integer.parseInt(str[1]);
			
			if (s1 >= s2) {
				lead = s1 - s2;
				if (lead > maxLead) {
					winner = 1;
					maxLead = lead;
				}
			} else {
				lead = s2 - s1;
				if (lead > maxLead) {
					winner = 2;
					maxLead = lead;
				}
			}
			//System.out.println(winner + " : " + lead);
			--numRounds;
		}
		System.out.println(winner + " " + maxLead);
	}
}
