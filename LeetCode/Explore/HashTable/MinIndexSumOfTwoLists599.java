package LeetCode.Explore.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinIndexSumOfTwoLists599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j)) {
                        map.put(i + j, new ArrayList<String>());
                    }
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int minIndexSum = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            minIndexSum = Math.min(minIndexSum, key);
        }
        String[] result = new String[map.get(minIndexSum).size()];
        return map.get(minIndexSum).toArray(result);
    }
}
