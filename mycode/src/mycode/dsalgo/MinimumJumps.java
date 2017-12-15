package mycode.dsalgo;

public class MinimumJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 5, 6, 3, 0, 0, 3, 9};
		System.out.println(minimumJumpsDP(arr));
	}

	public static int minimumJumpsRecur(int arr[], int start, int end) {
		// IF You are at end point , now no jump is required
		if (start == end) {
			return 0;
		}
		// If you can't take further steps
		// Note INT_MAX is for infinity as no jump possible
		if (arr[start] == 0) {
			return Integer.MAX_VALUE;
		}
		// Now try to jump to all possible positions from This position
		int min = Integer.MAX_VALUE;
		for (int i = start + 1; i <= end && i <= start + arr[start]; i++) {
			int jumps = minimumJumpsRecur(arr, i, end);
			// If from ith jump is optimal
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
				min = jumps + 1;
			}
		}
		return min;
	}

	public static int minimumJumpsDP(int arr[]) {
		int n = arr.length;
		// min_jumps[i] => Minimum jumps required to reach at ith position
		int min_jumps[] = new int[n];

		for (int i = 1; i < n; i++) {
			min_jumps[i] = Integer.MAX_VALUE;
		}

		// 0 jumps to reach at start index
		min_jumps[0] = 0;

		for (int i = 1; i < n; i++) {
			int mn = Integer.MAX_VALUE;
			// jump from all possible position , before this position
			for (int j = 0; j < i; j++) {
				if (j + arr[j] >= i) {
					// Update the minimum jumps
					mn = Math.min(mn, min_jumps[j] + 1);
				}
			}
			min_jumps[i] = mn;
		}
		return min_jumps[n - 1];

	}
}
