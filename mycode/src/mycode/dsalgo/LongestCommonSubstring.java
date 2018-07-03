package mycode.dsalgo;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1 = "abcf";
		String s2 = "fambcderst";
		int result = longestCommonSubstring(s1.toCharArray(), s2.toCharArray());
		System.out.println(result);
	}

	public static int longestCommonSubstring(char[] s1, char[] s2) {
		int max = 0;
		String output = "";
		String str1 = new String(s1);
		String str2 = new String(s2);
		int[][] T = new int[s1.length+1][s2.length+1];
		for(int i=1; i <= s1.length; i++) {
			for(int j=1; j <= s2.length; j++) {
				if(s1[i-1] == s2[j-1]) {
					T[i][j] = T[i-1][j-1] + 1;
					if(max < T[i][j]) {
						max = T[i][j];
						output = str1.substring(i - max, max+1);
						//output = str2.substring(j - max, j);
					}
				}
			}
		}
		System.out.println(output);
		return max;
	}
}
