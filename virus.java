import java.util.Scanner;

public class virus {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
	    // number for objects on the menu
	    String a = in.nextLine();
	    String b = in.nextLine();
	     
	    int start = 0;
	    int end = 0;
	    
	    int min_length = checkMinlength(a,b);
	  
	    while(start<min_length&&a.charAt(start)==b.charAt(start)) {
	    			start ++;
	    }
	    //System.out.println(start);
	    
	    while(end<min_length&&a.charAt(a.length()-end-1)==b.charAt(b.length()-end-1) ) {
	    			end ++;
	    }
	    //System.out.println(end);
	    int min = Math.min(start + end,a.length());
	    int max = Math.max(b.length()- min, 0);
	    /*
	     * int inserted = 0;
	    if(start + end ==0) {
	    		inserted =b.length();
	    }
	    else if(start + end >a.length()) {
	    		inserted = b.length()-a.length();
	    }
	    else {
	    		inserted = b.length()- end-start;
	    }
	    		
	    System.out.println(inserted);
	    */
	    System.out.println(max);
	}
	
	public static int checkMinlength(String a, String b) {
		if(a.length()-b.length()>0) {
			return b.length();
		}
		return a.length();
	}
    
}
