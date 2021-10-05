import java.util.*;
public class SubarrayProducts {
    public static List<List<Integer>> findProduct(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int pointerA = 0, product = 1;
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
            while (product >= target && pointerA < array.length) {  
                product /= array[pointerA++];
            }
            List<Integer> tempList = new LinkedList<>();
            for (int j = i; j >= pointerA; j--) {
                tempList.add(0, array[j]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findProduct(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(findProduct(new int[] { 8, 2, 6, 5 }, 50));
    }
}
