package mycode.dsalgo.string;

public class StringToIntegerConverter {

	public static void main(String[] args) {
		System.out.println(stringToInteger("1234"));
		System.out.println(integerToString(3456));
	}

	private static int stringToInteger(String str) {
		int num = 0;
		int index = 0;
		while(index < str.length()) {
			char ch = str.charAt(index);
			if(ch >= '0' && ch <= '9') {
				num = num*10 + (ch-'0');
				index++;
			}
			else {
				throw new NumberFormatException("invalid input");
			}			
		}
		return num;
	}
	
	private static String integerToString(Integer num) {
		int len = 0;
		int index = 0;
		int n = num;
		while(n != 0) {
			len++;
			n = n/10;
		}
		char[] str = new char[len];
		while(index <= len-1) {
			int rem = num%10;
			num = num/10;
			str[len-1-index] = (char) (rem + '0');
			index++;
		}
		return new String(str);
	}

}
