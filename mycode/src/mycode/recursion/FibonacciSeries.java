package mycode.recursion;

public class FibonacciSeries {
	static int[] fib = new int[20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(5));
	}

	public static int fibonacci(int n) {
		if(n<0) {
	       throw new IllegalArgumentException("n should be non-negative");
		}
		else if(n==0) {
			return 0;
		}
		else if(n == 1) {
			return 1;			
		}
		else {
			if(fib[n] > 0) {
				return fib[n];
			}
			fib[n] = fibonacci(n-1) + fibonacci(n-2);
			return fib[n];
		}
	}
}
