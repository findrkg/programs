package mycode.dsalgo;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,  3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}};

		System.out.println("found : "+search(matrix, 11));
	}

	public static boolean search(int[][] matrix, int target) {
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		int i = 0;
		int j = colLength-1;
		while(i < rowLength && j >= 0) {
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
