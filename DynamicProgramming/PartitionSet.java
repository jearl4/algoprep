package DynamicProgramming;

public class PartitionSet {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
        return this.canPartitionRecursive(dp, nums, sum / 2, 0);
    }

    private boolean canPartitionRecursive(Boolean[][] dp, int[] nums, int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }

        if (nums.length == 0 || currentIndex >= nums.length) {
            return false;
        }

        if (dp[currentIndex][sum] == null) {
            if (nums[currentIndex] <= sum) {
                if (canPartitionRecursive(dp, nums, sum - nums[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }
            dp[currentIndex][sum] = canPartitionRecursive(dp, nums, sum, currentIndex + 1);
        }
        
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = { 1, 2, 3, 4 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(ps.canPartition(num));
    }
}
