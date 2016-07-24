import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String as[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//int [] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
		int t = Integer.parseInt(br.readLine());
		while(t!=0){
			int n = Integer.parseInt(br.readLine());
			long ans=0;
			if(n>23) {
				n=23;
			}
			//for (int j = 0; j < num.length; j++) {
				ans = 0;
				for (int i = 1; i <= n; i++) {
					ans += (i * (i + 1) * ((long) Math.pow(2, i - 2)));
				}
				//out.println((ans + 1));				
				out.println((ans+1)%8388608);
				//out.println();

			//}
			//out.println((ans+1)%8388608);
			
			t--;
		}
		out.close();
	}
} 