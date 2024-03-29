package LeetCode.Explore.HashTable;

import java.util.HashMap;

public class UniqueWordAbbreviation288 {
    HashMap<String, String> map;

    public UniqueWordAbbreviation288(String[] dictionary) {
        map = new HashMap<String, String>();
        for (String str : dictionary) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(str)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }

    String getKey(String str) {
        if (str.length() <= 2)
            return str;
        return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
    }
}
