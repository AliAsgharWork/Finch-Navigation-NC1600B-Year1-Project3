package tringcode;

public class ErrorAndValidation extends mainclass {
	//Commence different test to see if the value for left and right wheel have a problem operating 


	//CONSTRUCTOR
	private static String commandCon;
	private static int timeCon;
	private static int rightCon;
	private static int leftCon;
	private int countCon;

	public ErrorAndValidation(String command,int firstVar,int secondVar,int thirdVar,int counter) 
	{
		// TODO Auto-generated constructor stub

		commandCon=command;
		timeCon=firstVar;
		rightCon=secondVar;
		leftCon=thirdVar;
		countCon=counter;

	}


												/**ERROR HANDLING AND VALIDATION**/
			/** Public Methods */

	public boolean forwardhandling() {
		if(commandCon.equals("F")&& timelimit()==true && speedRange()==true)
		{
			return true; 
		}
		return false;
		
	}
	
	public boolean righthandling() {
		if(commandCon.equals("R")&& right_movement() && timelimit() && speedRange() && ortogonal_handling())
		{
			return true;
		}
		return false;
	}
	
	                        																		//  CHECK THE TEST FOR THIS HANDLERS 
	public boolean lefthandling() {
																			                   //ADD ERROR HANDLING TO 90 DEGREE TURNS
	if(commandCon.equals("L") && left_movement() && timelimit() && speedRange() && ortogonal_handling())
		{
			return true;
		}
		return false;
	}
			
	//Number of backtrack moves cannot exceed the number of the move commands the finch has completed so far.
	public boolean counting() {

	if (countCon > timeCon)
		{
			System.out.println("Error: Not enought commands registered.");
			return false;
		}
		return true;
	}
			
			/**Private Method*/
	
	//If F, R or L , time has to be less then 6 second
	private boolean timelimit() //more then 6 ? false:true
	{
		if (( commandCon.equals("F")||commandCon.equals("R")||commandCon.equals("L") ) && timeCon>6 ) 
		{
			System.out.println("Error: The time given is more than 6 seconds");
			return false;
		}
		return true;	

	}
	
	//If R , the value for left has to be greater then right wheel
	private boolean right_movement() {
		if(commandCon.equals("R") && rightCon < leftCon ) 
		{
			System.out.println("Error: Value for right wheel is smaller then the left wheel.");
			return false;
		}
		return true;
	}
	
	//If L , the value for right has to be greater then left wheel 
	private boolean left_movement() {
		if(commandCon.equals("L") && (rightCon > leftCon) ) 
		{
			System.out.println("Error: Value for left wheel is smaller then the right wheel.");
			return false;
		}
		else
		return true;
	}
	
	
	
	
	
	private boolean ortogonal_handling() {
		String main_turn_name="RIGHT";
		String secndary_turn_name="LEFT";
		int T = 0,PRT = 0,PRL = 0,NLT = 0,NLL = 0;
		
		
		if(commandCon=="R"){
			if(timeCon==1) {T=1;PRT=32;PRL=28;   NLT=PRT*-1;NLL=PRL*-1;}
			if(timeCon==2) {T=2;PRT=22;PRL=18;   NLT=PRT*-1;NLL=PRL*-1;}
			if(timeCon==3) {T=3;PRT=17;PRL=13;   NLT=PRT*-1;NLL=PRL*-1;}
			if(timeCon==4) {T=4;PRT=14;PRL=12;   NLT=PRT*-1;NLL=PRL*-1;}
			if(timeCon==5) {T=5;PRT=15;PRL=13;   NLT=PRT*-1;NLL=PRL*-1;}
			//if(timeCon==6) {T=6;PRT=13;PRL=28;   NLT=PRT*-1;NLL=PRL*-1;} EXCEPTIONAL CASE
		}
//			else if(timeCon==2 && ((rightCon>=22 || rightCon<=18) || (leftCon>=-22 || leftCon<=-18)))
//			{
//				System.out.println("This Command will not take a orthogonal RIGHT turn to the current course.\n"
//						+ "Try entering the RIGHT wheel speed between 22 and 18\n"
//						+ "And the LEFT wheel speed between -22 and -18");
//				return false;
//			}
//			else if(timeCon==3 && ((rightCon>=17 || rightCon<=13) || (leftCon>=-17 || leftCon<=-13)))
//			{
//				System.out.println("This Command will not take a orthogonal RIGHT turn to the current course.\n"
//						+ "Try entering the RIGHT wheel speed between 17 and 13\n"
//						+ "And the LEFT wheel speed between -17 and -13");
//				return false;
//			}
//			else if(timeCon==4 && ((rightCon>=14 || rightCon<=12) || (leftCon>=-14 || leftCon<=-12)))
//			{
//				System.out.println("This Command will not take a orthogonal RIGHT turn to the current course.\n"
//						+ "Try entering the RIGHT wheel speed between 14 and 12\n"
//						+ "And the LEFT wheel speed between -14 and -12");
//				return false;
//			}
//			else if(timeCon==5 && ((rightCon>=15 || rightCon<=13) || (leftCon>=-15 || leftCon<=-13)))
//			{
//				System.out.println("This Command will not take a orthogonal RIGHT turn to the current course.\n"
//						+ "Try entering the RIGHT wheel speed between 15 and 13\n"
//						+ "And the LEFT wheel speed between -15 and -13");
//				return false;
//			}
//			else if(timeCon==6 && ((rightCon==13) || (leftCon==-13)))
//			{
//				System.out.println("This Command will not take a orthogonal RIGHT turn to the current course.\n"
//						+ "Try entering the RIGHT wheel speed as 13\n"
//						+ "And the LEFT wheel speed as -13");
//				return false;
//			}
		
			if(timeCon==T &&  ((rightCon>=PRT || rightCon<=PRL) || (leftCon>=NLT || leftCon<=NLL)))
			{
				System.out.println("This Command will not take a orthogonal "+main_turn_name+" turn to the current course.\n"
						+ "Try entering the "+main_turn_name+" wheel speed between "+PRT+" and "+PRL+"\n"
						+ "And the "+secndary_turn_name+ " wheel speed between "+NLT+" and"+NLL);
				return false;
			}
			else
				return true;	
	}
	
	
	
	

	
	
	
	
	//If the velocity entered is greater then the speed 100 and less then -100 
	private boolean speedRange() 
	{
		
		if(command.equals("F")&&(rightCon>100 || rightCon<-100))
		{
			System.out.println("Error: Speed for the wheels is out of range\nTry between 100 and -100\n");
			return false;
		}
		else if ((rightCon>100 || rightCon<-100)&&(leftCon>100 || leftCon<-100))
		{
			System.out.println("Error: Speed for RIGHT and LEFT wheel is out of range\nTry between 100 and -100\n");
			return false;
		}
		else if(rightCon>100 || rightCon<-100)
		{
			System.out.println("Error: Speed for RIGHT wheel is out of range\nTry between 100 and -100\n");
			return false;
		}
		else if(leftCon>100 || leftCon<-100)
		{
			System.out.println("Error: Speed for LEFT wheel is out of range\nTry between 100 and -100\n");
			return false;
		}
		else
			return true;
	}

}
