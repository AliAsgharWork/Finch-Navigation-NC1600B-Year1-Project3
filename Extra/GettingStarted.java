import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class GettingStarted {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Finch myFinch = new Finch();
/*
		int x = myFinch.getLeftLightSensor();
		int y = myFinch.getRightLightSensor();
		int roomlight = ((x+y)/2)+10;*/
		int roomlight = 80;

		int avg;//I TOOK THIS OUT SIDE
		do
		{
			int p = myFinch.getLeftLightSensor();
			int q = myFinch.getRightLightSensor();

			avg = (p+q)/2;

			System.out.println();

			if (p<=p-10 && p>= p+10 == q<=q-10&&q>=q+10)
			{
				myFinch.setWheelVelocities(100,100,1000);
			}
			else if (p>q)
			{
				myFinch.setWheelVelocities(100,150,1000);
			}

			else if (p<q)
			{
				myFinch.setWheelVelocities(150,100,1000);
			}
					
			
			
			System.out.println("Countdown started");
		myFinch.setLED(255,0,0);
		if (new Reminder(5)!=null)
			while ( avg != roomlight);
			
		}
		while ( avg != roomlight);
		
		
		
		
		
		
		
		
		/*while ( avg < roomlight)
			{
				myFinch.sleep(5000);
				break;
			}*/

		// average if room 
		//	myFinch.setWheelVelocities(255,255,10000);


	}

}