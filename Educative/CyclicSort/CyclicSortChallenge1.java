

public class CyclicSortChallenge1 {
    public static int[] findCorruptPairs(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }else{
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                return new int[] {nums[i], i + 1};
            }
        }
        return new int[]{-1, -1};
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = findCorruptPairs(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = findCorruptPairs(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
