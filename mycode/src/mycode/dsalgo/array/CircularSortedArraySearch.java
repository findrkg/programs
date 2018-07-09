package mycode.dsalgo.array;

public class CircularSortedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 5, 6, 7, 1, 2, 3};
		System.out.println("index is "+binarySearch(arr, 2));
	}
	
	public static int binarySearch(int[] a, int x) {
		if(a == null || a.length == 0) {
			return -1;
		}
		int start = 0;
		int end = a.length -1;
		
		while(start <= end) {
			int mid = (start + end)/2;
			if(a[mid] == x) {
				return mid;
			}
			else if(a[mid] <= a[end]) { //right half is sorted
				if(x > a[mid] && x <= a[end]) {
					start = mid + 1; // search in right half
				}
				else {
					end = mid -1;
				}
			}
			else { // left half is sorted
				if(x >= a[start] && x < a[mid]) {
					end = mid - 1; // search in left half
				}
				else {
					start = mid + 1;
				}
				
			}
		}
		return -1;
	}

}
