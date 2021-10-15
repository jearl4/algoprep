package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static int[] twoSum(int[] array, int target) {
        int pointer1 = 0, pointer2 = array.length-1, sum = Integer.MIN_VALUE;
        int[] result = new int[2];
        while (pointer1 < pointer2) {
            sum = array[pointer1] + array[pointer2];
            if (sum == target) {
                result =  new int[] {pointer1, pointer2};
            }

            if(sum > target){
                pointer2--;
            } else {
                pointer1++;
            }
        }
        return result;
    }

    public static int[] twoSumMap(int[] array, int target) {
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(nums.containsKey(target - array[i])){
                return new int[] {nums.get(target - array[i]), i};
            }else{
                nums.put(array[i], i);
            }
        }
        return new int[] {-1, -1}; //not found
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = twoSum(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = twoSumMap(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Map: [" + result[0] + ", " + result[1] + "]");
        result = twoSumMap(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Map: [" + result[0] + ", " + result[1] + "]");
  }
}
