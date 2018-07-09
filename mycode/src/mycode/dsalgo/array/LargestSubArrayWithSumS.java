package mycode.dsalgo.array;

import java.util.HashMap;

public class LargestSubArrayWithSumS {

	public static void main(String[] args) {
		int[] input = {5, -6, -5, 5, 3, 5, -3, -2, 0};
		printMaxLengthSubArray(input, 8);
	}

	public static void printMaxLengthSubArray(int[] arr, int S) {
		HashMap<Integer, Integer> map = new HashMap<>();
		//pair of Sum and Ending index
		map.put(0, -1);
		int sum = 0;
		int endIndex = -1;
		int maxLength = 0; // with sum S
		for(int i=0; i < arr.length; i++) {
			sum += arr[i];
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if(map.containsKey(sum - S) && maxLength < i - map.get(sum - S)) {
				maxLength = i - map.get(sum - S);
				endIndex = i;
			}
		}
		System.out.println("["+ (endIndex - maxLength + 1) + "," + endIndex + "]");
	}
}
