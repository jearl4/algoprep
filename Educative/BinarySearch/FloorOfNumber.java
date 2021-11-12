package Educative.BinarySearch;

public class FloorOfNumber {
    public static int searchFloorOfANumber(int[] arr, int key) {
        if (key < arr[0]) {
            return -1;
        }
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if(key == arr[middle]){
                return middle;
            }else if(key < arr[middle]){
                end = middle - 1;
            }else if(key > arr[middle]){
                start = middle + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
