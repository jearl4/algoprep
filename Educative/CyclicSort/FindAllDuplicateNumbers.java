

import java.util.*;

public class FindAllDuplicateNumbers {
    public static List<Integer> findAllDuplicates(int[] nums) {
        int i = 0;
        List<Integer> resultList = new ArrayList<>();
        while (i < nums.length) {
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }else{
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                resultList.add(nums[i]);
            }
        }

        return resultList;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = findAllDuplicates(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);
    
        duplicates = findAllDuplicates(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }
}
