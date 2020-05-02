package aPrototype3;

public class ErrorAndValidation extends mainclass {
	//Commence different test to see if the value for left and right wheel have a problem operating 
	
									
	//CONSTRUCTOR
	private static String commandCon;
	private static int timeCon;
	private static int leftCon;
	private int rightCon;
	private int countCon;
	
	public ErrorAndValidation(String command,int firstVar,int secondVar,int thirdVar,int counter) 
	{
		// TODO Auto-generated constructor stub
		
		commandCon=command;
		timeCon=firstVar;
		leftCon=secondVar;
		rightCon=thirdVar;
		countCon=counter;
	
	}

												/**VALIDATION SECTON **/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
										/**ERROR HANDLING SECTION**/
	//F, R and L are more then 6 second
	public boolean timer() 
	{
		if ((commandCon.equals("f")||commandCon.equals("F")||
				commandCon.equals("r")||commandCon.equals("R")||
				commandCon.equals("l")||commandCon.equals("L")) &&
				timeCon>6   )
		{
			System.out.println("Error: The time given is more than 6 seconds");
			return false;
		}
		return true;	

	}

	//If L , the value for right has to greater then left wheel
	public boolean lefthandling() {

		if((commandCon.equals("l")||commandCon.equals("L")) && (rightCon < leftCon) ) 
		{
			System.out.println("Error: Value for left wheel is smaller then the right wheel.");
			return false;
		}
		return true;
		
	}

	//If R , the value for left has to greater then right wheel
	public boolean righthandling() {

		if((commandCon.equals("r")||commandCon.equals("R")) && rightCon > leftCon ) 
		{
			System.out.println("Error: Value for right wheel is smaller then the left wheel.");
			return false;
		}
		return true;
	}

	//Number of backtrack moves cannot exceed the number of the move commands the finch has completed so far.
		public boolean counting()
		{

			if (countCon > timeCon)
			{
				System.out.println("Error: Not enought commands registered.");
				return false;
			}
			return true;
		}


}
