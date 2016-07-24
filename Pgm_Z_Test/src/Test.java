import java.io.Console;


public class Test {
	
	public static void main(String [] args)  {
		String str = "mani bhushan";
		while (true) {
			System.out.println(str);
			 System.out.flush();
		}
	}
	
	public void clearConsole()  {
		Console console = System.console();
		if (console == null)
            System.out.println("Couldn't get Console object !");
		console.flush();
	}
}
