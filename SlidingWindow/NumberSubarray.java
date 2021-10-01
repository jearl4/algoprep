import java.util.HashMap;
import java.util.Map;

public class NumberSubarray {
    public static int createSubarray(int[] array, int replacementCount) {
        int result = 0, windowStart = 0, maxNumbersReplaced = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            int rightNum = array[windowEnd];
            map.put(rightNum, map.getOrDefault(rightNum, 0) + 1);
            if(rightNum == 0){
                maxNumbersReplaced = Math.max(maxNumbersReplaced, map.get(rightNum));
                while(map.get(0) > replacementCount) {
                    int leftNum = array[windowStart];
                    map.put(leftNum, map.get(leftNum) - 1);
                    windowStart++;
                }
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(createSubarray(new int[] {0,1,1,0,0,0,1,1,0,1,1}, 2));
        System.out.println(createSubarray(new int[] {0,1,0,0,1,1,0,1,1,0,0,1,1}, 3));
    }
}
