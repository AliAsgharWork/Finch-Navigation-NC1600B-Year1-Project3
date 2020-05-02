package gui;

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

	/*INITIALIZING THE VARIABLES*/
	static String command;				//more details in the method "input_Conditions()" and the class "InputClass"
	static int firstVariable = 0;       //more details in the method "input_Conditions()" and the class "InputClass"
	static int secondVariable = 0;		//more details in the method "input_Conditions()" and the class "InputClass"
	static int rightWheel = 0;			//more details in the method "input_Conditions()" and the class "InputClass"
	static String stoping_factor = "" ; //used to stop the loop
	static int counter = 0;				//used to count the # of times the program executed a command
	static boolean backtrackingfactor=false;
	//static FinchExecute hi =new FinchExecute();
	
	public static void main(String args[]) throws IOException 
	// TODO Auto-generated method stub
	{
		//The sessions Date and Time is recorded
		int dateTime; 
		//A loop is set until termination is requested by user
		do
			{
			Scanner in = new Scanner(System.in);
			String input = "" ;	
			System.out.println("Write input:");
			input = in.nextLine();

			Run_Finch(input);
			
			}
		while (stoping_factor !="s"); 
		
	}
	
	public static void Run_Finch(String input) throws IOException 
	{
		String[] input_Array= InputSection.FinchInput(input);//Takes the input for the Finch from the class "InputSection" as an String array
			
			
		input_Conditions(input_Array);	/*	Comment : Variable Assignment Conditions
								This method takes the input for the InputClass, assigns
			 					the values to there respective conditions and then 
			 					whenever it executes a command in "command calling" it
			 					checks if there is any erroneous input,if there is it returns false
			 					thus stopping the program */
		
		//Error handling object
		ErrorAndValidation err = new ErrorAndValidation(command, firstVariable, secondVariable, rightWheel, counter, input_Array);
				/*      Comment : Error Handling
				  All the variable that are assigned are
				  used when it is to be determined if the input
				  that the user specified is within range 
				  for the program to match the criteria */
		
		//Command Logging Object
		LoggingClass log = new LoggingClass(input);
		
			
		//Command calling
			
		if((command.equals("F")) && err.forwardhandling())//Forward
		{FinchExecute.Forward(firstVariable, secondVariable);
		if(backtrackingfactor==false)
		{counter++;log.Command_Logger();}}  
		
		if((command.equals("R")) && err.righthandling())//Right
		{FinchExecute.Right(firstVariable, secondVariable, rightWheel);if(backtrackingfactor==false){counter++;log.Command_Logger();}}

		if(command.equals("L") && err.lefthandling())//Left
		{FinchExecute.Left(firstVariable, secondVariable, rightWheel);if(backtrackingfactor==false){counter++;log.Command_Logger();}}

		if(command.equals("B") && err.counting())//Backtrack
		{FinchExecute.BackTracing(firstVariable);}

		if(command.equals("S"))//Stop
		{
			FinchExecute.Stop();
			stoping_factor ="s";//Set variable "stoping_factor" as s to exit the loop
		}

		//Counting the number of times the program is executed 
		
	}


	public static String [] input_Conditions(String [] input_Array) {

		ErrorAndValidation.input_char_validacy(input_Array);//Check the values for illegal characters
		try{
		command= input_Array[0].toUpperCase();                     //Conditions for the command entered
		if (!(command.equals("S"))) 
		{
			firstVariable= Integer.parseInt(input_Array[1]);  	   // Time / # of backtrack
			secondVariable= Integer.parseInt(input_Array[2]); 	   // Speed / Speed of right wheel
			if (command.equals("R") || command.equals("L")) 
				rightWheel= Integer.parseInt(input_Array[3]);      //Implemented only if command is R or L
			
		}
		
		}
		catch (ArrayIndexOutOfBoundsException e ){/*Already have response to error being out of bound inside ErrorAndValidation*/}
		catch (NumberFormatException e){System.out.println("Error: Character entered in a place where it should not belong");}
		
		return input_Array;
		
	}
}