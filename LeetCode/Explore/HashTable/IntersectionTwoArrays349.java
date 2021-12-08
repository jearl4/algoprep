package LeetCode.Explore.HashTable;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionTwoArrays349 {

    // using java prebuilt retainAll method
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (Integer num : nums1) {
            set1.add(num);
        }

        for (Integer num : nums2) {
            set2.add(num);
        }

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int i = 0;
        for (int s : set1) {
            output[i++] = s;
        }
        return output;
    }

    // using custom intersection function
    public int[] customIntersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (Integer num : nums1) {
            set1.add(num);
        }

        for (Integer num : nums2) {
            set2.add(num);
        }

        if(set1.size() > set2.size()){
            return setIntersection(set1, set2);
        }else{
            return setIntersection(set2, set1);
        }
    }

    private int[] setIntersection(HashSet<Integer> largerSet, HashSet<Integer> smallerSet) {
        int[] output = new int[largerSet.size()];
        int i = 0;
        for(Integer num : largerSet){
            if(smallerSet.contains(num)){
                output[i++] = num;
            }
        }
        return Arrays.copyOf(output, i);
    }
}
