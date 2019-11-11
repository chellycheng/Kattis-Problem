import java.util.Arrays;
import java.util.Scanner;

public class cypher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		String [] y = in.nextLine().split("");
		String [] b = in.nextLine().split("");
		String [] a = new String[m];
		for(int i=m-n;i<a.length;i++) {
			//should be only keyword be put in
			a[i]=y[i-(m-n)];
		}
		
		//String a = string(m - n, ' ') + a;
		//string k(m, ' ');
			  
	  for (int i = m - 1; i > n - 1; i--) {
	    a[i - n] = Character.toString((char)('a' + (26 + b[i].charAt(0) - a[i].charAt(0) ) % 26));
	  }
			  
		
	  for(String i:a) {
		  System.out.print(i);
	  }
			

	}

}
