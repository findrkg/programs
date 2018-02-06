package mycode.dsalgo;

public class PrintMatrixInZigZag {

	public static void main(String[] args) {
		int arr[][] = { {1,  2,  3,  4,  5,  6},
        				{7,  8,  9,  10, 11, 12},
        				{13, 14, 15, 16, 17, 18}};
 
		zigZagPrint(arr, arr.length, arr[0].length);
	}

	public static void zigZagPrint(int[][] arr, int rowCount, int colCount) {
		//variable for corners
		int t=0, b=rowCount-1, l=0, r=colCount-1;
		while( t <= b) {
			//print first row in right direction
			for(int i=l; i <= r; i++) {
				System.out.print(arr[t][i]+" ");
			}
			t++;
			//print last row in left direction
			for(int i=r; i >= l && t <= b; i--) {
				System.out.print(arr[t][i]+" ");
			}
			t++;
		}
	}
}
