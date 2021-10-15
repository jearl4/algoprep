package TwoPointer;

import java.util.Arrays;

public class TripletTarget {
    public static int ClosestTripletSum(int[] array, int target) {
        Arrays.sort(array);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 2; i++) {
            int pointerA = i + 1, pointerB = array.length - 1;
            while (pointerA < pointerB) {
                int targetDifference = target - array[i] - array[pointerA] - array[pointerB];
                if(targetDifference == 0){
                    return target - targetDifference;
                }

                if(Math.abs(targetDifference) < Math.abs(smallestDifference) || 
                (Math.abs(targetDifference) == Math.abs(smallestDifference) && targetDifference > smallestDifference)){
                    smallestDifference = targetDifference;
                }

                if(targetDifference > 0){
                    pointerA++;
                }else{
                    pointerB--;
                }
            }
        }   
        return target - smallestDifference;
    }

    public static void main(String[] args) {
        System.out.println(ClosestTripletSum(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(ClosestTripletSum(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(ClosestTripletSum(new int[] { 1, 0, 1, 1 }, 100));
        System.out.println(ClosestTripletSum(new int[] { -5, -2, 3, 6 }, 5));
    }
}
