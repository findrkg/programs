package mycode.dsalgo;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {	{10, 20, 30, 40},
					        {15, 25, 35, 45},
					        {24, 29, 37, 48},
					        {32, 33, 39, 50}};

		System.out.println("found : "+search(matrix, 37));
	}

	public static boolean search(int[][] matrix, int target) {
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		int i = 0;
		int j = colLength-1;
		while(i <= rowLength-1 && j >= 0) {
			if(matrix[i][j] == target) {
				return true;
			}
			else if(matrix[i][j] < target) {
				i++;
			}
			else {
				j--;
			}
		}
		return false;
	}
}
