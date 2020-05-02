package Extra;
public class StartingClass {

	public static void main(String[] args) {
		
		MyDataInput MDI = new MyDataInput();

		int login_succes;
		
		login_succes = MDI._getUserValue();
		
		if (login_succes == 1) {
			
			System.out.println("Success");
		}
		
		

		
	}

	

}