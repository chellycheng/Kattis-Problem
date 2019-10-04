import java.util.ArrayList;
import java.util.Scanner;

public class RadioCommercials {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
			while (sc.hasNext()) {
				int s = sc.nextInt();
				int c = sc.nextInt();
				int profit = 0;
				int[] saving = new int[s];
				//initializing
				for(int i=0;i<s;i++) {
					int num = sc.nextInt()-c;
					saving[i] =num;
					if (profit< num) profit = num;
				}
				
				int current = 0;

				for (int x : saving)
					{
					if (current + x > 0)
						current += x;
					else
						current = 0;
					
					profit = Math.max(current , profit);
					}
				System.out.println(profit);
			}
			
			sc.close();
		
	}
	

	public static void calculate_profits(int s, int c, int[][] m, int profit) {
		
		//staring with i, selecting (j+1) elements
		//this solution also output correct value but exceed memory limit
		//filling out the dynamic programming array
		for(int i = 0; i<s;i++) {
			for (int j =1;j<s;j++) {
				if(i+j<s) {
					m [i][j] = m[i][j-1] +m[i+j][0];
					int current = m [i][j];
					if(profit<current) profit = current;
				}
			}
		}
		//print2D(m);
		System.out.println(profit);
	}
	
	public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int i = 0; i < mat.length; i++) {
  
            // Loop through all elements of current row 
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " "); 
            }
        System.out.print("\n"); 
        }
    } 

		
}
