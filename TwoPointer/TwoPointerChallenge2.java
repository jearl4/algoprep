package TwoPointer;

public class TwoPointerChallenge2 {
    public static boolean equalStrings(String stringA, String stringB) {
        boolean result = true;
        int index1 = stringA.length() - 1, index2 = stringB.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int i1 = getNextValidCharIndex(stringA, index1);
            int i2 = getNextValidCharIndex(stringB, index2);

            if(i1 < 0 && i2 < 0){
                result = true;
            }

            if(i1 < 0 || i2 < 0){
                result = false;
            }

            if (stringA.charAt(i1) != stringB.charAt(i2)) {
                result = false;
            }

            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return result;
    }

    private static int getNextValidCharIndex(String string, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (string.charAt(index) == '#') {
                backspaceCount++;
            }else if(backspaceCount > 0){
                backspaceCount--;
            }else{
                break;
            }
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(equalStrings("xy#z", "xzz#"));
        System.out.println(equalStrings("xy#z", "xyz#"));
        System.out.println(equalStrings("xp#", "xyz##"));    
        System.out.println(equalStrings("xywrrmp", "xywrrmu#p"));
    }
}
