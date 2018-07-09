package mycode.dsalgo.array;

import static java.lang.Math.*;
public class ArrayTriplet {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 1, 4, 9 };
		int t = 19;
		int ans = maxTripletSum(arr, t);
		System.out.println(ans);
	}

	// Function to calculate maximum triplet sum
	static int maxTripletSum(int arr[], int t)
	{
	    // Initialize the answer
	    int count = 0;
	    int n = arr.length;
	    int p = 0;
	    int q = 0;
	    int r = 0;
	    for (int i = 0; i < n-2; i++) {
	    	p = i;
	    	int j=i+1;
	    	for(; j < n-1; j++) {
	    		if(arr[i] < arr[j]) {
	    			q = j;
	    			break;
	    		}	    		
	    	}
	    	int k=j+1;
	    	for(;k < n; k++) {
	    		if(arr[j] < arr[k]) {
	    			r = k;
	    			break;
	    		}	    		
	    	}
	        if((arr[p] < arr[q] && arr[r] > arr[q]) && arr[p] + arr[q] + arr[r] <= t) {
	        	count++;
	        	System.out.println(arr[p] +" , "+arr[q]+" , "+arr[r]);
	        }
	    }
	    return count;
	}
}
