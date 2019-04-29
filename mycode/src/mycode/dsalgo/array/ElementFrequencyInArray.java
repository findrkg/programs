package mycode.dsalgo.array;

public class ElementFrequencyInArray {

	public static void main(String[] args) {
		int[] arr = {2, 3, 3, 2, 5};
		findFrequency(arr);
		System.out.println();
		countFrequencies(arr);
	}

	// O(n) time and O(1) space
	public static void findFrequency(int[] input) {
		int n = input.length;
        for (int i = 0; i < n; i++) {
            input[i]--;
        }
 
        for (int i = 0; i < n; i++) {
            input[input[i] % n] += n;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " => " + input[i] / n);
            // Change the element back to original value
            input[i] = input[i] % n + 1;
        }
    }
	
	// O(n) time and O(n) space
    public static void countFrequencies(int[] input) {
        int n = input.length;
        int[] count = new int[n];
 
//        for (int i = 0; i < n; i++) {
//            count[i] = 0;
//        }
 
        for (int i = 0; i < n; i++) {
            count[input[i] - 1]++;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " -> " + count[i]);
        }
    }
}
