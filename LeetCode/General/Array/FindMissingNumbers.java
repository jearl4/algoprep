package LeetCode.General.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> solution = new ArrayList<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                solution.add(i);
            }
        }
        return solution;
    }
}
