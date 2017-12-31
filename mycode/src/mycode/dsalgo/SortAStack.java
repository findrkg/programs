package mycode.dsalgo;

import java.util.LinkedList;
import java.util.Stack;

public class SortAStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(2);
		st.push(1);
		st.push(4);
		st.push(5);
		st.push(3);
		printStack(sortStack(st));
	}

	private static Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while(!s.isEmpty()) {
			Integer temp = s.pop();
			while(!r.isEmpty() && r.peek() < temp) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}
	
	private static void printStack(Stack s) {
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
}
