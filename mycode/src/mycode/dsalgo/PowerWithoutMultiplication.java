package mycode.dsalgo;

public class PowerWithoutMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(5, 4));
	}

	static int pow(int a, int b) {
		if(b ==0 ) {
			return 1;
		}
		else {
			return multiply(a, pow(a, b-1));
		}
	}
	
	static int multiply(int x, int y) {
		int result = 0;
		for(int i=0; i < y; i++) {
			result += x;
		}
		return result;
	}
}
