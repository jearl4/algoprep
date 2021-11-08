package LeetCode.Medium.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeats {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) >= start){
                    start = map.get(c) + 1;
                }
            }
            length = Math.max(length, i - start + 1);
            map.put(c, i);
        }
        return length;
    }
}
