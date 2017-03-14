import java.util.Scanner;

public class Mkouts2_Proj4_342 {

	public static void main(String[] args) {

		String command;
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.print("Enter a command: ");
			command = scan.nextLine();

			// 1. User Opens app, prompting a refresh of all data
			if (command.equals("Open App")){
				
				InfoGatherer();
			}
			
			// 2. User hits refresh button in app, prompting refresh of positional data
			else if (command.equals("Update Positions")){
				System.out.print("Calling infoGatherer()\n");
				infoGatherer2();
			}
			// 3. User clicks on Mars to get more information on its surface temperature
			else if (command.equals("Swipe Right")){
				
				System.out.print("User has swiped right\n");
			}
			else if (command.equals("Choose Mars")){
				BodyInfo();
			}
			// 4. Program makes a new planet orbiting a sun
			else if (command.equals("New Planet")) {
				BodyInfo2();
				System.out.println("Awaiting Completion of refresh\n");
			}else
				
			System.out.println("invalid command!");
		}
	}
	
	
	static void InfoGatherer(){
		System.out.print("Calling initiateConnection()\n");
		initiateConnection();
		System.out.print("Calling updateFull()\n");
		updateFull();
		System.out.print("Returning data to AndroidViewManager\n");
	}	
	static void infoGatherer2(){
		System.out.print("Calling initiateConnection()\n");
		initiateConnection();
		System.out.print("Calling updateDisplayInfo()\n");
		updateDisplayInfo();
		System.out.print("Returning data to AndroidViewManager\n");
	}	
	static void initiateConnection(){
		System.out.print("Connecting to NASA JPL...\n");
		System.out.print("Connection Established\n");
	}
	static void updateFull(){
		System.out.print("Downloading system/positional data\n");
		System.out.print("Download complete\n");

	}
	static void updateDisplayInfo(){
		System.out.print("Downloading positional data\n");
		System.out.print("Download complete\n");
	}
	static void BodyInfo(){
		System.out.print("Referencing Mars.BodyInfo.TrivialInfo...\n");
		TrivialInfo();
	}
	static void BodyInfo2(){
		System.out.print("initializing Mars.BodyInfo.TrivialInfo...\n");
		System.out.print("initializing Mars.BodyInfo.DisplayInfo...\n");
	}
	static void TrivialInfo(){
		System.out.print("Referencing temperature...\n");
		System.out.println("Returning temperature value to Controller\n");
	}
}
