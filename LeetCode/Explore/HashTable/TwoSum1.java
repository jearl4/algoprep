package LeetCode.Explore.HashTable;

import java.util.HashMap;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int lookingFor = target - nums[i];
            if (map.containsKey(lookingFor) && map.get(lookingFor) != i) {
                return new int[] { i, map.get(lookingFor) };
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
