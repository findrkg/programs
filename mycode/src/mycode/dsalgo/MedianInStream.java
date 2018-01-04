package mycode.dsalgo;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {

	static PriorityQueue<Integer> lowers;//maxHeap
    static PriorityQueue<Integer> highers;//minHeap

    public static double[] getMedians(int[] array){
        lowers = new PriorityQueue<Integer>(Collections.reverseOrder());
        highers = new PriorityQueue<Integer>();
        double[] medians = new double[array.length];
        for(int i=0; i < array.length; i++) {
        	int number = array[i];
        	addNumber(number);
        	rebalance();
        	medians[i] = getMedian();
        }
        return medians;
    }

    // Adds a number into the data structure.
    public static void addNumber(int number) {
    	if(lowers.size() == 0 || number < lowers.peek()) {
    		lowers.add(number);
    	}
    	else {
    		highers.add(number);
    	}
    }

    public static void rebalance() {
    	PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
    	PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
    	if(biggerHeap.size() - smallerHeap.size() >= 2) {
    		smallerHeap.add(biggerHeap.poll());
    	}
    }

    // Returns the median of current data stream
    public static double getMedian() {
    	PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
    	PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() == smallerHeap.size()){
            return (double)(biggerHeap.peek()+(smallerHeap.peek()))/2;
        }else{
            return biggerHeap.peek();
        }
    }
	public static void main(String[] args) {
		int[] array = {5, 15, 1, 3};
		double[] medians = getMedians(array);
		System.out.println(Arrays.toString(medians));
	}

}
