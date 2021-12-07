package LeetCode.General.String;

import java.util.HashMap;

public class DistinctSubstrings1876 {
    public int countGoodSubstrings(String s) {
        int start = 0, goodStrings = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int end = 0; end < s.length(); end++){
            char endCharacter = s.charAt(end);
            map.put(endCharacter, map.getOrDefault(endCharacter, 0) + 1);
            if((end - start + 1) == 3){
                if(map.size() == 3){
                    goodStrings++;
                }

                char frontCharacter = s.charAt(start++);
                map.put(frontCharacter, map.get(frontCharacter) - 1);
                if(map.get(frontCharacter) == 0){
                    map.remove(frontCharacter);
                }
            }
        }
        return goodStrings;
    }
}
