package LeetCode.General.String;

import java.util.HashMap;

public class DistinctSubstrings1876 {
    public int countGoodSubstrings(String s) {
        int start = 0, goodStrings = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if((end - start + 1) == 3){
                if(map.size() == 3){
                    goodStrings++;
                }

                char c2 = s.charAt(start++);
                map.put(c2, map.get(c2) - 1);
                if(map.get(c2) == 0){
                    map.remove(c2);
                }
            }
        }
        return goodStrings;
    }
}
