import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	public static int[][] manPref;
	public static int[] engagedMan;
	public static int[] engagedGirl;
	public static int[][] girlRanking;
	public static int [] menProposals;
//	public static Queue<Integer> freeMan = new LinkedList<Integer>();
	public static Queue freeMan;

	
	public static void main(String[] args) {
		readInput();
	}
	
	public static void stableMarriage() {
		
		while (!freeMan.isEmpty()) {
			int m = (Integer)freeMan.remove();
			if (menProposals[m] <= (menProposals.length-1)) {
				
				int w = manPref[m][menProposals[m]];
				
				++menProposals[m];
				
				//if w is FREE then (m,w) becomes engaged.
				if (engagedGirl[w] == 0) {
					engagedGirl[w] = m;
					engagedMan[m] = w;
				} else {
					// else w is engaged with m1
					int m1 = engagedGirl[w];
					
					//w prefers m1 to m
					if (girlRanking[w][m1] < girlRanking[w][m]) {
						freeMan.add(m);
					} else {
						engagedGirl[w] = m;
						engagedMan[m] = w;
						freeMan.add(m1);
					}
				}
			}
		}
		
	}

	
	public static void readInput() {
		Scanner sc = new Scanner(System.in);
		int numOfTestCases = sc.nextInt();
		
		while (numOfTestCases > 0 ) {
			freeMan = new LinkedList();
			--numOfTestCases;
			int numOfPpl = sc.nextInt();		
			if (numOfPpl == 0) {
				System.out.println();
			} else {
				manPref = new int[numOfPpl+1][numOfPpl+1];
				engagedGirl = new int[numOfPpl+1];
				engagedMan = new int[numOfPpl+1];
				girlRanking = new int[numOfPpl+1][numOfPpl+1];
				menProposals = new int[numOfPpl+1];
			//	long stime = -1;
				int rank = 1;
				for (int i=1; i<=numOfPpl; i++) {
					sc.nextInt();				
					for (int j=1; j <= numOfPpl; j++) {					
						girlRanking[i][sc.nextInt()] = rank;
//						if (stime == -1) {
//							stime = System.currentTimeMillis();
//						}
						++rank;
					}
					rank = 1;
				}	
				for (int i=1; i<=numOfPpl; i++) {
					++menProposals[i];
					freeMan.add(i);	
					for (int j=0; j <= numOfPpl; j++) {
						manPref[i][j] = sc.nextInt();
					}
				}
				
				if (numOfPpl == 1) {
					System.out.println(1 + " " + 1);
				} else {
					stableMarriage();
					printResult();
					//System.out.println("total time:" + (System.currentTimeMillis() - stime));
				}
			}
		}
	}
	
	public static void printResult() {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i=1; i < engagedMan.length; i++) {
			stringBuffer.append(Integer.toString(i) + " " + Integer.toString(engagedMan[i]) + '\n');
		}
		System.out.print(stringBuffer.toString());
	}
}
