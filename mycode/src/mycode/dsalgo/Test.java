package mycode.dsalgo;

import java.util.Scanner;

public class Test {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i < n; i++) {
		    String str = sc.next();
		    String patt = sc.next();
		    findMinimumIndexedChar(str, patt);
		}
	}
	
	static void findMinimumIndexedChar(String str, String patt) {
	    char ch = '\0';
	    int min = -1;
	    int index = str.indexOf(patt.charAt(0));
	    if(index >= 0)
	    	min = index;
	    for(int i=1; i < patt.length(); i++) {
	    	index = str.indexOf(patt.charAt(i));
    	    if(index >= 0 && index < min) {
    	        min = index;
    	        ch = patt.charAt(i);
    	    }
	    }
	    if(ch != '\0') {
	        System.out.println(ch);
	    }
	    else {
	        System.out.println("No character present");
	    }
	    
	}
}
