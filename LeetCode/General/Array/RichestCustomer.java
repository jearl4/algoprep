package LeetCode.General.Array;

import java.util.HashMap;
import java.util.Map;

public class RichestCustomer {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            map.put(i, wealth);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) > maxWealth) {
                maxWealth = map.get(i);
            }
        }
        return maxWealth;
    }
}
