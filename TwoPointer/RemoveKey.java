public class RemoveKey {
    public static int removeKey(int[] array, int key) {
        int nextElement = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != key){
                array[nextElement] = array[i];
                nextElement++;
            }
        }
        return nextElement;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(removeKey(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(removeKey(arr, 2));
    }
}
