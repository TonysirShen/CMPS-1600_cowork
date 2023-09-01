package input;
import java.util.Scanner;
public class MainClass {
	public static void main(String[] args) {
	System.out.println("start ShowMenu");
	
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	}
	public void Start(){
		Action("CreatePlace(Port, Port)");
		Action("CreatePlace(Cottage, Cottage)");
		Action("CreateCharacter(Jane, A)");
		Action("SetHairStyle(Jane, Long)");
		Action("SetClothing(Jane, Peasant)");
		Action("EnableIcon(\"Open\", Hand, Cottage.Door, \"Go to the port\", true)");
		Action("SetPosition(Jane, Cottage)");
		Action("SetCameraFocus(Jane)");
		Action("ShowMenu()");
		WaitFor("input Selected Start");
		Action("HideMenu()");
		Action("EnableInput()");
		WaitFor("input Open Cottage.Door");
		Action("Exit(Jane, Cottage.Door, true)");
		Action("Enter(Jane, Port.Exit, true)");
		WaitFor("input arrived Jane position Port.Exit");
		Action("Exit(Jane, Port.Exit, true)");
		Action("Enter(Jane, Cottage.Door, true)");
	}

	public void WaitFor(String msg)
	{
		while (true)
		{
			var input = Console.ReadLine();
			if (input == msg)
				break;
		}
	}

	public void Action(String msg)
	{
		Console.WriteLine("start " + msg);
		while (true)
		{
			var input = Console.ReadLine();
			if (input == "succeeded " + msg)
				break;
		}
	}
}
	