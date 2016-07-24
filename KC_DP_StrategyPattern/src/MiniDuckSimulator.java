
public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard  = new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		
		//Lets play with Model duck.
		Duck model = new ModelDuck();
		model.display();
		model.performFly();		
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();	
	}
}
