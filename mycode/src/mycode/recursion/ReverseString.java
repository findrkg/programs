package mycode.recursion;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("rajkishor");
		reverse(str, 0, str.length()-1);
		System.out.println(str.toString());
	}

	public static void reverse(StringBuilder s, int start, int end) {
		if(start >= end) {
			return;
		}
		char chStart = s.charAt(start);
		char chEnd = s.charAt(end);
		if(chStart != chEnd) {
			s.setCharAt(start, chEnd);
			s.setCharAt(end, chStart);
		}
		reverse(s, start+1, end-1);
	}
}
