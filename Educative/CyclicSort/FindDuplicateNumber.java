

public class FindDuplicateNumber {
    public static int findDuplicateNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if (nums[i] != i + 1) {
                if(nums[i] != nums[nums[i] - 1]){
                    swap(nums, i, nums[i] - 1);
                }else{
                    return nums[i];
                }
            }else{
                i++;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        System.out.println(findDuplicateNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(findDuplicateNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(findDuplicateNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
