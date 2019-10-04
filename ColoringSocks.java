import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
	
public class ColoringSocks {

	//import DoublyLinkedListImpl

		public static void main (String[] args) {
			Scanner sc = new Scanner(System.in);
			
			while (sc.hasNext()) {
				int s = sc.nextInt();
				int c = sc.nextInt();
				int k = sc.nextInt();
				ArrayList<Integer> socks = new ArrayList<Integer>();
				for(int i=0;i<s;i++) {
					int num = sc.nextInt();
					socks.add(num);
				}
				
				socks.sort(new Comparator<Integer>(){
					public int compare(Integer o1,Integer o2) {
						return o2-o1;
					}
				});
				//System.out.println(socks);
				System.out.println(color_socks(s, c, k, socks));
				
			}
			
			sc.close();
		}
		
		public static int color_socks(int s,int c,int k, ArrayList<Integer> socks) {
			int result = 0;
			while(s>0) {
				//add a new washing machine
				//new machine bag
				result++;
	            int C=c-1;
				//for this new washing machine, put one socks in
				//available socks number -1
				int putsocks = socks.get(s-1);
	            	s--;
	            	
	            //ArrayList<Integer>leftSocks= new ArrayList<Integer>();
	            while(C>0&&s>0) {

	                    int current = socks.get(s-1);
	                    //it will compared with next element in the bag
	                    if(current-putsocks<=k) {
	                    	 putsocks = current;
	                     s--;
	                     C--;
	                    }
	                    else {
	                    	//greedy algorithum if not succeeed for only once
	                    	//it gives up
	                    	//and create a new machine
	                    	break;
	                    }
				}
			}
			return result;
		}

}
