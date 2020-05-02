package gui;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LoggingClass {
	
	//CONSTRUCTOR VARIABLIES
	static String CommandinputCon;
	
	
	//STORAGE ARRAY FOR A SESSION
	static ArrayList<String> storage_input = new ArrayList<String>();
	
	
	
	//CONSTRUCTURE
	public LoggingClass(String input)     																		/*,date/time*/
	{
		CommandinputCon=input;	
	}
	
	
	
	
										/** * COMMAND LOGGING * * */

	public void Command_Logger() throws IOException{
		
		//Selects the file where it is going to store the logs
		FileWriter handle = new FileWriter("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt");
		BufferedWriter bw = new BufferedWriter(handle);
		
		storage_input.add(CommandinputCon);

		/*start a session when the code runs and end that session with time and date*/
		
		
		for (int i = 0; i < storage_input.size(); i++) {
			
			bw.write("Sucessful Run :"+storage_input.get(i));
			bw.newLine();
		}
		
		bw.close();
		handle.close();
		
		
		//write a code for logging the commands

		
		 /* when the section stopped stopped or terminated with time and date*/
		



	}

	 
}
