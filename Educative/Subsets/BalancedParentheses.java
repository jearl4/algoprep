package Educative.Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Educative.Subsets.DTO.ParenthesesString;

public class BalancedParentheses {
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
           ParenthesesString ps = queue.poll();

           if(ps.openCount == num && ps.closeCount == num){
               result.add(ps.str);
           } else {
               if (ps.openCount < num) {
                   queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));
               }

               if (ps.openCount > ps.closeCount) {
                   queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
               }
           }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);
    
        result = generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
