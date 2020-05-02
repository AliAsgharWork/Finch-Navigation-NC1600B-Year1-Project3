package Extra;

import java.util.ArrayList;

public class testing {
	
	static ArrayList<String> array = new ArrayList<String>();
	public static void main(String [] args) {
		
		run("sd");
		run("fghj");
	
		System.out.println(array.get(0));
		System.out.println(array.get(1));
		
		
	}
	
	public static void run (String hey)
	{
		array.add(hey);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
