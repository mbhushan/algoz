package manib;

/**
 * This is STRATEGY PATTERN: Defines a family of algorithms, encapsulates each one and
 * makes them interchangeable. Strategy lets the algorithm vary independently from clients
 * who use it.
 * @author manib
 *
 */
public class MiniDuckSimulator {
	
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		
		mallard.performFly();
		mallard.performQuack();
		mallard.display();
		
		Duck model = new ModelDuck();
		
		model.performFly();
		model.performQuack();
		model.display();
		
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
