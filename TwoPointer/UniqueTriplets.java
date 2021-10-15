package TwoPointer;

import java.util.*;

public class UniqueTriplets {
    public static List<List<Integer>> findTriplets(int[] array) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            searchArray(array, -array[i], i + 1, result);
        }
        return result;
    }

    public static void searchArray(int[] array, int targetSum, int pointerA, List<List<Integer>> result) {
        int pointerB = array.length - 1;
        while (pointerA < pointerB) {
            int currentSum = array[pointerA] + array[pointerB];
            if(currentSum == targetSum){
                result.add(Arrays.asList(-targetSum, array[pointerA], array[pointerB]));
                pointerA++;
                pointerB--;
                while (pointerA < pointerB && array[pointerA] == array[pointerA - 1]) {
                    pointerA++;
                }
                while (pointerA < pointerB && array[pointerB] == array[pointerB + 1]) {
                    pointerB--;
                }
            }else if(targetSum > currentSum){
                pointerA++;
            }else{
                pointerB--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(findTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
