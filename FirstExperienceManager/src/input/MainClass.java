package input;
import java.util.Scanner;

public class MainClass {
	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		MainClass test = new MainClass();
		test.start();
		while (true);
	}
    public void start() {;
        action("CreatePlace(Port, Port)");
        action("CreatePlace(Cottage, Cottage)");
        action("CreateCharacter(Jane, A)");
        action("SetHairStyle(Jane, Long)");
        action("SetClothing(Jane, Peasant)");
        action("EnableIcon(\"Open\", Hand, Cottage.Door, \"Go to the port\", true)");
        action("SetPosition(Jane, Cottage)");
        action("SetCameraFocus(Jane)");
        action("ShowMenu()");
        waitFor("input Selected Start");
        action("HideMenu()");
        action("EnableInput()");
        waitFor("input Open Cottage.Door");
        action("Exit(Jane, Cottage.Door, true)");
        action("Enter(Jane, Port.Exit, true)");
        waitFor("input arrived Jane position Port.Exit");
        action("Exit(Jane, Port.Exit, true)");
        action("Enter(Jane, Cottage.Door, true)");
    }

    public void waitFor(String msg) {
        while (true) {
            String input = scanner.nextLine();
            if (input.equals(msg)) {
                break;
            }
        }
    }

    public void action(String msg) {
        System.out.println("start " + msg);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("succeeded " + msg)) {
                break;
            }
        }
    }
    
    	


}
