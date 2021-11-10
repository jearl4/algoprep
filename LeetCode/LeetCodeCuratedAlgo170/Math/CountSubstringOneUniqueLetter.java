package LeetCode.LeetCodeCuratedAlgo170.Math;

public class CountSubstringOneUniqueLetter {
    public int countLetters(String s) {
        int sum = 0;
        int left = 0, right = 0;
        while (right <= s.length()) {
            if (right == s.length() || s.charAt(left) != s.charAt(right)) {
                int lenSubstring = right - left;
                sum += (1 + lenSubstring) * lenSubstring / 2;
                left = right;
            }
            right++;
        }
        return sum;
    }
}
