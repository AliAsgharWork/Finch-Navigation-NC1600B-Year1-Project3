
public class ErrorAndValidation  {
	//Commence different test to see if the value for left and right wheel have a problem operating 


	static String main_turn_name="";
	static String secndary_turn_name="";
	static int T = 0,pT = 0,pL = 0,nT = 0,nL = 0,for6positive=0,for6negetive=0;
	static boolean for_R_or_L = false;

	//CONSTRUCTOR
	private static String commandCon;
	private static int timeCon;
	private static int rightCon;
	private static int leftCon;
	private static String [] array_inputCon;
	private int countCon;

	public ErrorAndValidation(String command,int firstVar,int secondVar,int thirdVar,int counter,String [] input_array) 
	{
		// TODO Auto-generated constructor stub

		commandCon=command;
		timeCon=firstVar;
		rightCon=secondVar;
		leftCon=thirdVar;
		array_inputCon=input_array;
		countCon=counter;

	}


	/**ERROR HANDLING AND VALIDATION**/

	/** Public Methods *///These methods are used to run in the "mainclass" class

	public boolean forwardhandling() {
		
		if(commandCon.equals("F")&& timelimit()&& speedRange()&&array_Lenght())
		{
			return true; 
		}
		return false;

	}

	public boolean righthandling() {
		
		if(commandCon.equals("R")&& right_movement() && timelimit() && speedRange() && ortogonal_handling()&&array_Lenght())
		{
			return true;
		}
		return false;
	}

	public boolean lefthandling() {
		
		if(commandCon.equals("L") && left_movement() && timelimit() && speedRange() && ortogonal_handling()&&array_Lenght())
		{
			return true;
		}
		return false;
	}
	public boolean backtracehandling() {
		
		if(commandCon.equals("B") && counting() &&array_Lenght())
		{
			return true;
		}
		return false;
	}

	public static boolean input_char_validacy(String [] Array_input) {
		
		boolean prob=true;
		for (int i = 0; i < Array_input.length; i++) 
		{
			for (int k = 0; k < Array_input[i].length(); k++) 
			{
				char c =Array_input[i].toUpperCase().charAt(k);
				
				if(!((c >='0') && (c<='9'))&&!((c=='F')||(c=='R')||c=='L'||c=='S'||c=='B'||c=='-')) 
				{
					OutputAndLogging.print("The command inputed contains illegal characters:"+Array_input[i].charAt(k));
					prob = false;
				}	
			}
		}
		return prob;
	}
	public boolean stophandling() {
		
		if(commandCon.equals("S") && array_Lenght())
		{
			return true;
		}
		return false;
	}
	
	
	
	
	/**Private Method*///These methods only run in this class

	//If F, R or L , time has to be less then 6 second (more then 6 ? false:true)
	private boolean timelimit(){
		if (( commandCon.equals("F")||commandCon.equals("R")||commandCon.equals("L") ) && timeCon>6 ) 
		{
			OutputAndLogging.print("Error: The time given is more than 6 seconds");
			return false;
		}
		return true;	
	}

	//If R , the value for left has to be greater then right wheel
	private boolean right_movement() {
		if(commandCon.equals("R") && rightCon < leftCon ) 
		{
			OutputAndLogging.print("Error: Value for right wheel is smaller then the left wheel.");
			return false;
		}
		return true;
	}

	//If L , the value for right has to be greater then left wheel 
	private boolean left_movement() {
		if(commandCon.equals("L") && (rightCon > leftCon) ) 
		{
			OutputAndLogging.print("Error: Value for left wheel is smaller then the right wheel.");
			return false;
		}
		else
			return true;
	}

