package manib;

public class ModelDuck extends Duck {
	
	ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
	
	public void display() {
		System.out.println("Me a model duck guys. :p");
	}
}
