package Array;

import java.util.Collections;
import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveToEnd(List<Integer> array, int target) {
        int l = 0;
        int r = array.size() - 1; 

        while(l < r){
            while (l< r && array.get(r) == target) {
                r--;
            }
            if(array.get(l) == target){
                Collections.swap(array, l, r);
            }
            l++;
        }
        return array;
    }
}
