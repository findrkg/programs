package mycode.dsalgo.stack;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
	Stack<Integer> minStack = new Stack<Integer>();

	public Integer push(Integer value) {	
		if(value <= min()) {
			minStack.push(value);
		}
		return super.push(value);
	}

	public Integer pop() {
		Integer value = super.pop();
		if(value == min()) {
			minStack.pop();
		}
		return value;
	}

	public Integer min() {
		if(minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return minStack.peek();
	}

	public static void main(String[] args) {
		StackWithMin st = new StackWithMin();
		st.push(2);
		st.push(1);
		st.push(4);
		//st.push(0);
		st.push(3);
		System.out.println("Min value is "+st.min());
	}

}
