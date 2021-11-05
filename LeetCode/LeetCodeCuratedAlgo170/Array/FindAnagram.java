package LeetCode.LeetCodeCuratedAlgo170.Array;

public class FindAnagram {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int[] solution = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int i = 0;
        for (int num : nums1) {
            solution[i++] = map.get(num);
        }

        return solution;
    }
}
