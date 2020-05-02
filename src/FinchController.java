import java.io.IOException;

public class FinchController {

	//CONSTRUCTOR VARIABLIES
	static String inputCon;
	
	public FinchController(String input) {//CONSTRUCTOR
		// TODO Auto-generated constructor stub
		inputCon=input;
	}
	

	/*INITIALIZING THE VARIABLES*/
	static String command;					  //more details in the method "input_Conditions()"
	static int firstVariable = 0;       	  
	static int secondVariable = 0;			  
	static int rightWheel = 0;	
	static int counter = 0;					  //used to count the # of times the program executed a command.
	static boolean backtrackingfactor=false;  //used to determine if a command is usable for backtracking.
	static OutputAndLogging log = new OutputAndLogging(inputCon);
	
	public static void Run_Finch(String input) throws IOException 
	{
		inputCon=input;
		String[] input_Array= FinchInput(input);//Takes the input for the Finch from the class "InputSection" as an String array


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

		log = new OutputAndLogging(input);

		//Command calling

		if((command.equals("F")) && err.forwardhandling())//Forward
		{FinchExecute.Forward(firstVariable, secondVariable);if(backtrackingfactor==false){counter++;log.PositiveCommand();}}  

		if((command.equals("R")) && err.righthandling())//Right
		{FinchExecute.Right(firstVariable, secondVariable, rightWheel);if(backtrackingfactor==false){counter++;log.PositiveCommand();}}

		if(command.equals("L") && err.lefthandling())//Left
		{FinchExecute.Left(firstVariable, secondVariable, rightWheel);if(backtrackingfactor==false){counter++;log.PositiveCommand();}}
												//COUNTER stops the program from running more commands then it is possible for that session
		if(command.equals("B") && err.backtracehandling())//Backtrack
		{FinchExecute.BackTracing(firstVariable);}

		if(command.equals("S")&&err.stophandling())//Stop
		{
			FinchExecute.Stop();
			MainClass.stoping_factor ="s";//Set variable "stoping_factor" as s to exit the loop.
		}

		log.general_Log();//At the end of one run of the program it gets logged.
	}
	
	
	public static String[] FinchInput(String input)//UNDER 10 LINES OF CODE
	{
		String[] array_input= input.split(" ");
		/*
		 * array_input[0] is for the selecting the method to be execute	:
		 	
									 F (for forward movement) 
									 R (for right turn) 
									 L (for left turn) 
								   	 B (for backtracking the movement) 
									 S (stop the program)		

		 * array_input[1] is for the Time 
		 * array_input[2] is for Speed of the Finch(-100 to 100) / [For L and R commands, speed of right wheel]
		 * array_input[3] is For L and R speed of left wheel
		 * */

		if (input == null || input == "") array_input[0] = "S";//Empty input will set the first element of the array so that it terminates.
		
		return(array_input);
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
		catch (ArrayIndexOutOfBoundsException e ){/*Response to error being out of bound is already inside ErrorAndValidation*/}
		catch (NumberFormatException e){OutputAndLogging.print("Error: Character entered in a place where it should not belong");command="-1";}//At the chance of this error no command is executed 
		return input_Array;

	}
}
