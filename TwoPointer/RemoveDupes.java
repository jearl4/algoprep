public class RemoveDupes {
    public static int removeDuplicates(int[] array) {
        int nextNonDuplicate = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[nextNonDuplicate - 1] != array[i]){
                array[nextNonDuplicate] = array[i];
                nextNonDuplicate++;
            }       
        }
        return nextNonDuplicate;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(removeDuplicates(arr));
    
        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(removeDuplicates(arr));
    }
}
