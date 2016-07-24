
public class DeadLock {
	
	static class Resource  {
		private final String name;
		public Resource(String name) {
			this.name = name;
		}
		
		public String getName() { return this.name; }
		
		public synchronized void lock(Resource res) {
			System.out.println(this.getName() + " is locking hand " +  res.getName());
			res.release(this);
		}
		
		public synchronized void release(Resource res) {
			System.out.println(this.getName() + " is releasing hand " + res.getName());
		}
	}
	
	public static void main(String [] args) {
		final Resource ram = new Resource("Ram");
		final Resource ravan = new Resource("Ravan");
		
		new Thread(
				new Runnable() {
					public void run() { ram.lock(ravan);  }
				}
				).start();
		
		new Thread(
				new Runnable() {
					public void run() { ravan.lock(ram);  }
				}
				).start();
	}
}
