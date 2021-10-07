import java.util.Arrays;

public class TwoPointerChallenge3 {
    public static int smallestArrayToSort(int[] array) {
        int front = 0, end = array.length - 1;

        while(front < array.length - 1 && array[front] <= array[front + 1]) {
            front++;
        }

        if (front == array.length - 1) {
            return 0;
        }

        while(end > 0 && array[end] >= array[end - 1]){
            end--;
        }

        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int i = front; i <= end; i++) {
            subarrayMax = Math.max(subarrayMax, array[i]);
            subarrayMin = Math.min(subarrayMin, array[i]);
        }

        while (front > 0 && array[front - 1] > subarrayMin) {
            front--;
        }

        while (end < array.length - 1 && array[end + 1] < subarrayMax) {
            end++;
        }

        return end - front + 1;
    }

    public static void main(String[] args) {
        System.out.println(smallestArrayToSort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(smallestArrayToSort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(smallestArrayToSort(new int[] { 1, 2, 3 }));
        System.out.println(smallestArrayToSort(new int[] { 3, 2, 1 }));
    }
}
