package LeetCode.General.Array;

public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int x = 0, y = n, i = 0;
        int[] solution = new int[nums.length];
        while (x < n || y < nums.length) {
            if (i % 2 == 0) {
                solution[i] = nums[x];
                x++;
            } else {
                solution[i] = nums[y];
                y++;
            }
            i++;
        }
        return solution;
    }
}
