package LeetCode.Explore.HashTable;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        if (k == nums.length) {
            return nums;
        }

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));

        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        return result;
    }
}
