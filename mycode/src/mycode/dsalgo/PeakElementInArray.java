package mycode.dsalgo;

public class PeakElementInArray {

	public static void main(String[] args) {
		int[] array = { 15, 20, 25, 35, 45, 50, 60 };
		Integer peak = getPeakElement(array);
		System.out.println(peak != null ? "Peak Element is "  + peak : "No peak element!" );
	}
	
	public static Integer getPeakElement(int[] arr) {
		int n = arr.length;
		int start = 0;
		int end = n-1;
		while(start <= end) {
			int mid = (start + end)/2;
			if((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1|| arr[mid] <= arr[mid+1])) {
				return arr[mid];
			}
			else if(mid > 0 && arr[mid-1] > arr[mid]) {
				end = mid-1;
			}
			else {
				start = mid + 1;
			}
		}
		return null;
	}

}
