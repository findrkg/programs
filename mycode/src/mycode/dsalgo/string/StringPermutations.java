package mycode.dsalgo.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> results = permutations("abc");
		System.out.println(results.toString());
	}

	public static List<String> permutations(String str) {		
		List<String> results = new ArrayList<>();
		permutations(str.toCharArray(), 0, results);
		return results;
	}
	
	public static void permutations(char[] a, int start, List results) {
		if(start >= a.length) {
			String s = new String(a.clone());
			//if(!results.contains(s)) {
				results.add(s);
			//}		
		}
		else {
			for(int i=start; i < a.length; i++) {
				swap(a, start, i);
				permutations(a, start+1, results);
				swap(a, start, i);
			}
		}
	}
	
	public static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
