package mycode.dsalgo;

public class PrintMatrixInSpiral {

	public static void main(String[] args) {
		int arr[][] = { {1,  2,  3,  4,  5,  6},
		        		{7,  8,  9,  10, 11, 12},
		        		{13, 14, 15, 16, 17, 18}};
		 
		spiralPrint(arr, arr.length, arr[0].length);
	}

	public static void spiralPrint(int[][] arr, int rowCount, int colCount) {
		//variable for corners
		int t=0, b=rowCount-1, l=0, r=colCount-1;
		int dir = 0;
		while(t <= b && l <= r) {
			if(dir == 0) {
				//print first row in right direction
				for(int i=l; i <= r; i++) {
					System.out.print(arr[t][i]+" ");
				}
				t++;
			}
			else if(dir == 1) {
				//print last column in down direction
				for(int i=t; i <= b; i++) {
					System.out.print(arr[i][r]+" ");
				}
				r--;
			}
			else if(dir == 2) {
				//print last row in left direction
				for(int i=r; i >= l; i--) {
					System.out.print(arr[b][i]+" ");
				}
				b--;
			}
			else if(dir == 3) {
				//print first column in up direction
				for(int i=b; i >= t; i--) {
					System.out.print(arr[i][l]+" ");
				}
				l++;
			}
			dir = (dir+1)%4;
		}
	}
}
