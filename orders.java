import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class orders {

	public static void main (String[] args) {
		  Scanner in = new Scanner(System.in); 
	      // number for objects on the menu
	      int numDishes = in.nextInt();
	      int[] menu = new int[numDishes];
	      ArrayList<Integer> ori_menu = new ArrayList<Integer> ();
	      ArrayList<Integer> oldmenu = new ArrayList<Integer> ();
	      int i = numDishes;
	      while(i>0 &&in.hasNextInt()) {
	    	  	int a = in.nextInt();
	    	  	ori_menu.add(a);
	    	  	oldmenu.add(a);
	    	  	i --;
	      }
	      //System.out.print(oldmenu.toString());
	      oldmenu.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0-arg1;
			}
			
		});
	      
	      for(int z=0;z<numDishes;z++) {
	    	  	menu[z] = oldmenu.get(z);
	      }
	      //System.out.print(Arrays.toString(menu));
	      
	      int orderNum = in.nextInt();
	      int j = orderNum;
	      int[] orders = new int[orderNum];
	      int indexOrder = 0;
	      while(j>0 &&in.hasNextInt()) {
	    	  	orders[indexOrder] = in.nextInt();
	    	  	indexOrder ++;
	    	  	j --;
	      }
	      int [] table = new int[30000];
	      for(int o : orders) {
	    	  	//for o: we want to get the next Menu number
	    	  	int m = checkTable(table, o,menu);
	    	  	if(m==0) {
	    	  		return;
	    	  	}
	    	  	if(m == -1) {
	    	  		System.out.print("Impossible");
	    	  	}
	    	  	else if(m ==-2) {
	    	  		System.out.print("Ambiguous");
	    	  	}
	    	  	else{
	    	  		ArrayList<Integer> sorted = new ArrayList<Integer>();
	    	  		while(o>0) {
	    	  			int output = checkTable(table,o,menu);
	    	  			int real_index=ori_menu.indexOf(menu[output-1])+1;
	    	  			sorted.add(real_index);
	    	  			o -= menu[output-1];
	    	  		}
	    	  		sortAndPrint(sorted);
	    	  	}
	    	  	System.out.println("");
	      }
	      
	}
	
	public static int checkTable(int []table,int order,int [] menu) {
		if(order==0) {
			return 0;
		}
		int result = table[order-1];
		if(result==0) {
			//nothing inside yet, to check
			int filledup = getNextMenu(table,menu,order);
			table[order-1] = filledup;
			return filledup;
		}
		else {
			return result;
		}
	}
	
	public static int getNextMenu(int []table,int[] menu,int order) {
		int amb = 0 ;
		for (int i=0;i<menu.length;i++) {
			int cost = menu[i];
			int left_order = order - cost;
			if(left_order<0) {
				break;
			}
			if (left_order==0) {
				if(amb!=0) {
					return -2;
				}
				else {
					amb =i+1;
				}
			}
			else {
				//lest_order>0
				//we repeated the new cost is the left_order
				int nxt = checkTable(table,left_order,menu);
				if(nxt==-1)
				{
					continue;
				}
				if(nxt==-2){
					return -2;
				}
				//could possible by some repeatation 
				if(nxt<(i+1)) {
					continue;
				}
				
				if(amb!=0) {
					return -2;
				}
				else {
					amb =(i+1);
				}
			}
			
		}
		//if try all possible, they are all kind of not succesful.
		if(amb==0) {
			return -1;
		}
		else{
			return amb;
		}
	}
	
	public static void sortAndPrint(ArrayList<Integer> a) {
		a.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0-arg1;
			}
			
		});
		for(int i=0;i<a.size();i++) {
			System.out.print(a.get(i)+" ");
		}
		System.out.println();
	}
}
