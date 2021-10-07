import java.util.*;
public class TwoPointerChallenge1 {
    public static List<List<Integer>> uniqueQuadruplets(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < array.length - 3; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < array.length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) {
                    continue;
                }
                searchPairs(array, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchPairs(int[] array, int target, int first, int second, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[first] + array[second] + array[left] + array[right];
            if (sum == target) {
                quadruplets.add(Arrays.asList(array[first], array[second], array[left], array[right]));
                left++;
                right--;
                while (left < right && array[left] == array[left - 1]) {
                    left++;
                }
                while (left < right && array[right] == array[right + 1]) {
                    right--;
                }
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(uniqueQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(uniqueQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
