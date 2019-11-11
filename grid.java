import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class grid {

	public static void main(String[] args) {
		// TODO: this is a over time limit solution. 
		Scanner a = new Scanner(System.in);
		  int[] b = transform1(a.nextLine().split(" "));
		  int[][] c = new int [b[0]][b[1]];
		  for(int i = 0; i < b[0]; i++) {
		   int[] d = transform2(a.nextLine());
		   for(int j = 0; j < d.length; j++) {
		    c[i][j] = d[j];
		   }
		  }
		  int n = b[0];
		  int m = b[1];
		  //int level = 1;
		  Queue <int[]> s = new LinkedList<int[]>();
		  int [] b_new = {0,0,0,0};
		  s.add(b_new);
		  int r = 0;
		  int[][] visited =new int [b[0]][b[1]];
		  ArrayList<Integer> array = new ArrayList<Integer>();
		  int minlevel=1000;
		  while(!s.isEmpty()) {
			  int[] cr = s.poll();
			  int i =cr[0];
			  int j = cr[1];
			  int level =cr[2];
			  visited[i][j] = 1;
		
			  if(i==n-1&&j==m-1) {
				  if(minlevel>level) {
					  minlevel=level;
				  }
				 //array.add(level);
				 // System.out.println(level);
			  }
			  int step = c[i][j];
			  
			  if(i+step<n&&visited[i+step][j]==0) {
				  s.add(new int[]{i+step,j,level+1});
			  }
			  if(i-step>=0&&visited[i-step][j]==0) {
				  s.add(new int[]{i-step,j,level+1});
			  }
			  if(j+step<m&&visited[i][j+step]==0) {
				  s.add(new int[]{i,j+step,level+1});
			  }
			  if(j-step>=0&&visited[i][j-step]==0) {
				  s.add(new int[]{i,j-step,level+1});
			  }
			  
		  }
		  /*
		  if(!array.isEmpty()) {
			  array.sort(new Comparator<Integer>(){

					@Override
					public int compare(Integer arg0, Integer arg1) {
						return arg0-arg1;
					}
					
				});
			  System.out.println(array.get(0));
		  }*/
		  if(minlevel!=1000) {
			  System.out.println(minlevel);
		  }
		  else {
			  System.out.println(-1);
		  }
		  
	}
	
	/*
	public static void (Stack<int[]> s, int[] startpoint) {
		
	}*/
	
	
	public static int[] transform1(String[] a){
		  int[] b = new int[a.length];
		  for(int i = 0; i < a.length; i++) {
		   b[i] = Integer.parseInt(a[i]);
		  }
		  return b;
		 } 
		 
		 public static int[] transform2(String a){
		  int[] b = new int[a.length()];
		  for(int i = 0; i < a.length(); i++) {
		   b[i] = Integer.parseInt("" + a.charAt(i));
		  }
		  return b;
		 }

}
