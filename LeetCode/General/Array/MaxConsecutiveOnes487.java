package LeetCode.General.Array;

public class MaxConsecutiveOnes487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int longestChain = 0;
        if (nums.length < 2) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int currentCount = 1;
            int count = 0;
            if (nums[i] == 0) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0 && count > 0) {
                    break;
                } else if (nums[j] == 0) {
                    count++;
                    currentCount++;
                } else {
                    currentCount++;
                }
            }
            longestChain = Math.max(longestChain, currentCount);
        }
        return longestChain;
    }
}
