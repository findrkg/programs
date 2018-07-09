package mycode.dsalgo.array;

public class MajorityElementInArray {
	public static void main(String[] args) {
		int[] arr = {2, 6, 2, 2, 6, 2, 2, 8, 2, 1};
		System.out.println("Majority Element is "+getMajorityElement(arr));
	}
	//Boyer Moore Vote Algorithm	    
	public static Integer getMajorityElement(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		Integer candidate = null;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (count == 0) {
				candidate = array[i];
				count = 1;
				continue;
			} else {
				if (candidate == array[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		if (count == 0) {
			return null;
		}
		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (candidate == array[i]) {
				count++;
			}
		}
		return (count > array.length / 2) ? candidate : null;
	}
}