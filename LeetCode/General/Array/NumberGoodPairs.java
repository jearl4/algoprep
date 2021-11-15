package LeetCode.General.Array;

import java.util.HashMap;
import java.util.Map;

public class NumberGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            count += map.get(nums[i]) - 1;
        }
        return count;
    }
}