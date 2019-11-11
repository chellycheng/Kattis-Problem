import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class musicscore {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String a = in.nextLine();
		String[] m = a.split(" ");
		//System.out.println(Arrays.toString(m));
		String[] s = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
		int sl = 12;
		boolean printnone=true;
		for(int p = 0; p<s.length;p++) {
			String i = s[p];
			boolean print =true;
			//follow some rule to produce a list
			int index = p;
			ArrayList<String> c = new ArrayList<String>();
			c.add(s[index]);
			index =(index+2)%12;
			c.add(s[index]);
			index =(index+2)%12;
			c.add(s[index]);
			index =(index+1)%12;
			c.add(s[index]);
			index =(index+2)%12;
			c.add(s[index]);
			index =(index+2)%12;
			c.add(s[index]);
			index =(index+2)%12;
			c.add(s[index]);
			index = (index+1)%12;
			c.add(s[index]);
			
			for(String j:m) {
				if(!c.contains(j)) {
					print =false;
				}
				
			}
			if(print) {
				System.out.print(i+" ");
				printnone=false;
			}
			
		}
		if(printnone) {
			System.out.print("none");
		}
		
	}

}
