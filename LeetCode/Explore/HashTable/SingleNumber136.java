package LeetCode.Explore.HashTable;

import java.util.HashSet;

public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sumOfSet = 0, sumOfNums = 0;

        for (Integer num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }

        return 2 * sumOfSet - sumOfNums;
    }
}
