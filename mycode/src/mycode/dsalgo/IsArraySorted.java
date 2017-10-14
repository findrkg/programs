package mycode.dsalgo;

public class IsArraySorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 2, 3, 4, 5};
		System.out.println(isSorted(a, 0));
	}

	public static boolean isSorted(int[] a, int index)
	{
		if(a.length == 1) {
			return true;
		}
		return ((index < a.length-1) && a[index] > a[index+1]) ? false : isSorted(a, index+1);
	}
}
