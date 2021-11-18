package LeetCode.General.Array;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> solution = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0)
                nums[newIndex] *= -1;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                solution.add(i);
            }
        }
        return solution;
    }
}
