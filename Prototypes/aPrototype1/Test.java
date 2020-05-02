package aPrototype1;
import java.util.ArrayList;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;




public class Test {

	private static Finch myFinch;


	public static void main(String args[]) 
	// TODO Auto-generated method stub
	{

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Write input:");
		String a = in.nextLine();
		String[] b= a.split(" ");

		for(int i =0;i<b.length;i++)//Printing the command
		{
			System.out.println(b[i]);
		}
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


		String command=b[0];
		int firstVariable=Integer.parseInt(b[1]);// Time / # of backtrack
		int secondVariable=Integer.parseInt(b[2]);// Speed / Speed of right wheel
		int rightWheel = 0;
		/*if (command.equals("R") || command.equals("L") ||command.equals("r") || command.equals("l") ) 
		   { rightWheel=Integer.parseInt(b[3]);}//Implemented only if command is R or L
		*/
		

		if(command.equals("f") || command.equals("F") )//Forward
		{Forward(firstVariable, secondVariable);}
/*
		if(command.equals("r") || command.equals("R") )//Right
		{Right(firstVariable, secondVariable, rightWheel);}

		if(command.equals("l") || command.equals("L") )//Left
		{Left(firstVariable, secondVariable, rightWheel);}
		
		if(command.equals("b") || command.equals("B") )//Backtrack
		{BackTracing(firstVariable);}
		
		if(command.equals("s") || command.equals("S") )//Stop
		{Stop();}
*/



	}


	
	
	
	/** * COMMAND LOGGING * * */
	
	
	
	
	
	
	
	/** * ERROR AND VALIDATION SECTOR * */

	//F is not more then 6 second
	//R and L are more then 6 second
	//If L , the value for right has to greater then left wheel
	//If R , the value for left has to greater then right wheel
	//Number of backtrack moves cannot exceed the number of the move commands the finch has completed so far.


	//Commence different test to see if the value for left and right wheel have a problem operating 
	
	
	


	/** SPEED MAPPING SECTION * @return **/

	public static int mapping(int mappingValue) //Maps the input to the limits of the speed for the finch
	{
		int result;
		result=(255*mappingValue)/100;
		
		if (String.valueOf(mappingValue).contains("-")) 
			{
				return Math.round(result)*(-1);
			}
		  else
			{
			return Math.round(result);
			}
		
	}




	/** * * FINCH MOVEMENT CODE  * */
	public static void Forward(int Time,int Speed)
	{
		System.out.println("hi there");
		myFinch = new Finch();
		System.out.println("\n"+"Running: "+"\n");
		myFinch.setWheelVelocities(mapping(Speed),mapping(Speed),Time*1000);
	}

	public static void Left(int Time,int LeftW,int RightW)
	{
		myFinch = new Finch();
		System.out.println("\n"+"Running: "+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}

	public static void Right(int Time,int LeftW,int RightW)
	{
		myFinch = new Finch();
		System.out.println("\n"+"Running: "+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}


	public static void BackTracing(int LeftW)
	{
		//finch code 
	}

	public static void Stop()
	{
		myFinch.quit();
	}




}
