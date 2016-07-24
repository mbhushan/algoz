
public class SleepMessages {
	private static String [] arr = {"here", "is", "the", "many", "facets", "of", "humanity"};
	
	public static void main(String[] args) throws InterruptedException {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			Thread.sleep(2000);
		}
	}
}
