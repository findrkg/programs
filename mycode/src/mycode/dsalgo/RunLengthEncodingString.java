package mycode.dsalgo;

public class RunLengthEncodingString {

	public static void main(String[] args) {
		String str = "aaabbbbcdd";
		System.out.println(encode(str));
	}

	public static String encode(String s) {
		StringBuilder encodedStr = new StringBuilder("");
		int count=1;
		for(int i=0; i < s.length(); i++) {
			if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
				count++;
			}
			else {
				encodedStr.append(s.charAt(i)).append(count);
				count = 1;
			}
		}
		return encodedStr.toString();
	}
}
