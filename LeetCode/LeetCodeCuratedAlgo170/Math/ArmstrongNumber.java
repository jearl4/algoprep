package LeetCode.LeetCodeCuratedAlgo170.Math;

public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        int sum = 0;
        int nClone = n;
        int power = Integer.toString(n).length();
        for (int i = 0; i < power; i++) {
            int digit = nClone % 10;
            sum += Math.pow(digit, power);
            nClone /= 10;
        }

        if (sum == n)
            return true;
        return false;
    }
}
