package mycode.dsalgo.array;

public class DifferenceArray {
	// Array to be updated
    static int[] A = { 10, 5, 20, 40 };
 
    // Create and fill difference Array
    static int[] D = new int[A.length+1];

	public static void main(String[] args) {
	 
	    // After below update(l, r, x), the
	    // elements should become 20, 15, 20, 40
		D = initializeDiffArray(A);
	    update(0, 2, 5);
	    printArray(A, D);
	}

	private static int[] initializeDiffArray(int[] A) {
		D[0] = A[0]; 
		D[A.length] = 0;
		for(int i=1; i < A.length; i++) {
			D[i] = A[i] - A[i-1];
		}
		return D;
	}
	
	private static void update(int l, int r, int x) {
		D[l] += x;
	    D[r + 1] -= x;
	}
	
	private static void printArray(int[] A, int[] D) {
		for(int i=0; i < A.length; i++) {
			if(i==0) {
				A[i] = D[i];
			}
			else {
				A[i] = D[i] + A[i-1];
			}
			System.out.print(A[i]+" ");
		}
	}
}