	private boolean ortogonal_handling() {//CHANGE VARIABLE NAMES TO SOMETHING APPROPIRATE (PT,pL,etc...)

		//Initilising the variables

		if(commandCon.equals("R")){//Assigning values according to the time condition for RIGHT turn.

			main_turn_name="RIGHT";secndary_turn_name="LEFT";
			if(timeCon==1) {T=1;pT=32;pL=28;   nT=pT*-1;nL=pL*-1;}
			if(timeCon==2) {T=2;pT=22;pL=18;   nT=pT*-1;nL=pL*-1;}
			if(timeCon==3) {T=3;pT=17;pL=13;   nT=pT*-1;nL=pL*-1;}
			if(timeCon==4) {T=4;pT=14;pL=12;   nT=pT*-1;nL=pL*-1;}
			if(timeCon==5) {T=5;pT=15;pL=13;   nT=pT*-1;nL=pL*-1;}
			if(timeCon==6) {T=6;for6positive=13;  for6negetive=for6positive*-1;} //EXCEPTIONAL CASE

			//For R condition 
			if((rightCon>pT || rightCon<pL) || (leftCon<nT || leftCon>nL)) {
				for_R_or_L = true; }
			else
				for_R_or_L=false;
		}

		if(commandCon.equals("L")){//Assigning values according to the time condition for RIGHT turn.

			main_turn_name="LEFT";secndary_turn_name="RIGHT";
			if(timeCon==1) {T=1;nT=32;nL=28;   pT=nT*-1;pL=nL*-1;}
			if(timeCon==2) {T=2;nT=22;nL=18;   pT=nT*-1;pL=nL*-1;}
			if(timeCon==3) {T=3;nT=17;nL=13;   pT=nT*-1;pL=nL*-1;}
			if(timeCon==4) {T=4;nT=14;nL=12;   pT=nT*-1;pL=nL*-1;}
			if(timeCon==5) {T=5;nT=15;nL=13;   pT=nT*-1;pL=nL*-1;}
			if(timeCon==6) {T=6;for6negetive=13;   for6positive=for6negetive*-1;}// EXCEPTIONAL CASE

			//For L condition 
			if((rightCon<pT || rightCon>pL) || (leftCon>nT || leftCon<nL)) {
				for_R_or_L = true; }
			else
				for_R_or_L=false;	
		}

		if(timeCon==T && for_R_or_L )
		{
			if(!(T==6))
			{
				OutputAndLogging.print("This Command will not take a orthogonal "+main_turn_name+" turn to the current course.\n"
						+ "Try entering the "+main_turn_name+" wheel speed between "+pT+" and "+pL+"\n"
						+ "And the "+secndary_turn_name+ " wheel speed between "+nT+" and "+nL);
				return false;
			}
			else if((rightCon!=for6positive) || (leftCon!=for6negetive))//EXCEPTIONAL CASE RESPONSE
			{
				OutputAndLogging.print("This Command will not take a orthogonal "+main_turn_name+" turn to the current course.\n"
						+ "Try entering the "+main_turn_name+" wheel speed as "+for6positive+"\n"
						+ "And the "+secndary_turn_name+" wheel speed as "+for6negetive);
				return false;
			}

		}
		return true;	
	}


	//If the velocity entered is greater then the speed 100 and less then -100 
	private boolean speedRange() 
	{

		if(commandCon.equals("F")&&(rightCon>100 || rightCon<-100))//Forward conditon
		{
			OutputAndLogging.print("Error: Speed for the wheels is out of range\nTry between 100 and -100");
			return false;
		}
		else if ((rightCon>100 || rightCon<-100)&&(leftCon>100 || leftCon<-100))
		{
			OutputAndLogging.print("Error: Speed for RIGHT and LEFT wheel is out of range\nTry between 100 and -100");
			return false;
		}
		else if(rightCon>100 || rightCon<-100)
		{
			OutputAndLogging.print("Error: Speed for RIGHT wheel is out of range\nTry between 100 and -100");
			return false;
		}
		else if(leftCon>100 || leftCon<-100)
		{
			OutputAndLogging.print("Error: Speed for LEFT wheel is out of range\nTry between 100 and -100");
			return false;
		}
		else
			return true;
	}
	//Number of backtrack moves cannot exceed the number of the move commands the finch has completed so far.
	private boolean counting() {

		if (countCon < timeCon)
		{
			OutputAndLogging.print("Error: Not enought commands registered.");
			OutputAndLogging.print("Current Sucessful Stored Executions: "+ countCon);
			return false;
		}
		return true;
	}
	//Checks the number of elements in the input is at the specific limit
	private static boolean array_Lenght() {

		if(commandCon.equals("F")&&array_inputCon.length!=3) 
		{OutputAndLogging.print("The entered command for \""+commandCon+"\" should have 3 inputs (Command, Time and Velocity)");return false;}
		if((commandCon.equals("R")||commandCon.equals("L"))&&array_inputCon.length!=4) 
		{OutputAndLogging.print("The entered command for \""+commandCon+"\" should have 4 inputs (Command, Time, Velocity for Right Wheel and Velocity for Left Wheel )");return false;}
		if(commandCon.equals("B")&&array_inputCon.length!=2) 
		{OutputAndLogging.print("The entered command for \""+commandCon+"\" should have 2 inputs (Command, No. of Backtrace)");return false;}
		if(commandCon.equals("S")&&array_inputCon.length!=1) 
		{OutputAndLogging.print("The entered command for \""+commandCon+"\" should have 1 inputs (Command)");return false;}
		
		return true;

	}

}