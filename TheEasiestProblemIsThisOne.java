import java.util.Scanner;

public class TheEasiestProblemIsThisOne{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
		String a= sc.next();
		
		System.out.print(trik(a));
		}
		sc.close();
		   // solve test case and output answer
		}
		
		public static int trik(String op) {
			//initial position 0 
			//A means change 0 1
			//B means change 1 2
			//C means change 0 3 
			int result =1;
			for(int i=0;i<op.length();i++) {
				char singleOp = op.charAt(i);
		      switch(singleOp) {
		         case 'A' :
		           if(result==1) {
		        	   	result ++;
		        	   //System.out.print("Here1");
		           }
		           else if(result==2) {
		        	   result --;
		           }
		           else {
		        	   //no change
		           }
		           break;
		         case 'B':
		        	   if(result==2) {
			        	   	result++;
			        //		System.out.print("Here2"+ result);
			           }
			           else if(result==3) {
			        	   result--;
			           }
			           else {
			        	   //no change
			           }
		        	   break;
		         case 'C' :
		        	   if(result==1) {
			        	   	result = (result+2);
			           }
			           else if(result==3) {
			        	   result = (result-2);
			           }
			           else {
			        	   //no change
			           }
		            break;
		         default :
		            System.out.println("Invalid grade");
		      }
			}
			return (result);
		}
}
