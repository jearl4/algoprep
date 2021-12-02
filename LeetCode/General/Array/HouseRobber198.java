package LeetCode.General.Array;

import java.util.Arrays;

public class HouseRobber198 {
    private int[] memo;

    public int rob(int[] nums) {
        this.memo = new int[100];

        Arrays.fill(this.memo, -1);

        return robFrom(0, nums);
    }

    public int robFrom(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        if (this.memo[i] > -1) {
            return this.memo[i];
        }

        int ans = Math.max(robFrom(i + 1, nums), robFrom(i + 2, nums) + nums[i]);

        this.memo[i] = ans;
        return ans;
    }
}
