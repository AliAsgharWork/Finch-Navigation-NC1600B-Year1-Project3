
import java.io.IOException;
import java.util.Scanner;


public class MainClass {

	/*INITIALIZING THE VARIABLES*/
	static String input;
	static String stoping_factor = "" ; 	  //used to stop the loop.

	//Command Logging Object
	static OutputAndLogging log = new OutputAndLogging(input);
	
	//static FinchExecute hi =new FinchExecute();

	public static void main(String args[]) throws IOException 
	// TODO Auto-generated method stub
	{
		log.initialtimeStamplog();
		//When the sessions starts, a few initial instructional information is printed.
		//This is supposed to run only when the program starts.
		
		
		System.out.println("Welcome to the Finch Navigation Control Program\n"
				+ "\nThis program can run multiple commands like :"
				+ "\n F for forward movement(+ive speed forward,-ive speed backwards)." 
				+ "\n R for right orthogonal turn." 
				+ "\n L for left orthogonal turn."
				+ "\n B for backtracking the executed commands." 
				+ "\n S to stop the program."
				+ "\n\nPlease enter the Command, Time then Speed(right and left seperate for either right or left command) in this order."
				+ "\nEver variable should be separated by a SINGLE SPACE and Time should be less then 6 seconds."
				+ "Left and right movement should always be ortogonal to its current course.");

		//A loop is set until termination is requested by the user.
		do
		{
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			input = "" ;	
			System.out.println("\nEnter input:");
			input = in.nextLine();

			FinchController.Run_Finch(input);

		}
		while (stoping_factor !="s"); 
		
		log.finishtimeStamplog();
		
	}
	
}