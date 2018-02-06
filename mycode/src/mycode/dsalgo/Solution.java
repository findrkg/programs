package mycode.dsalgo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int k=0; k < n; k++) {
            arr[k] = sc.nextInt();
        }
        int max = 0;
        int prod = 0;
        long count = 0;
        int i = 0;
        int j = 1;
        Arrays.sort(arr);
        while(j< arr.length) {
            max = Math.max(max, Math.max(arr[i], arr[j]));
            prod = arr[i]*arr[j];
            if(prod <= max) {
                System.out.println((i+1) +"-"+(j+1));
                count++;
                j++;
                max = 0;
            }
            else {
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}
