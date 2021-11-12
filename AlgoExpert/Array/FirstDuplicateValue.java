package AlgoExpert.Array;

import java.util.HashSet;

// find the first duplicate value in the array. Return -1 if no dupes.
public class FirstDuplicateValue {
    public static int dataStructureDupe(int[] array) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (var value : array) {
            if (seen.contains(value)) {
                return value;
            }
            seen.add(value);
        }
        return -1;
    }

    /*
    * while iterating through array use the value at current index to flip values to negative.
    * if you come upon a negative value while going through array you know the value has been visited before.
    */
    public static int inPlaceDupe(int[] array) {
        for (var value: array) {
            var abs = Math.abs(value);
            if(array[abs - 1] < 0){
                return abs;
            }
            array[abs - 1] *= -1;
        }
        return -1;
    }
}
