package Educative.Subsets;

import java.util.ArrayList;
import java.util.List;

public class BalancedParenthesesRecursive {
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        char[] parenthesesString = new char[2 * num];
        generateValidParenthesesRecursive(num, 0, 0, parenthesesString, 0, result);
        return result;
    }

    private static void generateValidParenthesesRecursive(int num, int openCount, int closedCount, char[] parenthesesString, int index,
            List<String> result) {
        if (openCount == num && closedCount == num) {
            result.add(new String(parenthesesString));
        } else {
            if (openCount < num) {
                parenthesesString[index] = '(';
                generateValidParenthesesRecursive(num, openCount + 1, closedCount, parenthesesString, index + 1, result);
            }

            if (openCount > closedCount) {
                parenthesesString[index] = ')';
                generateValidParenthesesRecursive(num, openCount, closedCount + 1, parenthesesString, index + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
