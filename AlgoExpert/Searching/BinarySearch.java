package AlgoExpert.Searching;

public class BinarySearch {
    public static int binarySearchRunner(int[] array, int target) {
        String method = "recursive";
        if (method == "recursive") {
            // recursive
            return binarySearchRecursive(array, target, 0, array.length - 1);
        } else {
            // iterative
            return binarySearchIterative(array, target, 0, array.length - 1);
        }

    }

    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int potentialMatch = array[middle];
        if (target == potentialMatch) {
            return middle;
        } else if (target < potentialMatch) {
            return binarySearchRecursive(array, target, left, middle - 1);
        } else {
            return binarySearchRecursive(array, target, middle + 1, right);
        }
    }

    public static int binarySearchIterative(int[] array, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            int potentialMatch = array[middle];
            if (target == potentialMatch) {
                return middle;
            } else if (target < potentialMatch) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
