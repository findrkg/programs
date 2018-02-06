package mycode.dsalgo;

import java.util.Arrays;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String input = "uoY evil ni aidnI"; // You live in India
		System.out.println(reverseWords(input));
	}

	private static String reverseWords(String str) {
		// reversing words
		str = str+" ";
		char[] arr = str.toCharArray();
		int beginIndex = -1;
		int endIndex = -1;
		int length = arr.length;
		for(int i=0; i < length; i++) {
			endIndex++;
			if(arr[i] == ' ') {
				reverseString(arr, beginIndex+1, endIndex-1);
				beginIndex = endIndex;
			}
		}
		return new String(arr).trim();
	}
	
	
	private static char[] reverseString(char[] arr, int beginIndex, int endIndex) {
		while(beginIndex < endIndex) {
			char ch = arr[beginIndex];
			arr[beginIndex] = arr[endIndex];
			arr[endIndex] = ch;
			beginIndex++;
			endIndex--;
		}
		return arr;	
	}
}
