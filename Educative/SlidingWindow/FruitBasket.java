package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
    public static int countFruit(char[] fruits) {
        int result = 0, windowStart = 0;
        Map<Character, Integer> fruitBasketMap = new HashMap<Character,Integer>();

        for(int windowEnd = 0; windowEnd < fruits.length; windowEnd++){
            char rightFruit = fruits[windowEnd];
            fruitBasketMap.put(rightFruit, fruitBasketMap.getOrDefault(rightFruit, 0) + 1);
            while(fruitBasketMap.size() > 2){
                char leftFruit = fruits[windowStart];
                fruitBasketMap.put(leftFruit, fruitBasketMap.get(leftFruit) - 1);
                if (fruitBasketMap.get(leftFruit) == 0) {
                    fruitBasketMap.remove(leftFruit);
                }
                windowStart++;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countFruit(new char[] {'A', 'B', 'C', 'A', 'C'}));
    }
    
}
