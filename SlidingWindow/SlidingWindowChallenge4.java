package SlidingWindow;

import java.util.*;
public class SlidingWindowChallenge4 {
    public static List<Integer> wordCombo(String string, String[] words) {
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String word : words) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i <= string.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWord = i + j * wordLength;
                String word = string.substring(nextWord, nextWord + wordLength);
                if (!wordFreqMap.containsKey(word)) {
                    break;
                }
                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if(wordsSeen.get(word) > wordFreqMap.getOrDefault(word, 0)){
                    break;
                }

                if(j + 1 == wordsCount){
                    result.add(i);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> result = wordCombo("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = wordCombo("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}
