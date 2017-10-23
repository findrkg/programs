package mycode.dsalgo;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackReverse {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        /** First push all element to program stack **/
        int element = stack.pop();
        reverse(stack);

        /** Insert element at bottom of stack **/
        insertAtBottom(stack, element);
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {

        /** if stack is empty then add element in stack **/
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        /** temporarily remove all element from stack to add element at bottom  **/
        int temp = stack.pop();
        insertAtBottom(stack, element);

        /** Add remove elements back to stack after adding bottom element **/
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        StackReverse.reverse(stack);
        System.out.println(stack);
    }

}