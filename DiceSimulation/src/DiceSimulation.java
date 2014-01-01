/*
Dice simulation. The following code computes the exact probability distribu-
tion for the sum of two dice:
int SIDES = 6;
double[] dist =
for (int i = 1;
for (int j =
dist[i+j]
new double[2*SIDES+1];
i <= SIDES; i++)
1; j <= SIDES; j++)
+= 1.0;
for (int k = 2; k <= 2*SIDES; k++)
dist[k] /= 36.0;
The value dist[i] is the probability that the dice sum to k. Run experiments to vali-
date this calculation simulating N dice throws, keeping track of the frequencies of oc-
currence of each value when you compute the sum of two random integers between 1
and 6. How large does N have to be before your empirical results match the exact results
to three decimal places?
 */
import java.text.DecimalFormat;
import java.util.Random;


public class DiceSimulation {
	private static int SIDES = 6;
	private static double [] dist;
	
	public static void main(String[] args) {
		sumDiceProb();
		simulation(10000000);
	}
	
	public static void sumDiceProb() {
		int n = 2*SIDES;
		dist = new double[n+1];
		
		for (int i=1; i<=SIDES; i++) {
			for (int j=1; j<=SIDES; j++) {
				dist[i+j] += 1.0;
			}
		}
		DecimalFormat df = new DecimalFormat("#.###");
		double total = 0.0;
		System.out.println("original probabilities: ");
		for (int i=2; i<=n; i++) {
			dist[i] /= 36.0;
			total += dist[i];
			System.out.print(df.format(dist[i]) + " ");
		}
		System.out.println();
//		System.out.println("total: " + total);
	}
	
	public static void simulation(int n) {
		int m = 2*SIDES;
		double [] freq = new double[m+1];

		Random rand = new Random();
		
		for (int i=1; i<=n ;i++) {
			int v1 = rand.nextInt(6) + 1;
			int v2 = rand.nextInt(6) + 1;
			++freq[v1+v2];
		}
		System.out.println("after running simulation for " + n + " trials - probablities are: ");
		DecimalFormat df = new DecimalFormat("#.###");
		for (int i=2; i<=m; i++) {
			freq[i] /= n;
			System.out.print(df.format(freq[i]) + " ");
		}
	}
}
/*
original probabilities: 
0.028 0.056 0.083 0.111 0.139 0.167 0.139 0.111 0.083 0.056 0.028 
after running simulation for 10000000 trials - probablities are: 
0.028 0.056 0.083 0.111 0.139 0.167 0.139 0.111 0.083 0.056 0.028 
*/