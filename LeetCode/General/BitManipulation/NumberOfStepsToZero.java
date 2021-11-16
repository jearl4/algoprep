package LeetCode.General.BitManipulation;

public class NumberOfStepsToZero {
    public int numberOfSteps(int num) {
        int count = 0;

        if (num == 0) {
            return 0;
        }

        for (int powerOfTwo = 1; powerOfTwo <= num; powerOfTwo *= 2) {
            if ((powerOfTwo & num) != 0) {
                count += 2;
            } else {
                count++;
            }
        }
        return count - 1;
    }
}
