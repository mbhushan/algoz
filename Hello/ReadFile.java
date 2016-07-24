import java.util.Random;


public class ReadFile{
	public static void main(String [] args){
		ReadFile.generateRandom();
	}
	
	public static void generateRandom() {
		
		Random rand = new Random();
		
		int count = 100000;
		
		while (count >= 1) {
			int n = 1 + rand.nextInt(1000000);
			System.out.println(n);
			--count;
		}
	}
}