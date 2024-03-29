package AlgoExpert.String;

public class Palindrome {
    // iterative O(n) time - O(1) space
    public static boolean isPalindrome(String word){
        int left = 0;
        int right = word.length() - 1;
        while(left < right){
            if(word.charAt(left) != word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
