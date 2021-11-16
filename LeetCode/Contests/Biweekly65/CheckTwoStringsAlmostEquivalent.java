package LeetCode.Contests.Biweekly65;

import java.util.HashMap;
import java.util.Map;

public class CheckTwoStringsAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        if (word1.length() < 4 || word2.length() < 4) {
            return true;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        boolean isAlmostEquivalent = true;

        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        for (int i = 0; i < word1.length(); i++) {
            int letter1Frequency = map1.getOrDefault(word1.charAt(i), 0);
            int letter2Frequency = map2.getOrDefault(word1.charAt(i), 0);
            if (Math.abs(letter1Frequency - letter2Frequency) > 3) {
                isAlmostEquivalent = false;
            }
        }

        for (int i = 0; i < word2.length(); i++) {
            int letter1Frequency = map1.getOrDefault(word2.charAt(i), 0);
            int letter2Frequency = map2.getOrDefault(word2.charAt(i), 0);
            if (Math.abs(letter1Frequency - letter2Frequency) > 3) {
                isAlmostEquivalent = false;
            }
        }
        return isAlmostEquivalent;
    }

    // Optimal solution
    // public boolean checkAlmostEquivalent(String word1, String word2) {
    //     int[] f1 = new int[26];
    //     int[] f2 = new int[26];
    //     for(char c : word1.toCharArray()) {
    //         f1[c - 'a']++;
    //     }
    //     for(char c : word2.toCharArray()) {
    //         f2[c - 'a']++;
    //     }
    //     for(int i = 0; i < 26; i++) {
    //         if(Math.abs(f1[i] - f2[i]) > 3)
    //             return false;
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        CheckTwoStringsAlmostEquivalent check = new CheckTwoStringsAlmostEquivalent();
        System.out.println(check.checkAlmostEquivalent(
                "cdecdhhfgdieiifhhifffcgddeehgbciceggedbdggbigiieidgcceccgfhiecdefdhighbfdcdbgcfddeebbgibcihe",
                "bddhdfcdihfehbehfeiccehhchbibiggifcbgieedgfhggebcbeeddfdfiehcigdfcccdhgchbbfheddbdbiifeeiieg"));
    }
}
