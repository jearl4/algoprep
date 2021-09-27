class MaxSumArray {
    public static int maxSum(int k, int[] array){
        int result = Integer.MIN_VALUE, tempSum = 0, windowStart = 0;
        for(int windowEnd = 0; windowEnd < array.length; windowEnd++){
           tempSum += array[windowEnd];

           if(windowEnd >= k - 1){
               result = Math.max(result, tempSum);
               tempSum -= array[windowStart];
               windowStart++;
           } 
        }
        return result;
    }

    public static void main(String[] args) {
        int maxSum = maxSum(2, new int[] {2,3,4,1,5});
        System.out.println("Solution is: " + maxSum);    
    }
}