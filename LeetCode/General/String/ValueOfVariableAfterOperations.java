package LeetCode.General.String;

public class ValueOfVariableAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int sum = 0;

        for (String s : operations) {
            if (s.equals("++X") || s.equals("X++")) {
                sum++;
            } else {
                sum--;
            }
        }
        return sum;
    }
}
