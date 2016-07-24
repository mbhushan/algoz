
public class GarageDoorOpenCmd implements ICommand{
	GarageDoor garageDoor ;
	
	public GarageDoorOpenCmd(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.up();
	}

}
