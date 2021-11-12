package Educative.TwoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] findAllMedians(int[] nums, int size) {
        double[] result = new double[nums.length - size + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            rebalanceHeaps();

            if (i - size + 1 >= 0) {
                if (maxHeap.size() == minHeap.size()) {
                    result[i - size + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                }else{
                    result[i - size + 1] = maxHeap.peek();
                }

                int elementToBeRemoved = nums[i - size + 1];
                if(elementToBeRemoved <= maxHeap.peek()){
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                rebalanceHeaps();
            }
        }
        return result;
    }

    private void rebalanceHeaps(){
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findAllMedians(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
          System.out.print(num + " ");
        System.out.println();
    
        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findAllMedians(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
          System.out.print(num + " ");
        System.out.println();
    }
}
