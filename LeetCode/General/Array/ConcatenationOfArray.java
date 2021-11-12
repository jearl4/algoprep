package LeetCode.General.Array;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] solution = new int[nums.length * 2];
        int start = 0;

        for (int i = 0; i < solution.length; i++) {
            if (i < nums.length)
                solution[i] = nums[i];
            else {
                solution[i] = nums[start];
                start++;
            }
        }
        return solution;
    }
}
