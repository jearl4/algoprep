package SlidingWindow;

public class NumberSubarrayAlternate {
    public static int NumberSubarray(int[] array, int replacementCount) {
        int windowStart = 0, result = 0, maxOneCount = 0;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            if(array[windowEnd] == 1){
                maxOneCount++;
            }

            if (windowEnd - windowStart + 1 - maxOneCount > replacementCount) {
                if (array[windowStart] == 1) {
                    maxOneCount--;
                }
                windowStart++;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(NumberSubarray(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(NumberSubarray(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
