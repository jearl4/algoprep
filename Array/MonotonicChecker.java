package Array;

public class MonotonicChecker {
    public static boolean isMonotonic(int[] array) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        int i = 0;

        while ((isIncreasing || isDecreasing) && i < array.length - 1) {
            if (array[i] < array[i + 1]) {
                isIncreasing = false;
            }
            if (array[i] > array[i + 1]) {
                isDecreasing = false;
            }
            i++;
        }
        if (!isIncreasing && !isDecreasing) {
            return false;
        }
        return true;
    }
}
