package contest;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.Scanner;

public class busnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//6
		//180 141 174 143 142 175
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String a = in.nextLine();
		String [] aa= a.split(" ");
		int[] buses = new int[n];
		for(int i=0;i<n;i++) {
			buses[i] = Integer.parseInt(aa[i]);
		}
		Arrays.sort(buses);
		//System.out.print(Arrays.toString(buses));
		for(int i=0;i<n;i++) {
			int current = buses[i];
			//System.out.print(current);
			int j =i;
			//System.out.println(j);
			while(j<n-1) {
				int cur = buses[j];
				int next = buses[j+1];
				if(cur+1 == next) {
					//continue checking
					j++;
				}
				else {
					break;
				}
			}
				if(j==i) {
					System.out.print(buses[i]+" ");
					i = j;
				}
				else if(j==i+1) {
					System.out.print(buses[i] +" ");
					System.out.print(buses[j] +" ");
					i = j ;
				}
				else {
					System.out.print(buses[i]+"-"+ buses[j]+" ");
					i = j;
				}
			}
				
		}
	}

