import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FlexibleSpaces {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			int s = sc.nextInt();
			int c = sc.nextInt();
			int [] lines= new int[c+2];
			for(int i=1;i<c+1;i++) {
				int num = sc.nextInt();
				lines[i] = num;
			}
			lines[c+1] = s;
			countSpace(s, c, lines);
			
		}
		
		sc.close();
	}
	
	public static void countSpace(int s, int c, int[] lines) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<c+1;i++) {
			for(int j = i+1; j<c+2;j++) {
				int difference = lines[j]-lines[i];
				if(!result.contains(difference)) {
					result.add(difference);
				}
			}
		}

	        
		result.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0-arg1;
			}
			
		});
		int i =0;
		int size =result.size();
		for (int r: result) {
			System.out.print(r);
			if(!(i==size-1)) System.out.print(" ");
			i++;
		}
		

	}
	
}
