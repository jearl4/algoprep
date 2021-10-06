public class DutchNationalFlag {
    public static void sort(int[] array) {
        int pointerA = 0, pointerB = array.length - 1;
        for (int i = 0; i <= pointerB;) {
            if(array[i] == 0){
                swap(array, i, pointerA);
                pointerA++;
                i++;
            }else if(array[i] == 1){
                i++;
            }else{
                swap(array, i , pointerB);
                pointerB--;
            }
        }
    }

    private static void swap(int[] array, int pointerA, int pointerB) {
        int temp = array[pointerA];
        array[pointerA] = array[pointerB];
        array[pointerB] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        sort(arr);
        for (int num : arr)
        System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        sort(arr);
        for (int num : arr)
        System.out.print(num + " ");
    }
}
