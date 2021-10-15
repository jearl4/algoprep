package FastAndSlowPointers;

public class FastSlowChallenge3 {
    public static boolean isCycle(int[] array) {
       for (int i = 0; i < array.length; i++) {
           boolean isForward = array[i] >= 0;
           int slow = i, fast = i;

           do {
               slow = findNextIndex(array, isForward, slow);
               fast = findNextIndex(array, isForward, fast);
               if (fast != -1) {
                   fast = findNextIndex(array, isForward, fast);
               }
           } while (slow != -1 && fast != -1 && slow != fast);

           if(slow != -1 && slow == fast){
               return true;
           }
       }
       return false;
    }

    private static int findNextIndex(int[] array, boolean isForward, int currentIndex) {
        boolean direction = array[currentIndex] >= 0;
        if (isForward != direction) {
            return -1;
        }

        int nextIndex = (currentIndex + array[currentIndex]) % array.length;
        if(nextIndex < 0){
            nextIndex += array.length;
        }

        if(nextIndex == currentIndex){
            nextIndex = -1;
        }

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(isCycle(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(isCycle(new int[] { 2, 2, -1, 2 }));
        System.out.println(isCycle(new int[] { 2, 1, -1, -2 }));
    }
}
