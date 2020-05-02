package Extra;

public class orgtest {


	static String commandCon = "R";
	static int timeCon = 1;
	static int rightCon = 13;
	static int leftCon = -13;





	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println(ortogonal_handling());

	}

	
	
	

	public static boolean ortogonal_handling() {

		String main_turn_name="";
		String secndary_turn_name="";
		int T = 0,PT = 0,pL = 0,nT = 0,nL = 0,for6positive=0,for6negetive=0;
		boolean for_R_or_L = false;

		if(commandCon=="R"){
			main_turn_name="RIGHT";secndary_turn_name="LEFT";
			if(timeCon==1) {T=1;PT=32;pL=28;   nT=PT*-1;nL=pL*-1;}
			if(timeCon==2) {T=2;PT=22;pL=18;   nT=PT*-1;nL=pL*-1;}
			if(timeCon==3) {T=3;PT=17;pL=13;   nT=PT*-1;nL=pL*-1;}
			if(timeCon==4) {T=4;PT=14;pL=12;   nT=PT*-1;nL=pL*-1;}
			if(timeCon==5) {T=5;PT=15;pL=13;   nT=PT*-1;nL=pL*-1;}
			if(timeCon==6) {T=6;for6positive=13;  for6negetive=for6positive*-1;} //EXCEPTIONAL CASE
			
		//For R condition 
		 	if((rightCon>PT || rightCon<pL) || (leftCon<nT || leftCon>nL)) {
		 		for_R_or_L = true; }
		 	else
		 		for_R_or_L=false;
		}
		
		if(commandCon=="L"){
			
			main_turn_name="LEFT";secndary_turn_name="RIGHT";
			if(timeCon==1) {T=1;nT=32;nL=28;   PT=nT*-1;pL=nL*-1;}
			if(timeCon==2) {T=2;nT=22;nL=18;   PT=nT*-1;pL=nL*-1;}
			if(timeCon==3) {T=3;nT=17;nL=13;   PT=nT*-1;pL=nL*-1;}
			if(timeCon==4) {T=4;nT=14;nL=12;   PT=nT*-1;pL=nL*-1;}
			if(timeCon==5) {T=5;nT=15;nL=13;   PT=nT*-1;pL=nL*-1;}
			if(timeCon==6) {T=6;for6negetive=13;   for6positive=for6negetive*-1;}// EXCEPTIONAL CASE
			
		//For L condition 
			if((rightCon<PT || rightCon>pL) || (leftCon>nT || leftCon<nL)){
		 		for_R_or_L = true; }
		 	else
		 		for_R_or_L=false;	
		}

		if(timeCon==T && for_R_or_L )
		{
			if(!(T==6))
			{
				System.out.println("This Command will not take a orthogonal "+main_turn_name+" turn to the current course.\n"
						+ "Try entering the "+main_turn_name+" wheel speed between "+PT+" and "+pL+"\n"
						+ "And the "+secndary_turn_name+ " wheel speed between "+nT+" and "+nL);
				return false;
			}
			else if((rightCon!=for6positive) || (leftCon!=for6negetive))//EXCEPTIONAL CASE RESPONSE
			{
				System.out.println("This Command will not take a orthogonal "+main_turn_name+" turn to the current course.\n"
						+ "Try entering the "+main_turn_name+" wheel speed as "+for6positive+"\n"
						+ "And the "+secndary_turn_name+" wheel speed as "+for6negetive);
				return false;
			}

		}
		return true;	
	}

}
