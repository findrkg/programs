package mycode.dsalgo;

public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {	{10, 20, 30, 40},
					        {15, 25, 35, 45},
					        {24, 29, 37, 48},
					        {32, 33, 39, 50}};

		System.out.println("found : "+kthSmallest(matrix, 4));
	}

	public static int kthSmallest(int[][] matrix, int k) {
	    int m=matrix.length;
	 
	    int lower = matrix[0][0];
	    int upper = matrix[m-1][m-1];
	 
	    while(lower<upper){
	        int mid = lower + ((upper-lower)/2);
	        int count = search(matrix, mid);
	        if(count<k){
	            lower=mid+1;
	        }else{
	            upper=mid;
	        }
	    }	 
	    return upper;
	}
	 
	public static int search(int[][] matrix, int target) {
	    int m=matrix.length;
	    int i=m-1;
	    int j=0;
	    int count = 0;	 
	    while(i>=0&&j<m){
	        if(matrix[i][j]<=target){
	            count += i+1;
	            j++;
	        }else{
	            i--;
	        }
	    }	 
	    return count;
	}
}
