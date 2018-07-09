package mycode.dsalgo.array;

public class RotateMatrixBy90Degree {

	public static void main(String[] args) {
		int[][] matrix = {	{ 1, 2, 3, 4 }, 
							{ 5, 6, 7, 8 }, 
							{ 9, 10, 11, 12 }, 
							{ 13, 14, 15, 16 } };
		//rotateMatrixInplace(matrix);
		//printMatrix(matrix);
		int[][] rotatedMatrix = rotateMatrixBy90DegreeClockwise(matrix);
		printMatrix(rotatedMatrix);
	}

	// possible only in SQURE matrix
	public static void rotateMatrixInplace(int[][] matrix) {
		int length = matrix.length - 1;
		for (int i = 0; i <= length / 2; i++) {
			for (int j = i; j < length - i; j++) {
				int p1 = matrix[i][j];
				int p2 = matrix[j][length - i];
				int p3 = matrix[length - i][length - j];
				int p4 = matrix[length - j][i];

				// Swap values of 4 coordinates
				matrix[j][length - i] = p1;
				matrix[length - i][length - j] = p2;
				matrix[length - j][i] = p3;
				matrix[i][j] = p4;
			}
		}
	}

	// Rotate Matrix to 90 degree toward Right(clockwise)
	private static int[][] rotateMatrixBy90DegreeClockwise(int[][] matrix) {

		int totalRowsOfRotatedMatrix = matrix[0].length; // Total columns of Original Matrix
		int totalColsOfRotatedMatrix = matrix.length; // Total rows of Original Matrix

		int[][] rotatedMatrix = new int[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				rotatedMatrix[j][(totalColsOfRotatedMatrix - 1) - i] = matrix[i][j];
			}
		}
		return rotatedMatrix;
	}

	// Rotate Matrix to 90 degree toward Left(counter clockwise)
	private static int[][] rotateMatrixBy90DegreeCounterClockwise(int[][] matrix) {

		int totalRowsOfRotatedMatrix = matrix[0].length; // Total columns of Original Matrix
		int totalColsOfRotatedMatrix = matrix.length; // Total rows of Original Matrix

		int[][] rotatedMatrix = new int[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				rotatedMatrix[(totalRowsOfRotatedMatrix - 1) - j][i] = matrix[i][j];
			}
		}
		return rotatedMatrix;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i <= matrix.length - 1; i++) {
			for (int j = 0; j <= matrix[0].length - 1; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
