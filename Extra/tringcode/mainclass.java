package tringcode;

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

	
	public static void main(String args[]) 
	// TODO Auto-generated method stub
	{

		//A loop is set until termination is requested by user
		do
		{
			input_Conditions();/*		Comment : Variable Assignment Conditions
								 This method takes the input for the InputClass, assigns
			 					 the values to there respective conditions and then 
			 					 whenever it executes a command in "command calling" it
			 					 checks if there is any erroneous input,if there is it returns false
			 					 thus stopping the program */


			//Error handling object
			ErrorAndValidation err = new ErrorAndValidation(command, firstVariable, secondVariable, rightWheel, counter);
			/*      Comment : Error Handling
			  All the variable that are assigned
			  are used then ever it is to be determined									
			  if the input that the user specified is 					
			  within range for the program to work	*/

			//Command calling
			
			if((command.equals("F")) && err.forwardhandling())//Forward
			{FinchControlCommands.Forward(firstVariable, secondVariable);counter++;System.out.println(counter);}   //ASK IF THIS WAY (WITHOUT A MAKING A OBJECT) IS OK.

			if(( command.equals("R")) && err.righthandling())//Right
			{FinchControlCommands.Right(firstVariable, secondVariable, rightWheel);counter++;}

			if(command.equals("L") && err.lefthandling())//Left
			{FinchControlCommands.Left(firstVariable, secondVariable, rightWheel);counter++;}

			if(command.equals("B") && err.counting())//Backtrack
			{FinchControlCommands.BackTracing(firstVariable);}

			if(command.equals("S"))//Stop
			{
				FinchControlCommands.Stop();
				stoping_factor ="s";//Set variable "stoping_factor" as s to exit the loop
			}

			//Counting the number of times the program is executed 
		}
		while (stoping_factor !="s"); 

		System.out.println("Exiting ControlNaviFinch...");

	}



	public static void input_Conditions() {

		String[] input_Array= InputSection.FinchInput();//Takes the input for the Finch from the class "InputSection" as an array of strings. 
		

		//Conditions for the command entered
		command= input_Array[0].toUpperCase();
		if (!(command.equals("S"))) 
		{
			firstVariable= Integer.parseInt(input_Array[1]);  											    // Time / # of backtrack
			secondVariable= Integer.parseInt(input_Array[2]); 											    // Speed / Speed of right wheel
			if (command.equals("R") || command.equals("L")) rightWheel= Integer.parseInt(input_Array[3]);  //Implemented only if command is R or L
		}

	}















	/** * COMMAND LOGGING * * 

	public static void Logger(String x) throws IOException{

		FileWriter handle = new FileWriter("C:\\Users\\User\\Desktop\\FinchJavaEclipse\\logger.txt");
		BufferedWriter bw = new BufferedWriter(handle);

		//write a code for logging the commands

while ((line = br.readLine())!=null)
			{

				String [] nect =line.split("\n");
				for (int i = 0; i < nect.length; i++) {
					System.out.println(nect[i]);
				}
				//System.out.println(line);

			}


	}

	 */






}
