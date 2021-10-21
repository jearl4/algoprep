package Subsets;

import java.util.ArrayList;
import java.util.List;

public class BalancedParentheses {
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();

        result.add("()");
        return result;
    }

    public static void main(String[] args) {
        List<String> result = generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);
    
        result = generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
