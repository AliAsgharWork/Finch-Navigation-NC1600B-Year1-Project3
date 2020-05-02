package Extra;

// Needs a package declaration to move to another folder

import java.util.ArrayList;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;



/**
 * Created by:Mohammad Ali Asgar Abbas
 * Date:14/2/2020
 * A starter file to use the Finch
 */

public class testfil
   {
   public static void main(final String[] args)
      {
      // Instantiating the Finch object
      Finch myFinch = new Finch();

      Scanner in = new Scanner(System.in);
      String a = in.next();
      
      System.out.println(a);
      
      
      ArrayList<String> commandlist = new ArrayList<String>();
      commandlist.add(null);
      
      
      for(int i =0;i<commandlist.get(i).length();i++)
      {
    	  System.out.println(commandlist.get(i));
    	  
      }
      
      
     // myFinch.setWheelVelocities(100,100,5000/2);
      
   
      
      
      
     System.out.println();
      // Always end your program with finch.quit()
     // myFinch.quit();
      //System.exit(0);
      }
   }

