package mycode.recursion;

public class Factorial {
	static int fac[] = new int[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(4));
	}
	public static int factorial(int n) {
		if(n<0) {
	       throw new IllegalArgumentException("n should be non-negative");
		}
		else if(n==0) {
			return 1;
		}
		else {
			if(fac[n] > 0) {
				return fac[n];
			}
			fac[n] =  n*factorial(n-1);
			return fac[n];
		}
	}

}
