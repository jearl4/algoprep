package Recursion;

import java.util.ArrayList;
import java.util.List;

// takes array that can contain nested arrays and returns a sum. 
// Each nested array is multiplied according to the level it is at starting at 1 for base array.
// [5,2,[7,1],3,[6,[-13,8],4]] returns 12

public class ProductSum {
    public static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    public static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object el : array) {
            if (el instanceof ArrayList) {
                ArrayList<Object> ls = (ArrayList<Object>) el;
                sum += productSumHelper(ls, multiplier + 1);
            } else {
                sum += (int) el;
            }
        }
        return sum * multiplier;
    }
}
