package LeetCode.General.BitManipulation;

public class NumberOfStepsToZero {
    public int numberOfSteps(int num) {
        String binaryString = Integer.toBinaryString(num);
        int count = 0;

        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') {
                count += 2;
            } else {
                count++;
            }
        }
        return count - 1;
    }
}
