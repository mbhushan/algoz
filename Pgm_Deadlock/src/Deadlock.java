
public class Deadlock {
	public static class Friend {
		private String name;
		
		public Friend(String name) { this.name = name; }
		public String getName() { return this.name; }
		
		//Friend is bowing
		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s has bowed to me. ", this.name, bower.getName());			
			bower.bowBack(this);
		}
		
		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s has bowed back to me.  ", this.name, bower.getName());			
		}
	}
	
	public static void main(String [] args) {
		final Friend f1 = new Friend("mani");
		final Friend f2 = new Friend("sony");
		
		new Thread (
				new Runnable () {
					public void run () {
						f1.bow(f2);
					}
				  }
				).start();
		
		new Thread (
				new Runnable () {
					public void run() {
						f2.bow(f1);
					}
				}
				).start();
	}
}
