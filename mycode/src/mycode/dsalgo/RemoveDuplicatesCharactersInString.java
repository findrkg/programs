package mycode.dsalgo;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicatesCharactersInString {

	public static void main(String[] args) {
		System.out.println("without using extra space : "+removeDuplicates("abchhhbabc"));
		System.out.println("using hashset : "+removeDup("abchhhbabc"));

	}

	public static String removeDuplicates(String str) {
		char[] charArr = str.toCharArray();
		for(int i=0; i < charArr.length; i++) {
			for(int j=i+1; j < charArr.length; j++) {
				if(charArr[i] == charArr[j]) {
					charArr[j] = 0;
				}
			}
		}
		return uniqueString(charArr);
	}
	
	private static String uniqueString(char[] chars) {
		StringBuilder sb = new StringBuilder(chars.length);
		for(char k : chars) {
			if(k != 0) {
				sb.append(k);
			}			
		}
		return sb.toString();
	}
	
	private static String removeDup(String str) {
		LinkedHashSet set = new LinkedHashSet<>();
		char[] charArr = str.toCharArray();
		for(char c : charArr) {
			if(!set.contains(c)) {
				set.add(c);
			}
		}
		StringBuilder sb = new StringBuilder(set.size());
		Iterator it = set.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		return sb.toString();
	}
}
