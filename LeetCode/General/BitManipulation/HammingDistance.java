package LeetCode.General.BitManipulation;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int diff = x ^ y;

        while (diff != 0) {
            if (diff % 2 == 1) {
                count++;
            }
            diff = diff >> 1;
        }
        return count;
    }
}
