import java.util.*;

public class CyclicSortChallenge3 {
    public static List<Integer> kMissingPositiveNumbers(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }else{
                i++;
            }
        }

        List<Integer> resultList = new ArrayList<>();
        List<Integer> extraNumbers = new ArrayList<>();
       for (i = 0; i < nums.length && resultList.size() < k; i++) {
           if (nums[i] != i + 1) {
               resultList.add(i + 1);
               extraNumbers.add(nums[i]);
           }
       }

       for (i = 1; resultList.size() < k; i++) {
           int candidateNumber = i + nums.length;
           if(!extraNumbers.contains(candidateNumber)){
               resultList.add(candidateNumber);
           }
       }
        return resultList;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = kMissingPositiveNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);
    
        missingNumbers = kMissingPositiveNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);
    
        missingNumbers = kMissingPositiveNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
