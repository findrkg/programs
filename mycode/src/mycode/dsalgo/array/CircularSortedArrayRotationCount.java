package mycode.dsalgo.array;

public class CircularSortedArrayRotationCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 5, 6, 1, 2, 3};
		System.out.println("rotation count is "+countRotation(arr));
	}
	
	public static int countRotation(int[] a) {
		if(a == null || a.length == 0) {
			return -1;
		}
		int n = a.length;
		int start = 0;
		int end = a.length -1;
		while(start <= end) {
			int mid = (start + end)/2;
			int next = (mid + 1)%n;
			int prev = (mid + n -1)%n;
			if(a[start] <= a[end]) {
				return start;
			}
			else if(a[mid] <= a[prev] && a[mid] <= a[next]) {
				return mid;
			}
			else if(a[mid] <= a[end]) { 
				end = mid - 1;
			}
			else {
				start = mid + 1;	
			}
		}
		return -1;
	}

}
