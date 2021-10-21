package Subsets;

import java.util.ArrayList;
import java.util.List;

public class ChangeCasePermutations {
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if(str == null){
            return permutations;
        }
        
        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chars = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    }else{
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    permutations.add(String.valueOf(chars));
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
        System.out.println();
    }
}
