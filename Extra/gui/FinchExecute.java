package gui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchExecute {

	private static Finch myFinch=new Finch();
	
										/** * * FINCH MOVEMENT CODE * * **/
	public static void Forward(int Time,int Speed)
	{
		System.out.print("\n"+"Running: Forward"+"\n");
		myFinch.setWheelVelocities(mapping(Speed),mapping(Speed),Time*1000);
	}

	public static void Left(int Time,int LeftW,int RightW)
	{
		System.out.print("\n"+"Running: Left"+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}

	public static void Right(int Time,int LeftW,int RightW)
	{
		System.out.print("\n"+"Running: Right"+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}

	public static void BackTracing(int no_of_commands) throws IOException
	{
		//finch code 
		
		FileReader handle = new FileReader("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt");
		BufferedReader br = new BufferedReader(handle);
		String line ;
		ArrayList<String> hey = new ArrayList<String>();
		
		while ((line = br.readLine())!=null)
		{

			String [] nect =line.split("\n");
			for (int i = 0; i < nect.length; i++) {
				if(nect[i].startsWith("Sucessful Run :"))
					{
					String [] hey1 = nect[i].split(":");
					System.out.println(hey1[1]);
					hey.add(hey1[1]);
					}
			}
			//System.out.println(line);

		}
		
		
		
		
		mainclass.backtrackingfactor=true;
		
		for (int i = 0; i < no_of_commands; i++) {
			mainclass.Run_Finch(hey.get(i));
			myFinch.sleep(1500);//Stops for 1.5 seconds
			System.out.println("no of commands "+i+1);
		}
		
		mainclass.backtrackingfactor=false;
		

	}

	public static void Stop()
	{
		System.out.println("Ending program\nSee you next time :)");
		System.out.println("Exiting ControlNaviFinch...");
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