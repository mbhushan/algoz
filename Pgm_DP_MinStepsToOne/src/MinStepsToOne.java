
public class MinStepsToOne {
	
	public static void main(String[] args) {
		System.out.println("Min no. of steps to 1 is: " +  getMinStepsToOne(10));
	}
	
	//F(n) =   1 + min{  F(n-1) ,  F(n/2)  ,  F(n/3)  }  if (n>1) , else 0  ( i.e., F(1) = 0 )
	public static int getMinStepsToOne(int n) {
		if (1==n) { return 0; }
		int [] dp = new int[n+1];
		dp[1] = 0; //base case		
		for (int i=2; i<=n; i++) {
			dp[i] = 1 + dp[i-1];
			if (i%2 == 0) { dp[i] = Math.min(dp[i], 1+dp[i/2]); }
			if (i%3 == 0) { dp[i] = Math.min (dp[i], 1+dp[i/3]); }
		}
		return dp[n];
	}
}
