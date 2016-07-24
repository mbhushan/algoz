
public class SimpleRemoteControl {
	ICommand slot;
	
	public SimpleRemoteControl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCommand(ICommand command) {
		slot = command;
	}
	
	public void buttonPressed() {
		slot.execute();
	}
}
