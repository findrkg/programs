package mycode.dsalgo;

import java.util.*;

class MessageDecoding
 {
    static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I','J', 'K', 'L','M', 'N', 'O','P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	static int number = 0;
	static int temp = 0;
    public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int testNo = sc.nextInt();
		for (int tn = 0; tn < testNo; tn++) {
    		int len = sc.nextInt();
    		int num = sc.nextInt();
    		printNoOfWays(num, len);
		}
	 }
	 
	 static void printNoOfWays(int num, int len) {
	     int divisor = 10;
	     number = num;
	     int count = 1;
	     while(divisor <= 100) {
	         divisor = divisor*10;
	         int index = 0;
	         while(num !=0) {	        	
	        	index = num%divisor;
	        	if(index > 25) {
	        		count++;
	        	}
	            num = num/divisor;
	        }
	        num = number;
	     }
	     System.out.println(count);
	 }
}