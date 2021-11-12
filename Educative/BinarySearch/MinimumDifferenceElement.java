package Educative.BinarySearch;

public class MinimumDifferenceElement {
    public static int searchMinDiffElement(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        if (key < arr[start]) {
            return arr[start];
        }
        if (key > arr[end]) {
            return arr[end];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(key < arr[mid]){
                end = mid - 1;
            }else if (key > arr[mid]) {
                start = mid + 1;
            }else{
                return arr[mid];
            }
        }

        if ((arr[start] - key) < (key - arr[end])) {
            return arr[start];
        }
        return arr[end];
    }

    public static void main(String[] args) {
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
