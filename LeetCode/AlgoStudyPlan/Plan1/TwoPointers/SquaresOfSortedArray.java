package LeetCode.Easy.TwoPointers;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] solution = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                solution[i] = nums[right] * nums[right];
                right--;
            } else {
                solution[i] = nums[left] * nums[left];
                left++;
            }
        }
        return solution;
    }
}
