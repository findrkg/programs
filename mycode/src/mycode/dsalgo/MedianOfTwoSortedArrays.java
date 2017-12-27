package mycode.dsalgo;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		//Arrays are of same sizes
		//Time Complexity is O(log(n))
		//Space Complexity is O(1)
		System.out.println("Case 1: When arrays have odd number of elements in them.");
        int [] a = {1, 12, 15, 26, 38};
        int [] b = {2, 13, 17, 30, 45};          
        System.out.println("Median: " + findMedianSortedArrays(a, b, 0, a.length-1, 0, b.length-1));
         
        System.out.println("-----------------");
         
        System.out.println("Case 2: When arrays have even number of elements in them.");
        int[] c = {1, 2, 3, 6};
        int[] d = {4, 6, 8, 10};          
        System.out.println("Median: " + findMedianSortedArrays(c, d, 0, c.length-1, 0, d.length-1));	        
	}

	public static double findMedian(int[] arr, int startIndex, int endIndex) {
		int indexDiff = (endIndex - startIndex);
        if (indexDiff % 2 == 0) // we are looking at odd number of elements
        {
            return arr[startIndex + (indexDiff/2)];
        }
        else
        {
            return 1.0*(arr[startIndex + (indexDiff/2)] + arr[startIndex + (indexDiff/2) + 1])/2;
        }	}

	public static double findMedianSortedArrays(int[] a, int[] b, int startIndexA, int endIndexA, int startIndexB, int endIndexB) {
		// if a or b is empty
		if((endIndexA - startIndexA < 0) || ((endIndexB - startIndexB < 0))) {
			System.out.println("Invalid Input");
			return -1;
		}
		// if a and b are having just 1 element
		else if((endIndexA - startIndexA == 0) && ((endIndexB - startIndexB == 0))) {
			return (a[0]+b[0])/2;
		}
		// if a and b are having just 2 elements
		else if((endIndexA - startIndexA == 1) && ((endIndexB - startIndexB == 1))) {
			return (1.0*(Math.max(a[startIndexA], b[startIndexB]) + Math.min(a[endIndexA], b[endIndexB])))/2;
		}
		else {
			double m1 = findMedian(a, startIndexA, endIndexA);
	        double m2 = findMedian(b, startIndexB, endIndexB);
	        /* If medians are equal then return either m1 or m2 */
	        if (m2 == m1)
	        {
	            return m2;
	        }	          
	        // since m1 <= median <= m2 narrow down search by eliminating elements less than m1 and elements greater than m2  
	        else if (m1 < m2)
	        {
	            if ((endIndexA - startIndexA)%2 == 0) // we are looking at odd number of elements
	            {
	                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	                endIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	            }
	            else
	            {
	                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	                endIndexB = startIndexB + (endIndexB - startIndexB) / 2 + 1;                
	            }
	        }       
	        // since m2 <= median <= m1 narrow down search by eliminating elements less than m2 and elements greater than m1
	        else // m2 < m1
	        {
	            if ((endIndexB - startIndexB)%2 == 0) // we are looking at odd number of elements
	            {
	                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	                endIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	            }
	            else
	            {
	                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	                endIndexA = startIndexA + (endIndexA - startIndexA) / 2 + 1;                
	            }
	        }
	        return findMedianSortedArrays(a, b, startIndexA, endIndexA, startIndexB, endIndexB);
		}
	}
}
