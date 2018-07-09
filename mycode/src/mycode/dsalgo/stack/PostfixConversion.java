package mycode.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixConversion {

	public static void main(String[] args) {
		String s = "AB+CD-*";
		System.out.println("postfix exp : "+s);
		System.out.println("prefix exp : "+convertToPrefix(s));
		System.out.println("infix exp : "+convertToInfix(s));
	}

	static String convertToPrefix(String str) {
		Deque<String> stack = new ArrayDeque<>();
		char[] chArr = str.toCharArray();
		for(int i=0; i < chArr.length; i++) {
			if(chArr[i] == '/' || chArr[i] == '*' || chArr[i] == '+' || chArr[i] == '-') {
				String op2 = "";
				String op1 = "";
				if(!stack.isEmpty()) {
					op2 = stack.pop();
					op1 = stack.pop();					
				}
				stack.push(chArr[i]+op1+op2);
			}
			else {
				stack.push(""+chArr[i]);
			}
		}
		return stack.peek();
	}
	
	static String convertToInfix(String str) {
		Deque<String> stack = new ArrayDeque<>();
		char[] chArr = str.toCharArray();
		for(int i=0; i < chArr.length; i++) {
			if(chArr[i] == '/' || chArr[i] == '*' || chArr[i] == '+' || chArr[i] == '-') {
				String op2 = "";
				String op1 = "";
				if(!stack.isEmpty()) {
					op2 = stack.pop();
					op1 = stack.pop();					
				}
				stack.push("("+op1+chArr[i]+op2+")");
			}
			else {
				stack.push(""+chArr[i]);
			}
		}
		return stack.peek();
	}

}
