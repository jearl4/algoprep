package Educative.Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Educative.Subsets.DTO.AbbreviatedWord;

public class GeneralizedAbbreviation {
    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.add(new AbbreviatedWord(new StringBuilder(), 0, 0));
        int wordLen = word.length();

        while (!queue.isEmpty()) {
            AbbreviatedWord abWord = queue.poll();
            if (abWord.start == wordLen) {
                if (abWord.count != 0) {
                    abWord.str.append(abWord.count);
                }
                result.add(abWord.str.toString());
            } else {
                queue.add(new AbbreviatedWord(new StringBuilder(abWord.str), abWord.start + 1, abWord.count + 1));

                if (abWord.count != 0) {
                    abWord.str.append(abWord.count);
                }
                queue.add(new AbbreviatedWord(new StringBuilder(abWord.str).append(word.charAt(abWord.start)),
                        abWord.start + 1, 0));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
