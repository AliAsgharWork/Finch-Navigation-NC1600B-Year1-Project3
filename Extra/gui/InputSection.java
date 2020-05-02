package gui;
import java.util.Scanner;

public class InputSection {
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
}