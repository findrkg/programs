package mycode.dsalgo.array;

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
		int row = 0; // first row
		int col = colLength-1; // last coloumn
		while(row <= rowLength-1 && col >= 0) {
			if(matrix[row][col] == target) {
				return true;
			}
			else if(matrix[row][col] < target) {
				row++;
			}
			else {
				col--;
			}
		}
		return false;
	}
}
