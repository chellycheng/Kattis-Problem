import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ICanGuessTheDataStructure {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 //Scanner program to read
		 while (sc.hasNextLine()) {
				String next = sc.nextLine();
				String [] numbers = next.split(" ");
				
		//three boolean value to record if any test passed 
				boolean stackpass = true;
				boolean queuepass = true;
				boolean pqpass = true;
				
				//means it could be last lien or the split number
				if(numbers.length==1||numbers.length==0) {
					 //Three data structure to test
					 Queue<Integer> testQueue = new LinkedList<Integer>();
					 Stack<Integer> testStack = new Stack<Integer>();
					 int numscan = Integer.parseInt(next);
					 PriorityQueue<Integer> pq = new PriorityQueue<Integer>(numscan, new Comparator<Integer>() {
			             public int compare(Integer o1, Integer o2) {
			                 if (o1 >= o2) {
			                     return -1;
			                 }
			                 return 1;
			             }
			         });
				while (numscan>0) {
					String command =sc.nextLine();
					String [] commonds = command.split(" ");
					int cm = Integer.valueOf(commonds[0]);
					switch(cm) {
					case 1:
						//command 1 add element into the corresponding data structure
						testQueue.add( Integer.valueOf(commonds[1]));
						testStack.add( Integer.valueOf(commonds[1]));
						pq.add(Integer.valueOf(commonds[1]));
						break;
					case 2:
						//command 2 check the ouput matches to the output pop by data structure
						//if nothing in the data structure
						//it must be impossible
						int i = Integer.valueOf(commonds[1]);
						//output.add(value);
						
						if(testStack.isEmpty()) {
							stackpass = false;
						}
						
						if(stackpass&&!testStack.isEmpty()) {
							if(testStack.pop()!=i) {
								stackpass = false;
							}
						}
						if(testQueue.isEmpty()) {
							queuepass = false;
						}
						
						if(queuepass &&!testQueue.isEmpty()) {
							if(testQueue.remove()!=i) {
								queuepass = false;
							}
						}
						
						if(pq.isEmpty()) {
							pqpass = false;
						}
						
						
						if(pqpass&&!pq.isEmpty()) {
							if(pq.remove()!=i) {
								pqpass = false;
							}
						}
						break;
						
					default:
					}	
					numscan--;
				}
				resultPrintFunc(stackpass,queuepass,pqpass);
			}
				
		 }
		 sc.close();
		 
	}
	/*
	public static void guessDataStructure(ArrayList<Integer> output, Queue<Integer> q,Stack<Integer> s, PriorityQueue<Integer> pq ) {
		//output possible: stack,queue,priority queue,impossible,not sure
		//case1: test in order match 1
		//case2: test reverse order match 2
		//case3: test coming out is the largest number3
		//case4: initial value= 0 not possible
		//case5: >3 not sure
		boolean stackpass = true;
		boolean queuepass = true;
		boolean pqpass = true;
		if(s.size()<output.size()) {
			stackpass = false;
			queuepass = false;
			pqpass = false;
		}
		
		for(Integer i:output) {
			//test size
			
			//testcase stack
			if(!s.isEmpty()) {
				if(s.pop()!=i) {
					stackpass = false;
				}
			}
			
			if(!q.isEmpty()) {
				if(q.remove()!=i) {
					queuepass = false;
				}
			}
			
			if(!pq.isEmpty()) {
				if(pq.remove()!=i) {
					pqpass = false;
				}
			}
		}
		
		if(!(stackpass||queuepass||pqpass)) {
			 System.out.println("impossible");
		}
		else if((stackpass&&queuepass)||(pqpass&&queuepass)||(stackpass&&pqpass)) {
			 System.out.println("not sure");
		}
		else if(stackpass==true) {
			System.out.println("stack");
		}
		else if(pqpass==true) {
			 System.out.println("priority queue");
		}
		else {
			 System.out.println("queue");
		}
	}*/
	public static void resultPrintFunc(boolean stackpass, boolean queuepass, boolean pqpass ) {
		//function that take the three states and output the results
		if(!(stackpass||queuepass||pqpass)) {
			 System.out.println("impossible");
		}
		else if((stackpass&&queuepass)||(pqpass&&queuepass)||(stackpass&&pqpass)) {
			 System.out.println("not sure");
		}
		else if(stackpass==true) {
			System.out.println("stack");
		}
		else if(pqpass==true) {
			 System.out.println("priority queue");
		}
		else {
			 System.out.println("queue");
		}
	}
}
