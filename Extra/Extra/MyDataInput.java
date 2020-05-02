package Extra;

import java.util.Scanner;

/**
 * @author Zear Ibrahim
 * @version 1.0
 * <h1> Summary: This class will perform some capture user data from the console </h1>
 */


public class MyDataInput {

	private int UserValue;

	/**
	 * <h1> Summary: This construct uses a scanner to capture input </h1>
	 */
	public MyDataInput() {
		CaptureInput();
	}
	
	private void CaptureInput ()
	{
		Scanner user_input = new Scanner (System.in);

		UserValue = user_input.nextInt();
	}

	public int _getUserValue ()
	{
		return UserValue;
	}}