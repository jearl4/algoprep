package CyclicSort;

import java.util.*;

public class FindAllMissingNumbers {
    public static List<Integer> findAllMissingNumbers(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i , nums[i] - 1);
            }else{
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for(i = 0; i < nums.length; i++){
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missing = findAllMissingNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);
    
        missing = findAllMissingNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);
    
        missing = findAllMissingNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
