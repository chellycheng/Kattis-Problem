import java.util.Scanner;

public class Trik {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
		int a= sc.nextInt();
		
		if (a==0) {
			sc.close();
			break;
		}
	
		System.out.println(easiestOne(a));
	}
		   // solve test case and output answer
}
	
	public static int easiestOne(int n) {
		//this check if the numbers equal to each other
		int p=11;
		while(true) {
			if(calDigitSum(n*p)==calDigitSum(n)) {
				break;
			}
			p++;
		}
		return p;
	}
	
	public static int calDigitSum(int n) {
		//this calculate the digit sum given an integer
		int result = 0;
		int divisor=100000;
		while (n>0) {
			int left= n%divisor;
			if(left<10) {
				result+=left;
				n/=10;
			}
			if(divisor>10) {
			divisor/=10;
			}
		}
		return result;
	}

}
