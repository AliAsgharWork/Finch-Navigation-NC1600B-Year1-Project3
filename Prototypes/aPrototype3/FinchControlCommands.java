package aPrototype3;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchControlCommands {

	private static Finch myFinch=new Finch();
	
	/** * * FINCH MOVEMENT CODE  * */
	public static void Forward(int Time,int Speed)
	{
		
		System.out.print("\n"+"Running: forward"+"\n");
		myFinch.setWheelVelocities(mapping(Speed),mapping(Speed),Time*1000);
	}


	public static void Left(int Time,int LeftW,int RightW)
	{
		
		System.out.print("\n"+"Running: left"+"\n");
		myFinch.setWheelVelocities(mapping(LeftW),mapping(RightW),Time*1000);
	}


	public static void Right(int Time,int LeftW,int RightW)
	{
	
		System.out.print("\n"+"Running: right"+"\n");
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
	
	
									/** SPEED MAPPING SECTION * @return **/
	public static int mapping(int mappingValue) //Maps the input to the limits of the speed for the finch
	{
		int result;
		result=(255*mappingValue)/100;
		return Math.round(result);

	}

	

}
