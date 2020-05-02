import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchExecute {

	private static Finch myFinch=new Finch();
								/** * * FINCH MOVEMENT CODE * * **/
	public static void Forward(int Time,int Speed)
	{
		
		OutputAndLogging.print("\n"+"Running: Forward"+"\n");
		myFinch.setWheelVelocities(mapping(Speed),mapping(Speed),Time*1000);
	}

	public static void Left(int Time,int LeftW,int RightW)
	{
		OutputAndLogging.print("\n"+"Running: Left"+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}

	public static void Right(int Time,int LeftW,int RightW)
	{
		OutputAndLogging.print("\n"+"Running: Right"+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}

	public static void BackTracing(int no_of_commands) throws IOException
	{
		
		FileReader handle = new FileReader("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt");
		BufferedReader br = new BufferedReader(handle);
		String line ;
		ArrayList<String> backtrack_command_storage = new ArrayList<String>();
		
		while ((line = br.readLine())!=null)
		{
			String [] log_data =line.split("\n");
			
			for (int i = 0; i < log_data.length; i++) 
			{
				if(log_data[i].startsWith("Sucessful Run :"))
					{
					String [] command_Splitter = log_data[i].split(":");
					backtrack_command_storage.add(command_Splitter[1]);
					}
			}
		}
		
		FinchController.backtrackingfactor=true;//is set so the backtracked operations don't get logged to avoid running the backtrack commands again
		
		for (int i = 0; i < no_of_commands; i++) {
			OutputAndLogging.print("Command no."+(i+1));
			OutputAndLogging.print("\nExectuing command: "+backtrack_command_storage.get(i));
			
			FinchController.Run_Finch(backtrack_command_storage.get(i));
			myFinch.sleep(1500);//Stops for 1.5 seconds
		}
		br.close();
		FinchController.backtrackingfactor=false;
		
	}

	public static void Stop()
	{
		OutputAndLogging.print("Ending program\nSee you next time :)\nExiting ControlNaviFinch...");
		myFinch.quit();
	}
									/** SPEED MAPPING SECTION * @return **/
	private static int mapping(int mappingValue) //Maps the input to the limits of the speed for the finch
	{
		int result;
		result=(255*mappingValue)/100;
		return Math.round(result);
	}
}