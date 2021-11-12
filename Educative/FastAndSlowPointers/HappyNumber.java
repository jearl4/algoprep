package Educative.FastAndSlowPointers;

public class HappyNumber {
    public static boolean isHappyNumber(int number) {
        int slow = number, fast = number;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private static int findSquareSum(int number) {
        int sum = 0, digit;
        while (number > 0) {
            digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(23));
        System.out.println(isHappyNumber(12));
    }
}
