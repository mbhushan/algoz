
public class RemoteController {
	public static void main(String [] args) {
		SimpleRemoteControl scr = new SimpleRemoteControl();
		
		Light light = new Light();
		LightOnCommand loc = new LightOnCommand(light);
		scr.setCommand(loc);
		scr.buttonPressed();
		
		GarageDoor gd = new GarageDoor();
		GarageDoorOpenCmd gdoc = new GarageDoorOpenCmd(gd);
		scr.setCommand(gdoc);
		scr.buttonPressed();
	}
}
