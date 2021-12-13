package LeetCode.Explore.HashTable;

import java.util.HashMap;

public class ContainsDuplicate219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            
            map.put(nums[i], i);
            
            if(map.size() > k){
                map.remove(nums[i - k]);
            }
        }
        return false;
    }
}
