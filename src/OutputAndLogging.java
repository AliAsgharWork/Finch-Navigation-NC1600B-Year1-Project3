
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OutputAndLogging {
	
	//CONSTRUCTOR VARIABLIES
	static String CommandinputCon;
	static String result_outputCon;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
	
	//CONSTRUCTURE
	public OutputAndLogging(String input)     	
	{
		CommandinputCon=input;
	}
	
										/** * COMMAND LOGGING * * */

	
	public void initialtimeStamplog() throws IOException{/*start a session when the code runs and end that session with time and date*/
		LocalDateTime startdateTime= LocalDateTime.now();
		//The Date and Time is recorded at the start of a session.
		FileWriter handle = new FileWriter("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt",true);
		BufferedWriter bw = new BufferedWriter(handle);
		
		
		bw.newLine();
		bw.write("---------------------------SESSION START: "+dtf.format(startdateTime)+"----------------------------");
		bw.newLine();
		
		bw.close();
		handle.close();

	}
	
	public void finishtimeStamplog() throws IOException{/* when the section stopped stopped or terminated with time and date*/
		LocalDateTime enddateTime=LocalDateTime.now();
		
		FileWriter handle = new FileWriter("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt",true);
		BufferedWriter bw = new BufferedWriter(handle);
		
		
		bw.newLine();
		bw.write("----------------------------SESSION END: "+dtf.format(enddateTime)+"----------------------------");
		bw.newLine();
		
		bw.close();
		handle.close();

	}
	
	public static void print(String result_output) {
		result_outputCon=result_output;
		System.out.println(result_output);
		
	}

	public void PositiveCommand() throws IOException{
		
		//Selects the file where it is going to store the logs
		FileWriter handle = new FileWriter("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt",true);
		BufferedWriter bw = new BufferedWriter(handle);
		
		bw.write("Sucessful Run :"+CommandinputCon);
		bw.newLine();
		
		bw.close();
		handle.close();

	}
	
	public void general_Log() throws IOException{
		
		//Selects the file where it is going to store the logs
		FileWriter handle = new FileWriter("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt",true);
		BufferedWriter bw = new BufferedWriter(handle);
		
		bw.write("Command entered:"+CommandinputCon);
		bw.newLine();
		bw.write("RESULT:- \n"+result_outputCon);
		bw.newLine();

		bw.close();
		handle.close();

	}

	 
}
