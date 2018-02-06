package mycode.dsalgo;

public class MaxSumHourGlass {

	public static void main(String[] args) {
		int[][] arr = { { 0, -4, -6, 0, -7, -6},
						{-1, -2, -6, -8, -3, -1},
						{-8, -4, -2, -8, -8, -6},
						{-3, -1, -2, -5, -7, -4},
						{-3, -5, -3, -6, -6, -6},
						{-3, -6, 0, -8, -6, -7}};

		printMaxSumHourGlass(arr);
	}

	private static void printMaxSumHourGlass(int[][] arr) {
		int max_sum = Integer.MIN_VALUE;
        for(int i=0; i < arr.length-2; i++) {
            for(int j=0; j < arr[0].length-2; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(max_sum < sum) {
                    max_sum = sum;
                }
            }
        }
        System.out.print(max_sum);		
	}
}
