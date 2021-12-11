package LeetCode.Contests.Biweekly67;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindSubsequenceWithLargestSum2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (resultIndex == k) {
                return result;
            }
            if (minHeap.contains(nums[i])) {
                result[resultIndex] = nums[i];
                resultIndex++;
                minHeap.remove(nums[i]);
            }
        }
        return result;
    }
}
