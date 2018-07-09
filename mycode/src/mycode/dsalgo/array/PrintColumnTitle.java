package mycode.dsalgo.array;

import java.util.Scanner;

public class PrintColumnTitle {
	static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I','J', 'K', 'L','M', 'N', 'O','P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int T = in.nextInt();
	    for(int i=0; i < T; i++) {
	        long n = in.nextLong();
	        String result = printColumnTitle(n);
	        System.out.println(result);
	    }
	    
	}
	
	static String printColumnTitle(long num) {
		long number = num;
	    StringBuilder sb = new StringBuilder();
	    while(num != 0) {
	        if(num%26 != 0) {
	        	//System.out.println(letters[(int)(num%26 - 1)]);
	            sb.append(letters[(int)((num%26) -1)]);
	        }
	    	else if(num%26 == 0) {
	    	    sb.append(letters[25]);
	    	}
	        num = num/26;
	    }
	    sb.reverse();
	    return sb.toString();
	}
}