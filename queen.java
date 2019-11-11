package contest;

import java.util.Arrays;
import java.util.Scanner;

public class queen {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[][] b = new String[8][8];
		for(int i=0;i<8;i++){
			String s = in.nextLine();
			b[i] = s.split("");
		}
		//System.out.println(Arrays.deepToString(b));
		int number =0 ;
		boolean v = true;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(b[i][j].equals("*")) {
					number++;
					//check row
					int t1=i+1;
					while(t1<8) {
						if(b[t1][j].equals("*")) {
							v=false;
							break;
						}
						t1++;
					}
					//check col
					int t2=j+1;
					while(v&&t2<8) {
						if(b[i][t2].equals("*")) {
							v=false;
							break;
						}
						t2++;
					}
					//cheeck diagonal
					int t3=i+1;
					int t4=j+1;
					int t5=j-1;
					while(v&&t3<8&&(t4<8||t5>=0)) {
						if(t4<8&&b[t3][t4].equals("*")) {
							v=false;
							break;
						}
						else {
							t4++;
						}
						if(t5>=0&&b[t3][t5].equals("*")) {
							v=false;
							break;
						}
						else {
							t5--;
						}
						t3++;
						
					}
					
				}
			}
		}
		if(v&&number==8) {
			print(v);
		}
		else {
			print(false);
		}
		

	}
	
	public static void print(boolean a) {
		if(a) {
			System.out.println("valid");
		}
		else {
			System.out.println("invalid");
		}
	}

}
