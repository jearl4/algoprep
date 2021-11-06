public class ReverseWordsInString {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int right = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != ' ') {
                right = i;
                while (right + 1 < c.length && c[right + 1] != ' ') {
                    right++;
                }
                reverse(c, i, right);
                i = right;
            }
        }
        String solution = new String(c);
        return solution;
    }

    public void reverse(char[] c, int left, int right) {
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }
}
