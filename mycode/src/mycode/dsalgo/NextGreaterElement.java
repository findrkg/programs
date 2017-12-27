package mycode.dsalgo;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = { 98, 23, 54, 12, 20, 7, 27 };
		printNextGreaterElement(arr);
	}

	public static void printNextGreaterElement(int[] arr) {
		Stack<Integer> st = new Stack<>();
		st.push(arr[0]);
		for(int i=1; i < arr.length; i++) {
			while(!st.isEmpty() && st.peek() < arr[i]) {
				System.out.println("Next greater element for "+ st.pop() + " = "+ arr[i]);
			}
			st.push(arr[i]);
		}
		while(!st.isEmpty()) {
			System.out.println("Next greater element for "+ st.pop() + " = null");
		}
	}
}
