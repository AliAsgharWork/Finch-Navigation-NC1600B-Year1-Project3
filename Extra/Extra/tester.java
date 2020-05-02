package Extra;

public class tester {

	
	
	
	
	public static void main(String [] arg) {
		
		
		String []array_inputCon={"f","F","r","R","l","L","1","2","3","4","5","6","7","8","9","0","@"};
		
		
		for (int i = 0; i < array_inputCon.length; i++) 
		{
			for (int k = 0; k < array_inputCon[i].length(); k++) 
			{
				
				char c =array_inputCon[i].toUpperCase().charAt(k);
				
				
			if(!((c >='0') && (c<='9'))&&!((c=='F')||(c=='R')||c=='L')) 
			{System.out.println("The command inputed contains illegal characters:"+array_inputCon[i].charAt(k));
			System.out.println(array_inputCon[i].toUpperCase().charAt(k));}
			}
		}
		
	}
}
