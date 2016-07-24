
//8:28 am
public class ChineseFour {
	 public static void main(String [] args) {
		 
		 getNum(562);
	 }
	 
	 public static void getNum(int x) {
		 int result = 0;
		 int p=0;
		 while (x > 0) {
			 int d = x%10;
			 x = x/10;
			 if (d == 4) {
				 System.out.println("ILLEGAL!");
				 return;
			 }
			 if (d > 4) {
				 --d;
			 }
			 result = result + (int)Math.pow(10, p) * d;
			 ++p;
		 }
		 
		 //System.out.println(result);
		 String str = String.valueOf(result);
		 result = Integer.parseInt(str, 9);
		 System.out.println(result);
	 }
}
