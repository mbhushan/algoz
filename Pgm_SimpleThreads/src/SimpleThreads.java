
public class SimpleThreads {
	
	public static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": " + message);
	}
	
	private static class MessageLoop implements Runnable {
		@Override
		public void run() {
			String [] impInfo = {"this", "is", "imp", "my", "friend"};
			
			try {
				for (int i=0; i < impInfo.length; i++) {
					Thread.sleep(2000);
					threadMessage(impInfo[i]);
				}
				
			} catch (InterruptedException e) {
				threadMessage("I wasn't DONE!!");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		long patience = 1000 * 60 * 60;

		threadMessage("Starting message loop");
		Long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();

		threadMessage("Waiting for MessageLoop thread to finish");
		//loop until MessageLoop thread exits
		while (t.isAlive()) {
			threadMessage("Still waiting...");
			//Wait maximum of 1 second for MessageLoop thread to
			//finish.
			t.join(1000);
			if (((System.currentTimeMillis() - startTime) > patience) &&
					t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				//Shouldn't be long now -- wait indefinitely
				t.join();
			}
		}
		threadMessage("Finally!");
	}
}
