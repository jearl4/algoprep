package LeetCode.Explore.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class intersectionTwoArrays350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (Integer num : nums2) {
            if (map.containsKey(num) && map.get(num) != 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] solution = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            solution[i] = result.get(i);
        }
        return solution;
    }
}