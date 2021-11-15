package LeetCode.General.Array;

import java.util.ArrayList;
import java.util.List;

public class GreatestCandy {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> solution = new ArrayList<>();
        int maxCandies = 0;
        
        for(int i = 0; i < candies.length; i++){
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        
        for(int i = 0; i < candies.length; i++){
            solution.add(candies[i] + extraCandies >= maxCandies);
        }
         
        return solution;
        }
}
