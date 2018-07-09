package mycode.dsalgo.array;

public class SortedArrayOccurenceCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 4, 4, 4, 5, 6};
		System.out.println("occurence count is "+countOccurence(arr, 4));
	}
	
	public static int countOccurence(int[] a, int x) {
		int firstIndex = binarySearch(a, x, true);
		int lastIndex = binarySearch(a, x, false);
		return lastIndex - firstIndex + 1;
	}

	public static int binarySearch(int[]a, int x, boolean firstOccurence) {
		if(a == null || a.length == 0) {
			return -1;
		}
		int n = a.length;
		int start = 0;
		int end = a.length -1;
		int result = -1;
		while(start <= end) {
			int mid = (start + end)/2;
			if(a[mid] == x) {
				result = mid;
				if(firstOccurence) {
					end = mid -1;
				}
				else {
					start = mid + 1;
				}				
			}
			else if(x <= a[mid]) { 
				end = mid - 1;
			}
			else {
				start = mid + 1;	
			}
		}
		return result;		
	}

}
