package APrototype2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;




public class Test {

	private static Finch myFinch = null;


	public static void main(String args[]) 
	// TODO Auto-generated method stub
	{
		@SuppressWarnings("resource")

		Scanner in = new Scanner(System.in);
		myFinch= new Finch();
		/*INITIALIZING THE VARIABLES*/
		int firstVariable = 0;
		int secondVariable = 0;
		int rightWheel = 0;
		String a = "" ;
		int counter = 0;

		do
		{

			String[] b= FinchInput();


			//Conditions for the command entered[see if this is better off in the Error and validation section]
			String command=b[0];
			if (!(command.equals("s")||command.equals("S"))) 
			{
				firstVariable=Integer.parseInt(b[1]);  // Time / # of backtrack
				secondVariable=Integer.parseInt(b[2]); // Speed / Speed of right wheel
				if (command.equals("R") || command.equals("L") ||command.equals("r") || command.equals("l") ) 
				{ rightWheel=Integer.parseInt(b[3]);}  //Implemented only if command is R or L
			}


			//Command calling

			if(command.equals("f") || command.equals("F") )//Forward
			{Forward(firstVariable, secondVariable);}

			if(command.equals("r") || command.equals("R") )//Right
			{Right(firstVariable, secondVariable, rightWheel);}

			if(command.equals("l") || command.equals("L") )//Left
			{Left(firstVariable, secondVariable, rightWheel);}

			if(command.equals("b") || command.equals("B") )//Backtrack
			{BackTracing(firstVariable);}

			if(command.equals("s") || command.equals("S") )//Stop
			{
				Stop();
				a ="s";//Set variable "a" as s to exit the loop
			}
			counter++;

		}
		while (a !="s"); 

		System.out.println("Exiting DoesMyFinchWork...");

	}




	private static String[] FinchInput()
	{
		Scanner in = new Scanner(System.in);
		String a = "" ;	
		System.out.println("Write input:");
		a = in.nextLine();
		String[] b= a.split(" ");
		/*
		 * b[0] is for the selecting the method to be execute	:.
		 	
								 F (for forward movement) 
								 R (for right turn) 
								 L (for left turn) 
							   	 B (for backtracking the movement) 
								 S (stop the program)		

		 * b[1] is for the time 
		 * b[2] is for speed of the finch(-100 to 100) / [For L and R speed of right wheel]
		 * b[3] is For L and R speed of left wheel
		 * */

		if (a == null || a == "") b[0] = "s";
		
		/* * * Error method insert * * */
		
		
		return(b);
	}





	/** * COMMAND LOGGING * * 

	public static void Logger(String x) throws IOException{

		FileWriter handle = new FileWriter("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt");
		BufferedWriter bw = new BufferedWriter(handle);

		//write a code for logging the commands




	}

	 */





	/** * ERROR AND VALIDATION SECTOR * */
	public static String ErrorValidation(String command,int one,int two,int three) {


		//F, R and L are more then 6 second
		if ((command.equals("f")||command.equals("F")||(command.equals("r")||
				command.equals("R")||command.equals("l")||command.equals("L")))&& one>6)
		{
			String error = "The time given is more the 6 seconds";
			return error;

		}
		
		//If L , the value for right has to greater then left wheel
		if((command.equals("l")||command.equals("L")) && two > three ) 
		{
			System.out.println("Error: Value for left wheel is smaller then the right wheel.");
		}
		
		//If R , the value for left has to greater then right wheel
		if((command.equals("r")||command.equals("R")) && two > three ) 
		{
			System.out.println("Error: Value for right wheel is smaller then the left wheel.");
		}
		//Number of backtrack moves cannot exceed the number of the move commands the finch has completed so far.
		//if (counter>)
		{
			
		}

		//Commence different test to see if the value for left and right wheel have a problem operating 

		return null;
	}


	/** SPEED MAPPING SECTION * @return **/

	public static int mapping(int mappingValue) //Maps the input to the limits of the speed for the finch
	{
		int result;
		result=(255*mappingValue)/100;
		return Math.round(result);

	}




	/** * * FINCH MOVEMENT CODE  * */
	public static void Forward(int Time,int Speed)
	{
		//myFinch = new Finch();
		System.out.print("\n"+"Running: "+"\n");
		myFinch.setWheelVelocities(mapping(Speed),mapping(Speed),Time*1000);
	}


	public static void Left(int Time,int LeftW,int RightW)
	{
		//myFinch = new Finch();
		System.out.print("\n"+"Running: "+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}


	public static void Right(int Time,int LeftW,int RightW)
	{
		//myFinch = new Finch();
		System.out.print("\n"+"Running: "+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}


	public static void BackTracing(int LeftW)
	{
		//finch code 
	}


	public static void Stop()
	{
		System.out.println("Ending program\nSee you next time :)");
		myFinch.quit();
	}




}
