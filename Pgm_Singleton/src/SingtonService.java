
//what is the signature & body of method returning a singleton instance?

public class SingtonService {
	private static SingtonService singletonServiceObj;
	
	private SingtonService () {}
	
	public static synchronized SingtonService getServiceObject() {
		if (null == singletonServiceObj) {
			singletonServiceObj = new SingtonService();
			return singletonServiceObj;
		}
		return null;
	}
	public Object clone()  throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
