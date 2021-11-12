package AlgoExpert.Sorting;

public class SelectionSort {
    public static int[] selectionSort(int[] array){
        if(array.length == 0){
            return new int[] {};
        }

        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int smallestPointer = startIndex;
            for (int i = startIndex + 1; i < array.length; i++) {
                if(array[smallestPointer] > array[i]){
                    smallestPointer = i;
                }
            }
            swap(startIndex, smallestPointer, array);
            startIndex++;
        }
        return array;
    }

    public static void swap(int startIndex, int smallestPointer, int[] array){
        int temp = array[smallestPointer];
        array[smallestPointer] = array[startIndex];
        array[startIndex] = temp;
    }
}
