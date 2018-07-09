package mycode.dsalgo.stack;

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

	private static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> sortedStack = new Stack<>();
		while(!stack.isEmpty()) {
			Integer data = stack.pop();
			while(!sortedStack.isEmpty() && sortedStack.peek() > data) {
				stack.push(sortedStack.pop());
			}
			sortedStack.push(data);
		}
		return sortedStack;
	}
	
	private static void printStack(Stack stack) {
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
