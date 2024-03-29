package Educative.BinarySearch;

public class CeilingOfNumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (key > arr[arr.length - 1]) {
            return -1;
        }

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (key < arr[middle]) {
                end = middle - 1;
            } else if (key > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
