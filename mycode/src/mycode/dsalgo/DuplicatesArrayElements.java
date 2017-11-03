package mycode.dsalgo;

public class DuplicatesArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 4, 5, 6, 6};
		findDuplicates(arr);
	}
	
	public static void findDuplicates(int[] a) {
		for(int i=0; i < a.length; i++) {
			if(a[Math.abs(a[i])] >= 0) {
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			}
			else {
				System.out.println(Math.abs(a[i]));
			}
		}
	}
}
