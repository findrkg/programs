package mycode.dsalgo;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1 = "abcdef";
		String s2 = "fbcdea";
		int result = longestCommonSubstring(s1.toCharArray(), s2.toCharArray());
		System.out.println(result);
	}

	public static int longestCommonSubstring(char[] s1, char[] s2) {
		int max = 0;
		int[][] T = new int[s1.length+1][s2.length+1];
		for(int i=1; i <= s1.length; i++) {
			for(int j=1; j <= s2.length; j++) {
				if(s1[i-1] == s2[j-1]) {
					T[i][j] = T[i-1][j-1] + 1;
					if(max < T[i][j]) {
						max = T[i][j];
					}
				}
			}
		}
		return max;
	}
}
