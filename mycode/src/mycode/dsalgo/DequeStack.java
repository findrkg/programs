package mycode.dsalgo;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> st = new ArrayDeque<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}

}
