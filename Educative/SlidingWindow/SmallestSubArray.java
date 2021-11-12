package SlidingWindow;

public class SmallestSubArray {
    public static int findSmallestSubArray(int size, int[] array){
        int result = Integer.MAX_VALUE, tempSum = 0, windowStart = 0;
        for(int windowEnd = 0; windowEnd < array.length; windowEnd++){
            tempSum += array[windowEnd];
            while (tempSum >= size) {
                result = Math.min(result, windowEnd - windowStart + 1);
                tempSum -= array[windowStart];
                windowStart++;
            }
        }
        return result == Integer.MAX_VALUE ? 1 : result;
    }

    public static void main(String[] args) {
        System.out.println("Smallest sub-array length is: " + findSmallestSubArray(7, new int[] {2,1,5,2,3,2}));    
    }
}
