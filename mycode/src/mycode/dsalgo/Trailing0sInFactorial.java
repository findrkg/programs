package mycode.dsalgo;

public class Trailing0sInFactorial {
	public static void main(String[] args) {
		int num = 29;
		System.out.println(getTrailing0InFactorial(num));
	}

	public static int getTrailing0InFactorial(int num) {
		if (num < 0)
			return -1;

		int count = 0;
		for (int i = 5; (num / i) > 0; i = i * 5) {
			count = count + num / i;
		}
		return count;
	}
}