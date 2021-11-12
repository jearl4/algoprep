package TwoPointer;

public class Squares {
    public static int[] squareArray(int[] array) {
        int pointer1 = 0, pointer2 = array.length - 1, largestSquare = array.length - 1;
        int[] result = new int[array.length];
        
        while(pointer1 <= pointer2){
            int leftSquare = array[pointer1] * array[pointer1],
                rightSquare = array[pointer2] * array[pointer2];
            if (leftSquare > rightSquare) {
                result[largestSquare--] = leftSquare;
                pointer1++;
            }else{
                result[largestSquare--] = rightSquare;
                pointer2--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] result = squareArray(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = squareArray(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
