import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class plantingtrees {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in); 
	      // number for objects on the menu
	      int numTree= in.nextInt();
	      ArrayList<Integer> trees = new ArrayList<Integer>();
	      while(numTree>0 &&in.hasNextInt()) {
	    	  	int a = in.nextInt();
	    	  	trees.add(a);
	    	  	numTree --;
	      }
	      trees.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1-arg0;
			}
	    	  	
	      });
	      
	      int day =0;
	      int max_day = 0;
	      for(int tree:trees) {
	    	  	day++;
	    	  	int finished = day+tree;
	    	  	if(max_day<finished) {
	    	  		max_day = finished;
	    	  	}
	    	  	
	      }
	      System.out.println(max_day+1);
	      

	}

}
