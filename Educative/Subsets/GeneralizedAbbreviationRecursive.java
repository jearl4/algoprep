package Educative.Subsets;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviationRecursive {
    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        generateGeneralizedAbbreviationRecursive(word, new StringBuilder(), 0, 0, result);
        return result;
    }

    private static void generateGeneralizedAbbreviationRecursive(String word, StringBuilder abWord, int start,
            int count, List<String> result) {
        if (start == word.length()) {
            if (count != 0) {
                abWord.append(count);
            }
            result.add(abWord.toString());
        } else {
            generateGeneralizedAbbreviationRecursive(word, new StringBuilder(abWord), start + 1, count + 1, result);

            if (count != 0) {
                abWord.append(count);
            }
            generateGeneralizedAbbreviationRecursive(word, new StringBuilder(abWord).append(word.charAt(start)), start + 1, 0, result);
        }
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviationRecursive.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviationRecursive.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
