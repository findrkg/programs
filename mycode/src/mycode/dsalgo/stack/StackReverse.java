package mycode.dsalgo.stack;

import java.util.Stack;

public class StackReverse {
	static Stack<Integer> stack = new Stack<>();
    static void reverseStack() {
        if (stack.isEmpty()) {
            return;
        }

        /** First pop all elements from stack **/
        int element = stack.pop();
        reverseStack();

        /** Insert element at bottom of stack **/
        insertAtBottom(element);
    }

    static void insertAtBottom(int element) {

        /** if stack is empty then add element in stack **/
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        /** temporarily remove all element from stack to add element at bottom  **/
        int temp = stack.pop();
        insertAtBottom(element);

        /** Add removed elements back to stack after adding bottom element **/
        stack.push(temp);
    }

    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        reverseStack();
        System.out.println(stack);
    }

}