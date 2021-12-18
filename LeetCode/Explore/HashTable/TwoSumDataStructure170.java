package LeetCode.Explore.HashTable;

import java.util.HashMap;

public class TwoSumDataStructure170 {
    private HashMap<Integer, Integer> map;
    
    public TwoSumDataStructure170() {
        this.map = new HashMap<Integer, Integer>();
    }
    
    public void add(int number) {
        this.map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for(Integer num : map.keySet()){
            int complement = value - num;
            if(map.containsKey(complement)){
                if (num != complement || map.get(complement) > 1){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
