package Educative.FastAndSlowPointers;

public class FindDuplicateNumberTwoPointer {
    public static int findDuplicateNumber(int[] arr) {
        int slow = 0, fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        int current = arr[slow];
        int cycleLength = 0;
        do {
            current = arr[current];
            cycleLength++;
        } while (current != arr[slow]);

        return findStart(arr, cycleLength);
    }

    private static int findStart(int[] arr, int cycleLength) {
        int pointer1 = arr[0], pointer2 = arr[0];
        while (cycleLength > 0) {
            pointer2 = arr[pointer2];
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = arr[pointer1];
            pointer2 = arr[pointer2];
        }

        return pointer1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicateNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(findDuplicateNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(findDuplicateNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
