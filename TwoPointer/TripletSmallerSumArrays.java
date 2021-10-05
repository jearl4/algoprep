import java.util.*;
public class TripletSmallerSumArrays {
    public static List<List<Integer>> smallerSums(int[] array, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            int pointerA = i + 1,
                pointerB = array.length - 1;
            while(pointerA < pointerB){
                if(array[pointerA] + array[pointerB] < target - array[i]){
                    for (int j = pointerB; j > pointerA; j--) {
                        results.add(Arrays.asList(array[i], array[pointerA], array[j]));
                    }
                    pointerA++;
                }else{
                    pointerB--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(smallerSums(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(smallerSums(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
