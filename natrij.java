package contest;

import java.util.Arrays;
import java.util.Scanner;

public class natrij{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		String startTime = in.nextLine();
		String endTime = in.nextLine();
		
		String [] start = startTime.split(":");
		String [] end = endTime.split(":");
		//visualize(start);
		//visualize(end);
		
		int[] s = new int[3];
		int[]e = new int[3];
		for(int i=0;i<3;i++) {
			s[i] = Integer.valueOf(start[i]);
			e[i] = Integer.valueOf(end[i]);
		}
		
		//visualize(s);
		
		int[] result = new int[3];
		int mc=0;
		if(e[2]-s[2]<0) {
			result[2] = e[2]+60-s[2];
			mc++;
		}
		else {
			result[2] = e[2]-s[2];
		}
		int hc =0;
		if(e[1]-s[1]-mc<0) {
			result[1] = e[1]+60-s[1]-mc;
			hc++;
		}
		else {
			result[1] = e[1]-s[1]-mc;
		}
		
		if(e[0]-s[0]-hc<0) {
			result[0] = e[0]-s[0]+24-hc;
		}
		else {
			result[0] = e[0]-s[0]-hc;
		
		}
		//visualize(result);
		boolean all_zero=true;
		for(int i=0;i<result.length;i++) {
			if (result[i]!=0){
				all_zero=false;
				break;
			}
		}
		if(all_zero) {
			result[0]=24;
		}
		print(result);
		
	}
	
	public static void visualize (String[] a) {
		System.out.println(Arrays.toString(a));
		
	}
	
	public static void visualize (int[] a) {
		System.out.println(Arrays.toString(a));
		
	}
	
	public static void print(int[] a) {
		String result="";
		for(int i:a) {
			if(i<10) {
				result +="0"+i;
			}
			else {
				result +=i;
			}
			result+=":";
		}
		System.out.println(result.substring(0, 8));
	}
}
