package mycode.dsalgo;

public class PrintMatrixDiagonal {

	public static void main(String[] args) {
		int[][] matrix = {  {1, 2, 3, 10},
							{4, 5, 6, 11},
							{7, 8, 9, 12},
							{9, 6, 2, 6}};
		
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		// left diagonal
		int row = 0;
		int col = 0;
		while(row <= matrix.length-1 && col <= matrix.length-1) {
			System.out.print(matrix[row++][col++]+" ");
		}
		System.out.println("");
		// right diagonal
		row = 0;
		col = matrix[0].length-1;
		while(row <= matrix.length-1 && col >=0) {
			System.out.print(matrix[row++][col--]+" ");
		}
	}
}
