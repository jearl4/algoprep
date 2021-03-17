package Array;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDiff(int[] a1, int[] a2){
        int top = 0;
        int bottom = 0;
        int target = Integer.MAX_VALUE;
        int[] solution = new int[2];

        Arrays.sort(a1);
        Arrays.sort(a2);

        while(top < a1.length && bottom < a2.length){
            int temp = Math.abs(a1[top] - a2[bottom]);
            if(temp < target){
                solution[0] = a1[top];
                solution[1] = a2[bottom];
                target = temp;
                incrementLowerValue(top, bottom, a1, a2);
            }else{
                incrementLowerValue(top, bottom, a1, a2);
            }
        }
        return solution;
    }

    public static void incrementLowerValue(int a, int b, int[] a1, int[] a2){
        if(a1[a] < a2[b]){
            a++;
        }else{
            b++;
        }
    }
}
