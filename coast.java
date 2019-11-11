import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class coast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int row = in.nextInt();
		int col = in.nextInt();
		// 0 means unreached place, 1 means land, 2 means sea
		int [][] map = new int[row+2][col+2];
		int rindex =1;
		
		while(rindex<=row && in.hasNext()){
			int cindex =0;
			String a = in.next();
			while(cindex<col) {
				 map[rindex][cindex+1] = Character.getNumericValue(a.charAt(cindex));
				 cindex++;
			 }
			rindex++;
		}
		
		//visualizeMao( map );
		flow( map, row, col);
		//System.out.println();
		//visualizeMao( map );
		System.out.println(calculateEdge(map,row,col));
	   }
	
	public static void flow(int [][] map, int row, int col) {
		Queue<int[]> q = new LinkedList<int[]>();
		//initializa the location
		int[] loc = {1,1};
		q.add(loc);
		
		while(!q.isEmpty()) {
			int[] x = q.poll();
			if(map[x[0]][x[1]]!=2) {
				//the position have not be visited
				if(map[x[0]][x[1]]==0) {
					map[x[0]][x[1]]=2;
				}
				//only check right
				if(x[1]+1<=col+1 && map[x[0]][x[1]+1]==0) {
					q.add(new int[] {x[0],x[1]+1});
				}
				//check down
				if(x[0]+1<=row+1&&map[x[0]+1][x[1]]==0) {
					q.add(new int[] {x[0]+1,x[1]});
				}
				//check left
				if(x[1]-1>=0&&map[x[0]][x[1]-1]==0) {
					q.add(new int[] {x[0],x[1]-1});
				}
				//check up
				if(x[0]-1>=0&&map[x[0]-1][x[1]]==0) {
					q.add(new int[] {x[0]-1,x[1]});
				}
			}
		}
	}
	
	public static int calculateEdge(int[][] map,int row,int col) {
		Queue<int[]> q = new LinkedList<int[]>();
		int edges = 0;
		//initializa the location
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				if(map[i][j]==1) {
					
					//only check right
					if( map[i][j+1]==2) {
						edges++;
					}
					//check down
					if(map[i+1][j]==2) {
						edges++;
					}
					//check left
					if(map[i][j-1]==2) {
						edges++;
					}
					//check up
					if(map[i-1][j]==2) {
						edges++;
					}
				}
			}
		}
		return edges;
	}
	
	public static void visualizeMao (int[][] map) {
		for(int i=0;i<map.length;i++) {
			 System.out.println(Arrays.toString(map[i]));
		}
	}

}
