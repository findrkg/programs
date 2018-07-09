package mycode.dsalgo.array;

import java.util.HashMap;
import java.util.HashSet;

public class LargestSubArrayWithContiguousElements {

	public static void main(String[] args) {
		int[] input = {10, 12, 11, 9, 6, 0, 5, 7};
		printMaxLengthSubArray(input);
	}

	public static void printMaxLengthSubArray(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLength = 1;
		for(int i=0; i < arr.length-1; i++) {
	        // Create an empty hash set and add i'th element to it.
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
			int min = arr[i];
			int max = arr[i];
			for(int j=i+1; j < arr.length; j++) {
				if(set.contains(arr[j])) {
					break;
				}
				set.add(arr[j]);
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
				if(max -min == j -i) {
					maxLength = Math.max(maxLength, max-min+1);
				}
			}
		}
		System.out.println("Max length is "+maxLength);
	}

}
