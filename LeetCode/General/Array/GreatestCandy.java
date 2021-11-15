package LeetCode.General.Array;

import java.util.ArrayList;
import java.util.List;

public class GreatestCandy {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> solution = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            boolean isMostCandy = true;
            int totalCandy = candies[i] + extraCandies;
            for (int j = 0; j < candies.length; j++) {
                if (totalCandy < candies[j]) {
                    isMostCandy = false;
                }
            }
            solution.add(isMostCandy);
        }
        return solution;
    }
}
