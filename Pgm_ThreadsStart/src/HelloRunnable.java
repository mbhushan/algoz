
public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Running mani in a thread :)");
	}
	
	public static void main(String[] args) {
		new Thread(new HelloRunnable()).start();
	}
}
