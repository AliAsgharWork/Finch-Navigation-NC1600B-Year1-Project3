package aPrototype3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class mainclass {

	


	public static void main(String args[]) 
	// TODO Auto-generated method stub
	{
		
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

			//Error handling object
			ErrorAndValidation err = new ErrorAndValidation(command, firstVariable, secondVariable, rightWheel, counter);
			
			
			//Command calling

			if((command.equals("f") || command.equals("F")) &&err.timer())//Forward
			{FinchControlCommands.Forward(firstVariable, secondVariable);}

			if((command.equals("r") || command.equals("R"))&& err.timer() && err.righthandling())//Right
			{FinchControlCommands.Right(firstVariable, secondVariable, rightWheel);}

			if((command.equals("l") || command.equals("L")) &&err.timer()&&err.lefthandling())//Left
			{FinchControlCommands.Left(firstVariable, secondVariable, rightWheel);}

			if((command.equals("b") || command.equals("B")) && err.counting())//Backtrack
			{FinchControlCommands.BackTracing(firstVariable);}

			if(command.equals("s") || command.equals("S"))//Stop
			{
				FinchControlCommands.Stop();
				a ="s";//Set variable "a" as s to exit the loop
			}
			
			counter++;//Counting the number of times 
		}
		while (a !="s"); 

		System.out.println("Exiting ControlNaviFinch...");

	}




	private static String[] FinchInput()
	{
		Scanner in = new Scanner(System.in);
		String a = "" ;	
		System.out.println("Write input:");
		a = in.nextLine();
		String[] b= a.split(" ");
		/*
		 * b[0] is for the selecting the method to be execute	:
		 	
								 F (for forward movement) 
								 R (for right turn) 
								 L (for left turn) 
							   	 B (for backtracking the movement) 
								 S (stop the program)		

		 * b[1] is for the time 
		 * b[2] is for speed of the finch(-100 to 100) / [For L and R speed of right wheel]
		 * b[3] is For L and R speed of left wheel
		 * */

		if (a == null || a == "") b[0] = "s";//Empty input will 
		
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






}
