import java.util.Arrays;

public class TripletSmallerSum {
    public static int smallerSumsInline(int[] array, int target) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length - 2; i++) {
            int tempCount = 0,
                pointerA = i + 1,
                pointerB = array.length - 1;
            while (pointerA < pointerB) {
                int difference = array[pointerA] + array[pointerB];
                if (difference < target - array[i]) {
                    tempCount += pointerB - pointerA;
                    pointerA++;
                }else{
                    pointerB--;
                }
            }
            count += tempCount;
        }
        return count;
    }

    public static int smallerSumsRefactor(int[] array, int target) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length - 2; i++) {
            count += searchPair(array, target - array[i], i); 
        }
        return count;
    }

    private static int searchPair(int[] array, int target, int first){
        int count = 0,
            pointerA = first + 1,
            pointerB = array.length - 1;
            while(pointerA < pointerB){
                int difference = array[pointerA] + array[pointerB];
                if(difference < target){
                    count+= pointerB - pointerA;
                    pointerA++;
                }else{
                    pointerB--;
                }
            }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(smallerSumsRefactor(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(smallerSumsRefactor(new int[] { -1, 4, 2, 1, 3 }, 5));
        System.out.println(smallerSumsInline(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(smallerSumsInline(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
