import java.util.Scanner;



public class Main {
	
	public static int[][] manPref;
	public static int[][] girlPref;
	public static int[][] engagedMan;
	public static int[][] engagedGirl;
	
	public static void main(String[] args) {
		readInput();
	}
	public static void printResult() {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i=1; i < engagedMan.length; i++) {
			//System.out.println(i + " " + engagedMan[i][1]);
			stringBuffer.append(Integer.toString(i) + " " + Integer.toString(engagedMan[i][1]) + '\n');
		}
		System.out.print(stringBuffer.toString());
	}
	public static void stableMarriage() {
		//boolean isFreeMan = true;
		int c = 0;
		while (c < (engagedMan.length*2)) {
			++c;
			for (int i=1; i < engagedMan.length; i++) {
				if ((engagedMan[i][0] < (engagedMan.length-1)) && (engagedMan[i][1] == 0)) {
					engagedMan[i][0] += 1;
					int p = engagedMan[i][0];
					int mip = manPref[i][p];
					if(engagedGirl[mip][1] == 0 ) {
						engagedMan[i][1] = manPref[i][p];
						engagedGirl[mip][1] = i;
					} else {						
						int m1 = engagedGirl[mip][1];
						
						for (int m=1; m < girlPref[mip].length; m++) {
							if (girlPref[mip][m] == m1) {
								break;
							}
							if (girlPref[mip][m] == i) {
								engagedGirl[mip][1] = i;
								engagedMan[i][1] = mip;
								engagedMan[m1][1] = 0;		
								break;
							} 
						}
					}
				} 
			}
//			for (int j=1; j< engagedMan.length; j++) {
//				if ((engagedMan[j][0] < (engagedMan.length-1) && engagedMan[j][1] == 0)) {
//					isFreeMan = true;
//				} else {
//					isFreeMan = false;
//				}
//			}
		}
	}
	public static void readInput() {
		Scanner sc = new Scanner(System.in);
		
		int numOfTestCases = sc.nextInt();
		
		while (numOfTestCases > 0 ) {
			--numOfTestCases;
			int numOfPpl = sc.nextInt();
			manPref = new int[numOfPpl+1][numOfPpl+1];
			girlPref = new int[numOfPpl+1][numOfPpl+1];
			engagedGirl = new int[numOfPpl+1][2];
			engagedMan = new int[numOfPpl+1][2];
			long stime = -1;
			for (int i=1; i<=numOfPpl; i++) {
				for (int j=0; j <= numOfPpl; j++) {					
					girlPref[i][j] = sc.nextInt();
					if (stime == -1) {
						stime = System.currentTimeMillis();
					}
				}
			}
			for (int i=1; i<=numOfPpl; i++) {
				for (int j=0; j <= numOfPpl; j++) {
					manPref[i][j] = sc.nextInt();
				}
			}
			//System.out.println("InputTime: " + (System.currentTimeMillis()- stime));
			long startTime = System.currentTimeMillis();
			stableMarriage();
			printResult();
			long stableTime = System.currentTimeMillis() - startTime;
			//System.out.println("Total Time : " +  stableTime);
		}
	}
	public static void printInput() {
		System.out.println("Girls: ");
		for (int i=1; i<girlPref.length; i++) {
			for (int j=0; j < girlPref[i].length; j++) {
				System.out.print(girlPref[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Men: ");
		for (int i=1; i<manPref.length; i++) {
			for (int j=0; j < manPref[i].length; j++) {
				System.out.print(manPref[i][j] + " ");
			}
			System.out.println();
		}
	}
}
