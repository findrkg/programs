package mycode.dsalgo.array;

import java.util.ArrayList;
import java.util.Collections;
//Java Program to print all subsequence of a
//given string.
import java.util.HashSet;

public class AllSubsequence {

	// Driver code
	public static void main(String[] args)
	{
		String str="ggg";
		HashSet<String> set = new HashSet<>();		
		//System.out.println("All substring of abbc are:");
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j <= str.length(); j++) {
				set.add(str.substring(i, j));				 
			}
		}
		System.out.println(set);	 
	}
}