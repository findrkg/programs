package mycode.dsalgo;

public class PowerOfLargeNumer {

	public static void main(String[] args) {
		int x = 2;
		int n = 5;		
		power(x, n);
	}

	static void power(int x, int n) {
		int MAX = 10000;
		int[] res = new int[MAX];
		int res_size = 0;
		int temp = x;
		// init result array
		while (temp != 0) {
			res[res_size++] = temp % 10;
			temp = temp / 10;
		}
		for (int i = 1; i < n; i++) {
			res_size = multiply(x, res, res_size);
		}

		System.out.println("x^n : ");

		for (int j=res_size-1; j >= 0; j--) {
			System.out.print(res[j]);
		}
	}

	static int multiply(int x, int[] res, int res_size) {
		// Initialize carry
		int carry = 0;

		// One by one multiply n with
		// individual digits of res[]
		for (int i = 0; i < res_size; i++) {
			int prod = res[i] * x + carry;

			// Store last digit of
			// 'prod' in res[]
			res[i] = prod % 10;

			// Put rest in carry
			carry = prod / 10;
		}

		// Put carry in res and
		// increase result size
		while (carry != 0) {
			res[res_size] = carry % 10;
			carry = carry / 10;
			res_size++;
		}
		return res_size;
	}
}
