package mycode.dsalgo;

import java.util.Scanner;
import java.util.Stack;

//https://github.com/rshaghoulian/HackerRank_solutions
public class HackerRankSolution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> maxstack = new Stack<>();
 		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int data;
		for(int i=0; i < n; i++) {
			int type = in.nextInt();
			if(type == 1) {
				data = in.nextInt();
				stack.push(data);
                if(!maxstack.isEmpty()) {
                	if(maxstack.peek() <= data) {
                        maxstack.push(data);
                	}
                }
                else {
                    maxstack.push(data);
                }                
			}
			else if(type == 2) {
				int rdata = stack.pop();
                int top = -1;
                if(!maxstack.isEmpty()) {
                    top = maxstack.peek();
                }                
                if(rdata == top) {
                    maxstack.pop();
                }
			}
			else {
				if(!maxstack.isEmpty()) {
					System.out.println(maxstack.peek());
				}
			}
		}        
    }   
}
